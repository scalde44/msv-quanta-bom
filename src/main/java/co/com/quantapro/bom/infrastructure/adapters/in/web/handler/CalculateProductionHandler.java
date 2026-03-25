package co.com.quantapro.bom.infrastructure.adapters.in.web.handler;

import co.com.quantapro.bom.domain.dto.ProductionResult;
import co.com.quantapro.bom.domain.ports.in.CalculateProductionUseCase;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response.ProductionResponse;
import co.com.quantapro.bom.infrastructure.adapters.in.web.mapper.ProductWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CalculateProductionHandler {

    private final CalculateProductionUseCase useCase;
    private final ProductWebMapper mapper;

    public ProductionResponse handle(Long productId, int quantity) {

        ProductionResult result = useCase.calculate(productId, quantity);

        List<ProductionResponse.MaterialResponse> materials = result.materials().stream()
                .map(m -> mapper.toMaterialResponse(m.material(), m.required()))
                .toList();

        return mapper.toProductionResponse(
                result.productName(),
                result.quantity(),
                materials
        );
    }
}