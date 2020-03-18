package test2;

import java.io.*; 
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView; 
  
class Server { 
  
	static String response2;
    public static void main(String args[]) 
        throws Exception 
    { 
  
        System.out.println("Server..");
        ServerSocket ss = new ServerSocket(1234); 
        
        
        Socket s = ss.accept(); 
        System.out.println("Connection established"); 
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader br = new BufferedReader( new InputStreamReader(s.getInputStream())); 
        BufferedReader kb  = new BufferedReader(new InputStreamReader(System.in)); 
        String[] list = new String[2];
        while (true) { 
        	String str, str1; 
        	while ((str = br.readLine()) != null) { 
        		
        		
        		if(str.equals("File Structure")) {
        			
        			
        			File file = new File("C:");
        			String response1 = "Directory C \n";
        			response1 += FileDirectory.displayDirectoryContents(file);
        			response1 +="\n";
        			
        			file = new File("D:");
        			 response2 =FileDirectory.displayDirectoryContents(file);
        			
        			
        			
        			System.out.println(response2.length());
        			System.out.println(response2);
                    ps.println(response2);
//        			System.out.println(response2);
        			
//        			 FileSystemView fsv = FileSystemView.getFileSystemView();
//        		        File[] roots = fsv.getRoots();
//        		        for (int i = 0; i < roots.length; i++)
//        		        {
//        		            System.out.println("Root: " + roots[i]);
//        		        }
//
//        		        System.out.println("Home directory: " + fsv.getHomeDirectory());
//        		        File[] f = File.listRoots();
//        		        for (int i = 0; i < f.length; i++)
//        		        {
//        		        	
//        		   
//        		        	 if (f[i].canRead()) {
////        		        		System.out.println(f[i]);  
////        		        		 list[i] = f[i].toString();
//        		        		 
//        		        		 response=FileDirectory.displayDirectoryContents(f[i]);
//        		        		 System.out.println(response);
//        		            }
//        		                  
//        		        }
//        			for(int i=0;i<list.length;i++) {
//        				System.out.println(list[i]);
//        				FileDirectory.displayDirectoryContents(list[i]);
//        			}
        			
        		}
        		
        		else if(str.contains("Rename ")) {
        			
        			System.out.println("In the Rename condition");
        			String change[] = str.split(" ");
//        			System.out.println(change[0]);
//        			System.out.println(change[1]);
        			
        			try {
        			String source = "D:\\";
        			source+=change[1].toString();
        			System.out.println(source);
        			Path source1 = Paths.get(source);
        		
        			Files.move(source1, source1.resolveSibling(change[2].toString()));
        			}
        			catch(Exception e) {
//        					e.printStackTrace();
        				
        				
        			}
        			
        			
        			
//        			 str1 = kb.readLine(); 
                     ps.println("Renamed successfully");
        			
        		}
        		
        		else if(str.contains("copy")) {
        			System.out.println("In the copy condition");
        			String change[] = str.split(" ");
        			
        			String dest = change[2].toString();
        			String source="D:\\";
        			source+=change[1].toString();

        			Path source1 = Paths.get(source);
        			Path dest1 = Paths.get(dest);
        		
        
        		}
        		
        		else if(str.contains("Delete")) {
        			System.out.println("In delete condition");
        			
        			String change[] = str.split(" ");
        			String del = "D:\\";
        			del += change[1].toString();
        			Path del1 = Paths.get(del);
        			Files.delete(del1);
        			ps.println("Deleted successfully!");
        		}
        		else {
        			System.out.println(str); 
                    str1 = kb.readLine(); 
                    ps.println(str1);
        		}
                 
            } 
  
          
            ps.close(); 
            br.close(); 
            kb.close(); 
            ss.close(); 
            s.close(); 
  
           
            System.exit(0); 
  
        } 
    } 
    
} 