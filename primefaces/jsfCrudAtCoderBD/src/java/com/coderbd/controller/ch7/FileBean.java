package com.coderbd.controller.ch7;


import com.coderbd.util.MessageUtil;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * User: mertcaliskan
 * Date: 9/5/12
 */
@ManagedBean
@SessionScoped
public class FileBean implements Serializable {

    private UploadedFile file;

    private UploadedFile file1;
    private UploadedFile file2;

    private StreamedContent downloadFile;

    public FileBean() {
        InputStream stream = this.getClass().getResourceAsStream("/chapter7/PFSamplePDF.pdf");
        downloadFile = new DefaultStreamedContent(stream, "application/pdf", "PFSample.pdf");
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile1() {
        return file1;
    }

    public void setFile1(UploadedFile file1) {
        this.file1 = file1;
    }

    public UploadedFile getFile2() {
        return file2;
    }

    public void setFile2(UploadedFile file2) {
        this.file2 = file2;
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        MessageUtil.addInfoMessage("upload.successful", file.getFileName() + " is uploaded.");
    }

    public StreamedContent getDownloadFile() {
        return downloadFile;
    }
}