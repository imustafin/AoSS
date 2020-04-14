/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.interfaces;

import java.util.List;

/**
 *
 * @author ilgiz
 */
public interface Order {
    
    /**
     * @return id of this order or null if there is no access to this field
     */
    Integer getId();
    
    /**
     * @return first name or null if there is no access to this field
     */
    String getFirstName();
    
    /**
     * @return last name or null if there is no access to this field
     */
    String getLastName();
    
    /**
     * @return phone number or null if there is no access to this field
     */
    String getPhoneNumber();
    
    /**
     * @return address or null if there is no access to this field
     */
    String getAddress();
    
    /**
     * @return total cost of this order or null if there is no access to this field
     */
    Float getTotalCost();
    
    /**
     * @return is this order shipped or null if there is no access to this field
     */
    Boolean isShipped();
    
    /**
     * @return date when this order was created or null if there is no access to this field
     */
    String getOrderDate();
    
    /**
     * @return products included in this order or null if there is no access to this field
     */
    List<Product> getProducts();
}
