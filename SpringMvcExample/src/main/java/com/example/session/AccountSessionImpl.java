package com.example.session;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Account;

@Repository
@Transactional
public class AccountSessionImpl implements AccountSession {

	private final Logger logger = LoggerFactory
			.getLogger(AccountSessionImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAccount(Account account) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(account);
		session.flush();
		session.close();

	}

	@Override
	public List<Account> getAllAccounts() {
		Session session = sessionFactory.openSession();
		List<Account> accounts = session.createQuery("from Account").list();
		session.flush();
		session.close();
		return accounts;

	}

	@Override
	public void deleteAccount(Account account) {
		Session session = sessionFactory.openSession();
		session.delete(account);
		session.flush();
		session.close();
	}

	@Override
	public Account updateAccount(Account account) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(account);
		tx.commit();
		session.flush();
		session.close();
		return account;
	}

	@Override
	public Account getAccount(int accNo) {
		Session session = sessionFactory.openSession();
		Account acc = null;
		try {
			//acc = (Account) session.get(Account.class, accNo);
			acc = (Account)session.getNamedQuery("Account.findByAccno")
					.setParameter("accno", accNo).uniqueResult();
		} catch (Exception e) {
			logger.debug("exception occurred while loading account"
					+ e.getLocalizedMessage());
		} finally {

			session.flush();
			session.close();
		}
		return acc;
	}

}
