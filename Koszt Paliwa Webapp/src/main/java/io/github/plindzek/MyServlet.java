package io.github.plindzek;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * servlet at the localhost:8080/api/ method doGet runs automatic by Jetty. It
 * use MyService class to give response
 * @author Adam
 */

@WebServlet(displayName = "Nazwa z pola displayName (MyServlet)", urlPatterns = { "api/*" }, name = "My Servlet")
public class MyServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(MyServlet.class);
    // defniujemy parametry, jakich sie spodziewamy w requeście
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    // tworzymy zmienna serwisu powiazanego z servletem
    private MyService service;

    /*
     * servlet container needs it
     */
    public MyServlet() {
	this(new MyService());
    }

    MyServlet(MyService service) {
	this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	logger.info("Request got with parameters: " + req.getParameterMap());
	resp.setContentType("text/html; charset=utf-8");

	String name = req.getParameter(NAME_PARAM);
	Integer lang = Integer.valueOf(Optional.ofNullable(req.getParameter(LANG_PARAM)).orElse("1"));
	resp.getWriter().println(service.prepareGreeting(name, lang));

	resp.getWriter().write("<br />session=" + req.getSession(true).getId());
    }
}
