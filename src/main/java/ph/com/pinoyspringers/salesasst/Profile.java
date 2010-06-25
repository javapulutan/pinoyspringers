package ph.com.pinoyspringers.salesasst;


import javax.persistence.Column;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import ph.com.pinoyspringers.validator.constraint.CheckValues;

/**
 * @author JSEE
 * @since 08/24/2009
 */
@MappedSuperclass
public abstract class Profile extends DBEntity<Profile> {

    @Valid
    @Embedded
    private PersonName personName;

    @CheckValues(strValues = {"M", "F"})
    @Size(max = 1)
    @Column(name = "GENDER", length = 1)
    private String gender;

    @CheckValues(strValues = {"S", "M", "D"})
    @Size(max = 1)
    @Column(name = "CIVIL_STATUS", length = 1)
    private String civilStatus;

    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Email Invalid!")
    @Column(name = "EMAIL")
    private String email;

    @Valid
    @Embedded
    private Address address;

//    @NotNull
//    @Pattern(regexp = ".+", message = "Password must not be empty!")
//	@Column(name="PASSWORD")
//    private String password;

    public Profile() {

    }

    public Profile(final String firstName, final String middleName,
                   final String lastName) {

        this.personName = new PersonName(firstName, middleName, lastName);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

}
