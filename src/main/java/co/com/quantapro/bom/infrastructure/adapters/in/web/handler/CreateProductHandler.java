package co.com.quantapro.bom.infrastructure.adapters.in.web.handler;

import co.com.quantapro.bom.domain.ports.in.CreateProductUseCase;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request.CreateProductRequest;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response.CreateProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateProductHandler {

    private final CreateProductUseCase useCase;

    public CreateProductResponse handle(CreateProductRequest request) {
        return new CreateProductResponse(useCase.create(request.name()));
    }
}