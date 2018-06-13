package com.example.tlq.jsontest.oer.questionInfoBean;

import java.io.Serializable;

/**
 * Created by Hell on 2016/12/22.
 * 作图题
 */

public class DrawingQuestion implements Serializable {
    public String id;//	String	问题ID
    public Hypertext question;//	Hypertext	题干，可能包含图片
    public Hypertext drawingImages;//	Hypertext	作为答题底图的图片字串，只包含图片
    public Hypertext answer;//	Hypertext	文字或图片，可能为空
    public Hypertext analysis;//	Hypertext	试题解析
    public Hypertext videoAnalysis;//	Hypertext	视频讲解资源文件列表

    public DrawingQuestion() {
    }

    public DrawingQuestion(String id, Hypertext question, Hypertext drawingImages, Hypertext answer, Hypertext analysis, Hypertext videoAnalysis) {
        this.id = id;
        this.question = question;
        this.drawingImages = drawingImages;
        this.answer = answer;
        this.analysis = analysis;
        this.videoAnalysis = videoAnalysis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hypertext getQuestion() {
        return question;
    }

    public void setQuestion(Hypertext question) {
        this.question = question;
    }

    public Hypertext getDrawingImages() {
        return drawingImages;
    }

    public void setDrawingImages(Hypertext drawingImages) {
        this.drawingImages = drawingImages;
    }

    public Hypertext getAnswer() {
        return answer;
    }

    public void setAnswer(Hypertext answer) {
        this.answer = answer;
    }

    public Hypertext getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Hypertext analysis) {
        this.analysis = analysis;
    }

    public Hypertext getVideoAnalysis() {
        return videoAnalysis;
    }

    public void setVideoAnalysis(Hypertext videoAnalysis) {
        this.videoAnalysis = videoAnalysis;
    }
}
