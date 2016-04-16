/**
Copyright 2016 Brad Johnson, Enjekt Software
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 * 
 */
package org.enjekt.osgi.microserver.internal;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.log4j.Logger;
import org.enjekt.osgi.microserver.api.MicroWebservice;

/**
 * The Class MicroWebserviceContainer manages the registered bundles service interface and SOAP
 * and REST web services.  A container is unique to a given service registration.  While a bundle can export
 * multiple service registrations a service container will only reflect one of them.  In other words, if a bundle
 * exported three MicroserviceRegistrations then three separate containers would be set up reflecting three unique
 * web service views of from the bundle.  When the bundle is uninstalled all Microservices associated with it will be
 * shut down since each is uniquely associated with its own container.
 */
public class MicroWebserviceContainer {

	/** The soap server. */
	private Server soapServer;
	
	/** The rest server. */
	private Server restServer;
	
	/** The microservice. */
	private MicroWebservice microservice;

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MicroWebserviceContainer.class);

	/**
	 * Instantiates a new micro webservice container.
	 *
	 * @param osgiMicroservice the osgi microservice
	 */
	public MicroWebserviceContainer(MicroWebservice osgiMicroservice) {
		this.microservice = osgiMicroservice;
	
	}

	/**
	 * Instantiates a new micro webservice container.
	 */
	public MicroWebserviceContainer() {
	}

	/**
	 * Inits the soap and rest endpoints associated with this container.
	 */
	public void init() {
		logger.info("Initializing service endpoints.");
	
		startSoapEndpoint();
		startRestEndpoint();
	}


	/**
	 * Start rest endpoint.  The MicroserviceManager combined the incoming configuration with the default
	 * configuration creating a superset collection.  These are now added to the server endpoint and started.
	 */
	private void startRestEndpoint() {
		logger.info("Starting REST endpoint.");
		JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
		
		
		String base = microservice.getBaseAddress() + microservice.getRestRelativeURI();

		serverFactory.setAddress(base);
		serverFactory.setInInterceptors(microservice.getIn());
		serverFactory.setOutInterceptors(microservice.getOut());
		serverFactory.setProviders(microservice.getProviders());
		serverFactory.setServiceBean(microservice.getComponent());
		
		restServer = serverFactory.create();
		restServer.start();
	}


	/**
	 * Start soap endpoint. The MicroserviceManager combined the incoming configuration with the default
	 * configuration creating a superset collection.  These are now added to the server endpoint and started.
	 */
	private void startSoapEndpoint() {
		logger.info("Start SOAP endpoint.");
		JaxWsServerFactoryBean serverFactory = new JaxWsServerFactoryBean();
		serverFactory.setAddress(microservice.getBaseAddress() + microservice.getSoapRelativeURI());
		serverFactory.setInInterceptors(microservice.getIn());
		serverFactory.setOutInterceptors(microservice.getOut());
		serverFactory.setServiceBean(microservice.getComponent());
		serverFactory.setServiceClass(microservice.getInterfaceClazz());
	
		soapServer = serverFactory.create();
		soapServer.start();
	
	}

	/**
	 * Destroy.  The bundle associated with the service registry of the MicroWebservice associated with this
	 * container has been uninstalled so we are shutting down the endpoints and releasing memory.
	 */
	public void destroy() {
		logger.info("Unregistering SOAP and REST endpoints.");
		if (soapServer != null)
			soapServer.destroy();
		if (restServer != null)
			restServer.destroy();
		soapServer = null;
		restServer = null;
		microservice = null;
		microservice = null;
	}

	/**
	 * Sets the service. The MicroWebservice we will be working with in this container.
	 *
	 * @param service the new service
	 */
	public void setService(MicroWebservice service) {
		this.microservice = service;
	}

}
