package com.coderbd.controller.ch7;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * Created by mertcaliskan
 * on 26/01/15.
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class MediaBean implements Serializable {

    public StreamedContent getMedia() throws IOException {
        InputStream stream = this.getClass().getResourceAsStream("/chapter7/sample_iTunes.mov");
        return new DefaultStreamedContent(stream, "video/quicktime");
    }
}
