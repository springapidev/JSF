package com.coderbd;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BusController {

    private List<Bus> busList;
    private Bus selectedBus;


    public List<Bus> getBusList() {
        busList = new ArrayList<>();
        busList.add(new Bus("100", "1980", "Toyota", "Red"));
        busList.add(new Bus("101", "1940", "Nano", "Red"));
        busList.add(new Bus("102", "1980", "Toyota", "Green"));
        busList.add(new Bus("103", "1990", "Nano", "Red"));
        busList.add(new Bus("104", "1985", "Toyota", "Yellow"));
        busList.add(new Bus("105", "1960", "Nano", "Red"));
        busList.add(new Bus("106", "1920", "Toyota", "Orange"));
        busList.add(new Bus("107", "1975", "Nano", "Red"));
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public Bus getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Bus selectedBus) {
        this.selectedBus = selectedBus;
    }

   
// public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Bus Selected", ((Bus) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
// 
//    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Bus Unselected", ((Bus) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
}
