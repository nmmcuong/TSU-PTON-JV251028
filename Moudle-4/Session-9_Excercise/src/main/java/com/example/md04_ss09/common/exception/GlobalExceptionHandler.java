package com.example.md04_ss09.common.exception;

import com.example.md04_ss09.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // bắt lỗi của các trường trong DTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handlerValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>(); // cấu hình tên trường bị lỗi và thông báo lỗi

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField(); // trường dính lỗi của DTO
            String errorMessage = error.getDefaultMessage(); // xuất thông báo lỗi của DTO
            errors.put(fieldName, errorMessage);
        });

        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(errors);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class )
    public ResponseEntity<ApiResponse<Map<String,String>>> handleResourceNotFoundException(ResourceNotFoundException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage()); // cấu hình ghi chú và thông báo lỗi

        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(DuplicateException.class )
    public ResponseEntity<ApiResponse<Map<String,String>>> handleDuplicateException(DuplicateException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());

        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu trùng lặp");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleIllegalArgument(IllegalArgumentException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());

        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleMaxUploadSizeExceeded(MaxUploadSizeExceededException exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", "Kích thước ảnh quá lớn, chỉ nhận ảnh < 2MB");

        ApiResponse<Map<String,String>> apiResponse = new ApiResponse<>();
        apiResponse.setData(map);
        apiResponse.setStatus("FAIL");
        apiResponse.setMessage("Dữ liệu không hợp lệ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
