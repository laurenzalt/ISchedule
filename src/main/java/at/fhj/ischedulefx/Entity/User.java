package at.fhj.ischedulefx.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
    // private List<Enrollment> enrollmentsList;
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    // private List<Preferences> preferencesList;

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(Long teacher_id) {
        this.id = teacher_id;
    }

    public User(Long teacher_id, String role) {
        this.id = teacher_id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<Enrollment> getEnrollmentsList() {
//        return enrollmentsList;
//    }
//
//    public void setEnrollmentsList(List<Enrollment> enrollmentsList) {
//        this.enrollmentsList = enrollmentsList;
//    }
//
//    public List<Preferences> getPreferencesList() {
//        return preferencesList;
//    }
//
//    public void setPreferencesList(List<Preferences> preferencesList) {
//        this.preferencesList = preferencesList;
//    }
}
