package pers.zx.javatest;

public class StringOperation {

	public static String fg(String str) {
		char[] array=str.toCharArray();
		int flag=0;
		String str1="";
		for(int i=array.length-1;i>=0;i--) {
			flag++;
			str1+=array[i];			
			if(flag%3==0) {
				str1+=",";
			}
		}
		//×Ö·û´®·´×ª
		char[] array1=str1.toCharArray();
		String str2="";
		for(int i=array1.length-1;i>=0;i--) {
			str2+=array1[i];
		}
         return str2;
	}
	
	public static void main(String[] args) {
		System.out.println(StringOperation.fg("12345678"));
	}
}
