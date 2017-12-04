package ch.adriankrebs.services.book.boundary;

import ch.adriankrebs.services.book.data.Account;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.SUPPORTS;

@Stateless
@LocalBean //optional aber sollte man machen
public class AccountRepository {


    @PersistenceContext
    EntityManager em;

    public void add(Account account) {
        em.persist(account);
        em.flush();

    }

    @TransactionAttribute(SUPPORTS) // beim find ist es mir egal ob ich eine tx habe
    public Account findAccount(Integer accountNr) {
        return em.find(Account.class, accountNr, LockModeType.PESSIMISTIC_WRITE);
    }

    @TransactionAttribute(MANDATORY) // client muss bereits eine tx haben. default ist required und würde evtl dann hier erst eine erzeugen, auch ok
    public boolean remove(Account account) {
        try {
            account = em.getReference(Account.class, account.getNr());
            em.remove(account);
            return true;
        } catch (EntityExistsException ex ) {
            return false;
        }
    }

}
