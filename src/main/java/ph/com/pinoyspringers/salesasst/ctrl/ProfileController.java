package ph.com.pinoyspringers.salesasst.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import ph.com.pinoyspringers.salesasst.Profile;
import ph.com.pinoyspringers.salesasst.domain.SalesProfile;

import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 * User: JSEE
 * Date: Feb 27, 2010
 * Time: 4:05:27 PM
 * To change this template use File | Settings | File Templates.
 */

@RequestMapping("/profile/**")
@Controller
public class ProfileController {


    @RequestMapping(value = "/profile", method = POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String create(@Valid @ModelAttribute("profile") SalesProfile profile, BindingResult result) {

        if (profile == null) {
            throw new IllegalStateException("A profile is required");
        }

        if (result.hasErrors()) {

            return "profile/create";

        }

        profile.persist();

        return "redirect:/profile/" + profile.getId();
    }

    @RequestMapping(value = "/profile/{id}/form", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) {

        if (id == null) {
            throw new IllegalArgumentException("The id doest not exist");
        }


        Profile profile = SalesProfile.retrieveById(id);

        if (profile == null) {

            throw new IllegalStateException("Profile doest not exist");
        }

        modelMap.addAttribute("profile", profile);

        return "profile/edit";
    }


    @RequestMapping(value = "/profile/{id}/remove", method = DELETE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String delete(@PathVariable("id") Long id, ModelMap modelMap) {


        if (id == null) {
            throw new IllegalArgumentException("The id does not exist");
        }

        Profile profile = SalesProfile.retrieveById(id);

        if (profile == null) {

            throw new IllegalStateException("Profile doest not exist");
        }

        profile.delete();

        modelMap.addAttribute("profiles", SalesProfile.retrieveAll());

        return "profile/list";


    }


    @RequestMapping(method = PUT)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String update(@Valid @ModelAttribute("profile") SalesProfile profile, BindingResult result) {

        if (profile == null) {
            throw new IllegalStateException("A profile is required");
        }

        if (result.hasErrors()) {

            return "profile/edit";

        }

        profile.merge();

        return "redirect:/profile/" + profile.getId();
    }


    @RequestMapping(value = "/profile/form", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String createForm(ModelMap modelMap) {

        modelMap.addAttribute("profiles", SalesProfile.retrieveAll());
        modelMap.addAttribute("profile", new SalesProfile());

        return "profile/create";
    }


    @RequestMapping(value = "/profile/{id}", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {

        if (id == null) {
            throw new IllegalArgumentException("The id does not exist");
        }


        modelMap.addAttribute("profiles", SalesProfile.retrieveAll());

        return "profile/list";
    }

    
    @RequestMapping(value = "/profile", method = GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String list(ModelMap modelMap) {

        modelMap.addAttribute("profiles", SalesProfile.retrieveAll());

        return "profile/list";
    }

}
