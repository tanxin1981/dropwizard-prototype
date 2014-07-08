package com.zalora.core.api;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import com.google.inject.persist.PersistFilter;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.zalora.core.api.bundle.GuiceBundleFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RESTApp extends Application<RESTAppConfiguration>
{
	public static void main(String[] args) throws Exception
	{
        new RESTApp().run(args);
    }
	
	private GuiceBundle<RESTAppConfiguration> guiceBundle;
	
	@Override
	public String getName()
	{
		return "REST App";
	}

	@Override
	public void initialize(Bootstrap<RESTAppConfiguration> bootstrap)
	{
		guiceBundle = GuiceBundleFactory.createGuiceBundle();
		
		bootstrap.addBundle(guiceBundle);
	}

	@Override
	public void run(RESTAppConfiguration c, Environment e) throws Exception 
	{
		final PersistFilter pf
			= guiceBundle.getInjector().getInstance(PersistFilter.class);
		
		e.servlets()
			.addFilter("persistFilter", pf)
			.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}
}
