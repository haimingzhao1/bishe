package com.bm.controller;

import com.bm.model.TDiscipline;
import com.bm.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;
    /**
     * 查詢係根據id
     */
    @RequestMapping(value = "discipline/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TDiscipline findDisciplineById(@PathVariable(value = "id") Integer id){
        return disciplineService.findDisciplineById(id);
    }
    /**
     * 查詢所有係
     */
    @RequestMapping(value = "disciplines",method = RequestMethod.GET)
    @ResponseBody
    public List<TDiscipline> findDisciplines(){
        return disciplineService.findDisciplines();
    }
    /**
     * 添加係
     */
    @RequestMapping(value = "discipline",method = RequestMethod.POST)
    @ResponseBody
    public Map addDiscipline(@RequestParam(value = "discipline") String disciplineName){
        Map map = new HashMap();
        map.put("status", disciplineService.insertDiscipline(disciplineName));
        return map;
    }
    /**
     * 修改係
     */
    @RequestMapping(value = "discipline/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map updateDisciplineById(@PathVariable(value = "id") Integer id,@RequestParam(value = "discipline") String disciplineName){
        Map map = new HashMap();
        map.put("status", disciplineService.updateDisciplineById(id,disciplineName));
        return map;
    }
    /**
     * 刪除係
     */
    @RequestMapping(value = "discipline/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map deleteDisciplineById(@PathVariable(value = "id") Integer id){
        Map map = new HashMap();
        map.put("status", disciplineService.deleteDisciplineById(id));
        return map;
    }
}
