/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.interfaces;

/**
 *
 * @author ilgiz
 */
public interface Product {
    /**
     * @return Type of the good or null if there is no access to this field
     */
    String getType();
    
    /**
     * @return Id (productid/product_code) of the good or null if there is no access to this field
     */
    String getId();
    
    /**
     * @return Description of the good or null if there is no access to this field
     */
    String getDescription();
    
    /**
     * @return Quantity of the good or null if there is no access to this field
     */
    Integer getQuantity();
    
    /**
     * @return Price of the good or null if there is no access to this field
     */
    Float getPrice();
}
