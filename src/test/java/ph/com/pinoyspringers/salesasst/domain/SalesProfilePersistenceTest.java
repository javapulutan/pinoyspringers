package ph.com.pinoyspringers.salesasst.domain;

import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ph.com.pinoyspringers.salesasst.BaseTest;
import ph.com.pinoyspringers.salesasst.Profile;
import ph.com.pinoyspringers.salesasst.security.Authorities;

/**
 * 
 * @author JSEE
 * @since 10/10/2009
 * @version 1.0
 * 
 */
@ContextConfiguration(value = "classpath:domain-test.xml")
public class SalesProfilePersistenceTest extends BaseTest {

	@Before
	public void initMockData() {
		super.init();

	}

   	@Test
	@Transactional
	public void testRetrieveAll() {

		List<Profile> profiles = SalesProfile.retrieveAll();
		Assert.assertTrue("DB is empty", profiles.size() > 0);

	}

	@Test
	@Transactional
	public void testRetrieveById() {

		Long id = super.retrieveRandomObj().getId();

		Profile profile = SalesProfile.retrieveById(id);

		Assert.assertNotNull(profile);

	}

	@Test
	@Transactional
	public void testPersist() {

		Profile profile = super.createTransientInstance(Integer.MAX_VALUE);
		System.out.println("--here--");
        profile.persist();
		Assert.assertNotNull(profile.getId());

        Authorities admin = new Authorities();
        admin.setAuthority("ROLE_ADMIN");
        admin.setUserName("kabilaw.101@gmail.com");
        admin.persist();

	}

	@Test
	@Transactional
	public void testMerge() {

		Profile profile = super.retrieveRandomObj();
		Assert.assertNotNull(profile);
		profile.setEmail("kabilaw.101@gmail.com");
		profile.merge();
		profile = SalesProfile.retrieveById(profile.getId());
		Assert.assertEquals("kabilaw.101@gmail.com", profile.getEmail());

	}

	@Test
	@Transactional
	public void testDelete() {

		Profile profile = super.retrieveRandomObj();
		Assert.assertNotNull(profile);
		profile.delete();
		profile = SalesProfile.retrieveById(profile.getId());
		Assert.assertNull(profile);

	}
}
