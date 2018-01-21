package com.coderbd.controller;


import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "item")
@SessionScoped
public class Item implements Serializable {

   private static final long serialVersionUID = 1L;
   private String item;
   private Integer qty;
   private Double price;
   OrderBean order;

   public String getItem() {
       return item;
   }

   public void setItem(String item) {
       this.item = item;
   }

   public Double getPrice() {
       return price;
   }

   public void setPrice(Double price) {
       this.price = price;
   }

   public Integer getQty() {
       return qty;
   }

   public void setQty(Integer qty) {
       this.qty = qty;
   }

   public OrderBean getOrder() {
       return order;
   }

   public void setOrder(OrderBean order) {
       this.order = order;
   }
   private static final ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();

   public ArrayList<OrderBean> getOrderList() {
       return orderList;
   }

   public String addAction() {
       OrderBean orderitem = new OrderBean(this.item, this.qty, this.price);
       orderList.add(orderitem);

       item = "";
       qty = 0;
       price = 0.0;
       return null;
   }
   public void onEdit(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Edited",((OrderBean) event.getObject()).getItem());  
       FacesContext.getCurrentInstance().addMessage(null, msg);  
   }  
      
   public void onCancel(RowEditEvent event) {  
       FacesMessage msg = new FacesMessage("Item Cancelled");   
       FacesContext.getCurrentInstance().addMessage(null, msg); 
       orderList.remove((OrderBean) event.getObject());
   }  
}