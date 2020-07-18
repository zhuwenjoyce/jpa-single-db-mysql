package com.joyce.jpa.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel {

    @Column(name = "create_user", columnDefinition=" bigint(20) unsigned NOT NULL ")
    protected Long createUser;
    @Column(name = "create_time", columnDefinition=" datetime NOT NULL ")
    protected LocalDateTime createTime;

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
