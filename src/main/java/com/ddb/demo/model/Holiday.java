package com.ddb.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 *	区分每年的工作日休息日和节假日
 */
@Entity
@Table
public class Holiday implements Serializable{
	private static final long serialVersionUID = -5297523634936951087L;

	@Id
	@Column(length=11)
	private String id;
	
	@Column(length=5)
	private String code;
	
	@Column(length=11)
	private String codeCN;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeCN() {
		return codeCN;
	}

	public void setCodeCN(String codeCN) {
		this.codeCN = codeCN;
	}

	public Holiday() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Holiday(String id, String code, String codeCN) {
		super();
		this.id = id;
		this.code = code;
		this.codeCN = codeCN;
	}
	
}
