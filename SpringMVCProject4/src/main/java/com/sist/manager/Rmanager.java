package com.sist.manager;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
/*
 * Spring => 수집 (Hadoop) => mapreduce, spark ===> R  ====> REACT!
 * 							================				======> ANDROID
 * 							mongoDB							코틀린, React-Native(동적웹)
 *  
 */
@Component
public class Rmanager {
/*
	public static void main(String[] args) {
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn=DriverManager.getConnection(url,"hr","happy");
			String sql="SELECT empno, ename, job,sal FROM emp";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//결과값가져오기
			ResultSet rs=ps.executeQuery();
			
			String temp="empno,ename,job,sal\n";
			while(rs.next())
			{
				temp+=rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+"\n"; //엑셀넣기
				
			}
			rs.close();
			ps.close();
			conn.close();
			temp=temp.substring(0,temp.lastIndexOf("\n"));
			
			FileWriter fw=new FileWriter("c:\\upload\\emp.csv");// csv: 파일형 엑섹엑셀파일이 만들어짐
			fw.write(temp);
			fw.close();
			
			RConnection rc=new RConnection();
			//r명령어send하기 to Rserve
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep\",\")"); //명령어 sep=구분자
			
			
			}catch(Exception ex){
			
			ex.printStackTrace();
			}
	}*/

	//realpath
	//C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject4\board
	//그래프 그릴것!
	public void rGraph(int no)
	{
		try{
			
			//R연결 => 반드시 r serve가 연결이 되어있어야한다.
			/*
			 * cmd 
			 * 
C:\Users\sist>CD "C:\PROGRAM files"

C:\Program Files>cd R

C:\Program Files\R>CD R-4.0.0

C:\Program Files\R\R-4.0.0>CD BIN

C:\Program Files\R\R-4.0.0\bin>R.exe CMD Rserve.exe
Rserve: Ok, ready to answer queries.

			 */

				//명사를 자르면 2차원 배열로 되어 1차원 배열로 바꿔야한다 => unlist
				//글자가 몇번 사용되었는지 -> table
				//위에서부터 10개 잘르라 => head
				//그래프로 그려야. barplot 그림 명령어
				
				RConnection rc= new RConnection();
				//문자열을 못읽어서 파일을 저장해야함 . read.excel, read.svc
				//eval = send => 이 명령어를 r로 들어가서 명령어를 실행함
				rc.voidEval("library(rJava)");
				rc.voidEval("library(KoNLP)"); //import!
				rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject4/board/"+no+".png\",width=700,height=450)"); //png형식으로 그림을 그리고 여기에 저장해!
				rc.voidEval("data<-readLines(\"c:/data,board.txt\")"); //데이터 폴더에 board.txt 파일을 읽어~
				rc.voidEval("data2<-sapply(data,extractNoun,USE.NAMES = F)"); //KoNLP lib 사용하고있음
				rc.voidEval("data3<-unlist(data2)"); // 1차원 배열로 만듬
				
				//gsub()=> replace()
				rc.voidEval("data3<-gsub(\"[A-Za-z]\",\"\",data3)"); //한글 제외하고 모두 공백으로 해 => 한글만 가져오기!
				rc.voidEval("data3<-gsub(\"[0-9]\",\"\",data3)");
				rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data3)"); //x>=2 자른 단어에서 글자가 2글자 이상 가져와라.
				rc.voidEval("data4<-table(data2)");
				rc.voidEval("data5<-head(sort(data4,decreasing = T),10)");
				rc.voidEval("barplot(data5,col=rainbow(15))"); //막대그래프를 위 경로에 png로 그림!
				rc.voidEval("dev.off");
				rc.close(); // 열고닫고 반복해야한다.
				
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}

	
	
}
