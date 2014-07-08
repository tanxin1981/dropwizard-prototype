package com.zalora.core.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class RESTAppConfiguration extends Configuration
{
	@Valid
	@NotNull
	@JsonProperty("db")
	private final DataSourceFactory db = new DataSourceFactory();
	
	public DataSourceFactory getDataSourceFactory()
	{
		return db;
	}
}
