package ph.com.pinoyspringers.salesasst.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import ph.com.pinoyspringers.salesasst.BaseTest;
import ph.com.pinoyspringers.salesasst.Profile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Jun 29, 2010
 * Time: 3:39:58 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(value = "classpath:domain-test.xml")
public class SalesLeadsTest extends BaseTest {

    @Before
    public void initMockData(){

        init();

    }

    @Test
    public void create(){

        SalesProfile profile = new SalesProfile("Junar","Cabalo","Serilo");
        Lead lead = new Lead();

        profile.getLeads().add(lead);
        profile.persist();
        
        List<Lead> leads = new ArrayList<Lead>(profile.getLeads());

        Assert.isTrue(leads.size() > 0);
        Assert.notNull(leads.get(0).getId() > 0);


    }

    public void delete(){

    }

    public void update(){

    }

    public void listAll(){

    }



    
}
