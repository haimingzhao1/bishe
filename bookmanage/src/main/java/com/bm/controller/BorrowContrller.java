package com.bm.controller;

import com.bm.model.TBorrowDomain;
import com.bm.model.TStudent;
import com.bm.service.BorrowService;
import com.bm.service.UserService;
import com.bm.untils.DataUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class BorrowContrller {
    @Autowired
    UserService userService;
    @Autowired
    BorrowService borrowService;
    @RequestMapping("/mylend")
    public ModelAndView myLend(HttpServletRequest request){
        TStudent readerCard=(TStudent) request.getSession().getAttribute("readercard");
        ModelAndView modelAndView=new ModelAndView("reader_lend_list");
        Integer userid = userService.findUserByStuNum(readerCard.getStuNumber()).getId();
        List<TBorrowDomain> list = borrowService.findBorrowByUserId(userid);
        for (TBorrowDomain tBorrowDomain : list){
                if (tBorrowDomain.getBorrowDate()!= null){
                    String newBorrowDate = DataUtil.stampToDate(tBorrowDomain.getBorrowDate());
                    tBorrowDomain.setBorrowDate(newBorrowDate);
                }
            if (tBorrowDomain.getAlsoDate()!= null){
                String newAlsoDate = DataUtil.stampToDate(tBorrowDomain.getAlsoDate());
                tBorrowDomain.setAlsoDate(newAlsoDate);
            }
        }
//        System.out.println(list);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    /**
     * 借还日志——管理员部分
     */
    @RequestMapping("lendlist")
    public ModelAndView toLendList() {
        ModelAndView modelAndView = new ModelAndView("admin_lend_list");
        List<TBorrowDomain> borrowlist = borrowService.findAllBorrws();
        modelAndView.addObject("borrowlist",borrowlist);
        return modelAndView;
    }
    /**
     * 管理员下载借还列表
     */
    @RequestMapping(value = "export_lendlist")
    public String ExportLendList( HttpServletResponse response) throws IOException {
        List<TBorrowDomain> list = borrowService.findAllBorrws();
        // 创建一个Excl表格对象
        HSSFWorkbook wb = new HSSFWorkbook();
        // 建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("读者借还Excl表格");
        // 在sheet里创建第二行
        HSSFRow row1 = sheet.createRow(0);
        // 创建第一行设置单元格内容
        row1.createCell(0).setCellValue("图书编号");
        row1.createCell(1).setCellValue("学生学号");
        row1.createCell(2).setCellValue("出借日期");
        row1.createCell(3).setCellValue("是否逾期");
        row1.createCell(4).setCellValue("归还日期");
        row1.createCell(5).setCellValue("是否续借");

        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            TBorrowDomain borrowDomain = list.get(i);
            // 创建单元格并设置单元格内容
            row.createCell(0).setCellValue(borrowDomain.getBook().getBookNumber());//图书编号
            row.createCell(1).setCellValue(borrowDomain.getUser().getUsername());//学生学号
            row.createCell(2).setCellValue(borrowDomain.getBorrowDate());//出借日期
            //是否逾期
            String name = "";
            try {
                Integer res = borrowDomain.getIsAlso();
                if (res == 0) {
                    name = "否";
                } else {
                    name ="是";
                }
            } catch (Exception e) {

            }
            row.createCell(3).setCellValue(name);
            String alsodata = "";
            if (borrowDomain.getAlsoDate()!=null){
                alsodata = borrowDomain.getAlsoDate();
            } else{ alsodata = "未归还";}

            row.createCell(4).setCellValue(alsodata);//归还日期
            //是否续借
            String iscontinue = "";
            if (borrowDomain.getIsContinue() == 0) {
                iscontinue = "否";
            } else {
                iscontinue = "是";
            }
            row.createCell(5).setCellValue(iscontinue);
        }

        // 输出Excel文件
        ServletOutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        return "redirect:/lendlist";
    }
    /**
     * 借还日志删除——管理员部分
     */
    @RequestMapping("deleteborrow")
    public String deletebook(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        int res = borrowService.deleteBorrowById(id);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "删除信息成功！");
            return "redirect:/lendlist";
        }else {
            redirectAttributes.addFlashAttribute("succ", "删除信息失败！");
            return "redirect:/lendlist";
        }
    }
//    @RequestMapping("querybook")

}
