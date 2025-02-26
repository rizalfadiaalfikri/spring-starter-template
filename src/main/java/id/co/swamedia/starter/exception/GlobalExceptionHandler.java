package id.co.swamedia.starter.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import id.co.swamedia.starter.constant.ResponseMessage;
import id.co.swamedia.starter.dto.response.ErrorResponseDto;

/**
 * Global exception handler for handling various exceptions across the application.
 * <p>
 * This class uses {@link ControllerAdvice} to centralize exception handling and return
 * appropriate HTTP responses based on the type of exception.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link DuplicateKeyException} when a duplicate key is encountered in the database.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 409 Conflict status and error details
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.CONFLICT.value())
                        .success(false)
                        .message(ResponseMessage.ERR_DUPLICATE_KEY_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

    /**
     * Handles {@link RowNotFoundException} when a requested database row is not found.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 404 Not Found status and error details
     */
    @ExceptionHandler(RowNotFoundException.class)
    public ResponseEntity<Object> handleRowNotFoundException(RowNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.NOT_FOUND.value())
                        .success(false)
                        .message(ResponseMessage.ERR_ROW_NOT_FOUND_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

    /**
     * Handles {@link BadRequestException} when a bad request is encountered.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 400 Bad Request status and error details
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .success(false)
                        .message(ResponseMessage.ERR_BAD_REQUEST_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

    /**
     * Handles {@link AuthenticationException} when authentication fails.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 401 Unauthorized status and error details
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .success(false)
                        .message(ResponseMessage.ERR_AUTHENTICATION_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

    /**
     * Handles {@link AccessDeniedException} when access is denied.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 403 Forbidden status and error details
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.FORBIDDEN.value())
                        .success(false)
                        .message(ResponseMessage.ERR_ACCESS_DENIED_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

    /**
     * Handles {@link MethodArgumentNotValidException} when validation errors occur.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 400 Bad Request status and detailed validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> {
                    if (fieldError.getDefaultMessage() != null) {
                        return fieldError.getDefaultMessage();
                    }
                    return fieldError.getField() + ": is invalid";
                })
                .sorted().toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.BAD_REQUEST.value())
                        .success(false)
                        .message(ResponseMessage.ERR_METHOD_ARGUMENT_NOT_VALID_EXCEPTION)
                        .errors(errors)
                        .build());
    }

    /**
     * Handles generic {@link Exception} when an unexpected error occurs.
     *
     * @param ex the exception thrown
     * @return a {@link ResponseEntity} with HTTP 500 Internal Server Error status and error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleInternalServerErrorException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponseDto.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .success(false)
                        .message(ResponseMessage.ERR_INTERNAL_SERVER_EXCEPTION)
                        .errors(ex.getMessage())
                        .build());
    }

}
