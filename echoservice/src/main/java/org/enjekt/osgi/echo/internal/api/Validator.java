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
package org.enjekt.osgi.echo.internal.api;

import org.enjekt.osgi.models.impl.EchoRequestMessage;

/**
 * The Interface Validator.
 */
public interface Validator {


	// TODO throw exceptions from here and show how bundle specific handlers can be
	//added to the MicroserviceRegistration.
	/**
	 * Validate the incoming String for not null
	 *
	 * @param toEcho the to echo
	 */
	void validate(String toEcho);

	/**
	 * Validate the incoming request for a non-null message.
	 *
	 * @param request the request
	 */
	void validate(EchoRequestMessage request);

}
