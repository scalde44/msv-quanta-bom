package co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(@NotBlank String name) {
}
