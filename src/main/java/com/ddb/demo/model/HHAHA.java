package com.ddb.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HHHH")
public class HHAHA implements Serializable {
	private static final long serialVersionUID = -2070481887536720776L;

	@Id
	@Column
	private String id;
	@Column
	private String name;
	
}
