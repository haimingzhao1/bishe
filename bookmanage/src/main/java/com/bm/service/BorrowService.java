package com.bm.service;

import com.bm.dao.BStockMapper;
import com.bm.dao.TBookMapper;
import com.bm.dao.TBorrowMapper;
import com.bm.dao.TUserMapper;
import com.bm.model.BStock;
import com.bm.model.TBook;
import com.bm.model.TBorrow;
import com.bm.model.TBorrowDomain;
import com.bm.untils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class BorrowService {
    @Autowired
    TBorrowMapper borrowMapper;
    @Autowired
    TUserMapper userMapper;
    @Autowired
    BStockMapper stockMapper;
    @Autowired
    TBookMapper bookMapper;
    public List<TBorrowDomain> findBorrowByUserId(Integer userid) {
        return new ArrayList<TBorrowDomain>(borrowMapper.findBorrowByUserId(userid));
    }

    public List<TBorrowDomain> findAllBorrws() {
        List<TBorrowDomain> list = borrowMapper.findAllBorrws();
        for (TBorrowDomain borrowDomain : list) {
            if (borrowDomain.getBorrowDate() != null) {
                String newBorrowDate = DataUtil.stampToDate(borrowDomain.getBorrowDate());
                borrowDomain.setBorrowDate(newBorrowDate);
            }
            if (borrowDomain.getAlsoDate() != null) {
                String newAlsoDate = DataUtil.stampToDate(borrowDomain.getAlsoDate());
                borrowDomain.setAlsoDate(newAlsoDate);
            }
        }
        return list;
    }

    public int deleteBorrowById(Integer id) {
        return borrowMapper.deleteByPrimaryKey(id);
    }
    @Transactional
    public int lendToRturn(Integer id) {
        TBorrow borrow = borrowMapper.selectByPrimaryKey(id);
        borrow.setAlsoDate(DataUtil.timeStamp());
        int res = borrowMapper.updateByPrimaryKeySelective(borrow);
        return res;
    }

    public int lendIsAlso(Integer id) {
        TBorrow borrow = borrowMapper.selectByPrimaryKey(id);
        if (borrow.getIsAlso()==1){
            borrow.setIsAlso(0);
        }else borrow.setIsAlso(1);
        int res = borrowMapper.updateByPrimaryKeySelective(borrow);
        return res;
    }

    public int lendisaIsContinue(Integer id) {
        TBorrow borrow = borrowMapper.selectByPrimaryKey(id);
        if (borrow.getIsContinue()==1){
            borrow.setIsContinue(0);
        }else borrow.setIsContinue(1);
        int res = borrowMapper.updateByPrimaryKeySelective(borrow);
        return res;
    }
    @Transactional
    public int insertBorrow(Integer bookid, String username) {
        Integer userid = userMapper.findUserByStuNum(username).getId();
        TBook book = bookMapper.selectByPrimaryKey(bookid);
        book.setBorrowCount(book.getBorrowCount()+1);
        bookMapper.updateByPrimaryKeySelective(book);
        TBorrow borrow = new TBorrow();
        borrow.setIsContinue(0);
        borrow.setIsAlso(0);
        borrow.setBorrowDate(DataUtil.timeStamp());
        borrow.setBookId(bookid);
        borrow.setUserId(userid);
        int res = borrowMapper.insertSelective(borrow);
        BStock stock = stockMapper.selectByBookId(bookid);
        if (stock.getStock()>0){
            stock.setStock(stock.getStock()-1);
            stockMapper.updateByPrimaryKeySelective(stock);
        } else return 0;
        return res;
    }

    public List<TBorrowDomain> findBorrowByBookNum(String bookNum) {
        TBook book = bookMapper.findBookByBookNum(bookNum);
        Integer bookid = -1;
        if (book!=null) {
            bookid = book.getId();
        }
        List<TBorrowDomain> borrowDomains = borrowMapper.findBorrowsByBookId(bookid);
        return borrowDomains;
    }
}
