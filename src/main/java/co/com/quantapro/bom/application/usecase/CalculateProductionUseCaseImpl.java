package co.com.quantapro.bom.application.usecase;

import co.com.quantapro.bom.domain.dto.ProductionResult;
import co.com.quantapro.bom.domain.dto.ProductionResult.MaterialRequirement;
import co.com.quantapro.bom.domain.exceptions.InvalidProductionCalculationException;
import co.com.quantapro.bom.domain.model.Product;
import co.com.quantapro.bom.domain.ports.in.CalculateProductionUseCase;
import co.com.quantapro.bom.domain.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalculateProductionUseCaseImpl implements CalculateProductionUseCase {

    private static final String ERROR_MESSAGE_TEMPLATE = "Cannot calculate production for product '%s' because it has no materials defined.";

    private final ProductRepositoryPort repository;

    @Override
    public ProductionResult calculate(Long productId, int quantity) {

        Product product = repository.findById(productId);

        if (product.getMaterials().isEmpty()) {
            throw new InvalidProductionCalculationException(String.format(ERROR_MESSAGE_TEMPLATE, product.getName()));
        }

        List<MaterialRequirement> materials = product.getMaterials().stream()
                .map(m -> new MaterialRequirement(
                        m.getName(),
                        m.getQuantityPerUnit() * quantity
                ))
                .toList();

        return new ProductionResult(
                product.getName(),
                quantity,
                materials
        );
    }
}