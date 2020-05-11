package com.sist.myapp;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//�Ϲ� ��Ʈ�ѷ��� ���ϸ��� �Ѿ����
//restcontroller�� ���ϸ��� �Ѿ�� �ʰ� script�����̳� json�� �Ѿ��
//ex) �����ȣ ���� ������ ó���Ҷ�..
//��ũ��Ʈ�� �ѱ��.. => �Ϲݹ��ڿ��� �Ѿ��.
//ajax, react ���� => �ʿ��� ������(xml, json)
// ����� ��ũ��Ʈ ����ؾ��Ҷ� ���!
@RestController 
public class BoardRestController {
	
	//prototype =>�϶� �Ź� �ٸ� dao������!
	@Autowired
	private BoardDAO dao;//��� ��Ʈ�ѷ����� �޸� �Ҵ�� �ϳ��� �̱��� dao
	
	
	//��� ��!
	@PostMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo) //vo�� ���;� ������Ʈ�ȴ�.
	{
		String result="";
		
		//db���� true, false�� �޾ƿ�
		boolean bCheck=dao.boardUpdate(vo); //dao���� => true or false�� ���� ���´�!
		
		if(bCheck == true)
		{	
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";	
		}
		else
		{
			//�ʿ��� html, script�� ������ RESTCONTROLLER�� ���!
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		
		return result;
	}
	
	
	@PostMapping("board/delete_ok.do")
	public String board_delete_ok(int no, String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);

		if(bCheck == true)
		{	
			result="<script>location.href=\"list.do\"</script>";	
		}
		else
		{
			//�ʿ��� html, script�� ������ RESTCONTROLLER�� ���!
			result="<script>alert(\"Password Fail!!\");history.back();</script>";
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
}
