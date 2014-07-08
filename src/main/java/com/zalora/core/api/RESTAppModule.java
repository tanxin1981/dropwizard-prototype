package com.zalora.core.api;

import java.util.logging.Logger;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.google.inject.Provider;

public class RESTAppModule extends AbstractModule {
	@Override
	protected void configure() {
		
	}
}
