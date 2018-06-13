package com.example.tlq.jsontest.oer.questionInfoBean;

/**
 * Created by Administrator on 2016/7/8.
 */
public class QuestionOption {
    private String optionID;
    private Hypertext optionContent;

    public void setOptionID(String param){
        optionID = param;
    }

    public String getOptionID(){
        return optionID;
    }

    public void setOptionContent(Hypertext param){
        optionContent = param;
    }

    public Hypertext getOptionContent(){
        return optionContent;
    }
}
