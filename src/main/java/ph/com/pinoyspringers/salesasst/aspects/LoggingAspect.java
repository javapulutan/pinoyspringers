package ph.com.pinoyspringers.salesasst.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Jun 14, 2010
 * Time: 5:52:45 PM
 * To change this template use File | Settings | File Templates.
 *
 *
 */
@Aspect
public class LoggingAspect {


    private static final Logger log = Logger.getLogger(LoggingAspect.class.getName());


    @Before(value = "execution(* ph.com.pinoyspringers.salesasst.ctrl..*.*(..))")
    public void logAction(JoinPoint joinPoint){
        log.debug("logAction() - entry : class name = " + joinPoint.getSourceLocation());
    }

}
