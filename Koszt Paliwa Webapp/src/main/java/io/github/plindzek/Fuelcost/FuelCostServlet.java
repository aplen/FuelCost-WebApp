package io.github.plindzek.fuelcost;

import io.github.plindzek.car.CarRepository;
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
    private CarRepository repository;

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
        var trip = new Trip();
        try {
            trip.setKmOnPb(Double.parseDouble(kmOnPb));
            trip.setKmOnLpg(Double.parseDouble(kmOnLpg));
            trip.setKmOnOn(Double.parseDouble(kmOnOn));
        } catch (NumberFormatException | NullPointerException e) {
            //e.printStackTrace();
            resp.getWriter().println("wrong data format");
        }

        var Car = repository.findByName(name);


        double wynik = fuelCostService.calcCost(car, trip);
        System.out.println(wynik);
        resp.setContentType("text/html; charset=utf-8");
        //resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write((Double.toString(wynik)));
    }
}



