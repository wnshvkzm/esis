package com.daou.go.cgmetal.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CgPostServiceImpl implements CgPostService {

	@Override
	public void makeCmdsFile(String content, Long boardId, String postmen,
			String title, String attachName, String filePath, String sepa) {
		
		StringBuffer stringBuffer = new StringBuffer();
		
		if(attachName!=null && filePath!=null) {
			stringBuffer.append("addPost {").append("\"targetBoardId\":")
			.append(boardId).append(", \"createdAt\":").append("\"\"")
			.append(", \"sourceId\":").append("\"").append(123456)
			.append("\"").append(", \"content\":").append("\"")
			.append(content).append("\"").append(", \"writer\":")
			.append("{\"emailId\":").append("\"").append(postmen)
			.append("\"}").append(", \"title\":").append("\"")
			.append(title).append("\"").append(", \"attaches\":[{")
			.append("\"name\":").append("\"").append(attachName)
			.append("\"").append(",\"path\":").append("\"")
			.append(filePath)
			.append("\"").append("}]}");
		}
		else {
			stringBuffer.append("addPost {").append("\"targetBoardId\":")
			.append(boardId).append(", \"createdAt\":").append("\"\"")
			.append(", \"sourceId\":").append("\"").append(123456)
			.append("\"").append(", \"content\":").append("\"")
			.append(content).append("\"").append(", \"writer\":")
			.append("{\"emailId\":").append("\"").append(postmen)
			.append("\"}").append(", \"title\":").append("\"")
			.append(title).append("\"").append("}");
		}
		
		

		String path = "/opt/TerraceTims/sync/10/"+Date()+sepa+".cmds";
		
		//String path = "D:\\"+Date()+sepa+".txt";

		try {
			
			File file = new File(path);
   
			FileWriter writer = new FileWriter(file, true);
			System.out.println("writer생성");
			writer.write(stringBuffer.toString());
			System.out.println("ddddd");
			writer.flush();

			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	
	public String Date() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-hhmmssSSS");

		String today = dateFormat.format(date);

		return today;
	}
	
	public Long UnixTime() {
		
		Calendar c = Calendar.getInstance();
		Long time = c.getTimeInMillis();
		
		return time;
	}


}
