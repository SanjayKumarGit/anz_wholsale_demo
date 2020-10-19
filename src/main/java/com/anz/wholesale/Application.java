package com.anz.wholesale;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletWebServerFactory webContainer() {
		TomcatServletWebServerFactory server = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		server.addAdditionalTomcatConnectors(redirectPort());
		return server;
	}

	private Connector redirectPort() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);

		connector.setPort(8080);
		connector.setRedirectPort(8081);
		connector.setScheme("http");
		connector.setSecure(false);

		return connector;
	}

}
