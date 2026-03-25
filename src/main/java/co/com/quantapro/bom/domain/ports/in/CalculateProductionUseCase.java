package co.com.quantapro.bom.domain.ports.in;

import co.com.quantapro.bom.domain.dto.ProductionResult;

public interface CalculateProductionUseCase {
    ProductionResult calculate(Long productId, int quantity);
}