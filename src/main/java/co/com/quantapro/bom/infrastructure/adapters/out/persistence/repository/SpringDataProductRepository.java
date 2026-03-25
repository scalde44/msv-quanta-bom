package co.com.quantapro.bom.infrastructure.adapters.out.persistence.repository;

import co.com.quantapro.bom.infrastructure.adapters.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository
        extends JpaRepository<ProductEntity, Long> {
}