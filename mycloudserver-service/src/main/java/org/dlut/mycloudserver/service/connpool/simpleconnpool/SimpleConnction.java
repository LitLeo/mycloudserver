/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.service.connpool.simpleconnpool;

import java.util.ArrayList;
import java.util.List;

import org.dlut.mycloudserver.service.connpool.Connection;
import org.libvirt.Connect;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;
import org.libvirt.StoragePool;

/**
 * 类SimpleConnction.java的实现描述：TODO 类实现描述 线程不安全
 * 
 * @author luojie 2014年11月26日 下午3:14:13
 */
public class SimpleConnction implements Connection {

    /**
     * libvirt连接
     */
    private Connect                  conn;

    /**
     * 此连接所在的连接池
     */
    private SimpleSingleHostConnPool simpleSingleHostConnPool;

    public SimpleConnction(Connect conn, SimpleSingleHostConnPool simpleSingleHostConnPool) {
        this.conn = conn;
        this.simpleSingleHostConnPool = simpleSingleHostConnPool;
    }

    @Override
    public StoragePool getStoragePoolByName(String storagePoolName) throws LibvirtException {
        StoragePool storagePool = conn.storagePoolLookupByName(storagePoolName);
        return storagePool;
    }

    @Override
    public int close() throws LibvirtException {
        simpleSingleHostConnPool.putConn(this);
        return 0;
    }

    public Connect getLibvirtConn() {
        return this.conn;
    }

    @Override
    public Domain startVm(String xmlDesc) throws LibvirtException {
        Domain domain = conn.domainCreateXML(xmlDesc, 0);
        return domain;
    }

    @Override
    public boolean destroyVm(String vmUuid) throws LibvirtException {
        Domain domain = conn.domainLookupByUUIDString(vmUuid);
        if (domain == null) {
            return false;
        }
        domain.destroy();
        return true;
    }

    @Override
    public String getHostName() throws LibvirtException {
        return conn.getHostName();
    }

    @Override
    public List<String> listActiveVmName() throws LibvirtException {
        List<String> activieVmList = new ArrayList<String>();
        int[] activeVmIds = conn.listDomains();
        if (activeVmIds == null) {
            return activieVmList;
        }
        for (int vmId : activeVmIds) {
            Domain domain = conn.domainLookupByID(vmId);
            activieVmList.add(domain.getName());
        }
        return activieVmList;
    }

    @Override
    public Domain getDomainByName(String vmName) throws LibvirtException {
        return conn.domainLookupByName(vmName);
    }

}
