package com.pausa.stockservice.controllers;

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
public class ServicesController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesController.class);


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Object mailMessage(HttpServletRequest request) {
        logDefaultParameters(request);
        LOGGER.debug("Entering controller.");
        return "Hello World motherfuckers!";
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}
