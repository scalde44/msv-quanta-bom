package co.com.quantapro.bom.infrastructure.adapters.in.web.controller;

import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request.AddMaterialRequest;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.request.CreateProductRequest;
import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response.CreateProductResponse;
import co.com.quantapro.bom.infrastructure.adapters.in.web.handler.AddMaterialHandler;
import co.com.quantapro.bom.infrastructure.adapters.in.web.handler.CreateProductHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductHandler createHandler;
    private final AddMaterialHandler addMaterialHandler;

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@RequestBody @Valid CreateProductRequest request) {
        return ResponseEntity.ok(createHandler.handle(request));
    }

    @PostMapping("/{id}/materials")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMaterial(
            @PathVariable Long id,
            @RequestBody @Valid AddMaterialRequest request) {

        addMaterialHandler.handle(id, request);
    }
}