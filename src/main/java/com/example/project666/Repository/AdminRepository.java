package com.example.project666.Repository;

import com.example.project666.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableTransactionManagement
@EnableCaching
public class AdminRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JobSeekerRepository jr;

    @Autowired
    private HeadHunterRepository hr;

    @Transactional
    public void createAdmin(Admin admin){
        try{
            sessionFactory.getCurrentSession().save(admin);
            System.out.println("saved");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Transactional
    public boolean deleteUSER(String acc){
        boolean deleted = false;
        Query query;
        try{
            JobSeeker temp = jr.findJobSeekerByLogin(acc);
            CV cv = temp.getCv();
            if(cv != null){
                sessionFactory.getCurrentSession().delete(cv);
            }
            if(temp != null){
                sessionFactory.getCurrentSession().delete(temp);
            }
            sessionFactory.getCurrentSession().flush();

            deleted = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  deleted;
    }


    @Transactional
    public boolean deleteUSERcv(String acc) {
        boolean deleted = false;
        try {
            deleted = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return deleted;
    }

    @Transactional
    @Cacheable(cacheNames = "gelAllUsers")
    public List<JobSeeker> getALLUsers() {
        String sql = "FROM JobSeeker ";
        Query query = sessionFactory.openSession().createQuery(sql);
        List<JobSeeker> temp = query.list();
        return temp;
    }

    @Transactional
    @Cacheable(cacheNames = "gelAllHeadHunters")
    public List<HeadHunter> getAllHeadHunter(){
        String s = "FROM HeadHunter";
        List<HeadHunter> temp =sessionFactory.getCurrentSession().createQuery(s).list();
            return temp;
    }

    @Transactional
    public boolean deleteHEADHUNTER(String acc){
        boolean deleted = false;
        try{
            HeadHunter temp = hr.findHeadHunterByLogin(acc);
            List<Tests> tests = temp.getTests();
            if(tests != null){
                for (Tests t : tests){
                    sessionFactory.getCurrentSession().delete(t);
                }
            }
            if(temp != null){
                sessionFactory.getCurrentSession().delete(temp);
            }
            sessionFactory.getCurrentSession().flush();

            deleted = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  deleted;
    }


    @Transactional
    public String batchOp(){
        int batchSize = 30, totalRecords = 100;
        String sqlQuery = "FROM JobSeeker";
        Session session = sessionFactory.openSession();
        List<JobSeeker> jobSeekers = session.createQuery(sqlQuery).list();
        for (int j = 0; j < jobSeekers.size(); j++) {
            JobSeeker projectObj = jobSeekers.get(j);
            projectObj.setRoles("USERS");
            session.update(projectObj);
            if (j % batchSize == 0 && j > 0) {
                session.flush();
                session.clear();
        }
        }
        return ("Records Updated Successfully In The Database.......");
    }

}
