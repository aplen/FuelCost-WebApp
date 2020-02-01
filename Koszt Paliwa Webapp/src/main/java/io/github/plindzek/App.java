package io.github.plindzek;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    public static void main(String[] args) throws Exception {

	Logger logger = LoggerFactory.getLogger(App.class);
	logger.info("Ten tekst wyswietli się w konsoli");


	/*
	 * tworzymy i konfigurujemy handler
	 */
	var webapp = new WebAppContext();

	// ponizsza linijka podpina servlet ale bez obslugi adnotacji
//        webapp.addServlet(HelloServlet.class, "/api/*");

	/*
	 * ponizsza linijka pozwala zmieniać plik index.html podczas działania serwera
	 */
	webapp.setInitParameter("org.eclipse.jetty.servlet.Default.maxCachedFiles", "0");

	webapp.setResourceBase("src/main/webapp");
	// webapp.setContextPath("/");

	// konfiguracja z stackoverflow "webapp context configuration embedded servlet
	// 3.1
	webapp.setConfigurations(new Configuration[] { new AnnotationConfiguration(), new WebInfConfiguration(),
		new WebXmlConfiguration(), new MetaInfConfiguration(), new FragmentConfiguration(),
		new EnvConfiguration(), new PlusConfiguration(), new JettyWebXmlConfiguration() });
	webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");

	var server = new Server(8080);
	server.setHandler(webapp);

	// server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener()
	// {
	// @Override
	// public void lifeCycleStopped(LifeCycle event) {
	// HibernateUtil.close();
	// }
	// });

	server.start();
	server.join();



    }
}
