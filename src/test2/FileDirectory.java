package test2;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileDirectory {
	static String get="";
	public static String displayDirectoryContents(File dir) {
		try {
			
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					String check = file.getCanonicalPath();
					if(check.contains("D:\\System Volume")) {
						
					}
					else {
//						System.out.println("directory:" + file.getCanonicalPath());
						
						get+=" directory" + file.getCanonicalPath().toString() + "#";
						displayDirectoryContents(file);
					}
					
				} else {
//					System.out.println("     file:" + file.getCanonicalPath());
					get+=" file " + file.getCanonicalPath().toString() + "#";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return get;
	}
}