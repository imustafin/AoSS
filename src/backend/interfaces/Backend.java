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
     * @param order what filters to use (isShipped, id only), null for no filter
     * @return orders matching this pattern
     * @throws java.lang.Exception specific exceptions depend on implementation
     */
    List<Order> getOrders(Order order) throws Exception;
    
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
    
    /**
     * @param order which order to save
     * @throws Exception specific exceptions depend on implementation
     */
    void addOrder(Order order) throws Exception;
    
    /**
     * @param order which order to set as shipped
     * @throws Exception specific exceptions depend on implementation
     */
    void setShipped(Order order) throws Exception;
    
}
