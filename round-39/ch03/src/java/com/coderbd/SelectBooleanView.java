package com.coderbd;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class SelectBooleanView {

    Test test;

    public Test getTest() {
        if (test == null) {
            test = new Test();
        }
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void addMessage() {
        System.out.println("Date: " + test.getDate());
        System.out.println("Value1: " + test.isValue1());
        String summary = test.isValue2() ? "Checked" : "Unchecked";
        System.out.println("Value2: " + summary);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(test.getDate().toString()));
    }
}
