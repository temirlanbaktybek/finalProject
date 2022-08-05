package com.example.project666.Repository;

import com.example.project666.Entity.CV;
import com.example.project666.Entity.JobSeeker;
import com.example.project666.Entity.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;


@Repository
@EnableTransactionManagement
public class JobSeekerRepository {

    Logger log = Logger.getLogger(JobSeekerRepository.class.getName());
    private static String role = "USER";
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean registerJobSeeker(JobSeeker jobSeeker){
        boolean reg = false;
        try{
            jobSeeker.setRoles(role);
            sessionFactory.getCurrentSession().saveOrUpdate(jobSeeker);
            sessionFactory.getCurrentSession().flush();
            reg = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reg;
    }

    @Transactional
    public JobSeeker findJobSeekerByLogin(String jobseeker_login) {
        JobSeeker jobSeeker = null;
        try {
            jobSeeker = sessionFactory.getCurrentSession().get(JobSeeker.class, jobseeker_login);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jobSeeker;
    }

    @Transactional
    public CV getMyCV(String acc) {
        String sql = "FROM CV C WHERE C.name = :acc";
             Query query =  sessionFactory.getCurrentSession().createQuery(sql);
             query.setString("acc", acc);
        System.out.println(query);
             CV cv = (CV) query.uniqueResult();
             return cv;
    }


    public CV findCv(String cvtitle){
        return sessionFactory.getCurrentSession().get(CV.class, cvtitle);
    }

    @Transactional
    public boolean saveOrUpdateCV(String acc, CV cv) {
        sessionFactory.getCurrentSession().flush();
        boolean saved = false;
        try{
            JobSeeker jobSeeker = findJobSeekerByLogin(acc);
            CV temp = findCv(cv.getCv_title());
            if(temp != null){
                jobSeeker.setCv(cv);
                System.out.println(jobSeeker.toString());
                cv.setCv_title(temp.getCv_title());
                sessionFactory.getCurrentSession().merge(cv);
            }else{
                sessionFactory.getCurrentSession().save(cv);

            }
            sessionFactory.getCurrentSession().saveOrUpdate(jobSeeker);
            sessionFactory.getCurrentSession().flush();
            saved = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return saved;
    }

    @Transactional
    public void deleteCv(CV cv, JobSeeker jobSeeker) {
        Session session = sessionFactory.openSession();

        try{
            CV cv1 = jobSeeker.getCv();
            if(cv1 != null){
                sessionFactory.getCurrentSession().delete(cv1);
            }
//            jobSeeker.setCv(null);
            sessionFactory.getCurrentSession().merge(jobSeeker);
            sessionFactory.getCurrentSession().flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Transactional
    public Boolean answerQ(TestResult testResult){
        boolean saved = false;
        try {
            sessionFactory.getCurrentSession().save(testResult);
            saved = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return saved;
    }


}
