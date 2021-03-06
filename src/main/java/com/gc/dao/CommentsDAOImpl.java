package com.gc.dao;

import com.gc.models.CommentsEntity;
import com.gc.models.PostsEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.ui.Model;
import sun.security.tools.policytool.PolicyTool;

import java.util.ArrayList;


public class CommentsDAOImpl implements CommentsDAO {
    /**
     * @param newComments
     */
    public void save(CommentsEntity newComments) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.save(newComments);
        tx.commit();
        s.close();
    }

    /**
     * @param userID
     */
    public void deleteCommentsByUser(int userID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(userID);

        tx.commit();
        s.close();
    }

    /**
     * @param commentID
     */
    public void deleteComment(int commentID) {
        Session s = getSession();
        Transaction tx = s.beginTransaction();
        s.delete(commentID);

        tx.commit();
        s.close();
    }

    /**
     * @return
     */
    private Session getSession() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        return sessionFact.openSession();
    }

    /**
     * @param model
     * @param postId
     * @return
     */
    public ArrayList<CommentsEntity> getAllComments(Model model, int postId) {

        Session s = getSession();
        Transaction tx = s.beginTransaction();
        PostsEntity temp = (PostsEntity) s.get(PostsEntity.class, postId);

        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("postId", postId));


        model.addAttribute("postId", temp.getPostId());
        model.addAttribute("postTitle", temp.getPostTitle());
        model.addAttribute("postDescription", temp.getPostDescription());

        return (ArrayList<CommentsEntity>) c.list();
    }

    /**
     * @param userId
     * @return
     */
    public ArrayList<CommentsEntity> getUserComments(int userId) {

        Session s = getSession();
        Transaction tx = s.beginTransaction();

        Criteria c = s.createCriteria(CommentsEntity.class);
        c.add(Restrictions.like("userId", userId));

        return (ArrayList<CommentsEntity>) c.list();
    }

}
