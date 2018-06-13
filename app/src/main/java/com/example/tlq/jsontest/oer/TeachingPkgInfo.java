package com.example.tlq.jsontest.oer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoulei on 2018/5/14.
 */
public class TeachingPkgInfo {
    private Integer pkgId;
    private String name;
    private Integer subjectId;
    private String subject;
    private Integer gradeId;
    private String grade;
    private Integer schoolbookId;
    private String schoolbookName;
    private Integer volumeId;
    private String volumeName;
    private Integer unitId;
    private String unitName;
    private Integer chapterId;
    private String chapterName;
    private Integer sectionId;
    private String sectionName;
    private Integer publishingId;
    private String publishing;
    private Integer adviseDuration;
    private Integer difficulty;
    private List<QuestionList> questionList;

    public Integer getPkgId() {
        return pkgId;
    }

    public void setPkgId(Integer pkgId) {
        this.pkgId = pkgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSchoolbookId() {
        return schoolbookId;
    }

    public void setSchoolbookId(Integer schoolbookId) {
        this.schoolbookId = schoolbookId;
    }

    public String getSchoolbookName() {
        return schoolbookName;
    }

    public void setSchoolbookName(String schoolbookName) {
        this.schoolbookName = schoolbookName;
    }

    public Integer getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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

    public Integer getAdviseDuration() {
        return adviseDuration;
    }

    public void setAdviseDuration(Integer adviseDuration) {
        this.adviseDuration = adviseDuration;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public List<QuestionList> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionList> questionList) {
        this.questionList = questionList;
    }
}
