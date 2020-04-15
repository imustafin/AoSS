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
    
    /**
     * Add product to database
     * 
     * @param product what to add
     * @throws Exception specific exceptions depend on implementation
     */
    void addProduct(Product product) throws Exception;
    
    /**
     * Delete products by type and id
     * 
     * @param product what to delete with type and id
     * @return how many records were deleted
     * @throws Exception specific exceptions depend on implementation
     */
    Integer deleteProduct(Product product) throws Exception;
    
    /**
     * Decrement count of products by type and id
     * 
     * @param product where to decrement delete with type and id
     * @return updated products affected by decrement
     * @throws Exception specific exceptions depend on implementation
     */
    List<Product> decrementProduct(Product product) throws Exception;
    
    void addOrder(Order order) throws Exception;
}
