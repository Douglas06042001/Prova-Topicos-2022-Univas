package com.example.douglas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "order_table")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ordernumber")
	private long ordernumber;

	@Column(name = "productcode")
	private String productcode;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "amount")
	private String amount;

	@Temporal(TemporalType.TIME)
	@Column(name = "date")
	private Date date;

	@Column(name = "value")
	private String value;

	public Order() {

	}

	public Order(String productcode, String CPF, String amount, Date date, String value) {
		super();
		this.productcode = productcode;
		this.CPF = CPF;
		this.amount = amount;
		this.date = date;
		this.value = value;
	}

	public long getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
