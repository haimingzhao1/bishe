package com.bm.controller;

import com.bm.model.TAdmin;
import com.bm.model.TStudent;
import com.bm.model.TUser;
import com.bm.service.LonginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
public class LoginController {
    @Autowired
    private LonginService longinService;
    @RequestMapping(value = {"/","/login"})
    public String LoginCheck(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
        }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public @ResponseBody Object loginCheck(HttpServletRequest request){
        String username =request.getParameter("username");
        String passwd = request.getParameter("passwd");
        TUser user = longinService.LoginCheck(username, passwd);
        HashMap<String, String> res = new HashMap<String, String>();
        if (user == null) {
            res.put("stateCode", "0");
            res.put("msg","账号或密码错误！");
        }else if(user.getIsAdmin()==1&&user.getIsAdmin()==0) {
            res.put("stateCode", "0");
            res.put("msg","账号或密码错误！");
        } else if(user.getIsAdmin()==1){
            TAdmin admin = longinService.findAdminByJob(username);
            request.getSession().setAttribute("admin",admin);
            res.put("stateCode", "1");
            res.put("msg","管理员登陆成功！");
        }else {
            TStudent readerCard = longinService.findByStuNumber(username);
//            System.out.println(readerCard);
            request.getSession().setAttribute("readercard", readerCard);
            res.put("stateCode", "2");
            res.put("msg","读者登陆成功！");
        }
        return res;
    }
    //配置404页面
    @RequestMapping("*")
    public String notFind(){
        return "404";
    }
}
