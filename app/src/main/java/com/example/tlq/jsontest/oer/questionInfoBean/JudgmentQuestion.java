package com.example.tlq.jsontest.oer.questionInfoBean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/8.
 * 判断题结构
 */
public class JudgmentQuestion implements Serializable {
    private String id;	                        //问题ID
    private Hypertext question;                 //题干
    private String answer;	                    //试题答案，F 错  T对
    private Hypertext analysis;		            //试题解析
    private Hypertext videoAnalysis;	        //视频讲解资源文件列表

    public void setId(String param){
        this.id = param;
    }

    public String getId(){
        return id;
    }

    public void setQuestion(Hypertext param){
        question = param;
    }

    public Hypertext getQuestion(){
        return question;
    }

    public void setAnswer(String param){
        answer = param;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnalysis(Hypertext param){
        analysis = param;
    }

    public Hypertext getAnalysis(){
        return analysis;
    }

    public void setVideoAnalysis(Hypertext param){
        videoAnalysis = param;
    }

    public Hypertext getVideoAnalysis(){
        return videoAnalysis;
    }
}
