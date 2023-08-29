package org.sunso.sotheme.springcloud.common.data;

import lombok.Data;

import java.util.Date;

@Data
public class DataDTO {
    private String serviceId;
    private String serviceName;
    private Date createDate;

}
