package pers.zx.javatest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File {

	@SuppressWarnings("unused")
	public static void main(String[] args)throws IOException {
	    int jpg=0;
//		BufferedReader in=new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\dd\\1.jpg"));
	//	BufferedWriter out=new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\zx\\3.jpg"));
		
		 // 打开输入流
        FileInputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\dd\\1.jpg");
        // 打开输出流
        FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\zx\\3.jpg");
		byte[] b=new byte[1024];
		while((jpg=in.read(b))!=-1) {
			out.write(b);
		    
		}
		out.flush();
		in.close();
		out.close();
		
		
		
		
	}
}
