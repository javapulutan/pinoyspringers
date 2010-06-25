package ph.com.pinoyspringers.salesasst.ctrl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import ph.com.pinoyspringers.salesasst.BaseTest;
import ph.com.pinoyspringers.salesasst.Profile;
import ph.com.pinoyspringers.salesasst.domain.SalesProfile;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Mar 10, 2010
 * Time: 6:02:23 PM
 * To change this\\\ template use File | Settings | File Templates.
 */
@ContextConfiguration(value = "classpath:controller-test.xml")
public class ProfileControllerTest extends BaseTest {

    @Inject
    private ProfileController profileController;

    @Before
    public void initMockData() {

        super.init();
    }


    @Test
    @Transactional
    public void testCreate() {

        Assert.assertNotNull(profileController);

        SalesProfile profile = (SalesProfile) super.createTransientInstance(Integer.MAX_VALUE);

        BindingResult result = new BeanPropertyBindingResult(profile, "profile");

        String page = profileController.create(profile, result);

        Assert.assertNotNull(profile.getId());
        Assert.assertEquals("redirect:/profile/" + profile.getId(), page);
    }


    @Test
    @Transactional
    public void testEdit() {

        Assert.assertNotNull(profileController);

        Profile profile = super.retrieveRandomObj();

        ModelMap modelMap = new ModelMap();

        String page = profileController.edit(profile.getId(), modelMap);

        Assert.assertNotNull(modelMap.get("profile"));
        Assert.assertEquals("profile/edit", page);


    }

    @Test
    @Transactional
    @SuppressWarnings("unchecked")
    public void testDelete() {

        Assert.assertNotNull(profileController);

        Profile profile = super.retrieveRandomObj();

        Assert.assertNotNull(profile);

        ModelMap modelMap = new ModelMap();

        String page = profileController.delete(profile.getId(),modelMap);

        profile = SalesProfile.retrieveById(profile.getId());

        List<Profile> profiles = (List<Profile>)modelMap.get("profiles");

        Assert.assertFalse(profiles.contains(profile));
        Assert.assertEquals("profile/list",page);

    }


    @Test
    @Transactional
    public void testUpdate() {

        Assert.assertNotNull(profileController);

        Profile profile = super.retrieveRandomObj();

        ModelMap modelMap = new ModelMap();

        profile.setEmail("kabilaw.101@gmail.com");
        BindingResult result = new BeanPropertyBindingResult(profile, "profile");

        String page = profileController.update((SalesProfile) profile, result);

        Assert.assertEquals("redirect:/profile/" + profile.getId(), page);

        profileController.edit(profile.getId(), modelMap);
        Assert.assertEquals("kabilaw.101@gmail.com", ((SalesProfile) modelMap.get("profile")).getEmail());


    }


    @Test
    @Transactional
    public void testCreateForm() {

        Assert.assertNotNull(profileController);

        ModelMap modelMap = new ModelMap();

        String page = profileController.createForm(modelMap);

        Assert.assertEquals("profile/create", page);

        Assert.assertNotNull(modelMap.get("profile"));

    }


    @Test
    @Transactional
    @SuppressWarnings("unchecked")
    public void testShow() {

        Assert.assertNotNull(profileController);

        SalesProfile profile = (SalesProfile) super.createTransientInstance(Integer.MAX_VALUE);

        BindingResult result = new BeanPropertyBindingResult(profile, "profile");

        String page = profileController.create(profile, result);

        Assert.assertNotNull(profile.getId());
        Assert.assertEquals("redirect:/profile/" + profile.getId(), page);

        ModelMap modelMap = new ModelMap();

        page = profileController.show(profile.getId(), modelMap);

        List<Profile> profiles = (List<Profile>) modelMap.get("profiles");

        Assert.assertTrue(profiles.size() > 0);
        Assert.assertEquals("profile/list", page);

    }

    @Test
    @Transactional
    @SuppressWarnings("unchecked")
    public void testList() {

        Assert.assertNotNull(profileController);

        ModelMap modelMap = new ModelMap();

        String page = profileController.list(modelMap);

        List<Profile> profiles = (List<Profile>) modelMap.get("profiles");

        Assert.assertTrue(profiles.size() > 0);
        Assert.assertEquals("profile/list", page);

    }

}
