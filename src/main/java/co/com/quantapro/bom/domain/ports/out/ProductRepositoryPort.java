package co.com.quantapro.bom.domain.ports.out;

import co.com.quantapro.bom.domain.model.Product;

public interface ProductRepositoryPort {
    Product save(Product product);

    Product findById(Long id);
}