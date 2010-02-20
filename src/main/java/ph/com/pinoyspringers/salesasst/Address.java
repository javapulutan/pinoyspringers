package ph.com.pinoyspringers.salesasst;


import javax.persistence.Column;

import javax.persistence.Embeddable;

/**
 * 
 * @author JSEE
 * @since 08/24/2009
 * 
 */
@Embeddable
public class Address {
    
	@Column(name = "STREET")
	private String street;

	@Column(name = "TOWN")
	private String town;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PROVINCE")
	private String province;

	@Column(name = "COUNTRY")
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
