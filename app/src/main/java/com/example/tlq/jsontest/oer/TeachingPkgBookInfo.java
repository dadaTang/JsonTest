package com.example.tlq.jsontest.oer;

import java.util.List;

/**
 * Created by zhoulei on 2018/5/14.
 */
public class TeachingPkgBookInfo {
    private Integer pkgBookId;
    private String name;
    private String intro;
    private String author;
    private Integer subjectId;
    private String subject;
    private Integer gradeId;
    private String grade;
    private Integer publishingId;
    private String publishing;
    private List<TeachingPkgBookChapterInfo> chapterList;

    public Integer getPkgBookId() {
        return pkgBookId;
    }

    public void setPkgBookId(Integer pkgBookId) {
        this.pkgBookId = pkgBookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getPublishingId() {
        return publishingId;
    }

    public void setPublishingId(Integer publishingId) {
        this.publishingId = publishingId;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public List<TeachingPkgBookChapterInfo> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<TeachingPkgBookChapterInfo> chapterList) {
        this.chapterList = chapterList;
    }
}
