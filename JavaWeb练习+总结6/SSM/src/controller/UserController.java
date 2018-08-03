package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.UserInfo;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
    @RequestMapping("addUser")
    public String addUser(@ModelAttribute("user")UserInfo user){
    	userService.addUser(user);
    	return "redirect:/toLogin";
    }
    @RequestMapping("login")
    public String login(@ModelAttribute("user")UserInfo user,Model model){
    	UserInfo u=userService.login(user);
    	if(u==null){
    		model.addAttribute("msg", "用户名或密码错误");
    		return "regist";//去找前缀后缀
    	}else{
    		return "redirect:/product/findAll";
    	}
    }
}
