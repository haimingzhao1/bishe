package com.bm.service;

import com.bm.dao.TBorrowMapper;
import com.bm.model.TBorrow;
import com.bm.model.TBorrowDomain;
import com.bm.untils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BorrowService {
    @Autowired
    TBorrowMapper borrowMapper;

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
}
