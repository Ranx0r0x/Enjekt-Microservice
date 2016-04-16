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

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;


/**
 * A factory for creating RSClient objects mainly for test purposes.
 */
public class RSClientFactory {

	/** The factory. */
	private JAXRSClientFactoryBean factory = new JAXRSClientFactoryBean();

/**
 * Creates the RS client for testing (use badgerfish by default).  If this were to be used more generally
 * then it probably should be cleaned up and redesigned.
 *
 * @param <T> the generic type
 * @param address the address
 * @param cls the cls
 * @return the t
 */
//TODO Clean this up.
	public static <T> T create(String address, Class<T> cls)
	{

		JSONProvider provider = new JSONProvider();
	 	provider.setConvention("badgerfish");
		List providers = new ArrayList();
		providers.add(provider);
		
		
		return JAXRSClientFactory.create(address, cls, providers);
	}
	
	
	/**
	 * Inits the.
	 *
	 * @return the RS client factory
	 */
	public static RSClientFactory init()
	{
		return new RSClientFactory();
	}

	
	/**
	 * Use badgerfish.
	 *
	 * @return the RS client factory
	 */
	public RSClientFactory useBadgerfish()
	{
		JSONProvider provider = new JSONProvider();
	 	provider.setConvention("badgerfish");
		factory.setProvider(provider);
		return this;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param url the url
	 * @return the RS client factory
	 */
	public RSClientFactory setAddress(String url) {
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
