package com.example.tlq.jsontest.oer.questionInfoBean;

import java.io.Serializable;
import java.util.List;

public class ArithmeticQuestion implements Serializable {
    public String id;//	String	问题ID
    public Hypertext question;//	Hypertext	题干，填空位置的占位符是(___)
    public List<String> answer;//	List<String>	试题答案，每个填空位置占位符对应一个答案
    public Hypertext analysis;//	Hypertext	试题解析
    public Hypertext videoAnalysis;//	Hypertext	视频讲解资源文件列表
    public List<String> questionList;//	List<String>	具体小题的列表

    public ArithmeticQuestion(String id, Hypertext question, List<String> answer, Hypertext analysis, Hypertext videoAnalysis, List<String> questionList) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.analysis = analysis;
        this.videoAnalysis = videoAnalysis;
        this.questionList = questionList;
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

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
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

    public List<String> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }
}
