package com.example.ApplicationStudentRegistration.event;

import com.example.ApplicationStudentRegistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EventAddStudent extends ApplicationEvent {

    private final Student student;

    public EventAddStudent(Object source, Student student) {
        super(source);
        this.student = student;
    }
}
