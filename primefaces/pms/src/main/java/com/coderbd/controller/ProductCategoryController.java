package com.coderbd.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.coderbd.entity.ProductCategory;
import com.coderbd.service.ProductCategoryService;


@ManagedBean
public class ProductCategoryController {

	final static Logger logger = Logger.getLogger(ProductCategoryController.class);

	private ProductCategoryService productCategoryService;
	private ProductCategory productCategory;

	private List<ProductCategory> productCategories;

	public String save() {
		try {

			productCategoryService = new ProductCategoryService();
			productCategoryService.persist(productCategory);

			notificationSuccess("Persist Success!");
			productCategory = null;

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

	public ProductCategory getProductCategory() {
		if (productCategory == null) {
			productCategory = new ProductCategory();
		}
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public List<ProductCategory> getProductCategories() {
		try {

			productCategoryService = new ProductCategoryService();
			productCategories = productCategoryService.findAll();

		} catch (Exception e) {
			notificationError(e, "Persist Error!");
			logger.debug("This is debug :" + e);
			logger.error("This is error : " + e);
			logger.fatal("This is fatal : " + e);
		}
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

}
