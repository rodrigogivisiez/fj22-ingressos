package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagemCapa {
	
	@JsonProperty("Poster")
	String url;
	
	private String getUrl() {
		return url;

	}
	private void setUrl(String url) {
		this.url= url;

	}
}
