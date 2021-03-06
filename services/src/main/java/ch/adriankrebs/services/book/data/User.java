package ch.adriankrebs.services.book.data;
// Generated Oct 28, 2015 11:29:04 AM by Hibernate Tools 4.3.1.Final

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User")
public class User implements java.io.Serializable {

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "Username", nullable = false, length = 100)
	private String username;
	
	@Column(name = "EMail", nullable = false, length = 100)
	private String email;
	
	@Column(name = "Password", nullable = false, length = 45)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Collection<Book> books;

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String username, String email, String password, Set books) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.books = books;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!id.equals(user.id)) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
		if (password != null ? !password.equals(user.password) : user.password != null) return false;
		return !(books != null ? !books.equals(user.books) : user.books != null);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (books != null ? books.hashCode() : 0);
		return result;
	}
}
