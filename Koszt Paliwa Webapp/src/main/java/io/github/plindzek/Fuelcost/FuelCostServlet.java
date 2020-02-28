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
    private static final String KM_ON_LPG_PARAM = "kmOnLpgValue";
    private static final String KM_ON_PB_PARAM = "kmOnPbValue";
    private static final String KM_ON_ON_PARAM = "kmOnOnValue";
    private static final String PRICE_LPG_PARAM = "lpgPriceValue";
    private static final String PRICE_PB_PARAM = "pbPriceValue";
    private static final String PRICE_ON_PARAM = "onPriceValue";

    private FuelCostService fuelCostService;
    private CarRepository repository;

    /*
     * servlet container needs it
     */
    public FuelCostServlet() {
        this(new FuelCostService(), new CarRepository());
    }

    FuelCostServlet(FuelCostService fuelCostService, CarRepository repository) {
        this.fuelCostService = fuelCostService;
        this.repository = repository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Request got with parameters: " + req.getParameterMap());

        var kmOnLpg = req.getParameter(KM_ON_LPG_PARAM);
        var kmOnPb = req.getParameter(KM_ON_PB_PARAM);
        var kmOnOn = req.getParameter(KM_ON_ON_PARAM);
        var lpgPrice = req.getParameter(PRICE_LPG_PARAM);
        var pbPrice = req.getParameter(PRICE_PB_PARAM);
        var onPrice = req.getParameter(PRICE_ON_PARAM);
        var trip = new Trip();
        try {
            //TODO
            //przekazywany ma byc jsonem obiekt Trip oraz ID samochodu do pobrania

            //trip.setKmOnPb(Double.parseDouble(kmOnPb));
            //trip.setKmOnLpg(Double.parseDouble(kmOnLpg));
            //trip.setKmOnOn(Double.parseDouble(kmOnOn));
            //
            //trip.setLpgPrice(Double.parseDouble(lpgPrice));
            //trip.setPbPrice(Double.parseDouble(pbPrice));
            //trip.setOnPrice(Double.parseDouble(onPrice));

        } catch (NumberFormatException | NullPointerException e) {
            //e.printStackTrace();
            resp.getWriter().println("wrong data format");
        }

        String pathInfo = req.getPathInfo();
        logger.info("Request got with path info  " + pathInfo);
        try {
            var id = Integer.valueOf(pathInfo.substring(1));
            var car = repository.findById(id).orElse(null);
            //TODO
            double wynik = fuelCostService.calcCost(car, trip);
            System.out.println(wynik);
            resp.setContentType("text/html; charset=utf-8");
            //resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write((Double.toString(wynik)));
        } catch (NumberFormatException | NullPointerException e) {
            logger.info("Wrong path: " + pathInfo);
        }

    }
}



