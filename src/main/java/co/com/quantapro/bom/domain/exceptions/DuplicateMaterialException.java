package co.com.quantapro.bom.domain.exceptions;

public class DuplicateMaterialException extends RuntimeException {
    public DuplicateMaterialException(String message) {
        super(message);
    }
}
