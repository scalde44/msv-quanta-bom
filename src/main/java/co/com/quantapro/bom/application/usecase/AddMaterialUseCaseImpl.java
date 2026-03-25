package co.com.quantapro.bom.application.usecase;

import co.com.quantapro.bom.domain.exceptions.DuplicateMaterialException;
import co.com.quantapro.bom.domain.model.Material;
import co.com.quantapro.bom.domain.model.Product;
import co.com.quantapro.bom.domain.ports.in.AddMaterialUseCase;
import co.com.quantapro.bom.domain.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddMaterialUseCaseImpl implements AddMaterialUseCase {

    private static final String ERROR_MESSAGE_TEMPLATE = "Material '%s' already exists for product '%s'";

    private final ProductRepositoryPort repository;

    @Override
    public void add(Long productId, String material, int quantity) {
        Product product = repository.findById(productId);

        boolean materialExists = product.getMaterials().stream()
                .anyMatch(m -> m.getName().equalsIgnoreCase(material));
        if (materialExists) {
            throw new DuplicateMaterialException(String.format(ERROR_MESSAGE_TEMPLATE, material, product.getName()));
        }

        product.addMaterial(new Material(material, quantity));

        repository.save(product);
    }
}