package com.melardev.spring.rabbit_custom;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Notification.class)
public class Notification {
    private String message;

    private User sender;

    public Notification() {
    }

    public Notification(String message) {
        this.message = message;
    }

    public Notification(String message, User sender) {
        this.message = message;
        this.sender = sender;
    }

    // message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // products
    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getSender() {
        return this.sender;
    }

    @Override
    public String toString() {
        return String.format("Notification{message=%s,sender=%s}", message, sender);
    }
}
