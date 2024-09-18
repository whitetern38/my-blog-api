package io.whitetern.myblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    @Column(name = "created_dt")
    private LocalDateTime createdDt;

    @LastModifiedDate
    @Column(name = "updated_dt")
    private LocalDateTime updatedDt;

    //    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")

//    @PrePersist
//    public void onPrePersist() {
//        this.createdDt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
//        this.updatedDt = this.createdDt;
//    }
//
//    @PreUpdate
//    public void onPreUpdate() {
//        this.updatedDt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
//    }

}
