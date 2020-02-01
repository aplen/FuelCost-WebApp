package io.github.plindzek;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * servlet pod adresem localhost:8080/api/ metoda doGet odpala się automatycznie
 * obsługiwany przez service z MyService
 * 
 * @author Adam
 *
 */

@WebServlet(displayName = "To jest displayname servletu", urlPatterns = { "api/*" }, name = "My Servlet")
public class MyServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(MyServlet.class);

    // defniujemy parametr, jakiego sie spodziewamy w requeście
    private static final String NAME_PARAM = "name";

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

	resp.getWriter().println(service.prepareGreeting(req.getParameter(NAME_PARAM)));

	resp.getWriter().write("<br />session=" + req.getSession(true).getId());



    }
}
