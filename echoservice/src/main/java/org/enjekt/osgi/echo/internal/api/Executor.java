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
import org.enjekt.osgi.models.impl.EchoResponseMessage;


/**
 * The Interface Executor is for any business logic that would be executed
 * after the validation and transform phases.
 */
public interface Executor {


	/**
	 * Process the incoming EchoResponseMessage.
	 *
	 * @param msg the msg
	 * @return the echo response message
	 */
	EchoResponseMessage process(EchoRequestMessage msg);

}
