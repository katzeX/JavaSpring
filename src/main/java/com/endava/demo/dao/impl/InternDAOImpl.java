package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class InternDAOImpl implements InternDAO {


    public static List<Intern> internList = new ArrayList<>();

    private static Session currentSession;

    private static Transaction currentTransaction;

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Intern.class).buildSessionFactory();
        return sessionFactory;
    }

    public static Session openSession() {
        return currentSession = getSessionFactory().openSession();
    }

    public static Transaction beginTransaction() {
        currentTransaction = currentSession.beginTransaction();
        return currentTransaction;
    }

    public static void closeTransaction() {
        beginTransaction().commit();
    }

    @Override
    public List<Intern> findAll() {

        internList = openSession().createQuery("SELECT i FROM Intern i", Intern.class).getResultList();

        openSession().close();

        return internList;
    }

    @Override
    public void saveIntern(Intern intern) {


        openSession();
        currentSession.beginTransaction();
        currentSession.persist(intern);
        currentSession.getTransaction().commit();
        closeTransaction();
        currentSession.close();

    }

    @Override
    public int getMaxID() {
        return internList
                .stream()
                .max(Comparator.comparingInt(Intern::getId))
                .get()
                .getId();
    }

    @Override
    public void deleteIntern(int id) {
        openSession();
        currentTransaction = beginTransaction();

        Intern intern = currentSession.get(Intern.class, id);
        currentSession.delete(intern);
        currentTransaction.commit();
        currentSession.close();

       //closeTransaction();

    }

    public Optional<Intern> getInternById(int id) {
        currentSession = openSession();


        Optional<Intern> internList = currentSession
                .createQuery("SELECT i FROM Intern i WHERE id=:iId", Intern.class)
                .setParameter("iId", id)
                .getResultList().stream().findFirst();

        currentSession.close();
        return internList;

    }

    @Override
    public void update(Intern intern) {
        openSession();


        currentSession.merge(intern);
        currentTransaction.commit();
        currentSession.close();
        closeTransaction();
    }

}

