package com.bm.controller;

import com.bm.model.TAdmin;
import com.bm.model.TStudent;
import com.bm.model.TUser;
import com.bm.service.LonginService;
import com.bm.untils.Captcha;
import com.bm.untils.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
        String captha = request.getParameter("captha").trim().toLowerCase();
        String yanzheng = (String) request.getSession().getAttribute("validateCode");
        String newyanzheng = yanzheng.trim().toLowerCase();
//        System.out.println(yanzheng.trim().toLowerCase());
//        System.out.println(captha.trim().toLowerCase());
        TUser user = longinService.LoginCheck(username, passwd);
        HashMap<String, String> res = new HashMap<String, String>();
        if (user == null) {
            res.put("stateCode", "0");
            res.put("msg","账号或密码错误！");
        }else if(!captha.equals(newyanzheng)) {
            res.put("stateCode", "3");
            res.put("msg","验证码错误！");
        } else if(user.getIsAdmin()==1&&user.getIsAdmin()==0) {
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
    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "getCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //禁止图像缓存
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        Captcha captcha = new SpecCaptcha(150,40,5);// png格式验证码
        ServletOutputStream out = response.getOutputStream();
        BufferedImage bi = captcha.out(out);
        //获取验证码字符串放到session中，用于登录时取出来验证
        String verifyCode =   captcha.text();
        request.getSession().setAttribute("validateCode", verifyCode);
        //将图像输出到 servlet的输出流中
        ImageIO.write(bi, "png", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }
    //配置404页面
    @RequestMapping("*")
    public String notFind(){
        return "404";
    }
}
