package pers.zx.test;

/**
 * @author zx
 *定义一个MyStringUtil工具类，该类中定义2个方法，要求如下：
  (1)public static String getSingleString(String str) : 去除给定参数字符串中的重符字符（重复字符只保留一个），将
新的字符串返回
  (2)public static boolean isBalancedString(String str): 如果左右两边
字符相同则返回true，否则返回false，例如：abccba是对称字符；例如：abcdecba不是对称字符
 */
public class MyStringUtil {
  public static String getSingleString(String str) {
	  
         char[] array=str.toCharArray();//分割字符串
         //去除重复的字符用' '代替
         for(int i=0;i<array.length;i++) {
        	 for(int j=1+i;j<array.length;j++) {
        		 
        		 if(array[i]==array[j]) {
        			 array[j]=' ';
        		 }
        	 }
         }
       String str1="";
       //去除' ' 并转换为字符串
   for(int i=0;i<array.length;i++) {
	   if(array[i]!=' ') {
	   str1+=array[i];
	   }
   }
  
     
     return str1;    
     }
  
  public static boolean isBalancedString(String str) {
	  
	  boolean flag = true;
	    char[] array=str.toCharArray();//分割
	    if(str.length()%2!=0) {
	    	flag=false;
	     }else {
	    	 for(int i=str.length()/2-1;i>=0;i--) {
	    		 if(array[i]!=array[str.length()-i-1]) {//判断是否相等
	    			 flag=false;
	    			 break;
	    		 }else {
	    			 flag=true;
	    		 }
	    	 }
	     }
	    
	    return flag;
	    
  }
   public static void main(String[] args) {
	  
	   System.out.println(MyStringUtil.getSingleString("daffdsffx"));
	   System.out.println(MyStringUtil.isBalancedString("aabccbaa"));
	}
}
