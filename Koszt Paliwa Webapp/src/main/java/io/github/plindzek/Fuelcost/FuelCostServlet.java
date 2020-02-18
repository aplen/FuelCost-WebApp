package io.github.plindzek.fuelcost;

import io.github.plindzek.Trip;
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

@WebServlet(displayName = "FuelCost Servlet", urlPatterns = {"/api/fuelcost/*"}, name = "FuelCost Servlet")
public class FuelCostServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(io.github.plindzek.fuelcost.FuelCostServlet.class);
    private static final String KM_ON_LPG_PARAM = "kmOnLpg";
    private static final String KM_ON_PB_PARAM = "kmOnPb";
    private static final String KM_ON_ON_PARAM = "kmOnOn";

    /**
     * define references needed to handle response (eg. service, mapper or
     * repository)
     */
    private FuelCostService fuelCostService;

    /*
     * servlet container needs it
     */
    public FuelCostServlet() {
        this(new FuelCostService());
    }

    FuelCostServlet(FuelCostService fuelCostService) {
        this.fuelCostService = fuelCostService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Request got with parameters: " + req.getParameterMap());
        var kmOnLpg = req.getParameter(KM_ON_LPG_PARAM);
        var kmOnPb = req.getParameter(KM_ON_PB_PARAM);
        var kmOnOn = req.getParameter(KM_ON_ON_PARAM);
        /**
         * what we want to do in response to given request
         */
        resp.setContentType("text/html; charset=utf-8");
        //resp.setContentType("application/json; charset=utf-8");
        //new trip/calc/print in resp
        Trip trip = new Trip();
        trip.setKmOnPb(Double.parseDouble(kmOnPb));
        trip.setKmOnLpg(Double.parseDouble(kmOnLpg));
        trip.setKmOnOn(Double.parseDouble(kmOnOn));

        double wynik = fuelCostService.calcCost();

        System.out.println(wynik);
    }
}



