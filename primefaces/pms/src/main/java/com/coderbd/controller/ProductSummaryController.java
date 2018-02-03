package com.coderbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.ProductSummary;
import com.coderbd.service.ProductSummaryService;

@ManagedBean
public class ProductSummaryController {
	final static Logger logger = Logger.getLogger(ProductSummaryController.class);

	private ProductSummaryService productSummaryService;
	private ProductSummary productSummary;

	private List<ProductSummary> productSummaries;

	public String save() {
		try {

			productSummaryService = new ProductSummaryService();
			productSummaryService.persist(productSummary);

			notificationSuccess("Persist Success!");
			productSummary = null;

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

	public ProductSummary getProductSummary() {
		if(productSummary == null ){
			productSummary = new ProductSummary();
		}
		return productSummary;
	}

	public void setProductSummary(ProductSummary productSummary) {
		this.productSummary = productSummary;
	}

	public List<ProductSummary> getProductSummaries() {
		return productSummaries;
	}

	public void setProductSummaries(List<ProductSummary> productSummaries) {
		this.productSummaries = productSummaries;
	}


}
