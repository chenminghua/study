package ramq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ramq.model.Product;
import ramq.service.ProductService;

/**
 * @author: minghua
 * @date: 2018/5/28 11:25
 * @modified By:
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public String products(){
        return "hello~";
    }
    /**
     * 添加产品
     */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(int id, String name, double price){
        if (StringUtils.isEmpty(name)) {
            return "FAIL";
        }
        Product product = new Product(id, name, price);
        System.out.println("com.minghua.study.kafka.controller:" + product);
        productService.save(product);
        return product.toString();
    }
}
