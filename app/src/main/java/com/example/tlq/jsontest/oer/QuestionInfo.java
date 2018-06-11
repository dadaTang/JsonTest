package com.example.tlq.jsontest.oer;



/**
 * Created by zhoulei on 2018/5/14.
 */
public class QuestionInfo {
    private Integer questionId;

    private String questionTitle;

    private Integer subjectId;

    private String subjectName;

    private Integer questionType;

    private BaseQuestion questionInfo;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public BaseQuestion getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(BaseQuestion questionInfo) {
        this.questionInfo = questionInfo;
    }
}
