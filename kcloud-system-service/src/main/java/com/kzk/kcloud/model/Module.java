package com.kzk.kcloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity

public class Module implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
