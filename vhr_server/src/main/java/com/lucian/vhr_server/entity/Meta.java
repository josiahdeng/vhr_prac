package com.lucian.vhr_server.entity;

import java.io.Serializable;

public class Meta implements Serializable {

    private static final long serialVersionUID = -8162994416895656189L;

    private String name;

    private Boolean keepAlive;

    private Boolean requireAuth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
