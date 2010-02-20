package ph.com.pinoyspringers.salesasst;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * A Base class that can be extended by all the child classes that uses it. It
 * defines a unique ID for object identity.
 * 
 * @author jcserilo
 * @since 1.0
 * 
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	@Column(name = "VERSION")
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isNew() {
		return (id == null);
	}

}
