package com.pausa.stockservice;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emiliano.lourbet - taitooz - elourbet[at]despegar[dot]com.
 */
public abstract class AbstractController {

    protected abstract Logger getLogger();

    protected void logDefaultParameters(HttpServletRequest request) {
        if (request != null) {
            this.getLogger().debug("Call received, URL:{}", request.getRequestURI());
        }
    }

    private String getRequestURL(HttpServletRequest request) {
        return ((String) request.getAttribute(org.springframework.web.servlet.HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
    }

}
