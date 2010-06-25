package ph.com.pinoyspringers.salesasst.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ph.com.pinoyspringers.salesasst.PersonName;
import ph.com.pinoyspringers.salesasst.Profile;
import ph.com.pinoyspringers.salesasst.domain.SalesProfile;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: May 21, 2010
 * Time: 5:24:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DefaultAuthority {

//    @Autowired private SecurityService securityService;



    @PostConstruct
    public void init(){

//        Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
//        SecurityContextHolder.getContext().setAuthentication(authRequest);
//        securityService.persistDefaultUser();
//         SecurityContextHolder.clearContext();

//        admin.persist();


        Authentication authRequest = new UsernamePasswordAuthenticationToken("ignored", "ignored", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(authRequest);
        Authorities admin = new Authorities();
        admin.setAuthority("ROLE_ADMIN");
        admin.setUserName("kabilaw.101@gmail.com");
        admin.persist();
        User user = new User();
        PersonName personName = new PersonName();
        personName.setFirstName("Junar");
        personName.setMiddleName("Cabalo");
        personName.setLastName("Serilo");
        user.setPersonName(personName);
        user.setEmail("kabilaw.101@gmail.com");
        user.setPassword("admin");
        user.persist();
        SecurityContextHolder.clearContext();

    }

}
