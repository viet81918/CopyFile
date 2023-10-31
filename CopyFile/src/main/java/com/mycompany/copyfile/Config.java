/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.copyfile;

/**
 *
 * @author conch
 */
public class Config {
       private String copyFolder;
    private String dataType;
    private String path;

    // Constructor with default values
    public Config() {
        this.copyFolder = null;
        this.dataType = null;
        this.path = null;
    }

    public String getCopyFolder() {
        return copyFolder;
    }

    public void setCopyFolder(String copyFolder) {
        this.copyFolder = copyFolder;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
