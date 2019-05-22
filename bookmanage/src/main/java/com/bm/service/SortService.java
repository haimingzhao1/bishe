package com.bm.service;

import com.bm.dao.BSortMapper;
import com.bm.model.BSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortService {
    @Autowired
    BSortMapper bSortMapper;

    public BSort findSortById(Integer id) {
        return bSortMapper.selectByPrimaryKey(id);
    }

    public List<BSort> findSorts() {
        return bSortMapper.findAllSorts();
    }

    public Integer insertSort(String sortName) {
        BSort bSort = new BSort();
        bSort.setSortName(sortName);
        Integer res = bSortMapper.insertSelective(bSort);
        return res;
    }

    public Integer updateSortById(Integer id, String sortname) {
        BSort bSort = new BSort();
        bSort.setSortName(sortname);
        bSort.setId(id);
        return bSortMapper.updateByPrimaryKey(bSort);
    }

    public Integer deleteSortById(Integer id) {
        return bSortMapper.deleteByPrimaryKey(id);
    }

}
