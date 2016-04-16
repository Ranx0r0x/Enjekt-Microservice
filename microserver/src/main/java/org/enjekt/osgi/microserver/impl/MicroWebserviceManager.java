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
package org.enjekt.osgi.microserver.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;








import org.apache.log4j.Logger;
import org.enjekt.osgi.microserver.api.MicroWebservice;
import org.enjekt.osgi.microserver.api.MicroserverManager;
import org.enjekt.osgi.microserver.internal.MicroWebserviceContainer;
import org.osgi.framework.BundleContext;


/**
 * The Class MicroWebserviceManager listens for MicroWebservice registration events
 * and then creates a new MicroWebserviceContainer for each received registration.  The
 * MicroWebserviceManager combines its default configuration with the configuration information
 * being carried by the MicroWebservice.  
 * 
 * While this manager will have a default address/port the incoming MicroWebservice can override that
 * and specify a different port if desirable.  More commonly the incoming MicroWebservice will leave default
 * like address and logging alone but might provide different interceptors and exception handlers that should
 * be applied to its endpoint.
 */
public class MicroWebserviceManager implements MicroserverManager{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(MicroWebserviceManager.class);
	
	/** The microservices registry. */
	private Map<String,MicroWebserviceContainer> microservicesRegistry = new ConcurrentHashMap<String,MicroWebserviceContainer>();
	
	/** The configuration. */
	private MicroWebserviceConfiguration configuration;
	
	/**
	 * Inits the.
	 */
	public void init()  {
		logger.info("Initializing...");
	}


	/**
	 * Destroy.  Called when this bundle is shut down.  It ensures that all the endpoints it has stood up
	 * are shut down and its registry is cleared.
	 */
	public void destroy(){
		for(MicroWebserviceContainer container: microservicesRegistry.values())
			container.destroy();
		microservicesRegistry.clear();
	}


	/**
	 * Register and incoming MicroWebservice.  This is really the point of the MicroWebserver.
	 * It takes the incoming web service specifications and combines them with its own defaults
	 * to create the information necessary to stand up the endpoint.
	 *
	 * @param microservice the microservice
	 */
	public void register(MicroWebservice microservice)
	{
		logger.info("Registering microservice: " + microservice.getInterfaceClazz());
		coalesceConfiguration(microservice);
		MicroWebserviceContainer service = new MicroWebserviceContainer(microservice);
		microservicesRegistry.put(microservice.getIdentifier(), service);
		service.init();
	}
	
	/**
	 * Coalesce configuration. Checks for an override of the base address and
	 * then adds the default interceptors and providers to those that are unique
	 * to the MicroWebservcie.
	 *
	 * @param microservice the microservice
	 */
	private void coalesceConfiguration(MicroWebservice microservice) {
		if(!microservice.hasBaseAddress())
			microservice.setBaseAddress(configuration.getBaseAddress());
	
		microservice.addFaultIn(configuration.getFaultIn());
		microservice.addFaultOut(configuration.getFaultOut());
		microservice.addIn(configuration.getIn());
		microservice.addOut(configuration.getOut());
		microservice.addProviders(configuration.getProviders());
	}


	/**
	 * Unregister. If a bundle is unregistered the endpoint that is associated with in
	 * its container is shutdown and it is removed from the registry.
	 *
	 * @param microservice the microservice
	 */
	public void unregister(MicroWebservice microservice)
	{
		logger.info("Unregistered service: " + microservice.getInterfaceClazz());

		MicroWebserviceContainer service=microservicesRegistry.remove(microservice.getIdentifier());
		service.destroy();
		
	}


	/**
	 * Gets the configuration.
	 *
	 * @return the configuration
	 */
	public MicroWebserviceConfiguration getConfiguration() {
		return configuration;
	}


	/**
	 * Sets the configuration.
	 *
	 * @param configuration the new configuration
	 */
	public void setConfiguration(MicroWebserviceConfiguration configuration) {
		this.configuration = configuration;
	}


	/* (non-Javadoc)
	 * @see org.enjekt.osgi.microserver.api.MicroserverManager#getInformation()
	 */
	@Override
	public String getInformation() {
		return "Microserver registry contains this many elements: "+ this.microservicesRegistry.size();
	}
	

}
