package ph.com.pinoyspringers.salesasst.domain;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;

import ph.com.pinoyspringers.salesasst.Profile;

/**
 * 
 * @author JSEE
 * @since 08/24/2009
 */
@Entity
@Table(name = "TBL_SALES_PROFILE")
@Configurable
public class SalesProfile extends Profile {

	@PersistenceContext
	transient EntityManager entityManager;

	public SalesProfile() {

	}

	public SalesProfile(String firstName, String middleName, String lastName) {
		super(firstName, middleName, lastName);
	}

	@Transactional
	@Override
	public void delete() {

		if (this.entityManager == null) {
			throw new IllegalStateException("Entity Manager is null");
		}

		this.entityManager.remove(this);

	}

	@Transactional
	@Override
	public void persist() {

		if (this.entityManager == null) {
			throw new IllegalStateException("Entity Manager is null");
		}

		this.entityManager.persist(this);

	}

	@Override
	public void merge() {

		if (this.entityManager == null) {
			throw new IllegalStateException("Entity Manager is null");
		}

		this.entityManager.merge(this);
		this.entityManager.flush();

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public static List<Profile> retrieveAll() {

		EntityManager em = (new SalesProfile()).entityManager;

		if (em == null) {
			throw new IllegalStateException("Entity Manager is null");
		}

		return em.createQuery("SELECT sp FROM SalesProfile sp").getResultList();

	}

	@Transactional(readOnly = true)
	public static Profile retrieveById(Long id) {

		EntityManager em = (new SalesProfile()).entityManager;

		if (em == null) {
			throw new IllegalStateException("Entity Manager is null");
		}

		return em.find(SalesProfile.class, id);

	}

}
