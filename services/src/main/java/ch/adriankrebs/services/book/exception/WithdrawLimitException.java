package ch.adriankrebs.services.book.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class WithdrawLimitException extends Exception {
}
