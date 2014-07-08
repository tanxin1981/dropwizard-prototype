package com.zalora.core.api.catalog;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="catalog_config")
public class CatalogConfig {
	@Id
	@Column(name="id_catalog_config")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Catalog catalog;
	
	@NotEmpty
	@Length(min=3)
	@Column
	private String name;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at", nullable=true)
	private Date updatedAt;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@JsonProperty
	public String getName()
	{
		return name;
	}
}
