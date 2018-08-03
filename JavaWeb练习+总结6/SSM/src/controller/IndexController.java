package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
   @RequestMapping("toRegist")
   public String toRegist(){
	   return "regist";
   }
   @RequestMapping("toLogin")
   public String toLogin(){
	   return "login";
   }
}
