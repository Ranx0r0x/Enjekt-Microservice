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

import java.util.UUID;

import org.enjekt.osgi.microserver.api.MicroWebservice;


/**
 * The Class MicroWebserviceRegistration extends the basic MicroWebserviceConfiguration but also provides
 * specific fields and methods that are necessary for setting up a SOAP or REST web service such as the
 * interface and implementing component.
 * 
 * It creates a final UUID associated with this microservice so that it can be uniquely identified for registration
 * and unregistration events with the MicrowebserverManager.
 */
public class MicroWebserviceRegistration extends MicroWebserviceConfiguration implements MicroWebservice {

	/** The id. */
	private final String id = UUID.randomUUID().toString();
	
	/** The interface clazz. */
	private final Class interfaceClazz;
	
	/** The component. */
	private final Object component;


	/**
	 * Instantiates a new micro webservice registration.
	 *
	 * @param interfaceClazz the interface clazz
	 * @param component the component
	 */
	public MicroWebserviceRegistration(Class interfaceClazz, Object component) {
		this.interfaceClazz = interfaceClazz;
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see org.enjekt.osgi.microserver.api.MicroWebservice#getInterfaceClazz()
	 */
	@Override
	public Class getInterfaceClazz() {
		return interfaceClazz;
	}

	/* (non-Javadoc)
	 * @see org.enjekt.osgi.microserver.api.MicroWebservice#getComponent()
	 */
	@Override
	public Object getComponent() {
		return component;
	}

	/* (non-Javadoc)
	 * @see org.enjekt.osgi.microserver.api.MicroWebservice#getIdentifier()
	 */
	@Override
	public String getIdentifier() {
		return id;
	}



}
