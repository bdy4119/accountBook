package proc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileProc {

	
	private File file = null;

	public FileProc(String filename) {
		file = new File("d:\\tmp\\" + filename + ".txt");
		
		try {
			if(file.createNewFile()) {
				System.out.println("파일생성 성공");
			} else {
				System.out.println("기존의 파일이 존재합니다.");				
			}
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public String[] read() {
		String datas[] = null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			int count = 0;
			String str = "";
			while((str = br.readLine()) != null) {
				count++;
			}
			br.close();
			
			datas = new String[count];
			
			br = new BufferedReader(new FileReader(file));
			
			int w = 0;
			while((str = br.readLine()) != null) {
				datas[w] = str;
				w++;
			}
			br.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	
	
	
	
	public void write(String datas[]) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일에 저장되었습니다.");
	}
	
	
}
