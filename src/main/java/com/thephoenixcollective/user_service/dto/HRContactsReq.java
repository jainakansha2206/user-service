package com.thephoenixcollective.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class HRContactsReq {

    @NotBlank(message = "name should not be blank")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    private String title;
    @NotBlank(message = "Company name is required")
    private String company;
    private String status;
}
