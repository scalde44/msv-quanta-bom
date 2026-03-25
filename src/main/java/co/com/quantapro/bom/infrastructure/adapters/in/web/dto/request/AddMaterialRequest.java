package co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record AddMaterialRequest(@NotBlank String material, @Min(1) int quantity) {
}
