package com.coderbd.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.ProductCategory;
import com.coderbd.entity.ProductPurchase;
import com.coderbd.entity.ProductSummary;
import com.coderbd.service.ProductPurchaseService;
import com.coderbd.service.ProductSummaryService;

@ManagedBean(name = "productPurchaseController")
@SessionScoped
public class ProductPurchaseController {

	final static Logger logger = Logger.getLogger(ProductPurchaseController.class);
	private ProductSummaryService productSummaryService;
	private ProductSummary productSummary;

	private ProductCategory productCategory;
	private ProductPurchaseService productPurchaseService;
	private ProductPurchase productPurchase;

	private List<ProductPurchase> productPurchases;


	public String save() {
		productSummaryService = new ProductSummaryService();
		try {
			productPurchaseService = new ProductPurchaseService();
			productPurchase.setProductCategory(productCategory);
			productPurchase.setPurchaseDate(new Date());
			
			productSummary = new ProductSummary();
			productSummary.setProductName(productPurchase.getProductName());
			productSummary.setProductCode(productPurchase.getProductCode());
			productSummary.setPurchaseQty(productPurchase.getQty());
			productSummary.setAvilableQty(productPurchase.getQty());

			ProductSummary ps = (ProductSummary) productSummaryService.findProductSummaryByProductCode(productPurchase.getProductCode());
			if (ps != null) {
				productSummary.setId(ps.getId());
				productSummary.setPurchaseQty(ps.getPurchaseQty() + productPurchase.getQty());
				productSummary.setAvilableQty(ps.getAvilableQty() + productPurchase.getQty());
				productPurchaseService.persist(productPurchase);
				productSummaryService.merge(productSummary);
				notificationSuccess("Persist Success!");
				productSummary = null;
				productPurchase = null;
			}
		

			//productPurchase = null;

		} catch (Exception e) {
			try {
				productPurchaseService.persist(productPurchase);
				productSummaryService.persist(productSummary);
				notificationSuccess("Persist Success!");
				productSummary = null;
				productPurchase = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return null;

	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Success");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ProductPurchase getProductPurchase() {
		if (productPurchase == null) {
			productPurchase = new ProductPurchase();
		}
		return productPurchase;
	}

	public void setProductPurchase(ProductPurchase productPurchase) {
		this.productPurchase = productPurchase;
	}

	public List<ProductPurchase> getProductPurchases() {
		try {

			productPurchaseService = new ProductPurchaseService();
			productPurchases = productPurchaseService.findAll();

		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return productPurchases;
	}

	public void setProductPurchases(List<ProductPurchase> productPurchases) {
		this.productPurchases = productPurchases;
	}

	public ProductCategory getProductCategory() {
		if (productCategory == null) {
			productCategory = new ProductCategory();
		}
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	

	public ProductSummary getProductSummary() {
		if (productSummary == null) {
			productSummary = new ProductSummary();
		}
		return productSummary;
	}

	public void setProductSummary(ProductSummary productSummary) {
		this.productSummary = productSummary;
	}

}
