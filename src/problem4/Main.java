package problem4;

import java.io.IOException;



public class Main {

	public static void main(final String[] args){
		Files f = new Files();
		try {
			f.searchForDuplicateFiles("E:\\films");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f.toString());
	}
}
