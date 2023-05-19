package at.fhj.ischedulefx.Entity;

import jakarta.persistence.*;
@Entity
@Table
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Enrollment(User student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Enrollment() {
    }
}
