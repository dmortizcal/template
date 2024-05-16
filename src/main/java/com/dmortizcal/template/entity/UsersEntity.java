package com.dmortizcal.template.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mario
 */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "use_id")
    private Long useId;
    @Column(name = "use_email")
    private String useEmail;
    @Column(name = "use_name")
    private String useName;
}