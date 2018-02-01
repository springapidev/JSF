/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.controller;


import javax.faces.bean.ManagedBean;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Rajail Islam
 */
@ManagedBean
public class FileUploadController {
    public void handleFileUpload(FileUploadEvent event){
        UploadedFile file = event.getFile();
        
    }
}
