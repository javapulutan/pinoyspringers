package ph.com.pinoyspringers.salesasst;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ph.com.pinoyspringers.salesasst.domain.SalesProfile;

import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseTest {

    private static int PROFILE_MAX_SIZE = 20;

    @Transactional
    protected void init() {

        List<Profile> profiles = SalesProfile.retrieveAll();

        if (profiles.size() <= 0) {

            for (int i = 0; i < PROFILE_MAX_SIZE; i++) {
                Profile profile = createTransientInstance(i);
                profile.persist();
            }
        }

    }

    /**
     *
     * @param index
     * @return
     */
    protected Profile createTransientInstance(int index) {

        Profile profile = new SalesProfile("Junar" + index, "Cabalo" + index,
                "Serilo" + index);

        return profile;

    }

    /**
     *
     * @return
     */
    protected Profile retrieveRandomObj() {

        Random rnd = new java.security.SecureRandom();

        List<Profile> profiles = SalesProfile.retrieveAll();

        return profiles.get(rnd.nextInt(profiles.size()));
    }
}
