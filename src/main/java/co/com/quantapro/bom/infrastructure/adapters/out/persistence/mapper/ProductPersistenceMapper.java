package co.com.quantapro.bom.infrastructure.adapters.out.persistence.mapper;

import co.com.quantapro.bom.domain.model.Material;
import co.com.quantapro.bom.domain.model.Product;
import co.com.quantapro.bom.infrastructure.adapters.out.persistence.entity.MaterialEntity;
import co.com.quantapro.bom.infrastructure.adapters.out.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceMapper {

    public ProductEntity toEntity(Product domain) {

        ProductEntity entity = new ProductEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        List<MaterialEntity> materials = domain.getMaterials().stream()
                .map(m -> toEntity(m, entity))
                .collect(Collectors.toList());

        entity.setMaterials(materials);

        return entity;
    }

    private MaterialEntity toEntity(Material material, ProductEntity product) {
        MaterialEntity entity = new MaterialEntity();
        entity.setName(material.getName());
        entity.setQuantityPerUnit(material.getQuantityPerUnit());
        entity.setProduct(product);
        return entity;
    }

    public Product toDomain(ProductEntity entity) {

        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());

        List<Material> materials = entity.getMaterials().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());

        product.setMaterials(materials);

        return product;
    }

    private Material toDomain(MaterialEntity entity) {
        return new Material(
                entity.getName(),
                entity.getQuantityPerUnit()
        );
    }
}