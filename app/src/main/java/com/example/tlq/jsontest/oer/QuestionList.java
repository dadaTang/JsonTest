package com.example.tlq.jsontest.oer;

public class QuestionList<T> {

    private Integer questionId;
    private T questionInfo;
    private String questionTitle;
    private Integer questionType;
    private Integer subjectId;
    private String subjectName;


    public T getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(T questionInfo) {
        this.questionInfo = questionInfo;
    }

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

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
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
}
