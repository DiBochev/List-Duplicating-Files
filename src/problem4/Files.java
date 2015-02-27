package problem4;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Files {

	private ArrayList<File> files;

	public Files() {
		files = new ArrayList<File>();
	}
	
	public void searchForDuplicateFiles(String dir) throws IOException{
		searchForDuplicateFiles(new File(dir));
	}
	
	public void searchForDuplicateFiles(File dir) throws IOException{
		if (dir.isDirectory()) {
			String[] children = dir.list();

			for (String child : children) {
				searchForDuplicateFiles(new File(dir, child));
			}
		} else {
			if (!contain(dir)) {
				files.add(dir);
			}else{
				dir.delete();
			}
		}
	}
	
	
	private boolean contain(File file) throws IOException {
		if (this.files.size() == 0) {
			return false;
		}
		
		if (file == null) {
			 for (int i = 0; i < files.size() - 1; i++){
	                if (files.get(i) == null)
	                    return true;
	        }
		}
		if (!file.exists()) {
			return true;
		}

		for (int i = 0; i < files.size() - 1; i++) {
			if(files.get(i).length() == file.length()){
				return recursivelyCompare(0, 1000, files.get(i), file);
			}
		}
		return false;
	}

	private boolean recursivelyCompare(long equalsTo, int step, File file1,File file2) throws IOException {
		long sumFromFile = 0;
		long sumFromFile2 = 0;
		
		if (equalsTo + step >= file1.length()){
			equalsTo = file1.length() - 1;
			step = 0;
		}
		
		
		try(DataInputStream dis1 = new DataInputStream(new FileInputStream(file1));){
			for (long i = equalsTo; i < equalsTo + step; i++) {
				sumFromFile+= dis1.readByte();
			}
		}
		try(DataInputStream dis2 = new DataInputStream(new FileInputStream(file2));){
			for (long i = equalsTo; i < equalsTo + step; i++) {
				sumFromFile2+= dis2.readByte();
			}
		}
		
		
		if (sumFromFile == sumFromFile2) {
			if (equalsTo == file1.length() - 1) {
				return true;
			}
			recursivelyCompare(equalsTo + 1000, 1000, file1, file2);
		}else{
			return false;
		}
		return true;
	}

}
