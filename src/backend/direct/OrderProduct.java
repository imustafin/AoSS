/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.direct;

/**
 *
 * @author ilgiz
 */
public class OrderProduct implements backend.interfaces.OrderProduct {

    Integer idInOrder;
    String productId;
    String description;
    Float price;
    
    public OrderProduct(Integer idInOrder, String productId,
            String description, Float price) {
        this.idInOrder = idInOrder;
        this.productId = productId;
        this.description = description;
        this.price = price;
    }
    
    @Override
    public Integer getIdInOrder() {
        return idInOrder;
    }

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Float getPrice() {
        return price;
    }
    
}
