package com.bm.controller;

import com.bm.model.*;
import com.bm.service.AdminService;
import com.bm.service.DisciplineService;
import com.bm.service.LonginService;
import com.bm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    LonginService longinService;
    @Autowired
    StudentService studentService;
    @Autowired
    DisciplineService disciplineService;
    @RequestMapping(value = "/admin_main")
    public String toAdminMain(){
        return "admin_main";
    }

    @RequestMapping(value = "admin_repasswd")
    public String toAdminRepasswo() {
        return"admin_repasswd";
    }
    @RequestMapping("/admin_repasswd_do")
    public String reAdminPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, String reNewPasswd, RedirectAttributes redirectAttributes ) {

        TAdmin admin=(TAdmin) request.getSession().getAttribute("admin");
        int id=admin.getId();
        String passwd=adminService.findAdminById(id).getAdminPass();
        TAdmin toPudate = admin;
        if(passwd.equals(oldPasswd)){
            toPudate.setAdminPass(newPasswd);
            TUser tUser = longinService.LoginCheck(admin.getJobNumber(), null);
            boolean succo = studentService.updatePasswd(tUser, newPasswd);
            if (succo){
                redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
                return "redirect:/login";
            }
            else {
                redirectAttributes.addFlashAttribute("error", "密码修改失败！");
                return "redirect:/admin_repasswd";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "旧密码错误！");
            return "redirect:/admin_repasswd";
        }
    }
    @RequestMapping("allreaders")
    public ModelAndView allBooks(){
        ArrayList<TStudentDomain> readers=studentService.findAllStus();
        ModelAndView modelAndView=new ModelAndView("admin_readers");
        modelAndView.addObject("readers",readers);
        return modelAndView;
    }

    @RequestMapping(value = "reader_add")
    public ModelAndView toAddReader() {
        List<TDiscipline> disciplines = disciplineService.findDisciplines();
        ModelAndView modelAndView = new ModelAndView("admin_reader_add");
        modelAndView.addObject("disciplines",disciplines);
        return modelAndView;
    }
    //管理员功能--读者信息添加
    @RequestMapping("reader_add_do")
    public String readerInfoAddDo(@RequestParam("stuNum") String stuNum, @RequestParam("name") String name,
                                  @RequestParam("sex") Integer sex, @RequestParam("phone") String phone,
                                  @RequestParam("discipline") Integer discipline, @RequestParam("vip") Integer vip,
                                  RedirectAttributes redirectAttributes){
        TStudent student = new TStudent();
        student.setStuNumber(stuNum);
        student.setStuName(name);
        student.setGender(sex);
        student.setStuPhone(phone);
        student.setDisciplineId(discipline);
        student.setIsVip(vip);
        student.setCount(0);
        int res = studentService.addStudent(student);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "添加读者信息成功！");
            return "redirect:/allreaders";
        }else {
            redirectAttributes.addFlashAttribute("succ", "添加读者信息失败！");
            return "redirect:/allreaders";
        }
    }

    @RequestMapping(value = "reader_edit")
    public ModelAndView toEdit(@RequestParam("readerId") Integer id) {
        TStudentDomain student = studentService.findStudentDomainById(id);
        List<TDiscipline> disciplines = disciplineService.findDisciplines();
        ModelAndView modelAndView = new ModelAndView("admin_reader_edit");
        modelAndView.addObject("readerInfo",student);
        modelAndView.addObject("disciplines",disciplines);
        return modelAndView;
    }
    @RequestMapping(value = "reader_edit_do/{id}",method = RequestMethod.PUT)
    public String EditStudent(@PathVariable("id") Integer id,@RequestParam("name") String name,
                              @RequestParam("sex") Integer sex,@RequestParam("phone") String phone,
                              @RequestParam("discipline") Integer discipline,@RequestParam("vip") Integer vip,
                              RedirectAttributes redirectAttributes) {
        TStudent student = studentService.findStudentById(id);
        if (!student.getStuName().equals(name))
        student.setStuName(name);
        if (!student.getStuPhone().equals(phone))
            student.setStuPhone(phone);
        if (!student.getGender().equals(sex))
            student.setGender(sex);
        if (!student.getDisciplineId().equals(discipline))
        student.setDisciplineId(discipline);
        if (!student.getIsVip().equals(vip))
            student.setIsVip(vip);
        int res = studentService.updateStu(student);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "修改读者信息成功！");
            return "redirect:/allreaders";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "修改读者信息失败！");
            return "redirect:/allreaders";
        }
    }

    /**
     * 管理员删除读者
     */
    @RequestMapping(value = "reader_delete")
    public String deleteStudent(@RequestParam("readerId") Integer id,RedirectAttributes redirectAttributes) {
        int res = studentService.deleteStudent(id);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "删除读者信息成功！");
            return "redirect:/allreaders";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "删除读者信息失败！");
            return "redirect:/allreaders";
        }
    }

}
