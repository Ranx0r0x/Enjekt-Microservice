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
package org.enjekt.osgi.echo.internal.impl;


import org.enjekt.osgi.api.echo.EchoService;
import org.enjekt.osgi.echo.internal.api.Executor;
import org.enjekt.osgi.echo.internal.api.Transformer;
import org.enjekt.osgi.echo.internal.api.Validator;
import org.enjekt.osgi.models.impl.EchoRequestMessage;
import org.enjekt.osgi.models.impl.EchoResponseMessage;

/**
 * The Class EchoTestImpl is a simple implementation class for an echo service.  In this
 * case it is using some common objects via interfaces for logical operations.  This would
 * be overkill for a small service like this but would make sense in a larger context.
 * 
 * 
 */
public class EchoTestImpl implements EchoService{

	/** The validator. */
	private Validator validator;
	
	/** The transformer. */
	private Transformer transformer;
	
	/** The executor. */
	private Executor executor;
	
	/* (non-Javadoc)
	 * @see org.enjekt.osgi.api.echo.EchoService#echoString(java.lang.String)
	 */
	@Override
	public String echoString(String toEcho) {
		validator.validate(toEcho);
		EchoRequestMessage msg=transformer.transform(toEcho);
		EchoResponseMessage response = executor.process(msg);
		return response.getEchoResponse();
		
	}

 	/* (non-Javadoc)
	  * @see org.enjekt.osgi.api.echo.EchoService#echoObject(org.enjekt.osgi.models.impl.EchoRequestMessage)
	  */
	 @Override
	public EchoResponseMessage echoObject(EchoRequestMessage request) {
 		validator.validate(request);
 		return executor.process(request);
 	
	}

	
 	
	/**
	 * Gets the validator.
	 *
	 * @return the validator
	 */
	public Validator getValidator() {
		return validator;
	}

	/**
	 * Sets the validator.
	 *
	 * @param validator the new validator
	 */
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**
	 * Gets the transformer.
	 *
	 * @return the transformer
	 */
	public Transformer getTransformer() {
		return transformer;
	}

	/**
	 * Sets the transformer.
	 *
	 * @param transformer the new transformer
	 */
	public void setTransformer(Transformer transformer) {
		this.transformer = transformer;
	}

	/**
	 * Gets the executor.
	 *
	 * @return the executor
	 */
	public Executor getExecutor() {
		return executor;
	}

	/**
	 * Sets the executor.
	 *
	 * @param executor the new executor
	 */
	public void setExecutor(Executor executor) {
		this.executor = executor;
	}


	

}
