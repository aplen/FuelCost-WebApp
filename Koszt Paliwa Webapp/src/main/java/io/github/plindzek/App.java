package io.github.plindzek;

import io.github.plindzek.prices.FuelsPriceScrapper;
import io.github.plindzek.util.HibernateUtil;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class App {
    public static void main(String[] args) throws Exception {

        /* create and configure handler */
        var webapp = new WebAppContext();

        /*
          this line create servlet but without annotations handling we need
          annotations, so its off
          webapp.addServlet(HelloServlet.class, "/api/*");
         */

        /*
          this line allow to change static files in webapp folder without server
          restart
         */
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.maxCachedFiles", "0");

        webapp.setResourceBase("src/main/webapp");
        webapp.setContextPath("/");

        /*
          configuration from stackoverflow "webapp context configuration embedded
          servlet 3.1"
         */
        webapp.setConfigurations(new Configuration[]{new AnnotationConfiguration(), new WebInfConfiguration(),
                new WebXmlConfiguration(), new MetaInfConfiguration(), new FragmentConfiguration(),
                new EnvConfiguration(), new PlusConfiguration(), new JettyWebXmlConfiguration()});
        webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");

        var server = new Server(8080);
        server.setHandler(webapp);

        /* closing Hibernate session when closing server */
        server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStopped(LifeCycle event) {
                HibernateUtil.close();
            }
        });

        FuelsPriceScrapper.getAutocentrum();

        server.start();
        server.join();


    }
}
