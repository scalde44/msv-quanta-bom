package co.com.quantapro.bom.infrastructure.adapters.in.web.handler;

import co.com.quantapro.bom.domain.ports.in.AddMaterialUseCase;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request.AddMaterialRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddMaterialHandler {

    private final AddMaterialUseCase useCase;

    public void handle(Long productId, AddMaterialRequest request) {
        useCase.add(productId, request.material(), request.quantity());
    }
}