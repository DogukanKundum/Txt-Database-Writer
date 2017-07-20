package com.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TxtWriter {

	private static final String FILENAME = "E:\\test\\filename.txt";
	
	public static void main(String arg[]) throws SQLException{
		DatabaseConn con = new DatabaseConn();
		
		List<String> element= con.Connect();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			for (String string : element) {
				
				String content = element.toString() + "\n";

				bw.write(content);
			}
			
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
