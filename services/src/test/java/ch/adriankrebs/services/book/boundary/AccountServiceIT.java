package ch.adriankrebs.services.book.boundary;


import ch.adriankrebs.services.book.exception.AccountNotFoundException;
import ch.adriankrebs.services.book.exception.InvalidPinException;
import ch.adriankrebs.services.book.exception.WithdrawLimitException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import static org.junit.Assert.*;

public class AccountServiceIT {

	private static final long WITHDRAW_LIMIT = 1000;

	private AccountServiceRemote accountService;

	private Integer accountNr;
	private String pin = "12345";
	private long amount = 1000;


	@BeforeClass
	public void setUp() throws NamingException {
		Context jndiContext = new InitialContext();
		accountService = (AccountServiceRemote) jndiContext.lookup("java:global/services-1.0-SNAPSHOT/AccountService");
	}

	@Test
	public void openAccount() throws Exception {
		accountNr = accountService.openAccount(pin);
		assertNotNull(accountNr);
		try {
			accountService.getBalance(accountNr, "54321");
			fail("InvalidPinException expected");
		} catch (InvalidPinException ex) {
		}
	}

	@Test(dependsOnMethods = "openAccount")
	public void deposit() throws Exception {
		long balance = accountService.getBalance(accountNr, pin);
		accountService.deposit(accountNr, 2000);
		assertEquals(accountService.getBalance(accountNr, pin), balance + 2000);
	}

	@Test(dependsOnMethods = "openAccount")
	public void withdraw() throws Exception {
		long balance = accountService.getBalance(accountNr, pin);
		accountService.withdraw(accountNr, pin, amount);
		assertEquals(accountService.getBalance(accountNr, pin), balance - amount);
		try {
			accountService.withdraw(accountNr, pin, WITHDRAW_LIMIT + 1);
			fail("WithdrawLimitException expected");
		} catch (WithdrawLimitException ex) {
		}
	}

	@Test(dependsOnMethods = {"deposit", "withdraw"})
	public void closeAccount() throws Exception {
		accountService.closeAccount(accountNr, pin);
		try {
			accountService.getBalance(accountNr, pin);
			fail("AccountNotFoundException expected");
		} catch (AccountNotFoundException ex) { ;
		}
	}
	@Test(dependsOnMethods = "openAccount")
	public void transfer() throws Exception {
		long balance = accountService.getBalance(accountNr, pin);
		Integer creditAccountNr = accountService.openAccount(pin);
		accountService.transfer(accountNr, pin, amount, creditAccountNr);
		assertEquals(accountService.getBalance(accountNr, pin), balance - amount);
		assertEquals(accountService.getBalance(creditAccountNr, pin), amount);
		balance = accountService.getBalance(accountNr, pin);
		try {
			accountService.transfer(accountNr, pin, amount, 0);
		} catch (AccountNotFoundException ex) {
			System.out.println("exception");
		}
		assertEquals(accountService.getBalance(accountNr, pin), balance);
	}

}
