package io.github.plindzek;

import java.util.Optional;

/**
 * @author Adam servis z logiką biznesową do servletu MyServlet
 */
class MyService {

    /**
     * domyslna wartosc, gdy nie otrzymamy "name" w requescie i jest null
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
