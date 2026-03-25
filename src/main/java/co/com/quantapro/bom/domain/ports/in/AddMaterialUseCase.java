package co.com.quantapro.bom.domain.ports.in;

public interface AddMaterialUseCase {
    void add(Long productId, String material, int quantity);
}