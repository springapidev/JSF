package com.coderbd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "p_purchase")
public class ProductPurchase {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "p_name")
	private  String productName;
	@Column(name = "p_code")
	private  String productCode;
	@Column(name = "unit_price")
	private double unitPrice;
	@Column(name = "qty")
    private int qty;
	@Column(name = "t_price")
    private double totalPrice;

	@Temporal(TemporalType.DATE)
	@Column(name = "purchase_date")
    private Date purchaseDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id",referencedColumnName="id")
	private ProductCategory productCategory;
	
	@Column(name = "note")
	private  String note;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ProductPurchase [id=" + id + ", productName=" + productName + ", productCode=" + productCode
				+ ", unitPrice=" + unitPrice + ", qty=" + qty + ", totalPrice=" + totalPrice + ", purchaseDate="
				+ purchaseDate + ", productCategory=" + productCategory + ", note=" + note + "]";
	}


}
