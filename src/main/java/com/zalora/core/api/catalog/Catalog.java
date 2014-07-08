package com.zalora.core.api.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="catalog_simple")
public class Catalog
{
	@Id
	@Column(name="id_catalog_simple")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="sku")
	@NotEmpty
	private String sku;
	
	@OneToOne(mappedBy="catalog", fetch=FetchType.EAGER)
	@JoinColumn(name="fk_catalog_config")
	private CatalogConfig config;
	
	@JsonProperty
	public int getId()
	{
		return id;
	}
	
	public void setSKU(String sku)
	{
		this.sku = sku;
	}
	
	@JsonProperty
	public String getSKU()
	{
		return sku;
	}
	
	@JsonProperty
	public CatalogConfig getConfig()
	{
		return config;
	}
}
