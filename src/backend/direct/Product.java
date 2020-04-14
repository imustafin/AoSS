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
public class Product implements backend.interfaces.Product {
    
    final String id;
    final String type;
    final String productCode;
    final String description;
    final Integer quantity;
    final Float price;
    
    Product(String id, String type, String productCode,
            String description, Integer quantity, Float price) {
        this.id = id;
        this.type = type;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getProductCode() {
        return productCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public Float getPrice() {
        return price;
    }
    
}
