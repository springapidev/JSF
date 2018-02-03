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
@Table(name = "p_sales")
public class ProductSales {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private int id;
	
	@Column(name = "qty")
    private int qty;
	@Column(name = "unit_price")
    private double unitPrice;
	@Column(name = "total_price")
    private double totalPrice;
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName="id")
	private ProductPurchase productPurchase;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "sales_date")
    private Date salesDate;
	@Column(name = "customer_name")
    private String customerName;
	@Column(name = "customer_mobile")
    private String customerMobile;
	
	@Column(name = "note")
	private  String note;

    public ProductSales() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductPurchase getProductPurchase() {
		return productPurchase;
	}

	public void setProductPurchase(ProductPurchase productPurchase) {
		this.productPurchase = productPurchase;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ProductSales [id=" + id + ", qty=" + qty + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", productPurchase=" + productPurchase + ", salesDate=" + salesDate + ", customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", note=" + note + "]";
	}

	

}
