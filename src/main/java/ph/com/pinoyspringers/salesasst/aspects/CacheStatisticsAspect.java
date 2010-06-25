package ph.com.pinoyspringers.salesasst.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;


import javax.inject.Inject;


/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Jun 10, 2010
 * Time: 3:05:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
@Configurable
public class CacheStatisticsAspect {

    private static final Logger log = Logger.getLogger(CacheStatisticsAspect.class.getName());

    @Inject
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @After(value = "execution(* ph.com.pinoyspringers.salesasst.domain..*.*(..))")
    public void printPersistenceStatistics(JoinPoint joinPoint){

        log.debug("printPersistenceStatistics() - entry : method name =" + joinPoint.getSourceLocation());

        EntityManagerFactoryInfo test = (EntityManagerFactoryInfo) this.entityManagerFactory;
        System.out.println(((EntityManagerFactoryImpl) test.getNativeEntityManagerFactory()).getSessionFactory().getStatistics());

    }

}
