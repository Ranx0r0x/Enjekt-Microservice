package org.enjekt.osgi.echo;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.log4j.Logger;

public abstract class BaseTest extends CamelBlueprintTestSupport {

	protected static final Logger logger = Logger.getLogger(BaseTest.class);
	private static final String TEST_BLUEPRINT_XML = "OSGI-INF/blueprint/blueprint-properties.xml,OSGI-INF/blueprint/blueprint.xml";


	@Override
	protected String getBlueprintDescriptor() {
		return TEST_BLUEPRINT_XML;
	}

	@Override
	protected String getBundleFilter() {
		return "(!(Bundle-SymbolicName=org.apache.felix.fileinstall))";
	}

	@Override
	public Long getCamelContextCreationTimeout()
	{
		return 15000L;
	}
}