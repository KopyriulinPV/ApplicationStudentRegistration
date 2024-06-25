package com.example.ApplicationStudentRegistration.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    @org.springframework.context.event.EventListener
    public void listenEventAddStudent(EventAddStudent eventAddStudent) {
        System.out.println("Add student: " + eventAddStudent.getStudent());
    }

    @org.springframework.context.event.EventListener
    public void listenEventAddStudent(EventDeleteStudent eventDeleteStudent) {
        System.out.println("Delete student: " + eventDeleteStudent.getStudent());
    }
}
