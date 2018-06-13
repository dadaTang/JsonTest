package com.example.tlq.jsontest.oer.questionInfoBean;

/**
 * Created by Administrator on 2016/7/8.
 * 问答题结构
 */
public class EssayQuestion  {
    private String id;	                        //问题ID
    private Hypertext question;                 //题干
    private Hypertext answer;	                    //试题答案
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

    public void setAnswer(Hypertext param){
        answer = param;
    }

    public Hypertext getAnswer(){
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
