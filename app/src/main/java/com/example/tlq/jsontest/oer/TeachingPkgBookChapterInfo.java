package com.example.tlq.jsontest.oer;

import java.util.List;

/**
 * Created by zhoulei on 2018/5/14.
 */
public class TeachingPkgBookChapterInfo {
    private Integer pkgChapterId;
    private String pkgChapterName;
    private Integer pkgBookId;
    private List<QuestionInfo> questionList;

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

    public List<QuestionInfo> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionInfo> questionList) {
        this.questionList = questionList;
    }
}
