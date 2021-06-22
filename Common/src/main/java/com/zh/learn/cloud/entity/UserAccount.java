package com.zh.learn.cloud.entity;

import java.io.Serializable;

/**
 * TODO
 *
 * @author ZhouHu
 * @since 2020-08-25 17:42
 **/

public class UserAccount implements Serializable {
    private Long id;

    /**
     * 登录的用户名
     */
    private String username;

    /**
     * 用户余额,单位为分
     */
    private Long account;

    /**
     * 版本号
     */
    private Long version;

    /**
     * 是否禁用
     */
    private Long obsolete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getObsolete() {
        return obsolete;
    }

    public void setObsolete(Long obsolete) {
        this.obsolete = obsolete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", account=").append(account);
        sb.append(", version=").append(version);
        sb.append(", obsolete=").append(obsolete);
        sb.append("]");
        return sb.toString();
    }
}