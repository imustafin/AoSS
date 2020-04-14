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
public interface Backend {
    /**
     * @return All possible product types
     * @throws java.lang.Exception specific exceptions depend on implementation
     */
    List<String> getProductTypes() throws Exception;
    
    /**
     * @param type products of which type to get
     * @return all products of this type
     * @throws java.lang.Exception specific exceptions depend on implementation
     */
    List<Product> getProductsByType(String type) throws Exception;
    
    /**
     * @param isShipped filter by shipment status, null for no filter
     * @return all orders registered
     * @throws java.lang.Exception specific exceptions depend on implementation
     */
    List<Order> getOrders(Boolean isShipped) throws Exception;
}
