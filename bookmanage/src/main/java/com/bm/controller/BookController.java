package com.bm.controller;

import com.bm.model.*;
import com.bm.service.BookService;
import com.bm.service.StudentService;
import com.bm.untils.DataUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    StudentService studentService;
    /**
     * 学生查询图书
     *
     * @return
     */
    @RequestMapping("/reader_querybook")
    public ModelAndView readerQueryBook() {
        ModelAndView modelAndView = new ModelAndView("reader_book_query");
        return modelAndView;
    }

    @RequestMapping(value = "reader_querybook_do", method = RequestMethod.POST)
    public String readerQueryBookDo(HttpServletRequest request, String searchWord, RedirectAttributes redirectAttributes) {
        ArrayList<BookDomain> books = (ArrayList<BookDomain>) bookService.queryBook(searchWord);
        if (books.size() != 0) {
            redirectAttributes.addFlashAttribute("books", books);
            return "redirect:/reader_querybook";
        } else {
            redirectAttributes.addFlashAttribute("error", "没有匹配的图书！");
            return "redirect:/reader_querybook";
        }

    }

    /**
     * 学生查看图书详情
     *
     * @param bookid
     * @return
     */
    @RequestMapping(value = "readerbookdetail")
    public ModelAndView toReaderBookDetail(@RequestParam("bookId") Integer bookid) {
        BookDomain book = bookService.findBookById(bookid);
        BStock stock = bookService.findStockBybookId(bookid);
//        System.out.println(book);
        ModelAndView modelAndView = new ModelAndView("reader_book_detail");
        modelAndView.addObject("detail", book);
        modelAndView.addObject("detail_stock", stock);
        return modelAndView;
    }

    /**
     * 学生查看所有图书
     *
     * @return
     */
    @RequestMapping(value = "reader_booksort")
    public ModelAndView getBooks() {
        List sorts = bookService.findSort();
        ModelAndView modelAndView = new ModelAndView("reader_book_sort");
        modelAndView.addObject("sorts", sorts);
        return modelAndView;
    }

    @RequestMapping("reader_book_bysort")
    public ModelAndView getBooksBySort(@RequestParam("sortId") Integer sortId) {
        List<TBook> bookList = bookService.findBookListBySortId(sortId);
        BSort sortid = bookService.findSortBySortId(sortId);
        ModelAndView modelAndView = new ModelAndView("reader_book_list");
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("sortid", sortid);
        return modelAndView;
    }

    /**
     * 管理员查看图书详情
     */
    @RequestMapping("bookdetail")
    public ModelAndView bookDetailAdmin(@RequestParam("bookId") Integer id, @RequestParam("booksort") Integer sortId) {
        ModelAndView modelAndView = new ModelAndView("admin_book_detail");
        BookStock bookStock = bookService.findBookStockById(id);
        BSort bSort = bookService.findSortBySortId(sortId);
        modelAndView.addObject("bookStock", bookStock);
        modelAndView.addObject("bSort", bSort);
        return modelAndView;
    }

    /**
     * 添加图书--管理员
     */
    @RequestMapping("book_add")
    public ModelAndView toBookAdd() {
        List<BSort> bSorts = bookService.findSort();
        ModelAndView modelAndView = new ModelAndView("admin_book_add");
        modelAndView.addObject("bSorts", bSorts);
        return modelAndView;
    }

    @RequestMapping("book_add_do")
    public String BookAdd(@RequestParam("bookNum") String bookNum, @RequestParam("bookname") String bookname,
                          @RequestParam("bookauther") String bookauther, @RequestParam("bookpress") String bookpress,
                          @RequestParam("bookcreate") String bookcreate, @RequestParam("summary") String summary,
                          @RequestParam("remark") String remark, @RequestParam("sort") Integer sort,
                          @RequestParam("stock") String stock, @RequestParam("file") MultipartFile file,
                          RedirectAttributes redirectAttributes) {
        TBook book = new TBook();
        if (sort == 1) {
            stock = "-1";
        }
        book.setSortId(sort);
        book.setBookRemark(remark);
        book.setBookSummary(summary);
        book.setBookPress(bookpress);
        book.setBookCreatetime(DataUtil.dateToStampNoSecond(bookcreate.trim()));
        book.setBookAuthor(bookauther);
        book.setBookNumber(bookNum);
        book.setBookName(bookname);
        book.setAddTime(DataUtil.timeStamp());
        book.setBorrowCount(0);
        int res = bookService.addBook(book, stock, file);
        if (res > 0) {
            redirectAttributes.addFlashAttribute("succ", "添加图书成功！");
            return "redirect:/allbooks";
        } else {
            redirectAttributes.addFlashAttribute("error", "添加图书失败！");
            return "redirect:/book_add";
        }
    }

    /**
     * 学生下载图书
     */
    @RequestMapping(value = "loadbook",method = RequestMethod.POST)
    public String loadBook(@RequestParam("filename") String fileName, @RequestParam("userid") Integer userid, HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
        TStudent tStudent = studentService.findStudentById(userid);
        if (tStudent!=null) {
            if (tStudent.getIsVip()==1) {
                //获取输入流
                InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
                //假如以中文名下载的话   重命名下载后的名字
                String str = DataUtil.timeStamp();
                String filename = str.substring(0, str.length() - 3) + "下载文件.txt";
                //转码，免得文件名中文乱码
                filename = URLEncoder.encode(filename, "UTF-8");
                //设置文件下载头
                response.addHeader("Content-Disposition", "attachment;filename=" + filename);
                //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
                response.setContentType("multipart/form-data");
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                int len = 0;
                while ((len = bis.read()) != -1) {
                    out.write(len);
                    out.flush();
                }
                out.close();
                redirectAttributes.addFlashAttribute("succ", "下载电子书成功！");
                return "redirect:/reader_booksort";
            }
            else {
                redirectAttributes.addFlashAttribute("error", "下载电子书失败！您不是vip用户");
                return "redirect:/reader_booksort";
            }
        }else {
            redirectAttributes.addFlashAttribute("error", "下载电子书失败！");
            return "redirect:/reader_booksort";
        }
    }
    /**
     * 学生查看图书
     */
    @RequestMapping("/readBook")
    @ResponseBody
    public Object readBook(@RequestParam("bookId") String bookId){
        Map<String,String> res = new HashMap<>();
        if(!StringUtils.isEmpty(bookId)){
            res.put("status","0");
        }
        BookDomain book = bookService.findBookById(Integer.parseInt(bookId));
        if(null == book){
            res.put("status","1");
        }

        String bookPath = book.getEbook();
        File bookFile = new File(bookPath);

        try {
            byte[] bytes= new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(bookFile);
            fileInputStream.read(bytes,0,1024);



            String bookContent = new String(bytes);
//            bookContent += "...";

            res.put("status","2");
            res.put("bookContent",bookContent.trim()+ "...");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
