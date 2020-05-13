package com.sist.databoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("board/")
public class DataBoardController {
	
	@Autowired // @resource�� �ش� id�� ���� ã�� autowired�� �ڵ����� ã�Ƽ� �ּҰ��� ��������!
	private DataBoardDAO dao;
	
	@RequestMapping("list.do")
	public String board_list(Model model, String page)
	{
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		//����,�� �ʿ� �ֱ�
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		
		map.put("start", start);
		map.put("end", end);
	
		List<DataBoardVO> list=dao.databoardListData(map);
		int totalpage=dao.databoardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		//viewResolver / + "board/list"  + .jsp
		//			prefix				   suffix
		return "board/list";
		
	}
	
	
	@RequestMapping("insert.do")
	public String databoard_insert()
	{
		return "board/insert";
	}
	
	
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(DataBoardVO vo) throws Exception //����ڷκ��� �޴� ���� �ڵ����� vo�� ä���ٰ���
	{
		List<MultipartFile> list=vo.getFiles(); //list�� ����ư� ���Ͽ� ����� ����x
		
		
		//������ ������ Ư�� ���Ͽ� �ֱ� �ʿ�
		String temp1="";
		String temp2="";
		
		//���� �ִٸ� üũ�Ͽ� ���Ͽ������ض� => put it to upload, ���� ������ ���Ͽ� ��������� for������
		if(list!=null && list.size()>0)
		{
			//���� �������� mf�� ���� 1��
			for(MultipartFile mf:list)
			{
				//����ڰ� ������ �̸��Ѱ� ������
				String fn=mf.getOriginalFilename(); //�̸��� ���
				File file=new File("c:\\upload\\"+fn); //�ش������� �ش����� �־���
				mf.transferTo(file); //�ӽ������������̾��ٰ� => ������������ҷ� �̵��� => then transfer(����������) to upload!
				
				//1.jpg, 2.jpg
				temp1+=fn+","; //���� ,�߰�
				temp2+=file.length()+","; //�������� , �߰�!
			}
			temp1=temp1.substring(0,temp1.lastIndexOf(",")); //���ڻ��� ,����
			temp2=temp2.substring(0,temp2.lastIndexOf(",")); //�Ǹ����� ,����
			
			vo.setFilecount(list.size());
			vo.setFilename(temp1);
			vo.setFilesize(temp2);
		}
		else
		{
			//����ڰ� ���� �ø��� ���� ���
			vo.setFilecount(0);
			vo.setFilename("");
			vo.setFilesize("");
			
		}
		
		dao.databoardInsert(vo);
		
		return "redirect:list.do";
	}
	
	
	//�󼼺���
	@RequestMapping("detail.do")
	public String board_detail(Model model, int no)
	{
		DataBoardVO vo= dao.databoardDetailData(no);
		
		//����ó��
		if(vo.getFilecount()>0)
		{
			//�����Ѱ� �ڸ���
			StringTokenizer st1=new StringTokenizer(vo.getFilename(),",");
			List<String> fList=new ArrayList<String>();
			while(st1.hasMoreTokens())
			{
				fList.add(st1.nextToken());
			}
			
			//����ũ�� �ڸ���
			StringTokenizer st2=new StringTokenizer(vo.getFilesize(),",");
			List<String> sList=new ArrayList<String>();
			while(st2.hasMoreTokens())
			{
				sList.add(st2.nextToken());
			}
			
			// ����Ʈ�� �Ѱ��� ����
			// ����1 ũ��1, ����2 ũ��2,
			model.addAttribute("fList",fList);
			model.addAttribute("sList",sList);
		}
		
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	
	
	//�ٿ�ε�� ȭ���̵�x => void , ȭ���̵� => string!
	@RequestMapping("download.do")
	public void databoard_download(String fn,HttpServletResponse response)
	{	
		try{
			File file=new File("c:\\upload\\"+fn);//�������� ������
			//������ �Ѿ������ ���ϸ�� ����ũ�⸦ �����ش� => �׷��� ���α׷����ٿ� â ũ�⸦ ������.. =>header
			response.setHeader("content-Disposition", "atttachment;filename=" //���ϸ� �ѱ�
					+URLEncoder.encode(fn,"UTF-8"));// �ٿ�ε� â ���� 
			response.setContentLength((int)file.length()); //ũ��ѱ�
			
			//�ٿ�ε� â�� ������Ѵ�. 
			//�������� Ŭ���̾�Ʈ���� ���縦 �Ͽ� �ٿ�ε� �ϴ� ����..
			//�����б�=> c:\\upload\\a.jpg
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			
			//Ŭ���̾�Ʈ�� ������ ���
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			//Ŭ���̾�Ʈ���� ���Ϻ����� response�� �̿��ؼ� ������
			
			//������ i => byte����!
			int i=0;
			byte[] buffer=new byte[1024];
			while((i=bis.read(buffer, 0, 1024))!=-1) //-1 ���������� �о��, EOF END OF FILE
			{
				bos.write(buffer,0, i);	
			}
			
			bis.close();
			bos.close();
			
		}catch(Exception ex) {}
	}
}
