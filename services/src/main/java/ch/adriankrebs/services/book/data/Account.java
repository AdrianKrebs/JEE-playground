package ch.adriankrebs.services.book.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nr;

	/*@Version
	private Long version; */ //wäre dann für optimistic, in dem fall wollen wir pessimistic weil bank

	private String pin;
	private long balance;

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public boolean checkPin(String pin) {
		return pin.equals(this.pin);
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public long getBalance() {
		return balance;
	}

	public void deposit(long amount) {
		long temp = balance;
		balance = temp + amount;
	}

	//nötig weil via EJB parallel darauf zugegriffen wird
	// allenfalls lost update problem wenn nicht synchronized
	public  void withdraw(long amount) {
		long temp = balance;
		balance = temp - amount;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(nr);
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Account && Objects.equals(((Account) obj).nr, nr);
	}

	private void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
	}
}
