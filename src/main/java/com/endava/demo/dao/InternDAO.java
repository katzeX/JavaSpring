package com.endava.demo.dao;

import com.endava.demo.entity.Intern;

import java.util.List;
import java.util.Optional;

public interface InternDAO {
    List<Intern> findAll();

    void saveIntern(Intern intern);

    int getMaxID();

    void deleteIntern(int id);

    Optional<Intern> getInternById(int id);

    void update(Intern intern);
}
