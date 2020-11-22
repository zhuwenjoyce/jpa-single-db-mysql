package com.joyce.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = -9146378561169398513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday_date_time")
    private ZonedDateTime birthdayDateTime;

    @Column(name = "remark")
    private String remark;

    @Column(name = "create_date_time")
    private ZonedDateTime createDateTime;

}
