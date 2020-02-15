package io.github.plindzek.car;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.plindzek.lang.LangService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Adam
 */

@WebServlet(displayName = "Car Servlet", urlPatterns = { "/api/cars/*" }, name = "Car Servlet")
public class CarServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(CarServlet.class);

    /**
     * define references needed to handle response (eg. service, mapper or
     * repository)
     */
    private CarRepository service;
    private ObjectMapper mapper;
    /*
     * servlet container needs it
     */
    public CarServlet() {
	this(new CarRepository(), new ObjectMapper());
    }

    CarServlet(CarRepository service, ObjectMapper mapper) {
	this.service = service;
	this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	logger.info("Request got with parameters: " + req.getParameterMap());

	/**
	 * what we want to do in response to given request
	 */
	resp.setContentType("text/html; charset=utf-8");
	mapper.writeValue(resp.getOutputStream(), service.findAll());

	// resp.getWriter().println(service.prepareGreeting(name, lang));

    }
}
