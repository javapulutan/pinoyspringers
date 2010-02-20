package ph.com.pinoyspringers.salesasst.domain;

import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ph.com.pinoyspringers.salesasst.Profile;

/**
 * 
 * @author JSEE
 * @since 10/10/2009
 * @version 1.0
 * 
 */
public class SalesProfilePersistenceTest extends BaseTest {

	@Before
	public void initMockData() {
		init();

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

		Long id = retrieveRandomObj().getId();

		Profile profile = SalesProfile.retrieveById(id);

		Assert.assertNotNull(profile);

	}

	@Test
	@Transactional
	public void testPersist() {

		Profile profile = createTransientInstance(Integer.MAX_VALUE);
		profile.persist();
		Assert.assertNotNull(profile.getId());
	}

	@Test
	@Transactional
	public void testMerge() {

		Profile profile = retrieveRandomObj();
		Assert.assertNotNull(profile);
		profile.setEmail("test email");
		profile.merge();
		profile = SalesProfile.retrieveById(profile.getId());
		Assert.assertEquals("test email", profile.getEmail());

	}

	@Test
	@Transactional
	public void testDelete() {

		Profile profile = retrieveRandomObj();
		Assert.assertNotNull(profile);
		profile.delete();
		profile = SalesProfile.retrieveById(profile.getId());
		Assert.assertNull(profile);

	}

	@Transactional
	private void init() {

		List<Profile> profiles = SalesProfile.retrieveAll();

		if (profiles.size() <= 0) {

			for (int i = 0; i < 20; i++) {
				Profile profile = createTransientInstance(i);
				profile.persist();
			}
		}

	}

	private Profile createTransientInstance(int index) {

		Profile profile = new SalesProfile("Junar" + index, "Cabalo" + index,
				"Serilo" + index);

		return profile;

	}

	private Profile retrieveRandomObj() {

		Random rnd = new java.security.SecureRandom();

		List<Profile> profiles = SalesProfile.retrieveAll();

		return profiles.get(rnd.nextInt(profiles.size()));
	}

}
