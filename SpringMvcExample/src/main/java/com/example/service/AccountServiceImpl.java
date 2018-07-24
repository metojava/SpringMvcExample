package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Account;
import com.example.session.AccountSession;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountSession accountSession;

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public void addAccount(Account account) {
		accountSession.addAccount(account);
	}

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public List<Account> getAllAccounts() {
		return accountSession.getAllAccounts();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public void deleteAccount(Account account) {
		accountSession.deleteAccount(account);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public Account updateAccount(Account account) {
		account.getCustomerList().get(0).setAccno(account);
		return accountSession.updateAccount(account);
	}

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public Account getAccount(int accNo) {
		return accountSession.getAccount(accNo);
	}

}
