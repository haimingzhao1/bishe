package com.bm.controller;

import com.bm.model.*;
import com.bm.service.*;
import com.bm.untils.DataUtil;
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
    @Autowired
    BookService bookService;
    @Autowired
    BorrowService borrowService;
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

    /**
     * 管理员查看全部读者
     * @return
     */
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
    @RequestMapping("/allbooks")
    public ModelAndView allBook(){
        List<BookStock> bookStocks=bookService.getAllBookStock();
        ModelAndView modelAndView=new ModelAndView("admin_books");
        modelAndView.addObject("bookStocks",bookStocks);
        return modelAndView;
    }

    /**
     * 还书管理中归还
     * @param id
     * @return
     */
    @RequestMapping("lendtoreturn")
    public String lendToReturn(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        int res = borrowService.lendToRturn(id);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "归还成功！");
            return "redirect:/lendlist";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "归还失败！");
            return "redirect:/lendlist";
        }
    }

    /**
     * 修改是否逾期
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("lendisalso")
    public String lendIsAlso(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        int res = borrowService.lendIsAlso(id);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "修改逾期成功！");
            return "redirect:/lendlist";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "修改逾期失败！");
            return "redirect:/lendlist";
        }
    }

    /**
     * 管理员设置是否续期
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("lendisalsContinue")
    public String lendisaIsContinue(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
        int res = borrowService.lendisaIsContinue(id);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "续期成功！");
            return "redirect:/lendlist";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "续期失败！");
            return "redirect:/lendlist";
        }
    }
    /**
     * 借阅图书
     * @param id
     * @return
     */
    @RequestMapping("lendbook")
    public ModelAndView lendBook(@RequestParam("bookId") Integer id) {
        BookDomain lendbook = bookService.findBookById(id);
        ModelAndView modelAndView = new ModelAndView("admin_book_lend");
        modelAndView.addObject("lendbook",lendbook);
        return modelAndView;
    }

    @RequestMapping("lendbookdo")
    public String lendBookDo(@RequestParam("id") Integer bookid,@RequestParam("readerId") String username,RedirectAttributes redirectAttributes) {
        int res = borrowService.insertBorrow(bookid, username);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "借阅成功！");
            return "redirect:/lendlist";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "借阅失败！");
            return "redirect:/lendlist";
        }
    }


    /**
     * 管理员搜索单个图书的借阅情况
     */
    @RequestMapping("queryborrow")
    public ModelAndView queryBorrow(@RequestParam("searchWord") String bookNum) {
        List<TBorrowDomain> queryBorrowDomains = borrowService.findBorrowByBookNum(bookNum);
        ModelAndView modelAndView = new ModelAndView("query_borrow_list");
        if (queryBorrowDomains.size()>0){
            modelAndView.addObject("succ", "查询成功！");
            modelAndView.addObject("queryBorrowDomains",queryBorrowDomains);
            return modelAndView;
        }else {
            modelAndView.addObject("error", "查询的编号不存在！");
            return modelAndView;
        }
    }
    /**
     * 管理员修改图书信息
     * @param bookId 图书id
     * @return
     */
    @RequestMapping("updatebook")
    public ModelAndView toUpdateBook(@RequestParam("bookId") Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("admin_book_edit");
        BookDomain bookDomain = bookService.findBookById(bookId);
        List<BSort> sorts = bookService.findSort();
        BStock stock = bookService.findStockBybookId(bookId);
        modelAndView.addObject("bookDomain", bookDomain);
        modelAndView.addObject("sorts", sorts);
        modelAndView.addObject("stock", stock);
        return modelAndView;
    }

    @RequestMapping("book_edit_do")
    public String BookEditDo(@RequestParam("id") Integer bookId,@RequestParam("bookNum") String bookNum,
                                   @RequestParam("bookname") String bookname,@RequestParam("bookauther") String bookauther,
                                   @RequestParam("press") String press,@RequestParam("createtime") String createtime,
                                   @RequestParam("summary") String summary,@RequestParam("remark") String remark,@RequestParam("stock") String stock,
                                   @RequestParam("sort") Integer sort, RedirectAttributes redirectAttributes) {
        String s = createtime.trim();
        String s1 = DataUtil.dateToStampNoSecond(s);
        TBook book = new TBook();
        book.setBookName(bookname);
        book.setBookNumber(bookNum);
        book.setBookAuthor(bookauther);
        book.setBookCreatetime(s1);
        book.setBookPress(press);
        book.setBookSummary(summary);
        book.setBookRemark(remark);
        book.setId(bookId);
        book.setSortId(sort);
        book.setAddTime(DataUtil.timeStamp());
        BookDomain bookDomain = bookService.findBookById(bookId);
        if (sort!=1&&bookDomain.getSort().getId()==1){
            redirectAttributes.addFlashAttribute("error", "修改失败！电子书种类不可修改！");
            return "redirect:/allbooks";
        }
        if (sort==1&&bookDomain.getSort().getId()!=1){
            redirectAttributes.addFlashAttribute("error", "修改失败！不可修改为电子书种类！");
            return "redirect:/allbooks";
        }
        int res = bookService.updateBook(book,stock);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "修改成功！");
            return "redirect:/allbooks";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "修改失败！");
            return "redirect:/allbooks";
        }
    }

    /**
     * 管理员删除图书信息
     */
    @RequestMapping("deletebook")
    public String deleteBook(@RequestParam("bookId") Integer bookid,RedirectAttributes redirectAttributes) {
        int res = bookService.deleteBookByid(bookid);
        if (res>0){
            redirectAttributes.addFlashAttribute("succ", "删除 成功！");
            return "redirect:/allbooks";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "删除 失败！");
            return "redirect:/allbooks";
        }
    }

    /**
     * 管理员根据图书名搜索图书列表
     * @return
     */
    @RequestMapping("querybooksbyname")
    public ModelAndView queryBooksByName(@RequestParam("searchWord") String bookname){
        List<BookStock> querybookStocks=bookService.findBooksByBookName(bookname);
        ModelAndView modelAndView=new ModelAndView("query_books_by_name");
        modelAndView.addObject("querybookStocks",querybookStocks);
        return modelAndView;
    }
}
