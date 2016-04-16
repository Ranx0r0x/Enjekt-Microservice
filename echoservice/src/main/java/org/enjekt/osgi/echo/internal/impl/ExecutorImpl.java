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

import org.enjekt.osgi.echo.internal.api.Executor;
import org.enjekt.osgi.models.impl.EchoRequestMessage;
import org.enjekt.osgi.models.impl.EchoResponseMessage;

/**
 * The Class ExecutorImpl.
 */
public class ExecutorImpl implements Executor {


	/* (non-Javadoc)
	 * @see org.enjekt.osgi.echo.internal.api.Executor#process(org.enjekt.osgi.models.impl.EchoResponseMessage)
	 */
	@Override
	public EchoResponseMessage process(EchoRequestMessage msg) {
		EchoResponseMessage response = new EchoResponseMessage("Echoing: " +msg.getMessageToEcho());
		return response;
	}

}
