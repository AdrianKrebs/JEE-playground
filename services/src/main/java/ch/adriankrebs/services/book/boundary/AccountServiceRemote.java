package ch.adriankrebs.services.book.boundary;

import javax.ejb.Remote;

@Remote
public interface AccountServiceRemote {


    public int openAccount(String pin);
    public long getBalance(Integer accountNr, String pin) throws Exception;
    public void deposit(Integer accountNr, long amount) throws Exception;
    public void withdraw(Integer accountNr, String pin, long amount) throws Exception;
    public void closeAccount(Integer accountNr, String pin) throws Exception;
    public void transfer(Integer accountNr, String pin, long amount, Integer creditAccountNr) throws Exception;
}
