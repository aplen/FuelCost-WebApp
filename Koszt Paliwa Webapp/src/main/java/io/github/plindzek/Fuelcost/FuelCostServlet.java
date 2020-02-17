package io.github.plindzek.Fuelcost;

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

@WebServlet(displayName = "Nazwa z pola displayName FuelCostServlet", urlPatterns = { "/api" }, name = "FuelCost Servlet")
public class FuelCostServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(FuelCostServlet.class);
    // defniujemy parametry, jakich sie spodziewamy w requeście
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    /**
     * define references needed to handle response (eg. service, mapper or
     * repository)
     */
    private PbCostService service;

    /*
     * servlet container needs it
     */
    public FuelCostServlet() {
	this(new PbCostService());
    }

    FuelCostServlet(PbCostService service) {
	this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	logger.info("Request got with parameters: " + req.getParameterMap());
	String name = req.getParameter(NAME_PARAM);
	Integer lang = Integer.valueOf(Optional.ofNullable(req.getParameter(LANG_PARAM)).orElse("1"));

	/**
	 * what we want to do in response to given request
	 */


        resp.setContentType("text/html; charset=utf-8");
	resp.getWriter().println(service.prepareGreeting(name, lang));

    }
}
