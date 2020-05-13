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

	public static void main(String[] args) {
		
		try{
			
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");
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
			fw.close();*/
			
			RConnection rc=new RConnection();
			//r명령어send하기 to Rserve
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep\",\")"); //명령어 sep=구분자
			
			
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
}
