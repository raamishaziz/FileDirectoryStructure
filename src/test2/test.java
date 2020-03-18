package test2;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;

public class test {
	public static ArrayList<File> drives;
	public static ArrayList<File> readableDrives() {
		 FileSystemView fsv = FileSystemView.getFileSystemView();
	        File[] roots = fsv.getRoots();
	        for (int i = 0; i < roots.length; i++)
	        {
	            System.out.println("Root: " + roots[i]);
	        }

	        System.out.println("Home directory: " + fsv.getHomeDirectory());
	        File[] f = File.listRoots();
	        for (int i = 0; i < f.length; i++)
	        {
	        	
	   
	        	 if (f[i].canRead()) {
	        		System.out.println(f[i]);        
	            }
	        	 drives.add(f[i]);	           
	        }
	        for(int i=0;i<drives.size();i++) {
	        	System.out.println(drives.get(i));
	        }
			return drives;
	}
	
}
