package co.com.quantapro.bom.application.usecase;

import co.com.quantapro.bom.domain.model.Product;
import co.com.quantapro.bom.domain.ports.in.CreateProductUseCase;
import co.com.quantapro.bom.domain.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort repository;

    @Override
    public Long create(String name) {
        return repository.save(new Product(name)).getId();
    }
}