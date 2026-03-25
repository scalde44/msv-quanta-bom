package co.com.quantapro.bom.infrastructure.adapters.out.persistence.repository;

import co.com.quantapro.bom.domain.exceptions.ProductNotFoundException;
import co.com.quantapro.bom.domain.model.Product;
import co.com.quantapro.bom.domain.ports.out.ProductRepositoryPort;
import co.com.quantapro.bom.infrastructure.adapters.out.persistence.entity.ProductEntity;
import co.com.quantapro.bom.infrastructure.adapters.out.persistence.mapper.ProductPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private static final String ERROR_MESSAGE_TEMPLATE = "Product not found with id: %d";

    private final SpringDataProductRepository repository;
    private final ProductPersistenceMapper mapper;

    @Override
    public Product save(Product product) {

        ProductEntity entity = mapper.toEntity(product);

        ProductEntity saved = repository.save(entity);

        return mapper.toDomain(saved);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() ->
                        new ProductNotFoundException(String.format(ERROR_MESSAGE_TEMPLATE, id)));
    }
}