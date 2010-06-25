package ph.com.pinoyspringers.salesasst.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;
import ph.com.pinoyspringers.salesasst.Profile;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: May 22, 2010
 * Time: 9:01:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TBL_USER")
@Configurable
public class User extends Profile{

    @PersistenceContext
    transient EntityManager entityManager;

    @NotNull
    @Pattern(regexp = ".+",message = "Password must not be empty.")
    private String password;


    public String getPassword(){

        return password;
    }

    public void setPassword(String password){

        this.password = password;
    }

    public void merge(){

    }


    public void delete(){

    }

    @Transactional
    @Override
    public void persist(){

        if(this.entityManager == null){
            throw new IllegalStateException("Entity Manager is null.");
        }
          System.out.println("--persist--");
        this.entityManager.persist(this);
        System.out.println("--end persist--");

    }


}
