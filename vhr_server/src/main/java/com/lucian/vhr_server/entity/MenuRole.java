package com.lucian.vhr_server.entity;

import java.io.Serializable;

/**
 * (MenuRole)实体类
 *
 * @author makejava
 * @since 2020-11-21 20:11:30
 */
public class MenuRole implements Serializable {
    private static final long serialVersionUID = 108478296224083855L;

    private Integer id;

    private Integer mid;

    private Integer rid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}