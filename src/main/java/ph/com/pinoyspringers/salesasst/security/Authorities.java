package ph.com.pinoyspringers.salesasst.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import ph.com.pinoyspringers.salesasst.DBEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: May 19, 2010
 * Time: 4:21:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "AUTHORITIES")
@Configurable
public class Authorities extends DBEntity<Authorities> {

    @PersistenceContext
    transient EntityManager entityManager;

    @Size(max = 50)
    @Column(name = "USERNAME")
    private String userName;

    @Size(max = 50)
    @Column(name = "AUTHORITY")
    private String authority;

    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {

        return authority;
    }


    public void setAuthority(String authority) {

        this.authority = authority;
    }

    @Override
    public void merge() {

    }

    @Override
    public void delete() {

    }

    @Override
    @Transactional
    public void persist() {

        if (this.entityManager == null) {
            throw new IllegalStateException("Entity Manager is null.");
        }
        System.out.println("--persist--");
        this.entityManager.persist(this);
        this.entityManager.flush();
        System.out.println("--end persist--");

    }

}
