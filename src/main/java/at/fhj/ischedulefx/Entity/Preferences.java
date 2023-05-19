package at.fhj.ischedulefx.Entity;
import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.DayOfWeek;

@Entity
@Table
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "preffered_room_id")
    private Room preferredRoom;
    private LocalTime preferredStartTime;
    private LocalTime preferredEndTime;
    private DayOfWeek preferredDayOfWeek;

    public Preferences(User user, Course course, Room preferredRoom, LocalTime preferredStartTime, LocalTime preferredEndTime, DayOfWeek preferredDayOfWeek) {
        this.user = user;
        this.course = course;
        this.preferredRoom = preferredRoom;
        this.preferredStartTime = preferredStartTime;
        this.preferredEndTime = preferredEndTime;
        this.preferredDayOfWeek = preferredDayOfWeek;
    }

    public Preferences() {
    }
}
