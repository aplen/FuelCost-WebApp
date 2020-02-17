package io.github.plindzek.lang;

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
 * servlet at the localhost:8080/api/langs method doGet runs automatic by Jetty. It
 * use LangService class to give response
 *
 * @author Adam
 */

@WebServlet(displayName = "Lang Servlet", urlPatterns = {"/api/langs/*"}, name = "Lang Servlet")
public class LangServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    /**
     * define references needed to handle response (eg. service, mapper or
     * repository)
     */
    private LangService service;
    private ObjectMapper mapper;

    /*
     * servlet container needs it
     */
    public LangServlet() {
        this(new LangService(), new ObjectMapper());
    }

    LangServlet(LangService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Request got with parameters: " + req.getParameterMap());

        /**
         * what we want to do in response to given request
         */
        //resp.setContentType("text/html; charset=utf-8");
        resp.setContentType("application/json; charset=utf-8");

        //mapper convert langDTO object to JSON and send to frontend

        mapper.writeValue(resp.getOutputStream(), service.findAll());
    }
}
