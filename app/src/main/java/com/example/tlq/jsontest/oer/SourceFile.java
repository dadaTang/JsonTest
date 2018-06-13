package com.example.tlq.jsontest.oer;

/**
 * 离线资源包中的资源描述节点
 * 
 * @author jaxer
 * @version [版本号, 2016年6月5日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SourceFile
{
    private String resourceID;
    
    private int resourceType;
    
    private String resourceName;
    
    private String metaID;
    
    private String postfix;
    
    private int size;
    
    private String md5sum;
    
    private String mimetype;

    private Integer goodsId;

    
    /**
     * 该资源在离线包内的路径，相对于根目录的路径
     */
    private String localPath;

    public String getResourceID()
    {
        return resourceID;
    }
    
    public void setResourceID(String resourceID)
    {
        this.resourceID = resourceID;
    }
    
    public int getResourceType()
    {
        return resourceType;
    }
    
    public void setResourceType(int resourceType)
    {
        this.resourceType = resourceType;
    }
    
    public String getResourceName()
    {
        return resourceName;
    }
    
    public void setResourceName(String resourceName)
    {
        this.resourceName = resourceName;
    }
    
    public String getMetaID()
    {
        return metaID;
    }
    
    public void setMetaID(String metaID)
    {
        this.metaID = metaID;
    }
    
    public String getPostfix()
    {
        return postfix;
    }
    
    public void setPostfix(String postfix)
    {
        this.postfix = postfix;
    }
    
    public int getSize()
    {
        return size;
    }
    
    public void setSize(int size)
    {
        this.size = size;
    }
    
    public String getMd5sum()
    {
        return md5sum;
    }
    
    public void setMd5sum(String md5sum)
    {
        this.md5sum = md5sum;
    }
    
    public String getMimetype()
    {
        return mimetype;
    }
    
    public void setMimetype(String mimetype)
    {
        this.mimetype = mimetype;
    }
    
    public String getLocalPath()
    {
        return localPath;
    }
    
    public void setLocalPath(String localPath)
    {
        this.localPath = localPath;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SourceFile [resourceID=");
        builder.append(resourceID);
        builder.append(", resourceType=");
        builder.append(resourceType);
        builder.append(", resourceName=");
        builder.append(resourceName);
        builder.append(", metaID=");
        builder.append(metaID);
        builder.append(", postfix=");
        builder.append(postfix);
        builder.append(", size=");
        builder.append(size);
        builder.append(", md5sum=");
        builder.append(md5sum);
        builder.append(", mimetype=");
        builder.append(mimetype);
        builder.append(", localPath=");
        builder.append(localPath);
        builder.append("]");
        return builder.toString();
    }

}
