package co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response;

import java.util.List;

public record ProductionResponse(
        String product,
        int quantity,
        List<MaterialResponse> materials
) {
    public record MaterialResponse(String material, int required) {
    }
}