/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.client.common.vmmanage;

import java.io.Serializable;

/**
 * 类QueryVmCondition.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年11月30日 下午7:38:09
 */
public class QueryVmCondition implements Serializable {

    private static final long serialVersionUID = 3647882884780360660L;

    /**
     * 虚拟机名称
     */
    private String            vmName;

    /**
     * 虚拟机uuid
     */
    private String            vmUuid;

    /**
     * 虚拟机cpu数量
     */
    private Integer           vmVcpu;

    /**
     * 虚拟机内存
     */
    private Long              vmMemory;

    /**
     * 虚拟机对应的镜像
     */
    private String            imageUuid;

    /**
     * 虚拟机状态
     */
    private VmStatusEnum      vmStatus;

    /**
     * 虚拟机所在的主机
     */
    private Integer           hostId;

    /**
     * 用户账号
     */
    private String            userAccount;

    /**
     * 课程id
     */
    private Integer           classId;

    /**
     * 父虚拟机uuid
     */
    private String            parentVmUuid;

    /**
     * 是否为模板虚拟机
     */
    private Boolean           isTemplateVm;

    /**
     * 是否是共有的模板虚拟机
     */
    private Boolean           isPublicTemplate;

    private int               offset           = 0;

    private int               limit            = 10;

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getVmUuid() {
        return vmUuid;
    }

    public void setVmUuid(String vmUuid) {
        this.vmUuid = vmUuid;
    }

    public Integer getVmVcpu() {
        return vmVcpu;
    }

    public void setVmVcpu(Integer vmVcpu) {
        this.vmVcpu = vmVcpu;
    }

    public Long getVmMemory() {
        return vmMemory;
    }

    public void setVmMemory(Long vmMemory) {
        this.vmMemory = vmMemory;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public VmStatusEnum getVmStatus() {
        return vmStatus;
    }

    public void setVmStatus(VmStatusEnum vmStatus) {
        this.vmStatus = vmStatus;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getParentVmUuid() {
        return parentVmUuid;
    }

    public void setParentVmUuid(String parentVmUuid) {
        this.parentVmUuid = parentVmUuid;
    }

    public Boolean getIsTemplateVm() {
        return isTemplateVm;
    }

    public void setIsTemplateVm(Boolean isTemplateVm) {
        this.isTemplateVm = isTemplateVm;
    }

    public Boolean getIsPublicTemplate() {
        return isPublicTemplate;
    }

    public void setIsPublicTemplate(Boolean isPublicTemplate) {
        this.isPublicTemplate = isPublicTemplate;
    }

}
