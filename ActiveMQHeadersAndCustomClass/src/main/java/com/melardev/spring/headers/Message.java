package com.melardev.spring.headers;

import java.io.Serializable;

/* Messages destination be sent must be Serializable */
public class Message implements Serializable {
    private String source;
    private String destination;
    private String text;

    public Message() {
    }

    public Message(String source, String destination, String text) {
        this.source = source;
        this.destination = destination;
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Message{source=%s; destination=%s; text=%s}", source, destination, text);
    }
}
