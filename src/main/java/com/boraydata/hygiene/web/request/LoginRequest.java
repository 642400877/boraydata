package com.boraydata.hygiene.web.request;

import lombok.Data;

@Data
public class LoginRequest {

    private Long id;

    private Long rId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String token;

}
