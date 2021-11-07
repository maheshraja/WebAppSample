package com.yogesh.webapp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yogesh.webapp.db.util.HibernateUtil;
import com.yogesh.webapp.model.User;


public class UserDaoImpl implements UserDao {

	@Override
	public void insertUser(User user) throws HibernateException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.save(user);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User selectUser(long userId) throws HibernateException{
		Transaction transaction = null;
		User inputUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			inputUser = session.get(User.class, userId);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return inputUser;
	}

	@Override
	public List<User> selectAllUsers() {
		Transaction transaction = null;
		List<User> usersList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			usersList = session.createQuery("from users").getResultList();
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return usersList;
	}

	@Override
	public boolean deleteUser(long userId) throws HibernateException {
		Transaction transaction = null;
		User inputUser = null;
		boolean isDeleted=false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			inputUser = session.get(User.class, userId);
			if(null!=inputUser)
			{
				session.delete(inputUser);
				isDeleted=true;
			}
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
		
		return isDeleted;
	}

	@Override
	public void updateUser(User user) throws HibernateException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(user);
			
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			throw e;
		}
	}
	
	

}
