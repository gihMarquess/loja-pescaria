package com.becommerce.api.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class ErrorMessageDefinition implements java.io.Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String message;

    private java.lang.String processor;

    private java.util.List<java.lang.String> errors = new java.util.ArrayList<java.lang.String>();

    /**
     * Returns the value of property "message". 
     * 
     */
    public java.lang.String getMessage() {
        return message;
    }

    /**
     * Updates the value of property "message". 
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    /**
     * Returns the value of property "processor". 
     * 
     */
    public java.lang.String getProcessor() {
        return processor;
    }

    /**
     * Updates the value of property "processor". 
     */
    public void setProcessor(java.lang.String processor) {
        this.processor = processor;
    }

    /**
     * Returns the value of property "errors". 
     * 
     */
    public java.util.List<java.lang.String> getErrors() {
        return errors;
    }

    /**
     * Updates the value of property "errors". 
     */
    public void setErrors(java.util.List<java.lang.String> errors) {
        this.errors = errors;
    }

}
