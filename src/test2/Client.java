package test2;


import java.io.*; 
import java.net.*; 
  
class Client { 
  
    public static void main(String args[]) 
        throws Exception 
    { 
  
    	
    	System.out.println("Client..");
    	System.out.println("recieved command for file structure");
		System.out.println("List of working commands given below");
		System.out.println("- File Structure");
		System.out.println("- Rename");
		System.out.println("- Copy");
		System.out.println("- Delete");
		
		
        
        Socket s = new Socket("localhost", 1234); 
//        Socket s = null;
//        SocketAddress sockaddr=new InetSocketAddress("192.168.1.158", 1234);
//        s.connect(sockaddr,1234);
      
        DataOutputStream dos  = new DataOutputStream(s.getOutputStream()); 
        BufferedReader br = new BufferedReader( new InputStreamReader(s.getInputStream())); 
        BufferedReader kb = new BufferedReader( new InputStreamReader(System.in)); 
        String str, str1; 
        //while (!(str = kb.readLine()).equals("exit")) { 
        	 while ((str = kb.readLine())!=null) { 
        	dos.writeBytes(str + "\n"); 
        	str1 = br.readLine(); 
        	System.out.println(str1); 
        	
        } 
  
        
        dos.close(); 
        br.close(); 
        kb.close(); 
        s.close(); 
    } 
} 
