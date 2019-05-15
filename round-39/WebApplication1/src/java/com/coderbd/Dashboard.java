package com.coderbd;

public class Dashboard {

    private String dashboardTitle = "Admin Dashboard";
    private double todaySales = 150000.0;
    private double weeklyAvgSales = 70000.0;
    private double lastMonthSales = 1800000.0;
    private int totalNoOfCustomers = 25000;
    private String mostPurchaseCustomer = "Mr. AAAAAAA";
    private int noOfProuductsInShop = 380;

    public String getDashboardTitle() {
        return dashboardTitle;
    }

    public void setDashboardTitle(String dashboardTitle) {
        this.dashboardTitle = dashboardTitle;
    }

    public double getTodaySales() {
        return todaySales;
    }

    public void setTodaySales(double todaySales) {
        this.todaySales = todaySales;
    }

    public double getWeeklyAvgSales() {
        return weeklyAvgSales;
    }

    public void setWeeklyAvgSales(double weeklyAvgSales) {
        this.weeklyAvgSales = weeklyAvgSales;
    }

    public double getLastMonthSales() {
        return lastMonthSales;
    }

    public void setLastMonthSales(double lastMonthSales) {
        this.lastMonthSales = lastMonthSales;
    }

    public int getTotalNoOfCustomers() {
        return totalNoOfCustomers;
    }

    public void setTotalNoOfCustomers(int totalNoOfCustomers) {
        this.totalNoOfCustomers = totalNoOfCustomers;
    }

    public String getMostPurchaseCustomer() {
        return mostPurchaseCustomer;
    }

    public void setMostPurchaseCustomer(String mostPurchaseCustomer) {
        this.mostPurchaseCustomer = mostPurchaseCustomer;
    }

    public int getNoOfProuductsInShop() {
        return noOfProuductsInShop;
    }

    public void setNoOfProuductsInShop(int noOfProuductsInShop) {
        this.noOfProuductsInShop = noOfProuductsInShop;
    }

   

}
