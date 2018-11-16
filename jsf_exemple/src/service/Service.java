package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Service<T> {

	public void create(T o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}

	public List<T> findAll(String _T) {
		SessionFactory sf = util.HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<T> liste = session.createQuery("from " + _T).list();
		session.getTransaction().commit();
		session.close();
		return liste;
	}

	public T findById(Class<T> obj, int id) {
		
		SessionFactory sf = util.HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		T o = (T) session.get(obj, id);
		session.getTransaction().commit();
		session.close();
		return o;
	}

	public void delete(Class<T> obj, int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		T o = (T) session.get(obj, id);
		session.delete(o);
		session.getTransaction().commit();
	}

	public void update(T obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
	}
	public T getByLogin(String login, String password, String _T) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		T u = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session
					.createQuery("from " + _T + " where login='" + login + "' and password='" + password + "'");
			u = (T) q.uniqueResult();
			tx.commit();
			return u;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}
	
	
}
