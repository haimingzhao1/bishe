package com.bm.controller;

import com.bm.model.TDiscipline;
import com.bm.model.TStudent;
import com.bm.model.TUser;
import com.bm.service.DisciplineService;
import com.bm.service.LonginService;
import com.bm.service.StudentService;
import com.bm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    LonginService longinService;
    @Autowired
    DisciplineService disciplineService;

    @RequestMapping(value = "/reader_main")
    public String toUserMain() {
        return "reader_main";
    }

    /**
     * 進入個人信息界面
     *
     * @return
     */
    @RequestMapping(value = "/reader_info")
    public ModelAndView toReaderInfo(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        TStudent readerCard = (TStudent) request.getSession().getAttribute("readercard");
        TDiscipline discipline = disciplineService.findDisciplineById(readerCard.getDisciplineId());
        view.addObject("discipline", discipline);
        view.addObject("reader_info");
        return view;
    }

    //用户功能--进入修改密码页面
    @RequestMapping("reader_repasswd")
    public String readerRePasswd() {
        return "reader_repasswd";
    }

    //    用户功能--修改密码执行
    @RequestMapping("reader_repasswd_do")
    public String readerRePasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, String reNewPasswd, RedirectAttributes redirectAttributes) {
        TStudent readerCard = (TStudent) request.getSession().getAttribute("readercard");
        String number = readerCard.getStuNumber();
        TUser tUser = longinService.LoginCheck(number, null);
        String passwd = tUser.getPassword();
        if (newPasswd.equals(reNewPasswd)) {
            if (passwd.equals(oldPasswd)) {
                boolean succ = studentService.updatePasswd(tUser, newPasswd);
                if (succ) {
                    readerCard.setStuPhone(newPasswd);
                    request.getSession().setAttribute("readercard", readerCard);
                    redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                    return "redirect:/login";
                } else {
                    redirectAttributes.addFlashAttribute("error", "密码修改失败！");
                    return "redirect:/reader_repasswd";
                }

            } else {
                redirectAttributes.addFlashAttribute("error", "修改失败,原密码错误");
                return "redirect:/reader_repasswd";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "修改失败,两次输入的新密码不相同");
            return "redirect:/reader_repasswd";
        }

    }

    //读者功能--读者信息修改
    @RequestMapping("reader_info_edit")
    public ModelAndView readerInfoEditReader(HttpServletRequest request) {
        TStudent readerCard = (TStudent) request.getSession().getAttribute("readercard");
        TDiscipline discipline = disciplineService.findDisciplineById(readerCard.getDisciplineId());
        ModelAndView modelAndView = new ModelAndView("reader_info_edit");
        modelAndView.addObject("discipline", discipline);
        return modelAndView;

    }

    @RequestMapping("reader_edit_do_r")
    public String readerInfoEditDoReader(HttpServletRequest request, @RequestParam(value = "name") String name, @RequestParam(value = "sex") Integer sex,
                                         @RequestParam(value = "phone") String phone, RedirectAttributes redirectAttributes) {
        TStudent readerCard = (TStudent) request.getSession().getAttribute("readercard");
        TStudent toUpdateStu = readerCard;
        if (!readerCard.getStuName().equals(name)) {
            toUpdateStu.setStuName(name);
            if (!readerCard.getGender().equals(sex))
                toUpdateStu.setGender(sex);
            if (!readerCard.getStuPhone().equals(phone))
                toUpdateStu.setStuPhone(phone);
            int res = studentService.updateStu(toUpdateStu);
            if (res > 0) {
                TStudent readerCardNew = longinService.findByStuNumber(readerCard.getStuNumber());
                request.getSession().setAttribute("readercard", readerCardNew);
                redirectAttributes.addFlashAttribute("succ", "信息修改成功！");
                return "redirect:/reader_info";
            } else {
                redirectAttributes.addFlashAttribute("error", "信息修改失败！");
                return "redirect:/reader_info";

            }

        }
        return "redirect:/reader_info";
    }
}
