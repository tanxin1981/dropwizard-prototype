package com.zalora.core.api.bundle;

import com.google.inject.persist.jpa.JpaPersistModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.zalora.core.api.RESTApp;
import com.zalora.core.api.RESTAppConfiguration;
import com.zalora.core.api.RESTAppModule;


public class GuiceBundleFactory
{
	public static GuiceBundle<RESTAppConfiguration> createGuiceBundle()
	{
		return new GuiceBundle.Builder<RESTAppConfiguration>()
			.addModule(new RESTAppModule())
			.addModule(new JpaPersistModule("Default"))
			
			/* auto-register all resources class in given package */
			.enableAutoConfig(RESTApp.class.getPackage().getName())
			.setConfigClass(RESTAppConfiguration.class)
			.build();
	}
}
