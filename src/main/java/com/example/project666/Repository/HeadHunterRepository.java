package com.example.project666.Repository;

import com.example.project666.Entity.HeadHunter;
import com.example.project666.Entity.TestResult;
import com.example.project666.Entity.Tests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
@EnableTransactionManagement
public class HeadHunterRepository {

    Logger log = Logger.getLogger(HeadHunterRepository.class.getName());
    private static String role = "HEADHUNTER";
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean registerHeadHunter(HeadHunter headHunter){
        boolean reg = false;
        try{
            headHunter.setRoles(role);
            sessionFactory.getCurrentSession().saveOrUpdate(headHunter);
            sessionFactory.getCurrentSession().flush();
            reg = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reg;
    }


    @Transactional
    public HeadHunter findHeadHunterByLogin(String acc) {
        HeadHunter temp = null;
        try {
            temp = sessionFactory.getCurrentSession().get(HeadHunter.class, acc);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return temp;
    }

    @Transactional
    public boolean createTest(Tests tests, String acc){
        boolean created = false;
        try {
            HeadHunter headHunter = findHeadHunterByLogin(acc);
            List<Tests> t = new ArrayList<>();
            t.add(tests);
            headHunter.updateTest(tests);
            sessionFactory.getCurrentSession().merge(tests);
            sessionFactory.getCurrentSession().merge(headHunter);
            sessionFactory.getCurrentSession().flush();
            created = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return created;
    }

    @Transactional
    public List<HeadHunter> getAllTest(String acc) {
        List<HeadHunter> tests = new ArrayList<>();
        try {
            String sql = "FROM HeadHunter ";
            Session session = sessionFactory.openSession();
            Query query = session.createQuery(sql);
            tests = query.list();
//            tests = sessionFactory.getCurrentSession().get(Tests.class, acc);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tests;
    }

    @Transactional
    public List<Tests> getTest (){
        List<Tests> tests1 = new ArrayList<>();
        try{
            String sql2 = "FROM Tests ";
            Session session = sessionFactory.openSession();
            Query query1 = session.createQuery(sql2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return tests1;
    }

    @Transactional
    public  List<TestResult> getTestResults(){
        String s = "FROM TestResult";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(s);

        List<TestResult> temp = query.list();
        return temp;
    }
}
