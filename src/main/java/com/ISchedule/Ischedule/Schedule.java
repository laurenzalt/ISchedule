package com.ISchedule.Ischedule;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    @Column(name = course)
    private Course course;
    @ManyToOne
    @JoinColumn(name = "room_id")
    @Column(name = room)
    private Room room;
    @Column(name = startTime)
    private Time startTime;
    @Column(name = endTime)
    private Time endTime;
    @Column(name = date)
    private Date date;
}