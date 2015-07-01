package mi.khtp.spring3mvcxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;

/**
 *
 * @author mattong
 *
 */
@Controller
public class PersonsController extends BaseController {

    private static Logger log = Logger.getLogger(PersonsController.class);

    @Autowired
    private PersonsService personsService;

    /**
     * contructor
     */
    public PersonsController() {
        setSuccessView("list");
    }

    @RequestMapping(value = "/persons/init", method = RequestMethod.GET)
    public String init(Model model) {
        log.info("Initialize Persons...");
        personsService.init();        
        return "init";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String list(Model model) {
        log.info("Listing Persons...");
        Person[] list = personsService.currentList();
        model.addAttribute("persons", list);
        return getSuccessView();
    }

}
