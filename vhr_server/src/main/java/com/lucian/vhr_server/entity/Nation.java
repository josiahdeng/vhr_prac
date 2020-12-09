package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:33
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = -39240794384631558L;

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}