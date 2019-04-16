package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class InternDAOImpl implements InternDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Intern> findAll() {

        return  entityManager.createQuery("SELECT i FROM Intern i", Intern.class).getResultList();

    }

    @Override
    public void saveIntern(Intern intern) {

        System.err.println(intern.getId());

        if (intern.getId() == 0)
            entityManager.persist(intern);
        else entityManager.refresh(intern);
    }


    @Override
    public void deleteIntern(int id) {

        Intern intern = entityManager.find(Intern.class, id);
        entityManager.remove(intern);




    }

    public Intern getInternById(int id) {

        Intern intern = entityManager.find(Intern.class, id);
        if ( intern == null )
        {
            throw new EntityNotFoundException("Can't find Intern for ID" + id);
        }

     return intern;

    }

    @Override
    public void save(Intern intern) {

        entityManager.merge(intern);

    }

}

