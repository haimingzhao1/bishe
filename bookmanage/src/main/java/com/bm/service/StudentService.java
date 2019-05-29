package com.bm.service;

import com.bm.dao.TBookMapper;
import com.bm.dao.TStudentMapper;
import com.bm.dao.TUserMapper;
import com.bm.model.TBook;
import com.bm.model.TStudent;
import com.bm.model.TStudentDomain;
import com.bm.model.TUser;
import com.bm.untils.DataUtil;
import freemarker.template.utility.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    TUserMapper userMapper;
    @Autowired
    TStudentMapper studentMapper;
    @Autowired
    TBookMapper bookMapper;
    public boolean updatePasswd(TUser user,String newPass) {
        user.setPassword(newPass);
        Integer res = userMapper.updateByPrimaryKeySelective(user);
        if (res>0)
        return true;
        else
            return false;
    }

    public int updateStu(TStudent toUpdateStu) {
        return studentMapper.updateByPrimaryKeySelective(toUpdateStu);
    }

    public ArrayList<TStudentDomain> findAllStus() {
        return new ArrayList<TStudentDomain>(studentMapper.findAllStus());
    }
    @Transactional
    public int addStudent(TStudent student) {
//        System.out.println(student);
        TUser user = new TUser();
        user.setIsAdmin(0);
        user.setPassword("123456");
        user.setUsername(student.getStuNumber());
        int res1 = userMapper.insertSelective(user);
        int res2 = studentMapper.insertSelective(student);
        return res1 + res2;
    }

    public TStudentDomain findStudentDomainById(Integer id) {
        return studentMapper.findStudentDomainById(id);
    }

    public TStudent findStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
    @Transactional
    public int deleteStudent(Integer id) {
        TStudentDomain studentDomain = studentMapper.findStudentDomainById(id);
        TUser user = userMapper.findUserByStuNum(studentDomain.getStuNumber());
        int res1 = studentMapper.deleteByPrimaryKey(id);
        int res2 = userMapper.deleteByPrimaryKey(user.getId());
        return res1+res2;
    }

    public List<TBook> getHotBooks() {
        List<TBook> books = bookMapper.getHotBooks();
        for (TBook book : books) {
            book.setBookCreatetime(DataUtil.stampToDateNoSecond(book.getBookCreatetime()));
        }
        return books;
    }
}
