package com.bm.service;

import com.bm.dao.TDisciplineMapper;
import com.bm.model.TDiscipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    TDisciplineMapper disciplineMapper;

    public TDiscipline findDisciplineById(Integer id) {
        return disciplineMapper.selectByPrimaryKey(id);
    }

    public List<TDiscipline> findDisciplines() {
        return disciplineMapper.findDisciplines();
    }

    public Integer insertDiscipline(String disciplineName) {
        TDiscipline discipline = new TDiscipline();
        discipline.setDisciplineName(disciplineName);
        discipline.setDisciplineId(0);
        Integer res = disciplineMapper.insertSelective(discipline);
        return res;
    }

    public Integer updateDisciplineById(Integer id, String disciplineName) {
        TDiscipline discipline = new TDiscipline();
        discipline.setDisciplineName(disciplineName);
        discipline.setId(id);
        discipline.setDisciplineId(0);
        return disciplineMapper.updateByPrimaryKey(discipline);
    }

    public Integer deleteDisciplineById(Integer id) {
        return disciplineMapper.deleteByPrimaryKey(id);
    }
}
