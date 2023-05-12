package com.selenium.pom.objects;

import com.selenium.pom.utils.JacksonUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
public class Product {

    private int id;
    private String name;

    public Product(int id) throws IOException {
        Product[] products = JacksonUtils.deserializeJson("products.json", Product[].class);
        for (Product product : products) {
            if (product.id == id) {
                this.id = product.getId();
                this.name = product.getName();
            }
        }
    }
}
