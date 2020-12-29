package com.in.washingMachine.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;

/**
 * Created by khizar khan
 */
@Entity
@Table(name = "TB_APPLIANCES")
public class WashingMachine {
	private Integer id;
	private String serial;
	private String model;
	private String state;

	public WashingMachine(String model, String state, String serial) {
		super();
		this.model = model;
		this.state = state;
		this.serial = serial;
	}
	
	public WashingMachine() {
		super();
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column
	public String getModel() {
		return model;
	}

	public String getSerial() {
		return serial;
	}
	@Column
	public void setModel(String model) {
		this.model = model;
	}

	

	public void setSerial(String serial) {
		this.serial = serial;
	}

}
