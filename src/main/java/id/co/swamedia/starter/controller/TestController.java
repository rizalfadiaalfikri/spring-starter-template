package id.co.swamedia.starter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.swamedia.starter.dto.ApiResponseDto;
import id.co.swamedia.starter.dto.CreateAccountRequestDto;
import id.co.swamedia.starter.exception.AccessDeniedException;
import id.co.swamedia.starter.exception.AuthenticationException;
import id.co.swamedia.starter.exception.BadRequestException;
import id.co.swamedia.starter.exception.DuplicateKeyException;
import id.co.swamedia.starter.exception.RowNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {
    
    @GetMapping("/duplicate")
    public ResponseEntity<ApiResponseDto> duplicateKey() {
        throw new DuplicateKeyException("duplicate");
    }

    @GetMapping("/rowNotFound")
    public ResponseEntity<ApiResponseDto> rowNotFound() {
        throw new RowNotFoundException("rowNotFound");
    }

    @GetMapping("/badRequest")
    public ResponseEntity<ApiResponseDto> badRequest() {
        throw new BadRequestException("badRequest");
    }

    @GetMapping("/internalServerError")
    public ResponseEntity<ApiResponseDto> internalServerError() {
        throw new RuntimeException("internalServerError");
    }

    @GetMapping("/authenticationError")
    public ResponseEntity<ApiResponseDto> authenticationError() {
        throw new AuthenticationException("authenticationError");
    }

    @GetMapping("/accessDenied")
    public ResponseEntity<ApiResponseDto> accessDenied() {
        throw new AccessDeniedException("accessDenied");
    }

    @PostMapping("/createAccount")
    public ResponseEntity<ApiResponseDto> createAccount(@Valid @RequestBody CreateAccountRequestDto createAccountRequestDto) {
        return ResponseEntity.ok(ApiResponseDto.builder().status(200).success(true).message("Account created successfully.").build());
    }

}
