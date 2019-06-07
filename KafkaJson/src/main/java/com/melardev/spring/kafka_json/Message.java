package com.melardev.spring.kafka_json;

public class Message {
    private String source;
    private String message;

    public Message() {
    }

    public Message(String source, String message) {
        this.source = source;
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
