package com.starter.springboot.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    @NotBlank(message = "Email or username must not be blank")
    private String identifiers;

    @NotBlank(message = "Password must not be blank")
    private String password;
}

