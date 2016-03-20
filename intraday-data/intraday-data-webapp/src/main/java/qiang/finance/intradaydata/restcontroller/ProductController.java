package qiang.finance.intradaydata.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qiang.finance.intradaydata.entities.Product;
import qiang.finance.intradaydata.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiang He on 04/03/2016.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

//    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/products")
    public List<Product> allProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        for (Product product : iterable) {
            products.add(product);
        }
        return products;
    }

}
