package io.github.plindzek;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * servlet at the localhost:8080/api/ method doGet runs automatic by Jetty. It
 * use MyService class to give response
 * @author Adam
 */

@WebServlet(displayName = "Lang Servlet", urlPatterns = { "/api/langs" }, name = "Lang Servlet")
public class LangServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    /**
     * define references needed to handle response (eg. service, mapper or
     * repository)
     */
    private LangRepository repository;
    private ObjectMapper mapper;
    /*
     * servlet container needs it
     */
    public LangServlet() {
	this(new LangRepository(), new ObjectMapper());
    }

    LangServlet(LangRepository repository, ObjectMapper mapper) {
	this.repository = repository;
	this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	logger.info("Request got with parameters: " + req.getParameterMap());

	/**
	 * what we want to do in response to given request
	 */
	resp.setContentType("text/html; charset=utf-8");
	mapper.writeValue(resp.getOutputStream(), repository.findAll());

	// resp.getWriter().println(service.prepareGreeting(name, lang));

    }
}
