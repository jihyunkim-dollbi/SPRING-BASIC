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
	
	@Autowired // @resource는 해당 id를 직접 찾고 autowired는 자동으로 찾아서 주소값을 주입해줌!
	private DataBoardDAO dao;
	
	@RequestMapping("list.do")
	public String board_list(Model model, String page)
	{
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		//시작,끝 맵에 넣기
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
	public String board_insert_ok(DataBoardVO vo) throws Exception //사용자로부터 받는 값을 자동으로 vo에 채워줄것임
	{
		List<MultipartFile> list=vo.getFiles(); //list에 저장됐고 파일에 저장된 상태x
		
		
		//가져온 파일을 특정 파일에 넣기 필요
		String temp1="";
		String temp2="";
		
		//값이 있다면 체크하여 파일에저장해라 => put it to upload, 값이 없으면 파일에 넣을수없어서 for문에러
		if(list!=null && list.size()>0)
		{
			//파일 가져오기 mf가 파일 1개
			for(MultipartFile mf:list)
			{
				//사용자가 보내준 이름한개 가져옴
				String fn=mf.getOriginalFilename(); //이름을 얻고
				File file=new File("c:\\upload\\"+fn); //해당폴더에 해당파일 넣어줘
				mf.transferTo(file); //임시파일저장중이었다가 => 실제파일저장소로 이동함 => then transfer(여기저장해) to upload!
				
				//1.jpg, 2.jpg
				temp1+=fn+","; //개당 ,추가
				temp2+=file.length()+","; //마지막에 , 추가!
			}
			temp1=temp1.substring(0,temp1.lastIndexOf(",")); //글자사이 ,삭제
			temp2=temp2.substring(0,temp2.lastIndexOf(",")); //맨마지막 ,삭제
			
			vo.setFilecount(list.size());
			vo.setFilename(temp1);
			vo.setFilesize(temp2);
		}
		else
		{
			//사용자가 파일 올리지 않은 경우
			vo.setFilecount(0);
			vo.setFilename("");
			vo.setFilesize("");
			
		}
		
		dao.databoardInsert(vo);
		
		return "redirect:list.do";
	}
	
	
	//상세보기
	@RequestMapping("detail.do")
	public String board_detail(Model model, int no)
	{
		DataBoardVO vo= dao.databoardDetailData(no);
		
		//에러처리
		if(vo.getFilecount()>0)
		{
			//파일한개 자르기
			StringTokenizer st1=new StringTokenizer(vo.getFilename(),",");
			List<String> fList=new ArrayList<String>();
			while(st1.hasMoreTokens())
			{
				fList.add(st1.nextToken());
			}
			
			//파일크기 자르기
			StringTokenizer st2=new StringTokenizer(vo.getFilesize(),",");
			List<String> sList=new ArrayList<String>();
			while(st2.hasMoreTokens())
			{
				sList.add(st2.nextToken());
			}
			
			// 리스트를 한개로 묶음
			// 파일1 크기1, 파일2 크기2,
			model.addAttribute("fList",fList);
			model.addAttribute("sList",sList);
		}
		
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	
	
	//다운로드시 화면이동x => void , 화면이동 => string!
	@RequestMapping("download.do")
	public void databoard_download(String fn,HttpServletResponse response)
	{	
		try{
			File file=new File("c:\\upload\\"+fn);//파일정보 가져옴
			//파일이 넘어가기전에 파일명과 파일크기를 보내준다 => 그래야 프로그래스바와 창 크기를 결정됨.. =>header
			response.setHeader("content-Disposition", "atttachment;filename=" //파일명 넘김
					+URLEncoder.encode(fn,"UTF-8"));// 다운로드 창 띄우기 
			response.setContentLength((int)file.length()); //크기넘김
			
			//다운로드 창을 띄워야한다. 
			//서버에서 클라이언트한테 복사를 하여 다운로드 하는 형식..
			//서버읽기=> c:\\upload\\a.jpg
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			
			//클라이언트로 보내는 기능
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			//클라이언트한테 파일보낼때 response를 이용해서 보낸다
			
			//보내기 i => byte개수!
			int i=0;
			byte[] buffer=new byte[1024];
			while((i=bis.read(buffer, 0, 1024))!=-1) //-1 마지막까지 읽어라, EOF END OF FILE
			{
				bos.write(buffer,0, i);	
			}
			
			bis.close();
			bos.close();
			
		}catch(Exception ex) {}
	}
}
