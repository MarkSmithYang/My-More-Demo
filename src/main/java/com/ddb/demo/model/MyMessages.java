package com.ddb.demo.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("我的消息-app")
@Entity
@Table
public class MyMessages implements Serializable {
	private static final long serialVersionUID = -2159112902924972093L;

	@Id
	@Column(length = 128)
	@ApiModelProperty("消息id")
	private String id;

	@Column(length = 128)
	@ApiModelProperty("消息日期")
	private String date;

	@Column(length = 128)
	@ApiModelProperty("消息内容")
	private String messages;

	public MyMessages() {
		super();
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
	}

	public MyMessages(String date, String messages) {
		super();
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
		this.date = date;
		this.messages = messages;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}
