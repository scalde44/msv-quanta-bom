package co.com.quantapro.bom.infrastructure.adapters.in.web.dto.response;

import java.util.Map;

public record ErrorResponse(int status, String message, Map<String, String> fieldErrors) {
}
