package com.github.geub.plugin.maven.example;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

public class ExampleMojoTest extends AbstractMojoTestCase {

	public void testHelloPluginExists() throws Exception {

		File pluginConfig = new File(super.getBasedir(), "src/test/resources/unit/hello-plugin-basic-test/plugin-config.xml");

		try {
			ExampleMojo mojo = (ExampleMojo) super.lookupMojo("hello", pluginConfig);
			super.assertNotNull(mojo);
		} catch (Exception ex) {
			super.fail();
			throw ex;
		}
	}
}
