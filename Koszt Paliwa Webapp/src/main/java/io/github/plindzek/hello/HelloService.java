package io.github.plindzek.hello;

import io.github.plindzek.lang.Lang;
import io.github.plindzek.lang.LangRepository;
import java.util.Optional;

/**
 * Service with bussiness logic for HelloServlet
 * @author Adam
 */
class HelloService {
    /**
     * default value, when we dont receive "name" in request and we have null
     */
    static final String FALLBACK_NAME = "add \"?name=your name\" at the end of this site address";
    /**
     * default values, when we dont receive "lang" in request and we have null
     */
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "pl", "Name of car: ",
	    "Spalanie LPG w litrach na 100km: ", "Cena LPG: ", "Ilość przejechanych kilometrów na LPG: ",
	    "Spalanie PB95 w litrach na 100 km: ", "Cena PB95: ", "ilość przejechanych kilometrów na PB95: ",
	    "Koszt trasy wyniesie: ", "Oblicz", "Wyjście", "Zapisz profil", "Wczytaj profil");

    private LangRepository repository;

    HelloService() {
	this(new LangRepository());
    }

    HelloService(LangRepository langRepository) {
	this.repository = repository;
    }
    /**
     * @param name
     * @return welcome message with name and default langId
     */
    String prepareGreeting(String name) {
	return prepareGreeting(name, FALLBACK_LANG.getLangId());
    }
    /**
     * @param name
     * @return welcome message with name
     */
    String prepareGreeting(String name, Integer langId) {
	LangRepository repository = new LangRepository();
	var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
	var nameToWelcome =  Optional.ofNullable(name).orElse(FALLBACK_NAME);

	return welcomeMsg + "<br />" + nameToWelcome + "!";
    }
 }
