package com.juhao666.spring.jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedBy
    @Column(updatable = false)
    String creator;

    @LastModifiedBy
    @Column(updatable = true)
    String modifier;

    @CreatedDate
    @Column(updatable = false)
    LocalDate createTime;

    @LastModifiedDate
    @Column(updatable = true)
    LocalDate updateTime;

}
