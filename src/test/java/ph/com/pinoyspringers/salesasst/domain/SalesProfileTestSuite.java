package ph.com.pinoyspringers.salesasst.domain;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { SalesProfileValidationTest.class,
		SalesProfilePersistenceTest.class })
public class SalesProfileTestSuite {

}
