package com.example.tlq.jsontest.oer;

public class BaseQuestion {
    private String id;
    private String question;
    private String analysis;
    private String videoAnalysis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getVideoAnalysis() {
        return videoAnalysis;
    }

    public void setVideoAnalysis(String videoAnalysis) {
        this.videoAnalysis = videoAnalysis;
    }

    @Override
    public String toString() {
        return "BaseQuestion{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", analysis='" + analysis + '\'' +
                ", videoAnalysis='" + videoAnalysis + '\'' +
                '}';
    }
}
