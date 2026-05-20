package com.example.session11.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.example.session11.model.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

        // 1. Đánh chặn lỗi sai thông tin đăng nhập từ Spring Security (Trả về đúng mã
        // 401)
        @ExceptionHandler(BadCredentialsException.class)
        public ResponseEntity<ErrorResponse> handleBadCredentialsException(
                        BadCredentialsException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.UNAUTHORIZED.value(),
                                "Unauthorized",
                                "Tài khoản hoặc mật khẩu không chính xác.",
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        // 2. Đánh chặn lỗi 404 Not Found
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
                        ResourceNotFoundException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.NOT_FOUND.value(),
                                "Not Found",
                                ex.getMessage(),
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        // 3. Đánh chặn lỗi 409 Conflict (Trùng lặp)
        @ExceptionHandler(DuplicateResourceException.class)
        public ResponseEntity<ErrorResponse> handleDuplicateResourceException(
                        DuplicateResourceException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.CONFLICT.value(),
                                "Conflict",
                                ex.getMessage(),
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

        // 4. Lưới bọc an toàn cuối cùng cho các lỗi hệ thống không kiểm soát (Trả về
        // lỗi 500 sạch)
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGlobalException(
                        Exception ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "Internal Server Error",
                                "Hệ thống đang gặp sự cố. Vui lòng thử lại sau.",
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(MaxUploadSizeExceededException.class)
        public ResponseEntity<ErrorResponse> handleMaxSizeException(
                        MaxUploadSizeExceededException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                "Bad Request",
                                "Kích thước file quá lớn. Vui lòng chọn file dưới 5MB.",
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
                        IllegalArgumentException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                "Bad Request",
                                ex.getMessage(), // Lấy đúng câu "Chỉ chấp nhận file ảnh định dạng JPG/PNG"
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, Object>> handleValidationExceptions(
                        MethodArgumentNotValidException ex, HttpServletRequest request) {

                // Gom nhóm các lỗi chi tiết của từng field
                Map<String, String> fieldErrors = new HashMap<>();
                for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                        fieldErrors.put(error.getField(), error.getDefaultMessage());
                }

                Map<String, Object> errorResponse = new LinkedHashMap<>();
                errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
                errorResponse.put("error", "Bad Request");
                errorResponse.put("message", "Dữ liệu đầu vào không hợp lệ.");
                errorResponse.put("details", fieldErrors); // Danh sách lỗi chi tiết cho Frontend
                errorResponse.put("path", request.getRequestURI());
                errorResponse.put("timestamp", LocalDateTime.now().toString());

                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(DisabledException.class)
        public ResponseEntity<ErrorResponse> handleDisabledException(
                        DisabledException ex, HttpServletRequest request) {

                ErrorResponse error = new ErrorResponse(
                                HttpStatus.FORBIDDEN.value(), // Thường dùng 403 cho tài khoản bị khóa
                                "Forbidden",
                                "Tài khoản chưa được kích hoạt. Vui lòng kiểm tra email và nhập mã OTP.",
                                request.getRequestURI(),
                                LocalDateTime.now());
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }
}
