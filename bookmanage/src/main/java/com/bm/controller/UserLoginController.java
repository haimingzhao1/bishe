package com.bm.controller;

import com.bm.service.UserLonginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class UserLoginController {
    @Autowired
    private UserLonginService userLonginService;
    @RequestMapping("/")
    public String LoginCheck(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
        }
    @RequestMapping(value = "userloginCheck",method = RequestMethod.POST)
    @ResponseBody
    public Map userLoginCheck(String username,String password){
        Map res = new HashMap();
        if (username==null&&password==null){
            res.put("stateCode", 0);
        }else if (userLonginService.LoginCheck(username,password)){
            res.put("stateCode",1);
        }
        else
            res.put("stateCode", 0);
        return res;
    }
}
