package ch.adriankrebs.services.book.boundary;


import ch.adriankrebs.services.book.data.Account;
import ch.adriankrebs.services.book.exception.AccountNotFoundException;
import ch.adriankrebs.services.book.exception.InvalidPinException;
import ch.adriankrebs.services.book.exception.UnbalancedAccountException;
import ch.adriankrebs.services.book.exception.WithdrawLimitException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

@Stateless
public class AccountService implements AccountServiceRemote{

	private static final Logger logger = Logger.getLogger(AccountService.class.getName());

	@Resource(name="withdrawLimit")
	private long withdrawLimit;

	@Inject
	AccountRepository accountRepo;

	@Resource
	private EJBContext context;

	@PostConstruct
	public void postConstruct() {
		logger.warning("********************POST CONSTRUCTION PHASE");
	}

	@PreDestroy
	public void preDestroy() {
		logger.warning("********************PRE DESTRUCTION PHASE");
	}

	public int openAccount(String pin) {
		logger.info("open account");
		ch.adriankrebs.services.book.data.Account account = new Account();
		account.setPin(pin);
		accountRepo.add(account);
		return account.getNr();
	}

	public long getBalance(Integer accountNr, String pin) throws AccountNotFoundException, InvalidPinException {
		logger.info("get balance of account " + accountNr);
		Account account = accountRepo.findAccount(accountNr);
		if (account == null) {
			throw new AccountNotFoundException();
		}
		if (!account.checkPin(pin)) {
			throw new InvalidPinException();
		}
		return account.getBalance();
	}

	public void deposit(Integer accountNr, long amount) throws AccountNotFoundException {
		logger.info("deposit to account " + accountNr);
		Account account = accountRepo.findAccount(accountNr);
		if (account == null) {
			//entweder ApplicationException mir rollback = true annotieren oder transaktion hzum Rollback markieren mit Hilfe EJBContext.setRollbackOnly()
			//context.setRollbackOnly();

			throw new AccountNotFoundException();
		}
		account.deposit(amount);
	}

	public void withdraw(Integer accountNr, String pin, long amount)
			throws AccountNotFoundException, InvalidPinException, WithdrawLimitException {
		logger.info("withdraw from account " + accountNr);
		Account account = accountRepo.findAccount(accountNr);
		if (account == null) {
			throw new AccountNotFoundException();
		}
		if (!account.checkPin(pin)) {
			throw new InvalidPinException();
		}
		if (amount > 1000) {

			throw new WithdrawLimitException();
		}
		account.withdraw(amount);
	}

	public void closeAccount(Integer accountNr, String pin)
			throws AccountNotFoundException, InvalidPinException, UnbalancedAccountException {
		logger.info("close account " + accountNr);
		Account account = accountRepo.findAccount(accountNr);


		if (account == null) {
			throw new AccountNotFoundException();
		}
		if (!account.checkPin(pin)) {
			throw new InvalidPinException();
		}
		if (account.getBalance() != 0) {
			throw new UnbalancedAccountException();
		}
		accountRepo.remove(account);
	}

	@Override
	public void transfer(Integer accountNr, String pin, long amount, Integer creditAccountNr) throws Exception {
		withdraw(accountNr,pin,amount);
		deposit(creditAccountNr, amount);
	}


}
