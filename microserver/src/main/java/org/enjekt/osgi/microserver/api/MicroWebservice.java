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
package org.enjekt.osgi.microserver.api;

import java.util.List;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;


/**
 * The Interface MicroWebservice is the mechanism that is used for bundles to expose themselves
 * via a running Microwebserver.  This interface is registered via OSGi in the registry where
 * the Microserver picks it up and exposes it via a combination of the defaults set in the Microwebserver
 * and the specifics configured in the bundle itself
 */
public interface MicroWebservice {


	/**
	 * Gets the interface clazz that carries the SOAP and/or REST annotations.  
	 *
	 * @return the interface clazz
	 */
	public Class getInterfaceClazz();
	
	/**
	 * Gets the component that implements the interface.  Because this is carrying the component it
	 * is not proxied and so does not create issues for CXF.
	 *
	 * @return the component
	 */
	public Object getComponent();
	
	/**
	 * Gets the identifier.  This is a unique identifier that is used by the Microserver for 
	 * registering and unregistering the service.  By default it is a generated UUID.
	 *
	 * @return the identifier
	 */
	public String getIdentifier();
	
	/**
	 * Checks for base address.
	 *
	 * @return the boolean
	 */
	public Boolean hasBaseAddress();
	
	/**
	 * Checks for rest relative uri.
	 *
	 * @return the boolean
	 */
	public Boolean hasRestRelativeURI();
	
	/**
	 * Checks for soap relative uri.
	 *
	 * @return the boolean
	 */
	public Boolean hasSoapRelativeURI();
	
	/**
	 * Gets the rest relative uri.
	 *
	 * @return the rest relative uri
	 */
	public String getRestRelativeURI();
	
	/**
	 * Sets the rest relative uri.
	 *
	 * @param restRelativeURI the new rest relative uri
	 */
	public void setRestRelativeURI(String restRelativeURI);
	
	/**
	 * Sets the soap relative uri.
	 *
	 * @param soapRelativeURI the new soap relative uri
	 */
	public void setSoapRelativeURI(String soapRelativeURI);
	
	/**
	 * Gets the soap relative uri.
	 *
	 * @return the soap relative uri
	 */
	public String getSoapRelativeURI();
	
	/**
	 * Gets the base address.
	 *
	 * @return the base address
	 */
	public String getBaseAddress();
	
	/**
	 * Sets the base address.
	 *
	 * @param baseAddress the new base address
	 */
	public void setBaseAddress(String baseAddress);
	
	//The following are optional add elements that a bundle can add if customization is required.
	//A common example will be the exception handlers in a bundle or custom JSON providers that
	//are different than the global setting.
	//Base address/ports can be overridden by the bundle's settings.
	/**
	 * Sets the adds the in.
	 *
	 * @param interceptor the new adds the in
	 */
	public void setAddIn(Interceptor<? extends Message> interceptor);
	
	/**
	 * Sets the adds the out.
	 *
	 * @param interceptor the new adds the out
	 */
	public void setAddOut(Interceptor<? extends Message> interceptor);
	
	/**
	 * Sets the adds the fault in.
	 *
	 * @param interceptor the new adds the fault in
	 */
	public void setAddFaultIn(Interceptor<? extends Message> interceptor);
	
	/**
	 * Sets the adds the fault out.
	 *
	 * @param interceptor the new adds the fault out
	 */
	public void setAddFaultOut(Interceptor<? extends Message> interceptor);
	
	/**
	 * Sets the adds the provider.
	 *
	 * @param provider the new adds the provider
	 */
	public void setAddProvider(Object provider);
	
	
	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public List<Interceptor<? extends Message>> getOut();
	
	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(List<Interceptor<? extends Message>> out);
	
	/**
	 * Gets the in.
	 *
	 * @return the in
	 */
	public List<Interceptor<? extends Message>> getIn();
	
	/**
	 * Sets the in.
	 *
	 * @param in the new in
	 */
	public void setIn(List<Interceptor<? extends Message>> in);
	
	/**
	 * Gets the fault in.
	 *
	 * @return the fault in
	 */
	public List<Interceptor<? extends Message>> getFaultIn();
	
	/**
	 * Sets the fault in.
	 *
	 * @param faultIn the new fault in
	 */
	public void setFaultIn(List<Interceptor<? extends Message>> faultIn);
	
	/**
	 * Gets the fault out.
	 *
	 * @return the fault out
	 */
	public List<Interceptor<? extends Message>> getFaultOut();
	
	/**
	 * Sets the fault out.
	 *
	 * @param faultOut the new fault out
	 */
	public void setFaultOut(List<Interceptor<? extends Message>> faultOut);
	
	/**
	 * Gets the providers.
	 *
	 * @return the providers
	 */
	public List<Object> getProviders();
	
	/**
	 * Sets the providers.
	 *
	 * @param providers the new providers
	 */
	public void setProviders(List<Object> providers);
	
	/**
	 * Adds the out.
	 *
	 * @param out the out
	 */
	public void addOut(List<Interceptor<? extends Message>> out);
	
	/**
	 * Adds the in.
	 *
	 * @param in the in
	 */
	public void addIn(List<Interceptor<? extends Message>> in);
	
	/**
	 * Adds the fault in.
	 *
	 * @param faultIn the fault in
	 */
	public void addFaultIn(List<Interceptor<? extends Message>> faultIn);
	
	/**
	 * Adds the fault out.
	 *
	 * @param faultOut the fault out
	 */
	public void addFaultOut(List<Interceptor<? extends Message>> faultOut);
	
	/**
	 * Adds the providers.
	 *
	 * @param providers the providers
	 */
	public void addProviders(List<Object> providers);
}
