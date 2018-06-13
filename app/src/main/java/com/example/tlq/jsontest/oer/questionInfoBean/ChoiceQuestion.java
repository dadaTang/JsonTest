package com.example.tlq.jsontest.oer.questionInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 * 选择题结构
 */
public class ChoiceQuestion {
    private String id;	                        //问题ID
    private int type;	                        //1 单选题 2多选题
    private Hypertext question;                 //题干
    private List<QuestionOption> options;		//选项
    private String answer;	                    //试题答案，如果是多选题多个答案以英文逗号分隔
    private Hypertext analysis;		            //试题解析
    private Hypertext videoAnalysis;	        //视频讲解资源文件列表

    public void setId(String param){
        this.id = param;
    }

    public String getId(){
        return id;
    }

    public void setType(int param){
        type = param;
    }

    public int getType(){
        return type;
    }

    public void setQuestion(Hypertext param){
        question = param;
    }

    public Hypertext getQuestion(){
        return question;
    }

    public void setOptions(List<QuestionOption> param){
        options = param;
    }

    public List<QuestionOption> getOptions(){
        return options;
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
