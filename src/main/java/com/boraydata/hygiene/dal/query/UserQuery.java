package com.boraydata.hygiene.dal.query;

import lombok.Data;

@Data
public class UserQuery {

    private Long id;

    private Integer rId;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private Integer status;

    private String token;

}
