package com.example.tlq.jsontest.oer;

import java.util.List;

/**
 * Created by tlq on 2018/6/12.
 */
public class ChapterList {
    private Integer pkgChapterId;
    private String pkgChapterName;
    private Integer pkgBookId;
    private List<QuestionList> questionList;

    public List<QuestionList> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionList> questionList) {
        this.questionList = questionList;
    }

    public Integer getPkgChapterId() {
        return pkgChapterId;
    }

    public void setPkgChapterId(Integer pkgChapterId) {
        this.pkgChapterId = pkgChapterId;
    }

    public String getPkgChapterName() {
        return pkgChapterName;
    }

    public void setPkgChapterName(String pkgChapterName) {
        this.pkgChapterName = pkgChapterName;
    }

    public Integer getPkgBookId() {
        return pkgBookId;
    }

    public void setPkgBookId(Integer pkgBookId) {
        this.pkgBookId = pkgBookId;
    }


}
