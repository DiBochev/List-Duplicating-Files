package problem4;

import java.io.IOException;



public class Main {

	public static void main(final String[] args){
		Files f = new Files();
		try {
			f.searchForDuplicateFiles("E:\\1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
