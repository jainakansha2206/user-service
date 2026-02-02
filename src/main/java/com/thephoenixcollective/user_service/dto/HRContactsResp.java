package com.thephoenixcollective.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HRContactsResp {
    private int id;
    private String name;
    private String title;
    private String email;
    private String company;
    private String status;

}
