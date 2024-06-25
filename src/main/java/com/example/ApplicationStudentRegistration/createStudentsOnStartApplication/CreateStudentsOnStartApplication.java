package com.example.ApplicationStudentRegistration.createStudentsOnStartApplication;

import com.example.ApplicationStudentRegistration.Student;
import com.example.ApplicationStudentRegistration.StudentCommands;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@Component
@ConditionalOnProperty("app.create-students-on-startup")
public class CreateStudentsOnStartApplication {

    @EventListener(ApplicationStartedEvent.class)
    public void createStudents() {
        StudentCommands.students.put(1, new Student(1, "Ivan", "Ivanov", 25));
        StudentCommands.students.put(2, new Student(2, "Petr", "Petrov", 28));
    }
}
