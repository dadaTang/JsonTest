package com.example.tlq.jsontest.oer;

import java.util.Map;

/**
 * Created by zhoulei on 2018/5/14.
 */
public class GoodsInfo<T> {
    private String buyCount;
    private String collectCount;
    private String contentId;
    private T contentInfo;
    private String contentType;
    private String createrId;
    private String createrName;
    private String createrType;
    private String goodsId;
    private String intro;
    private String name;
    private String oerResourceId;
    private String previewResourceId;
    private String createTime;
    private String price;
    private Map<String, SourceFile> resources;
    private String viewCount;

    public String getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount;
    }

    public String getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(String collectCount) {
        this.collectCount = collectCount;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public T getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(T contentInfo) {
        this.contentInfo = contentInfo;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getCreaterType() {
        return createrType;
    }

    public void setCreaterType(String createrType) {
        this.createrType = createrType;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOerResourceId() {
        return oerResourceId;
    }

    public void setOerResourceId(String oerResourceId) {
        this.oerResourceId = oerResourceId;
    }

    public String getPreviewResourceId() {
        return previewResourceId;
    }

    public void setPreviewResourceId(String previewResourceId) {
        this.previewResourceId = previewResourceId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Map<String, SourceFile> getResources() {
        return resources;
    }

    public void setResources(Map<String, SourceFile> resources) {
        this.resources = resources;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }
}
