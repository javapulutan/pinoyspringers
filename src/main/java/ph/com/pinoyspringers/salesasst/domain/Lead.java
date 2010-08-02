package ph.com.pinoyspringers.salesasst.domain;

import ph.com.pinoyspringers.salesasst.BaseEntity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Jun 27, 2010
 * Time: 1:44:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="TBL_LEADS")
public class Lead extends BaseEntity{

    @Column(name = "LEAD_NAME",unique = true)
    private String name;


    @ManyToOne
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
