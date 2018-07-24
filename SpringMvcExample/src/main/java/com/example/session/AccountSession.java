package com.example.session;

import java.util.List;

import com.example.domain.Account;

public interface AccountSession {

	public void addAccount(Account account);

	public List<Account> getAllAccounts();

	public void deleteAccount(Account account);

	public Account updateAccount(Account account);

	public Account getAccount(int accNo);

}
