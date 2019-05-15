package com.bm.controller;

import com.bm.model.BSort;
import com.bm.model.BStock;
import com.bm.model.BookDomain;
import com.bm.model.TBook;
import com.bm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * 学生查询图书
     * @return
     */
    @RequestMapping("/reader_querybook")
    public String readerQueryBook(){
        return "reader_book_query";
    }
    @RequestMapping(value = "reader_querybook_do", method = RequestMethod.POST)
    public String readerQueryBookDo(HttpServletRequest request, String searchWord, RedirectAttributes redirectAttributes){
        ArrayList<BookDomain> books = (ArrayList<BookDomain>) bookService.queryBook(searchWord);
        if (books.size()!=0){
            redirectAttributes.addFlashAttribute("books", books);
            return "redirect:/reader_querybook";
        }
        else{
            redirectAttributes.addFlashAttribute("error", "没有匹配的图书！");
            return "redirect:/reader_querybook";
        }

    }

    /**
     * 学生查看图书详情
     * @param bookid
     * @return
     */
    @RequestMapping(value = "readerbookdetail")
    public ModelAndView toReaderBookDetail(@RequestParam("bookId") Integer bookid) {
        BookDomain book = bookService.findBookById(bookid);
        BStock stock = bookService.findStockBybookId(bookid);
//        System.out.println(book);
        ModelAndView modelAndView = new ModelAndView("reader_book_detail");
        modelAndView.addObject("detail",book);
        modelAndView.addObject("detail_stock",stock);
        return modelAndView;
    }

    /**
     * 学生查看所有图书
     * @return
     */
    @RequestMapping(value = "reader_booksort")
    public ModelAndView getBooks(){
        List sorts = bookService.findSort();
        ModelAndView modelAndView = new ModelAndView("reader_book_sort");
        modelAndView.addObject("sorts",sorts);
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
}
