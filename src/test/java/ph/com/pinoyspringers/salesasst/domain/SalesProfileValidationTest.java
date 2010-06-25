package ph.com.pinoyspringers.salesasst.domain;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.test.context.ContextConfiguration;
import ph.com.pinoyspringers.salesasst.BaseTest;
import ph.com.pinoyspringers.salesasst.Address;
import ph.com.pinoyspringers.salesasst.Profile;

/**
 * @author JSEE
 * @version 1.0
 * @since 08/27/2009
 */
@ContextConfiguration(value = "classpath:domain-test.xml")
public class SalesProfileValidationTest extends BaseTest {

    @Inject
    private ValidatorFactory validatorFactory;

    private static Validator validator;

    private static Map<Integer, Map<Profile, Integer>> mockTestProfiles;

    @BeforeClass
    public static void setUpMockData() {

        Map<Profile, Integer> mapProfiles = new HashMap<Profile, Integer>();
        Profile profile = null;

        mockTestProfiles = new HashMap<Integer, Map<Profile, Integer>>();

        mapProfiles.put(new SalesProfile("First", "Middle", "Last"), 0);
        mapProfiles.put(new SalesProfile(null, "Middle", "Last"), 1);
        mapProfiles.put(new SalesProfile("First", null, "Last"), 1);
        mapProfiles.put(new SalesProfile("First", "Middle", null), 1);
        mapProfiles.put(new SalesProfile(null, null, "Last"), 2);
        mapProfiles.put(new SalesProfile(null, null, null), 3);

        mockTestProfiles.put(1, mapProfiles);

        mapProfiles = new HashMap<Profile, Integer>();
        profile = new SalesProfile("First_1", "Middle", "Last");
        profile.setGender("M");
        mapProfiles.put(profile, 0);
        profile = new SalesProfile("First_2", "Middle", "Last");
        profile.setGender("F");
        mapProfiles.put(profile, 0);
        profile = new SalesProfile("First_3", "Middle", "Last");
        profile.setGender("K");
        mapProfiles.put(profile, 1);
        mockTestProfiles.put(2, mapProfiles);

        mapProfiles = new HashMap<Profile, Integer>();
        Address address = new Address();
        profile = new SalesProfile("First_1", "Middle", "Last");
        profile.setCivilStatus("S");
        profile.setAddress(address);
        mapProfiles.put(profile, 0);
        profile = new SalesProfile("First_2", "Middle", "Last");
        profile.setCivilStatus("M");
        mapProfiles.put(profile, 0);
        profile = new SalesProfile("First_3", "Middle", "Last");
        profile.setCivilStatus("D");
        mapProfiles.put(profile, 0);
        profile = new SalesProfile("First_4", "Middle", "Last");
        profile.setCivilStatus("K");
        mapProfiles.put(profile, 1);
        mockTestProfiles.put(3, mapProfiles);

    }

    @Before
    public void setUpValidator() {

        Assert.assertNotNull(validatorFactory);
        validator = validatorFactory.getValidator();

    }

    @Test
    public void checkMockData() {

        Assert.assertNotNull(mockTestProfiles.get(1));
    }

    @Test
    public void testCompleteProfileName() {

        for (Entry<Profile, Integer> entry : mockTestProfiles.get(1).entrySet()) {

            testValidateProfile(entry.getKey(), entry.getValue());

        }

    }

    @Test
    public void testProfileGenderValues() {

        for (Entry<Profile, Integer> entry : mockTestProfiles.get(2).entrySet()) {

            testValidateProfile(entry.getKey(), entry.getValue());

        }

    }

    @Test
    public void testProfileCivilStatusValues() {

        for (Entry<Profile, Integer> entry : mockTestProfiles.get(3).entrySet()) {

            testValidateProfile(entry.getKey(), entry.getValue());

        }

    }

//    @Test
    public void testValidProfileEmail() {


        Profile profile = new SalesProfile("First", "Middle", "Last");

        profile.setEmail("test@gmail.com");
        testValidateProfile(profile, 0);

    }

//    @Test
    public void testInvalidProfileEmail() {


        Profile profile = new SalesProfile("First", "Middle", "Last");

        profile.setEmail("test#gmail.com");
        testValidateProfile(profile, 1);

    }


    @Test
    public void testCustomValidationMessage() {

        Map<Profile, Integer> copyMockTests = new HashMap<Profile, Integer>();

        copyMockTests.putAll(mockTestProfiles.get(2)); // Gender
        copyMockTests.putAll(mockTestProfiles.get(3)); // Civil Status

        for (Entry<Profile, Integer> entry : copyMockTests.entrySet()) {

            testValidationMessage(entry.getKey(), "Invalid code.");

        }

    }


    /**
     * @param profile
     * @param expectedConstraint
     */
    private static void testValidateProfile(final Profile profile,
                                            final int expectedConstraint) {

        Set<ConstraintViolation<Profile>> profiles = validator
                .validate(profile);

        Assert.assertEquals(expectedConstraint, profiles.size());

    }

    /**
     * @param profile
     * @param expectedMessage
     */
    private static void testValidationMessage(final Profile profile,
                                              final String expectedMessage) {

        Set<ConstraintViolation<Profile>> profiles = validator
                .validate(profile);

        for (ConstraintViolation<Profile> cv : profiles) {

            Assert.assertEquals(expectedMessage, cv.getMessage());

        }

    }

}
