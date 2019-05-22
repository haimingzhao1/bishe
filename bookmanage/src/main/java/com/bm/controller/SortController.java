package com.bm.controller;

import com.bm.model.BSort;
import com.bm.model.TDiscipline;
import com.bm.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SortController {
    @Autowired
    SortService sortService;
    /**
     * 查詢所有係
     */
    @RequestMapping(value = "allsorts",method = RequestMethod.GET)
    public ModelAndView findSorts(){
        ModelAndView modelAndView = new ModelAndView("admin_sorts");
        List<BSort> sorts = sortService.findSorts();
        modelAndView.addObject("sorts", sorts);
        return modelAndView;
    }
    /**
     * 添加係
     */

    @RequestMapping(value = "sort_add")
    public String addSort(){
        return "admin_sort_add";
    }
    @RequestMapping(value = "sort_add_do",method = RequestMethod.POST)
    public String addSortDo(@RequestParam(value = "name") String sortName, RedirectAttributes redirectAttributes){
        int res = sortService.insertSort(sortName);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "添加 成功！");
            return "redirect:/allsorts";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "添加 失败！");
            return "redirect:/allsorts";
        }
    }
    /**
     * 修改係
     */
    @RequestMapping(value = "sort_edit")
    public ModelAndView updateSortById(@RequestParam("sortId") Integer disicid){
        ModelAndView modelAndView = new ModelAndView("admin_sort_edit");
        BSort bSort = sortService.findSortById(disicid);
        modelAndView.addObject("bSort",bSort);
        return modelAndView;
    }
    @RequestMapping(value = "sort_edit_do/{sortid}",method = RequestMethod.PUT)
    public String editSortById(@PathVariable("sortid") Integer sortid, @RequestParam("name") String sortname, RedirectAttributes redirectAttributes){
        int res = sortService.updateSortById(sortid,sortname);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "修改 成功！");
            return "redirect:/allsorts";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "修改 失败！");
            return "redirect:/allsorts";
        }
    }
    /**
     * 刪除係
     */
    @RequestMapping(value = "sort_delete")
    public String deleteDisciplineById(@RequestParam(value = "sortId") Integer sortId, RedirectAttributes redirectAttributes){
        int res = sortService.deleteSortById(sortId);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "删除 成功！");
            return "redirect:/allsorts";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "删除 失败！");
            return "redirect:/allsorts";
        }
    }
}
