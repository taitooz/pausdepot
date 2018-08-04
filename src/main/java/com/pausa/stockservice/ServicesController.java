package com.pausa.stockservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emiliano.lourbet - taitooz
 */
@Controller
public class ServicesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesController.class);


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Object mailMessage(HttpServletRequest request) {
        LOGGER.debug("Entering controller.");
        return "Hello World motherfuckers!";
    }

}
