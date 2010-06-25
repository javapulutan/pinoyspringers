package ph.com.pinoyspringers.salesasst;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;

import javax.persistence.Embeddable;
import javax.print.attribute.standard.Severity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author JSEE
 * @version 1.0
 * @since 08/30/2009
 */
@Embeddable
public class PersonName {

    @NotEmpty
    @Size(max = 20)
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @NotEmpty
    @Size(max = 20)
    @Column(name = "MIDDLE_NAME", nullable = false, length = 20)
    private String middleName;

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

    /**
     * @return
     */
    public String getFullName() {

        StringBuffer buff = new StringBuffer();

        buff.append(getFirstName())
                .append("\n")
                .append(getMiddleName())
                .append("\n")
                .append(getLastName());

        return buff.toString();

    }

    @Override
    public int hashCode() {

        int result = 0;

        result = firstName == null ? 0 : firstName.hashCode();
        result += middleName == null ? 0 : middleName.hashCode();
        result += lastName == null ? 0 : lastName.hashCode();

        return 27 * result;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof PersonName)) return false;

        PersonName that = (PersonName) obj;

        if (this == that) return true;

        return (getFirstName().equals(that.getFirstName())
                && this.getMiddleName().equals(that.getMiddleName())
                && this.getLastName().equals(that.getLastName()));


    }

}
