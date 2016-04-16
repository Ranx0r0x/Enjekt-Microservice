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
import java.util.LinkedList;
import java.util.List;

import org.apache.cxf.common.util.ModCountCopyOnWriteArrayList;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.message.Message;


/**
 * The Class MicroWebserviceConfiguration is used by both the MicroWebserviceManager itself and by the registering
 * microservices.  At start up the Microwebserver loads a set of defaults that are used for configuration of all 
 * bundles that expose themselves via a MicroserviceRegistration.  But the MicroserviceRegistration also uses this 
 * to provide for some overrides and bundle specific configuration elements.
 */
public class MicroWebserviceConfiguration  {

	/** The in. */
	private List<Interceptor<? extends Message>> in = new ModCountCopyOnWriteArrayList<Interceptor<? extends Message>>();
	
	/** The out. */
	private List<Interceptor<? extends Message>> out = new ModCountCopyOnWriteArrayList<Interceptor<? extends Message>>();
	
	/** The fault in. */
	private List<Interceptor<? extends Message>> faultIn = new ModCountCopyOnWriteArrayList<Interceptor<? extends Message>>();
	
	/** The fault out. */
	private List<Interceptor<? extends Message>> faultOut = new ModCountCopyOnWriteArrayList<Interceptor<? extends Message>>();
    
    /** The providers. */
    private List<Object> providers = new ArrayList<Object>();
	
	/** The base address. */
	private String baseAddress;
	
	/** The soap relative uri. */
	private String soapRelativeURI = "/services";
	
	/** The rest relative uri. */
	private String restRelativeURI = "/resources";
	
	/**
	 * Checks for base address.
	 *
	 * @return the boolean
	 */
	public Boolean hasBaseAddress()
	{
		return baseAddress!=null && !baseAddress.equals("");
	}
	
	/**
	 * Checks for rest relative uri.
	 *
	 * @return the boolean
	 */
	public Boolean hasRestRelativeURI()
	{
		return restRelativeURI!=null && !restRelativeURI.equals("");
	}
	
	/**
	 * Checks for soap relative uri.
	 *
	 * @return the boolean
	 */
	public Boolean hasSoapRelativeURI()
	{
		return soapRelativeURI!=null && !soapRelativeURI.equals("");
	}
	
	/**
	 * Gets the base address.
	 *
	 * @return the base address
	 */
	public String getBaseAddress() {
		return baseAddress;
	}
	
	/**
	 * Sets the base address.
	 *
	 * @param baseAddress the new base address
	 */
	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}
	
	/**
	 * Sets the adds the in.
	 *
	 * @param interceptor the new adds the in
	 */
	public void setAddIn(Interceptor<? extends Message> interceptor)
	{
		in.add(interceptor);
	}
	
	/**
	 * Sets the adds the out.
	 *
	 * @param interceptor the new adds the out
	 */
	public void setAddOut(Interceptor<? extends Message> interceptor)
	{
		out.add(interceptor);
	}
	
	/**
	 * Sets the adds the fault in.
	 *
	 * @param interceptor the new adds the fault in
	 */
	public void setAddFaultIn(Interceptor<? extends Message> interceptor)
	{
		faultIn.add(interceptor);
	}
	
	/**
	 * Sets the adds the fault out.
	 *
	 * @param interceptor the new adds the fault out
	 */
	public void setAddFaultOut(Interceptor<? extends Message> interceptor)
	{
		faultOut.add(interceptor);
	}
	
	/**
	 * Sets the adds the provider.
	 *
	 * @param provider the new adds the provider
	 */
	public void setAddProvider(Object provider)
	{
		providers.add(provider);
	}
	
	
	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public List<Interceptor<? extends Message>> getOut() {
		return out;
	}
	
	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(List<Interceptor<? extends Message>> out) {
		this.out = out;
	}
	
	/**
	 * Gets the in.
	 *
	 * @return the in
	 */
	public List<Interceptor<? extends Message>> getIn() {
		return in;
	}
	
	/**
	 * Sets the in.
	 *
	 * @param in the new in
	 */
	public void setIn(List<Interceptor<? extends Message>> in) {
		this.in = in;
	}
	
	/**
	 * Gets the fault in.
	 *
	 * @return the fault in
	 */
	public List<Interceptor<? extends Message>> getFaultIn() {
		return faultIn;
	}
	
	/**
	 * Sets the fault in.
	 *
	 * @param faultIn the new fault in
	 */
	public void setFaultIn(List<Interceptor<? extends Message>> faultIn) {
		this.faultIn = faultIn;
	}
	
	/**
	 * Gets the fault out.
	 *
	 * @return the fault out
	 */
	public List<Interceptor<? extends Message>> getFaultOut() {
		return faultOut;
	}
	
	/**
	 * Sets the fault out.
	 *
	 * @param faultOut the new fault out
	 */
	public void setFaultOut(List<Interceptor<? extends Message>> faultOut) {
		this.faultOut = faultOut;
	}
	
	/**
	 * Gets the providers.
	 *
	 * @return the providers
	 */
	public List<Object> getProviders() {
		return providers;
	}
	
	/**
	 * Sets the providers.
	 *
	 * @param providers the new providers
	 */
	public void setProviders(List<Object> providers) {
		this.providers = providers;
	}

	/**
	 * Adds the out.
	 *
	 * @param out the out
	 */
	public void addOut(List<Interceptor<? extends Message>> out) {
		this.out.addAll(out);
	}

	/**
	 * Adds the in.
	 *
	 * @param in the in
	 */
	public void addIn(List<Interceptor<? extends Message>> in) {
		this.in.addAll(in);
	}

	/**
	 * Adds the fault in.
	 *
	 * @param faultIn the fault in
	 */
	public void addFaultIn(List<Interceptor<? extends Message>> faultIn) {
		this.faultIn.addAll(faultIn);
	}

	/**
	 * Adds the fault out.
	 *
	 * @param faultOut the fault out
	 */
	public void addFaultOut(List<Interceptor<? extends Message>> faultOut) {
		this.faultOut.addAll(faultOut);

	}

	/**
	 * Adds the providers.
	 *
	 * @param providers the providers
	 */
	public void addProviders(List<Object> providers) {
		this.providers.addAll(providers);
	}
	
	/**
	 * Gets the rest relative uri.
	 *
	 * @return the rest relative uri
	 */
	public String getRestRelativeURI() {
		return restRelativeURI;
	}

	/**
	 * Sets the rest relative uri.
	 *
	 * @param restRelativeURI the new rest relative uri
	 */
	public void setRestRelativeURI(String restRelativeURI) {
		if (restRelativeURI != null) {
			this.restRelativeURI = restRelativeURI;
			if (!this.restRelativeURI.startsWith("/"))
				this.restRelativeURI = "/" + this.restRelativeURI;
		}
	}

	/**
	 * Sets the soap relative uri.
	 *
	 * @param soapRelativeURI the new soap relative uri
	 */
	public void setSoapRelativeURI(String soapRelativeURI) {
		if (soapRelativeURI != null) {
			this.soapRelativeURI = soapRelativeURI;
			if (!this.soapRelativeURI.startsWith("/"))
				this.soapRelativeURI = "/" + this.soapRelativeURI;
		}
	}

	/**
	 * Gets the soap relative uri.
	 *
	 * @return the soap relative uri
	 */
	public String getSoapRelativeURI() {
		return soapRelativeURI;
	}

	
	
}
