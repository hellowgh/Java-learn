package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    /**
     * fetch = FetchType.EAGER: 这表示在查询 User 实体时，同时也会加载关联的 Role 实体. EAGER 表示急加载，即立即加载关联的对象
     * cascade = CascadeType.ALL: 这表示级联操作，即在对 User 实体进行操作时，同样会对与之关联的 Role 实体进行相同的操作。
     * <p>
     * joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")}: 表示在 "users_roles" 表中，与 User 表相关的外键是 "USER_ID"，它引用了 User 表的 "ID" 列。
     * <p>
     * joinColumns 是指中间表（users_roles）与当前实体（User）相关的外键。
     * inverseJoinColumns 指中间表与关联实体（Role）相关的外键。
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles = new ArrayList<>();
}
