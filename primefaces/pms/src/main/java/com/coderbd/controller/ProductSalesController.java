package com.coderbd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.ProductCategory;
import com.coderbd.entity.ProductPurchase;
import com.coderbd.entity.ProductSales;
import com.coderbd.entity.ProductSummary;
import com.coderbd.service.ProductPurchaseService;
import com.coderbd.service.ProductSalesService;
import com.coderbd.service.ProductSummaryService;

@SessionScoped
@ManagedBean(name="productSalesController")
public class ProductSalesController {

	final static Logger logger = Logger.getLogger(ProductSalesController.class);
	private ProductSummaryService productSummaryService;
	private ProductSummary productSummary;
	private List<ProductSummary> productSummaries;
	
	private ProductCategory productCategory;
	
	private ProductPurchaseService productPurchaseService;
	private ProductPurchase productPurchase;
	private List<ProductPurchase> productPurchases;
	
	
	private ProductSalesService productSalesService;
	private ProductSales productSales;

	private List<ProductSales> productSaleses;

	
	public void loadProductListByCategory(){
		try {
			if(productCategory.getId() != 0)
			productPurchases = new ArrayList<ProductPurchase>();
			productPurchaseService = new ProductPurchaseService();
			productPurchases = productPurchaseService.findAllProductPurchaseCategory(productCategory.getId());

		} catch (Exception ex) {
			notificationError(ex, "Persist Error!");
			logger.debug("This is debug :" + ex);
			logger.error("This is error : " + ex);
			logger.fatal("This is fatal : " + ex);
		}
	}
	
	
	
	public String save() {
		try {
			if(productPurchase.getId() != 0){

			productSalesService = new ProductSalesService();
			productSales.setProductPurchase(productPurchase);
			productSales.setSalesDate(new Date());
			productSalesService.persist(productSales);
			productPurchaseService = new ProductPurchaseService();
			ProductPurchase pp = productPurchaseService.findById(productPurchase.getId());
			productSummaryService = new ProductSummaryService();
			ProductSummary ps = (ProductSummary) productSummaryService.findProductSummaryByProductCode(pp.getProductCode());
			
			productSummary = new ProductSummary();
			productSummary.setProductName(ps.getProductName());
			productSummary.setProductCode(ps.getProductCode());
			productSummary.setPurchaseQty(ps.getPurchaseQty());
			productSummary.setAvilableQty(ps.getAvilableQty() - productSales.getQty());
			productSummary.setSoldQty(ps.getSoldQty() + productSales.getQty());
			productSummary.setId(ps.getId());
			productSummaryService.merge(productSummary);
			notificationSuccess("Persist Success!");
			productSales = null;
			productSummary = null;
			}
		} catch (Exception e) {
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

	public ProductSales getProductSales() {
		if(productSales == null ){
			productSales = new ProductSales();
		}
		return productSales;
	}

	public void setProductSales(ProductSales productSales) {
		this.productSales = productSales;
	}

	public List<ProductSales> getProductSaleses() {
		try {

			productSalesService = new ProductSalesService();
			productSaleses = productSalesService.findAll();

			} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return productSaleses;
	}

	public void setProductSaleses(List<ProductSales> productSaleses) {
		this.productSaleses = productSaleses;
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
	
	public List<ProductSummary> getProductSummaries() {
		try {
			productSummaryService = new ProductSummaryService();
			productSummaryService.findAll();
		} catch (Exception e) {
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return productSummaries;
	}

	public void setProductSummaries(List<ProductSummary> productSummaries) {
		this.productSummaries = productSummaries;
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


}
