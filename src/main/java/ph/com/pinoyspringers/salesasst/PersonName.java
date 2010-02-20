package ph.com.pinoyspringers.salesasst;

import javax.persistence.Column;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validation.constraints.NotEmpty;

/**
 * 
 * @author JSEE
 * @since 08/30/2009
 * @version 1.0
 * 
 */
@Embeddable
public class PersonName {

	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	private String firstName;

	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column(name = "MIDDLE_NAME", nullable = false, length = 20)
	private String middleName;

	@NotNull
	@NotEmpty
	@Size(max = 30)
	@Column(name = "LAST_NAME", nullable = false, length = 30)
	private String lastName;

	public PersonName() {

	}

	public PersonName(final String firstName, final String middleName,
			final String lastName) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
