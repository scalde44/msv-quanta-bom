package co.com.quantapro.bom.domain.dto;

import java.util.List;

public record ProductionResult(
        String productName,
        int quantity,
        List<MaterialRequirement> materials) {

    public record MaterialRequirement(
            String material,
            int required) {
    }
}