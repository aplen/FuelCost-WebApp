package io.github.plindzek;

import java.util.Optional;

/**
 * Service with bussiness logic for MyServlet
 * 
 * @author Adam
 */
class MyService {

    /**
     * default value, when we dont receive "name" in request and we have null
     */
    private static final String FALLBACK_NAME = "add \"?name=your name\" at the end of this site address";

    /**
     * 
     * @param name
     * @return welcome message with name
     */
    String prepareGreeting(String name) {

	return "<br /><h1>Hello, "
		+ Optional.ofNullable(name).orElse(FALLBACK_NAME)
		+ "!<h1/>";
    }

}
