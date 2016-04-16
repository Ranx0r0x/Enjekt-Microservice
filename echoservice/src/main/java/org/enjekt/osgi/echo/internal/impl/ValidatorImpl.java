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

import org.enjekt.osgi.echo.internal.api.Validator;
import org.enjekt.osgi.models.impl.EchoRequestMessage;

/**
 * The Class ValidatorImpl validates the incoming messages and throws an exception if
 * they are not valid.  Those are caught by the CXF handlers that are added by this bundle
 * at start up.
 */
public class ValidatorImpl implements Validator {

	/* (non-Javadoc)
	 * @see org.enjekt.osgi.echo.internal.api.Validator#validate(java.lang.String)
	 */
	@Override
	public void validate(String toEcho) {
		// TODO throw exceptions from here to demonstrate adding handlers to the MicroserviceRegistration
		
	}

	/* (non-Javadoc)
	 * @see org.enjekt.osgi.echo.internal.api.Validator#validate(org.enjekt.osgi.models.impl.EchoRequestMessage)
	 */
	@Override
	public void validate(EchoRequestMessage request) {
		// TODO throw exceptions from here to demonstrate adding handlers to the MicroserviceRegistration
		
	}

}
