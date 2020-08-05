package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Device {

    private int id;
    private String device_name;
    private String communication_type;
    private String device_id;
    private String version;
    private String status;
    private Date create_time;
}
