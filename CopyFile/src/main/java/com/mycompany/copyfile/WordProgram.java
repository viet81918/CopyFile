/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.copyfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;
import java.util.Scanner;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class WordProgram {
  
    public Scanner in = new Scanner(System.in);
     void readFileConfig() {
        File propertiesFile = new File("config.properties");
        Properties prop = new Properties();

        if (propertiesFile.exists()) {
            boolean checkFileConfig = checkFileConfig(propertiesFile);

            if (!checkFileConfig) {
                System.out.println("System shutdown!");
                return;
            }

            try (FileReader reader = new FileReader(propertiesFile)) {
                prop.load(reader);
                copyFolder(prop.getProperty("COPY_FOLDER"), prop.getProperty("PATH"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("File configure is not found!");
            createFileConfig(propertiesFile, prop);
        }
    }

    private boolean checkFileConfig(File propertiesFile) {
        Properties prop = new Properties();
        boolean exist = false;

        try (InputStream input = new FileInputStream(propertiesFile)) {
            prop.load(input);
            if (prop.getProperty("COPY_FOLDER").length() == 0) {
                System.err.println("Folder Source is not input");
            }
            if (prop.getProperty("PATH").length() == 0) {
                System.err.println("Folder Destination is not input");
            }
            exist = prop.getProperty("COPY_FOLDER") != null && prop.getProperty("PATH") != null;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Can't read file configure!");
        }

        return exist;
    }

    private void createFileConfig(File propertiesFile, Properties prop) {
        try (OutputStream output = new FileOutputStream(propertiesFile)) {
            System.out.print("Copy Folder: ");
            String copyFolder = in.nextLine();
            System.out.print("Data Type: ");
            String dataType = in.nextLine();
            System.out.print("Path: ");
            String path = in.nextLine();

            prop.setProperty("COPY_FOLDER", copyFolder);
            prop.setProperty("DATA_TYPE", dataType);
            prop.setProperty("PATH", path);

            // Save file config
            prop.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("File cannot be created");
            System.out.println("System shutdown");
        }
    }

    private void copyFolder(String copyFolder, String path) {
        File f1 = new File(copyFolder);
        File f2 = new File(path);

        if (checkInformationConfig(f1, f2)) {
            File[] listOfFiles = f1.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    copyFile(copyFolder + File.separator + listOfFiles[i].getName(), path);
                    System.out.println("File name: " + listOfFiles[i].getName());
                }
            }
            System.out.println("Copy is finished...");
        } else {
            System.err.println("System shutdown");
        }
    }

    private void copyFile(String file, String folder) {
        File f1 = new File(file);
        File f2 = new File(folder);

        if (f1.exists() && f1.isFile() && f2.exists() && f2.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(f1);
                FileOutputStream fos = new FileOutputStream(folder + File.separator + f1.getName());
                int b;
                while ((b = fis.read()) != -1) {
                    fos.write(b);
                }
                fis.close();
                fos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean checkInformationConfig(File f1, File f2) {
        boolean checkInformationConfig = f1.exists() && f1.isDirectory() && f2.exists() && f2.isDirectory();

        if (!f1.exists() || !f1.isDirectory()) {
            System.err.println("Can't find folder Source");
        }
        if (!f2.exists() || !f2.isDirectory()) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }
}