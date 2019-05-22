package com.bm.service;

import com.bm.dao.BSortMapper;
import com.bm.dao.BStockMapper;
import com.bm.dao.TBookMapper;
import com.bm.model.*;
import com.bm.untils.DataUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    TBookMapper bookMapper;
    @Autowired
    BStockMapper stockMapper;
    @Autowired
    BSortMapper bSortMapper;
    public List<BookDomain> queryBook(String searchWord) {
        List<BookDomain> books = new ArrayList<>();
        if (!StringUtils.isBlank(searchWord)) {
            books = bookMapper.queryBook("%" + searchWord + "%", null);

            if (books.size() == 0) {
                books = bookMapper.queryBook(null, "%" + searchWord + "%");
            }
        }
        for (BookDomain bookDomain : books) {
            if (bookDomain.getBookCreatetime() != null) {
                String newCreatetime = DataUtil.stampToDateNoSecond(bookDomain.getBookCreatetime());
                bookDomain.setBookCreatetime(newCreatetime);
            }

        }
        return books;
    }

    public BookDomain findBookById(Integer bookid) {
            BookDomain bookDomain = bookMapper.findBookById(bookid);
            String newCreatetime = DataUtil.stampToDateNoSecond(bookDomain.getBookCreatetime());
            bookDomain.setBookCreatetime(newCreatetime);
        return bookDomain;
    }

    /**
     * 根据id查询图书库存
     * @param id
     * @return
     */
    public BStock findStockByid(Integer id) {
        return stockMapper.selectByPrimaryKey(id);
    }
    /**
     * 根据bookid查询图书库存
     * @param bookid
     * @return
     */
    public BStock findStockBybookId(Integer bookid) {
        return stockMapper.selectByBookId(bookid);
    }

    /**
     * 查询所有图书分类
     */
    public List<BSort> findSort() {
        return bSortMapper.findAllSorts();
    }

    public List<TBook> findBookListBySortId(Integer sortId) {
        List<TBook> books = bookMapper.findBookListBySortId(sortId);
        for (TBook book : books) {
            if (book.getBookCreatetime() != null) {
                String newtime = DataUtil.stampToDateNoSecond(book.getBookCreatetime());
                book.setBookCreatetime(newtime);
            }
        }
        return books;
    }

    public BSort findSortBySortId(Integer sortId) {
        return bSortMapper.selectByPrimaryKey(sortId);
    }

    public List<BookStock> getAllBookStock() {
        List<BookStock> bookStocks = bookMapper.findAllBookStock();
        for (BookStock bookStock : bookStocks) {
            if (bookStock.getBookCreatetime()!=null){
                String newtime = DataUtil.stampToDateNoSecond(bookStock.getBookCreatetime());
                bookStock.setBookCreatetime(newtime);
            }
        }
        return bookStocks;
    }

    /**
     * 通过bookid获取BookStock类型
     * @param id
     * @return
     */
    public BookStock findBookStockById(Integer id) {
        BookStock bookStock = bookMapper.findBookStockById(id);
        if (bookStock.getBookCreatetime() != null) {
            String newtime = DataUtil.stampToDateNoSecond(bookStock.getBookCreatetime());
            bookStock.setBookCreatetime(newtime);
        }
        return bookStock;
    }
    @Transactional
    public int updateBook(TBook book, String stock) {
        int res = bookMapper.updateByPrimaryKeySelective(book);
        if (stock.equals("电子书")) {
            return res;
        } else {
            Integer i = Integer.valueOf(stock);
            if (i != -1) {
                BStock stock1 = stockMapper.findStockByBookId(book.getId());
                stock1.setStock(i);
                stockMapper.updateByPrimaryKeySelective(stock1);
            }
            return res;
        }
    }
    @Transactional
    public int deleteBookByid(Integer bookid) {
        int res = bookMapper.deleteByPrimaryKey(bookid);
        stockMapper.deleteByPrimaryKey(stockMapper.selectByBookId(bookid).getId());
        return res;
    }

    public List<BookStock> findBooksByBookName(String bookname) {
        String newbookname = "%" + bookname + "%";
        List<BookStock> list = bookMapper.findBooksByBookName(newbookname);
        for (BookStock bookStock : list) {
            if (bookStock.getBookCreatetime() != null) {
                String newtime = DataUtil.stampToDateNoSecond(bookStock.getBookCreatetime());
                bookStock.setBookCreatetime(newtime);
            }
        }
        return list;
    }

    @Transactional
    public int addBook(TBook book, String stock, MultipartFile file) {
        if(!file.isEmpty()){
            try {
                //这里将上传得到的文件保存目录
                String child = System.currentTimeMillis() + file.getOriginalFilename();
                book.setEbook("E:\\temp\\"+ child);
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E:\\temp",child));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int res = bookMapper.insertSelective(book);
        if (!stock.equals("")) {
            TBook book1 = bookMapper.findBookByBookNum(book.getBookNumber());
            BStock bStock = new BStock();
            bStock.setStock(Integer.valueOf(stock));
            if (book1!= null) {
                bStock.setBookId(book1.getId());
            }
            stockMapper.insertSelective(bStock);
        }
        return res;
    }
}
