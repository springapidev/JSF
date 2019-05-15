package com.coderbd;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DashboardController {

    private Dashboard dashboard;

    public Dashboard getDashboard() {
        if(dashboard == null ){
        dashboard = new Dashboard();
        dashboard.setDashboardTitle("ATM Mobile Shop");
        }
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

}
