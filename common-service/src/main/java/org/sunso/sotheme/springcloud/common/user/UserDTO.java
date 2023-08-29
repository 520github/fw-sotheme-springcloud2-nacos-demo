package org.sunso.sotheme.springcloud.common.user;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    private Long id;
    private String name;
    private Long age;
    private String sex;
    private String education;

    private Date creationTime;

    private Date updateTime;
}
