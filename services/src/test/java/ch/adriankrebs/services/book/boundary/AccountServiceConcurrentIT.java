package ch.adriankrebs.services.book.boundary;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;


public class AccountServiceConcurrentIT {

	private static final int THREAD_COUNT = 10;

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
	}

	@Test(dependsOnMethods = "openAccount", threadPoolSize = THREAD_COUNT, invocationCount = THREAD_COUNT)
	public void deposit() throws Exception {
		accountService.deposit(accountNr, amount);
	}

	@Test(dependsOnMethods = "deposit")
	public void checkBalance() throws Exception {
		long balance = accountService.getBalance(accountNr, pin);
		assertEquals(balance, THREAD_COUNT * amount);
	}
}
