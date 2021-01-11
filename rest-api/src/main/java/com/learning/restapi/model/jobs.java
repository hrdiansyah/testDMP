package com.learning.restapi.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class jobs {
	@Id
	private String id;
	
	private String type;
	private String url;
	private String created_at;
	private String company;
	private String company_url;
	private String location;
	private String title;
	private String descripition;
	private String how_to_apply;
	private String company_logo;
}
