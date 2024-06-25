package com.example.ApplicationStudentRegistration;

import com.example.ApplicationStudentRegistration.event.EventAddStudent;
import com.example.ApplicationStudentRegistration.event.EventDeleteStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Map;
import java.util.TreeMap;


@ShellComponent
@RequiredArgsConstructor
public class StudentCommands {

    public static final Map<Integer, Student> students = new TreeMap<>();

    private final ApplicationEventPublisher publisher;

    @ShellMethod(key = "listStudents")
    public String listStudents() {
       return students.toString();
    }

    public int generateStudentId() {
        if (students.size() != 0) {
            return students.get(students.size()).getId() + 1;
        } else {
            return 1;
        }
    }

    @ShellMethod(key = "addStudent")
    public void addStudent(@ShellOption(value = "firstName") String firstName,
                       @ShellOption(value = "lastName") String lastName,
                       @ShellOption(value = "age") int age) {
        Student student = Student.builder()
                .id(generateStudentId())
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build();
        publisher.publishEvent(new EventAddStudent(this, student));
        students.put(student.getId(), student);
    }

    @ShellMethod(key = "deleteStudent")
    public void deleteStudent(@ShellOption(value = "id") int id) {
        publisher.publishEvent(new EventDeleteStudent(this, students.get(id)));
        students.remove(id);
    }

    @ShellMethod(key = "deleteAllStudent")
    public void deleteAllStudent() {
        students.clear();
    }
}

