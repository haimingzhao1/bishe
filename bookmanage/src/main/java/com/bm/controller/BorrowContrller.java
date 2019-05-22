package com.bm.controller;

import com.bm.model.TBorrowDomain;
import com.bm.model.TStudent;
import com.bm.service.BorrowService;
import com.bm.service.UserService;
import com.bm.untils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BorrowContrller {
    @Autowired
    UserService userService;
    @Autowired
    BorrowService borrowService;
//    @RequestMapping("/lendbook.html")
//    public ModelAndView bookLend(HttpServletRequest request){
//        long bookId=Integer.parseInt(request.getParameter("bookId"));
//        Book book=bookService.getBook(bookId);
//        ModelAndView modelAndView=new ModelAndView("admin_book_lend");
//        modelAndView.addObject("book",book);
//        return modelAndView;
//    }

//    @RequestMapping("/lendbookdo.html")
//    public String bookLendDo(HttpServletRequest request, RedirectAttributes redirectAttributes, int readerId){
//        long bookId=Integer.parseInt(request.getParameter("id"));
//        boolean lendsucc=lendService.bookLend(bookId,readerId);
//        if (lendsucc){
//            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
//            return "redirect:/allbooks.html";
//        }else {
//            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
//            return "redirect:/allbooks.html";
//        }
//
//
//    }
//
//    @RequestMapping("/returnbook.html")
//    public String bookReturn(HttpServletRequest request,RedirectAttributes redirectAttributes){
//        long bookId=Integer.parseInt(request.getParameter("bookId"));
//        boolean retSucc=lendService.bookReturn(bookId);
//        if (retSucc){
//            redirectAttributes.addFlashAttribute("succ", "图书归还成功！");
//            return "redirect:/allbooks.html";
//        }
//        else {
//            redirectAttributes.addFlashAttribute("error", "图书归还失败！");
//            return "redirect:/allbooks.html";
//        }
//    }


//    @RequestMapping("/lendlist.html")
//    public ModelAndView lendList(){
//
//        ModelAndView modelAndView=new ModelAndView("admin_lend_list");
//        modelAndView.addObject("list",lendService.lendList());
//        return modelAndView;
//    }
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
