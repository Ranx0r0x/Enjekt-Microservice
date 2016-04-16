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

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


/**
 * A factory for creating WSClients mainly for testing purposes although they could
 * also be used to create calls to external systems
 */
public class WSClientFactory {

	/** The factory. */
	private JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

/**
 * Instance of the factory..
 *
 * @return the WS client factory
 */
//TODO Make this and RS client factory consistent.
	public static WSClientFactory instance()
	{
		return new WSClientFactory();
	}
	
	/**
	 * Creates the client associated with the URL and service interface class.
	 *
	 * @param <T> the generic type
	 * @param serviceURL the service url
	 * @param serviceClazz the service clazz
	 * @return the t
	 */
	public static <T> T create(String serviceURL, Class<T> serviceClazz)
	{
		return WSClientFactory.instance()
					.setAddress(serviceURL)
					.create(serviceClazz);
	}
	
	/**
	 * Sets the address.
	 *
	 * @param url the url
	 * @return the WS client factory
	 */
	public WSClientFactory setAddress(String url) {
		factory.setAddress(url);
		return this;
	}
	
	/**
	 * Creates the.
	 *
	 * @param <T> the generic type
	 * @param clazz the clazz
	 * @return the t
	 */
	public <T> T create(Class<T> clazz)
	{
		return factory.create(clazz);
	}
}
