package com.bm.controller;

import com.bm.model.TDiscipline;
import com.bm.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;
    /**
     * 查詢所有係
     */
    @RequestMapping(value = "alldisciplines",method = RequestMethod.GET)
    public ModelAndView findDisciplines(){
        ModelAndView modelAndView = new ModelAndView("admin_disciplines");
        List<TDiscipline> tdisciplines = disciplineService.findDisciplines();
        modelAndView.addObject("tdisciplines", tdisciplines);
        return modelAndView;
    }
    /**
     * 添加係
     */

    @RequestMapping(value = "discipline_add")
    public String addDiscipline(){
        return "admin_discipline_add";
    }
    @RequestMapping(value = "discipline_add_do",method = RequestMethod.POST)
    public String addDisciplineDo(@RequestParam(value = "name") String disciplineName,RedirectAttributes redirectAttributes){
        int res = disciplineService.insertDiscipline(disciplineName);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "添加 成功！");
            return "redirect:/alldisciplines";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "添加 失败！");
            return "redirect:/alldisciplines";
        }
    }
    /**
     * 修改係
     */
    @RequestMapping(value = "discipline_edit")
    public ModelAndView updateDisciplineById(@RequestParam("disicId") Integer disicid){
        ModelAndView modelAndView = new ModelAndView("admin_discipline_edit");
        TDiscipline tDiscipline = disciplineService.findDisciplineById(disicid);
        modelAndView.addObject("tDiscipline",tDiscipline);
        return modelAndView;
    }
    @RequestMapping(value = "disicipline_edit_do/{disicid}",method = RequestMethod.PUT)
    public String editDisciplineById(@PathVariable("disicid") Integer disicid, @RequestParam("name") String diciname, RedirectAttributes redirectAttributes){
        int res = disciplineService.updateDisciplineById(disicid,diciname);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "修改 成功！");
            return "redirect:/alldisciplines";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "修改 失败！");
            return "redirect:/alldisciplines";
        }
    }
    /**
     * 刪除係
     */
    @RequestMapping(value = "discipline_delete")
    public String deleteDisciplineById(@RequestParam(value = "disicid") Integer disicid, RedirectAttributes redirectAttributes){
        int res = disciplineService.deleteDisciplineById(disicid);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "删除 成功！");
            return "redirect:/alldisciplines";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "删除 失败！");
            return "redirect:/alldisciplines";
        }
    }
}
