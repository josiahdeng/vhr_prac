package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (PoliticsStatus)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:34
 */
public class PoliticsStatus implements Serializable {
    private static final long serialVersionUID = -49884114348532817L;

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