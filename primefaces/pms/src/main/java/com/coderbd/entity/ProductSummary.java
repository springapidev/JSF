package com.coderbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "p_summary")
public class ProductSummary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private int id;
	
	@Column(name = "purchase_qty")
    private int purchaseQty;
	@Column(name = "sold_qty")
    private int soldQty;
	@Column(name = "avilable_qty")
    private int avilableQty;
	@Column(name = "product_code")
    private String productCode;
	
	@Column(name = "product_name")
    private String productName;

    public ProductSummary() {
    }

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPurchaseQty() {
		return purchaseQty;
	}

	public void setPurchaseQty(int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public int getSoldQty() {
		return soldQty;
	}

	public void setSoldQty(int soldQty) {
		this.soldQty = soldQty;
	}

	public int getAvilableQty() {
		return avilableQty;
	}

	public void setAvilableQty(int avilableQty) {
		this.avilableQty = avilableQty;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "ProductSummary [id=" + id + ", purchaseQty=" + purchaseQty + ", soldQty=" + soldQty + ", avilableQty="
				+ avilableQty + ", productCode=" + productCode + ", productName=" + productName + "]";
	}

   

}
