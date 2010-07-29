package ph.com.pinoyspringers.salesasst.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.*;


import org.hibernate.annotations.Cache;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import ph.com.pinoyspringers.salesasst.PersonName;
import ph.com.pinoyspringers.salesasst.Profile;

import static org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE;

/**
 * @author JSEE
 * @since 08/24/2009
 */

@Cache(usage = READ_WRITE)
@Entity
@Table(name = "TBL_SALES_PROFILE")
@Configurable
public class SalesProfile extends Profile {

    @PersistenceContext
    transient EntityManager entityManager;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(name = "TBL_SALES_LEADS")
    private Set<Lead> leads = new HashSet<Lead>();

    public SalesProfile() {

    }

    public SalesProfile(String firstName, String middleName, String lastName) {
        super(firstName, middleName, lastName);
    }


    public Set<Lead> getLeads() {
        return leads;
    }

    public void setLeads(Set<Lead> leads) {
        this.leads = leads;
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

    @Transactional
    @Override
    public void merge() {

        if (this.entityManager == null) {
            throw new IllegalStateException("Entity Manager is null");
        }

        this.entityManager.merge(this);
        this.entityManager.flush();

    }

    @Transactional(readOnly = true)
    public static List<Profile> retrieveAll() {

        EntityManager em = (new SalesProfile()).entityManager;

        if (em == null) {
            throw new IllegalStateException("Entity Manager is null");
        }

        return em.createQuery("SELECT sp FROM SalesProfile sp", Profile.class).getResultList();

    }

    @Transactional(readOnly = true)
    public static Profile retrieveById(Long id) {

        EntityManager em = (new SalesProfile()).entityManager;

        if (em == null) {
            throw new IllegalStateException("Entity Manager is null");
        }

        return em.find(SalesProfile.class, id);

    }

    @Override
    public int hashCode() {

        int result = 0;

        PersonName personName = getPersonName();

        result = personName == null ? 0 : getPersonName().hashCode();

        return 27 * result;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;

        if (!(obj instanceof SalesProfile)) return false;

        SalesProfile that = (SalesProfile) obj;

        if (this == that) return true;

        return this.getPersonName().equals(that.getPersonName());


    }

}
