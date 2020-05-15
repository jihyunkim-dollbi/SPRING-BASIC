package com.sist.databoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.io.*; //폴더에 파일제거시 필요
import java.util.*; //폴더에 파일제거시 필요

@RestController
@RequestMapping("board/")
public class DataBoardRestController {

	@Autowired //싱글톤, 메모리관리, 재사용 가능
	private DataBoardDAO dao;	
	
	@RequestMapping("update_ok.do")
	public String update_ok(DataBoardVO vo) //변수에 값이 채워져서 온다
	{
		//비번체크
		String result="";
		//비번가져오기
		String db_pwd=dao.databoardGetPassword(vo.getNo()); //db에서 가져온pwd
		if(db_pwd.equals(vo.getPwd()))
		{
			//비번이 맞는 경우
			result="OK";
			dao.databoardUpdate(vo);
		}
		else
		{
			//틀린경우
			result="NOPWD";	
		}
		return result;
		
	}
	
	@RequestMapping("delete_ok.do")
	public String delete_ok(int no, String pwd)
	{
		String result="";
		
		//미리 받아놓고 db를 먼저제거하고 파일을 제거!
		DataBoardVO vo=dao.databoardFileInfoData(no); // 파일개수 확인
		boolean bCheck=dao.databoardDelete(no, pwd); //true 경우 => DB제거! 
		if(bCheck==true)
		{
			result="OK";
			//파일제거 시작
			try{
				
				if(vo.getFilecount()>0)
				{
				  StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
				  while(st.hasMoreTokens())
				  {
					  // 파일 한개씩 가져오기
					  File file=new File("c:\\upload\\"+st.nextToken());
					  file.delete();
					  //업로드된 데이터 삭제하기
					  //한개씩 사제, 한번에x
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
