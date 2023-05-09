package com.ISchedule.Ischedule;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private UserRole role;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(unique = true)
    private String email;

}
