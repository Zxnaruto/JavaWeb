package pers.zx.test;

/**
 * @author zx
 *����һ��MyStringUtil�����࣬�����ж���2��������Ҫ�����£�
  (1)public static String getSingleString(String str) : ȥ�����������ַ����е��ط��ַ����ظ��ַ�ֻ����һ��������
�µ��ַ�������
  (2)public static boolean isBalancedString(String str): �����������
�ַ���ͬ�򷵻�true�����򷵻�false�����磺abccba�ǶԳ��ַ������磺abcdecba���ǶԳ��ַ�
 */
public class MyStringUtil {
  public static String getSingleString(String str) {
	  
         char[] array=str.toCharArray();//�ָ��ַ���
         //ȥ���ظ����ַ���' '����
         for(int i=0;i<array.length;i++) {
        	 for(int j=1+i;j<array.length;j++) {
        		 
        		 if(array[i]==array[j]) {
        			 array[j]=' ';
        		 }
        	 }
         }
       String str1="";
       //ȥ��' ' ��ת��Ϊ�ַ���
   for(int i=0;i<array.length;i++) {
	   if(array[i]!=' ') {
	   str1+=array[i];
	   }
   }
  
     
     return str1;    
     }
  
  public static boolean isBalancedString(String str) {
	  
	  boolean flag = true;
	    char[] array=str.toCharArray();//�ָ�
	    if(str.length()%2!=0) {
	    	flag=false;
	     }else {
	    	 for(int i=str.length()/2-1;i>=0;i--) {
	    		 if(array[i]!=array[str.length()-i-1]) {//�ж��Ƿ����
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
