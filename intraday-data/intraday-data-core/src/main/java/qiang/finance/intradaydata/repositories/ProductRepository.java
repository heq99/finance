package qiang.finance.intradaydata.repositories;

import org.springframework.data.repository.CrudRepository;
import qiang.finance.intradaydata.entities.Product;

/**
 * Created by qhe on 13/02/16.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByName(String name);

}
