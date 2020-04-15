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
public interface OrderProduct {
    /**
     * @return id of the product inside this order or null if there is no access
     */
    Integer getIdInOrder();
    
    /**
     * @return id of the product in inventory database or null if there is no access
     */
    String getProductId();
    
    /**
     * @return description of the product or null if there is no access
     */
    String getDescription();
    
    /**
     * @return price of the product or null if there is no access
     */
    Float getPrice();
}
