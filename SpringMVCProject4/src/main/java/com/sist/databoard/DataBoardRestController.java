package com.sist.databoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.io.*; //������ �������Ž� �ʿ�
import java.util.*; //������ �������Ž� �ʿ�

@RestController
@RequestMapping("board/")
public class DataBoardRestController {

	@Autowired //�̱���, �޸𸮰���, ���� ����
	private DataBoardDAO dao;	
	
	@RequestMapping("update_ok.do")
	public String update_ok(DataBoardVO vo) //������ ���� ä������ �´�
	{
		//���üũ
		String result="";
		//�����������
		String db_pwd=dao.databoardGetPassword(vo.getNo()); //db���� ������pwd
		if(db_pwd.equals(vo.getPwd()))
		{
			//����� �´� ���
			result="OK";
			dao.databoardUpdate(vo);
		}
		else
		{
			//Ʋ�����
			result="NOPWD";	
		}
		return result;
		
	}
	
	@RequestMapping("delete_ok.do")
	public String delete_ok(int no, String pwd)
	{
		String result="";
		
		//�̸� �޾Ƴ��� db�� ���������ϰ� ������ ����!
		DataBoardVO vo=dao.databoardFileInfoData(no); // ���ϰ��� Ȯ��
		boolean bCheck=dao.databoardDelete(no, pwd); //true ��� => DB����! 
		if(bCheck==true)
		{
			result="OK";
			//�������� ����
			try{
				
				if(vo.getFilecount()>0)
				{
				  StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
				  while(st.hasMoreTokens())
				  {
					  // ���� �Ѱ��� ��������
					  File file=new File("c:\\upload\\"+st.nextToken());
					  file.delete();
					  //���ε�� ������ �����ϱ�
					  //�Ѱ��� ����, �ѹ���x
				  }				  
				}
				File file=new File("C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringMVCProject4\\board"+no+".png");
				file.delete();
				
			}catch(Exception ex) {}
		}
		else
		{
			result="NOPWD";
		}
		return result;
	}
	
	
	
	
	
	
}	
