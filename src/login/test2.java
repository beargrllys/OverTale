package login;

import java.io.*;

public class test2 {

	public static String[][] a1() {
		
		String[][] a = new String[1000][4];

		try {
			////////////////////////////////////////////////////////////////
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\����\\eclipse-workspace\\soloproject\\src\\text\\test.txt"));
			String s;
			for(int i = 0; i < 1000; i++) {
				for(int j =0; j<4; j++) {
					s = in.readLine();
					if(s == null) {
						break;
					}
					a[i][j] = s;
				}
			}
			in.close();
			////////////////////////////////////////////////////////////////
		} catch (IOException e) {
			System.err.println(e); // ������ �ִٸ� �޽��� ���
			System.exit(1);
		}
		return a;
	}
}