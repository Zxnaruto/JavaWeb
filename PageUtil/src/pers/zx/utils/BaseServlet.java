package pers.zx.utils;

import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet{
	  
    public int pagesize = 5;
    
    
    public int currentPage(String cpage){
        int currentpage = cpage!=null && !"".equals(cpage) && isint(cpage)? currentpage=Integer.parseInt(cpage):1;
        return currentpage;
    }
    
    public boolean isint(String str){
        boolean bo = true;
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            bo = false;
        }
        return bo;
    }

}
