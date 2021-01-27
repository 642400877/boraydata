package com.boraydata.hygiene.dal.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Long id;

    private Long rId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String token;

}
