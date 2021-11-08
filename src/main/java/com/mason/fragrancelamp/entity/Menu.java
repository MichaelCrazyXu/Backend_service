package com.mason.fragrancelamp.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Menu {

    private int menu_id;
    private int pid;
    private String name;
    private String path;
    private String url;
    private int sort;
    private String type;
    private int level;

}
