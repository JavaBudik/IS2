package pack.pojo;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Super users table with common fields for all users.
 * @author kfidria
 *
 */
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category", 
		discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("@")
public class User {

	/** id of user. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** login of user. */
	@Column(name = "Login", nullable = false)
	private String login;

	/** password of user. */
	@Column(name = "Password", nullable = false)
	private String password;

	/** phone of user. */
	@Column(name = "Phone", nullable = false)
	private String phone;

	/** secret question of user. */
	@Column(name = "Question", nullable = true)
	private String question;

	/** secret answer of user. */
	@Column(name = "Answer", nullable = true)
	private String answer;
	
	/** status of user. */
	@Column(name = "Status", nullable = false)
	private String status;
	
	/** .**************.Getters & Setters.***********************. */

	/**
	 * @return id of user.
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @return login
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * @return password longer then 8 characters.
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @return phone with 12 digits.
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * @return secret question.
	 */
	public final String getQuestion() {
		return question;
	}

	/**
	 * @return - answer for secret question.
	 */
	public final String getAnswer() {
		return answer;
	}

	
	
	/**
	 * @return Checked or Unchecked.
	 */
	public final String getStatus() {
		return status;
	}	

	/**
	 * @param identificator identificator of user.
	 */
	public final void setId(final Long identificator) {
		this.id = identificator;
	}

	/**
	 * @param usersLogin - login for entering the system.
	 */
	public final void setLogin(final String usersLogin) {
		this.login = usersLogin;
	}

	/**
	 * @param pass password for entering the system.
	 */
	public final void setPassword(final String pass) {
		this.password = pass;
	}

	/**
	 * @param telephone 12 digits phone.
	 */
	public final void setPhone(final String telephone) {
		this.phone = telephone;
	}

		/**
	 * @param secretQuestion secret question.
	 */
	public final void setQuestion(final String secretQuestion) {
		this.question = secretQuestion;
	}

	/**
	 * @param secretAnswer answer for secret question.
	 */
	public final void setAnswer(final String secretAnswer) {
		this.answer = secretAnswer;
	}

	/**
	 * @param usersStatus Checked or Unchecked.
	 */
	public final void setStatus(final String usersStatus) {
		this.status = usersStatus;
	}
}
