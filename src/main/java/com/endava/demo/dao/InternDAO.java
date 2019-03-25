package com.endava.demo.dao;

import com.endava.demo.entity.Intern;
import com.endava.demo.entity.InternStreams;

import java.util.List;

public interface InternDAO {
     List<Intern> findAll();
    void save(Intern intern);
    int getMaxID();
    Intern getInternById(int id);
    void delete(int id);
    void update(Intern intern);

}
