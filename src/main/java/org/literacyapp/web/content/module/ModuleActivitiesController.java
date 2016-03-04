package org.literacyapp.web.content.module;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content/module/activities")
public class ModuleActivitiesController {
    
    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(Model model) {
    	logger.info("handleRequest");
        
        // TODO

        return "content/module/activities";
    }
}
