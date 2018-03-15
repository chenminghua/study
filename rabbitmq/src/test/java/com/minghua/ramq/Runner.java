package com.minghua.ramq;

import com.minghua.ramq.model.Product;
import com.minghua.ramq.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author minghua.chen
 * @version 1.0.0
 * @Description
 * @date 17-9-14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Runner {
    @Autowired
    private ProductService productService;
    @Test
    public void testMsg() {
        Product product = new Product();
        product.setId(1).setName("iphone X").setPrice(8898.9);
        productService.save(product);
    }
}
