package login;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class texttest2 {

	public static String f(String a) {
		FileWriter f_writer = null;
		try {
			f_writer = new FileWriter("C:\\Users\\±è»ó¹Î\\eclipse-workspace\\soloproject\\src\\text\\test.txt", true);

			BufferedWriter b_writer = new BufferedWriter(f_writer, 1024);
			
			b_writer.write("\r\n");
			b_writer.write(a);

			b_writer.close();
			f_writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";

	}

}
