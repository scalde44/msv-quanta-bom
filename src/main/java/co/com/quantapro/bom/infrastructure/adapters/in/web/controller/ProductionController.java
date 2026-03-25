package co.com.quantapro.bom.infrastructure.adapters.in.web.controller;

import co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response.ProductionResponse;
import co.com.quantapro.bom.infrastructure.adapters.in.web.handler.CalculateProductionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/production")
@RequiredArgsConstructor
public class ProductionController {

    private final CalculateProductionHandler handler;

    @GetMapping("/calculate")
    public ResponseEntity<ProductionResponse> calculate(
            @RequestParam Long productId,
            @RequestParam int quantity) {

        return ResponseEntity.ok(handler.handle(productId, quantity));
    }
}