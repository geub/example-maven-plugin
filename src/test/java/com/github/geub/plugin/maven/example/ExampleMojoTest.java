package com.github.geub.plugin.maven.example;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class ExampleMojoTest extends AbstractMojoTestCase {

	public final static String BASIC_TEST_FILE_PATH = "src/test/resources/unit/example-maven-plugin/plugin-config.xml";

	public void testExamplePluginExists() throws Exception {

		File pluginConfig = new File( super.getBasedir(), ExampleMojoTest.BASIC_TEST_FILE_PATH);

		try {
			ExampleMojo mojo = getBasicExampleMojo();
			super.assertNotNull(mojo);
		} catch(Exception ex) {
			super.fail();
			throw ex;
		}
	}

	public void testExampleInConsoleOutput() throws Exception {

		File pluginConfig = new File( super.getBasedir(), ExampleMojoTest.BASIC_TEST_FILE_PATH );
		ExampleMojo mojo = getBasicExampleMojo();

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		PrintStream testConsole = new PrintStream(outStream);
		PrintStream trueConsole = System.out;

		System.setOut(testConsole);
		mojo.execute();
		System.setOut(trueConsole);

		super.assertEquals("example", outStream.toString().trim().toLowerCase());
	}

	private ExampleMojo getBasicExampleMojo() throws Exception {
		File pluginConfig = new File( super.getBasedir(), ExampleMojoTest.BASIC_TEST_FILE_PATH );
		return( (ExampleMojo) super.lookupMojo("example", pluginConfig) );
	}
}
