package com.bm.service;

import com.bm.dao.BSortMapper;
import com.bm.dao.BStockMapper;
import com.bm.dao.TBookMapper;
import com.bm.model.BSort;
import com.bm.model.BStock;
import com.bm.model.BookDomain;
import com.bm.model.TBook;
import com.bm.untils.DataUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return bookMapper.findBookListBySortId(sortId);
    }

    public BSort findSortBySortId(Integer sortId) {
        return bSortMapper.selectByPrimaryKey(sortId);
    }
}