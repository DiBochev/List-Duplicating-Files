package problem4;

import java.io.IOException;



public class Main {

	public static void main(final String[] args){
		Files f = new Files();
		String dir = "E:\\films";
		try {
			f.searchForDuplicateFiles(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.toString());
	}
}
