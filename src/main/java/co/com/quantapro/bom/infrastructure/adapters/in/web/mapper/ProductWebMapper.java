package co.com.quantapro.bom.infrastructure.adapters.in.web.mapper;

import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response.ProductionResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductWebMapper {

    public ProductionResponse.MaterialResponse toMaterialResponse(String name, Integer required) {
        return new ProductionResponse.MaterialResponse(name, required);
    }

    public ProductionResponse toProductionResponse(
            String productName,
            int quantity,
            List<ProductionResponse.MaterialResponse> materials) {

        return new ProductionResponse(productName, quantity, materials);
    }
}