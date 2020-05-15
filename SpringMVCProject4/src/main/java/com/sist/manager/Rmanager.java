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
 * Spring => ���� (Hadoop) => mapreduce, spark ===> R  ====> REACT!
 * 							================				======> ANDROID
 * 							mongoDB							��Ʋ��, React-Native(������)
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
			
			//�������������
			ResultSet rs=ps.executeQuery();
			
			String temp="empno,ename,job,sal\n";
			while(rs.next())
			{
				temp+=rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4)+"\n"; //�����ֱ�
				
			}
			rs.close();
			ps.close();
			conn.close();
			temp=temp.substring(0,temp.lastIndexOf("\n"));
			
			FileWriter fw=new FileWriter("c:\\upload\\emp.csv");// csv: ������ �������������� �������
			fw.write(temp);
			fw.close();
			
			RConnection rc=new RConnection();
			//r��ɾ�send�ϱ� to Rserve
			rc.voidEval("emp<-read.csv(\"c:/upload/emp.csv\",header=T,sep\",\")"); //��ɾ� sep=������
			
			
			}catch(Exception ex){
			
			ex.printStackTrace();
			}
	}*/

	//realpath
	//C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject4\board
	//�׷��� �׸���!
	public void rGraph(int no)
	{
		try{
			
			//R���� => �ݵ�� r serve�� ������ �Ǿ��־���Ѵ�.
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

				//��縦 �ڸ��� 2���� �迭�� �Ǿ� 1���� �迭�� �ٲ���Ѵ� => unlist
				//���ڰ� ��� ���Ǿ����� -> table
				//���������� 10�� �߸��� => head
				//�׷����� �׷���. barplot �׸� ��ɾ�
				
				RConnection rc= new RConnection();
				//���ڿ��� ���о ������ �����ؾ��� . read.excel, read.svc
				//eval = send => �� ��ɾ r�� ���� ��ɾ ������
				rc.voidEval("library(rJava)");
				rc.voidEval("library(KoNLP)"); //import!
				rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject4/board/"+no+".png\",width=700,height=450)"); //png�������� �׸��� �׸��� ���⿡ ������!
				rc.voidEval("data<-readLines(\"c:/data,board.txt\")"); //������ ������ board.txt ������ �о�~
				rc.voidEval("data2<-sapply(data,extractNoun,USE.NAMES = F)"); //KoNLP lib ����ϰ�����
				rc.voidEval("data3<-unlist(data2)"); // 1���� �迭�� ����
				
				//gsub()=> replace()
				rc.voidEval("data3<-gsub(\"[A-Za-z]\",\"\",data3)"); //�ѱ� �����ϰ� ��� �������� �� => �ѱ۸� ��������!
				rc.voidEval("data3<-gsub(\"[0-9]\",\"\",data3)");
				rc.voidEval("data3<-Filter(function(x){nchar(x)>=2},data3)"); //x>=2 �ڸ� �ܾ�� ���ڰ� 2���� �̻� �����Ͷ�.
				rc.voidEval("data4<-table(data2)");
				rc.voidEval("data5<-head(sort(data4,decreasing = T),10)");
				rc.voidEval("barplot(data5,col=rainbow(15))"); //����׷����� �� ��ο� png�� �׸�!
				rc.voidEval("dev.off");
				rc.close(); // ����ݰ� �ݺ��ؾ��Ѵ�.
				
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
	}

	
	
}
