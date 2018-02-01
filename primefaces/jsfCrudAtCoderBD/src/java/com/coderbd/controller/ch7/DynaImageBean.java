package com.coderbd.controller.ch7;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * User: mertcaliskan
 * Date: 10/18/12
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class DynaImageBean implements Serializable {

    public StreamedContent getGraphicText() throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/chapter7/primefaces.jpg");
        return new DefaultStreamedContent(stream);
    }
}
