package com.example.tlq.jsontest.oer.questionInfoBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Hell on 2016/12/6.
 * 完形填空
 */

public class ClozeQuestion implements Serializable {
    public String id;//	String	问题ID
    public Hypertext question;//	Hypertext	题干，填空位置的占位符是(__序号__)，序号为1~30的数字，与optionMap的选项列表对应
    public Map<String,List<QuestionOption>> optionMap;//	Map<String,List<QuestionOption>>	key为1~30的字符串，代表题干中的填空处，每个填空处的选项为一个list，ABCD四个。
    public List<String> answer;//	List<String>	试题答案，每个填空答案为ABCD中一个
    public Hypertext analysis;//	Hypertext	试题解析
    public Hypertext videoAnalysis;//	Hypertext	视频讲解资源文件列表

    public ClozeQuestion() {
    }

    public ClozeQuestion(String id, Hypertext question, Map<String, List<QuestionOption>> optionMap, List<String> answer, Hypertext analysis, Hypertext videoAnalysis) {
        this.id = id;
        this.question = question;
        this.optionMap = optionMap;
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

    public Map<String, List<QuestionOption>> getOptionMap() {
        return optionMap;
    }

    public void setOptionMap(Map<String, List<QuestionOption>> optionMap) {
        this.optionMap = optionMap;
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
}
