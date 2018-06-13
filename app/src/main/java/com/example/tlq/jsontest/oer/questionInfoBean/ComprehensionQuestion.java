package com.example.tlq.jsontest.oer.questionInfoBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Hello on 2017/6/5.
 * 阅读理解结构
 */

public class ComprehensionQuestion implements Serializable {
    public String id;//	String	问题ID
    public Hypertext question;//	Hypertext	题干，可能包含图片
    public List<String> answer;//	List<String>	ABCD等答案
    public List<ChoiceQuestion> subQuestions;// 	List< ChoiceQuestion >	包含的选择题，只有题干和选项，其他为空
    public Hypertext analysis;//	Hypertext	试题解析
    public Hypertext videoAnalysis; //	Hypertext	视频讲解资源文件列表

    public ComprehensionQuestion(String id, Hypertext question, List<String> answer, List<ChoiceQuestion> subQuestions, Hypertext analysis, Hypertext videoAnalysis) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.subQuestions = subQuestions;
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

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public List<ChoiceQuestion> getSubQuestions() {
        return subQuestions;
    }

    public void setSubQuestions(List<ChoiceQuestion> subQuestions) {
        this.subQuestions = subQuestions;
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
