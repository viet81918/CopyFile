/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.copyfile;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author conch
 */
class ExceptionHandle extends Exception {
         private List<String> exceptions = new ArrayList<>();

    // Add an exception message to the list
    public void addException(String message) {
        exceptions.add(message);
    }

    // Check if the list of exceptions is empty
    public boolean isEmpty() {
        return exceptions.isEmpty();
    }

    // Get all exception messages as a list
    public List<String> getExceptions() {
        return exceptions;
    }
}
