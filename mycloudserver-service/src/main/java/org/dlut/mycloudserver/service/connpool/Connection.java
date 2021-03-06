/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.service.connpool;

import java.util.List;

import org.libvirt.Domain;
import org.libvirt.LibvirtException;
import org.libvirt.StoragePool;

/**
 * libvirt连接的接口
 * 
 * @author luojie 2014年11月26日 下午3:06:49
 */
public interface Connection {

    /**
     * 获取物理机的主机名称
     * 
     * @return
     * @throws LibvirtException
     */
    public String getHostName() throws LibvirtException;

    /**
     * 根据名称获取对应的存储池
     * 
     * @param storagePoolName
     * @return
     */
    public StoragePool getStoragePoolByName(String storagePoolName) throws LibvirtException;

    /**
     * 列出在线的虚拟机列表的名称
     * 
     * @return 虚拟机的uuid列表
     * @throws LibvirtException
     */
    public List<String> listActiveVmName() throws LibvirtException;

    /**
     * 从xmlDesc中启动虚拟机
     * 
     * @param xmlDesc
     * @return
     */
    public Domain startVm(String xmlDesc) throws LibvirtException;

    /**
     * 强制关机
     * 
     * @param vmUuid
     * @return
     * @throws LibvirtException
     */
    public boolean destroyVm(String vmUuid) throws LibvirtException;

    /**
     * 根据名称获取虚拟机
     * 
     * @param vmName
     * @return
     * @throws LibvirtException
     */
    public Domain getDomainByName(String vmName) throws LibvirtException;

    /**
     * 关闭连接
     * 
     * @return
     */
    public int close() throws LibvirtException;

}
