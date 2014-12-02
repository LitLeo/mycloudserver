/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.service.connpool;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.dlut.mycloudserver.service.BaseTestCase;
import org.junit.Test;
import org.libvirt.Connect;
import org.libvirt.LibvirtException;
import org.libvirt.jna.ConnectionPointer;
import org.libvirt.jna.DomainPointer;
import org.libvirt.jna.Libvirt.VirConnectDomainEventGenericCallback;

import com.sun.jna.Pointer;

/**
 * 类SimpleMutilHostConnPoolTest.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年11月26日 下午9:04:54
 */
public class SimpleMutilHostConnPoolTest extends BaseTestCase {

    @Resource(name = "mutilHostConnPool")
    private IMutilHostConnPool mutiHostConnPool;

    /**
     * Test method for
     * {@link org.dlut.mycloudserver.service.connpool.simpleconnpool.SimpleMutilHostConnPool#getLocalConn()}
     * .
     * 
     * @throws LibvirtException
     */
    @Test
    public void testGetLocalConn() throws LibvirtException {

        for (int i = 1; i <= 13; i++) {
            Connection conn = mutiHostConnPool.getLocalConn();
            if (conn == null) {
                System.out.println(i + ": 获取连接失败");
                continue;
            }
            conn.close();
        }
    }

    /**
     * Test method for
     * {@link org.dlut.mycloudserver.service.connpool.simpleconnpool.SimpleMutilHostConnPool#getConnByHostId(int)}
     * .
     */
    @Test
    public void testGetConnByHostId() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link org.dlut.mycloudserver.service.connpool.simpleconnpool.SimpleMutilHostConnPool#updateRemoteMutilHostConnPoolMap()}
     * .
     */
    @Test
    public void testUpdateRemoteMutilHostConnPoolMap() {
        fail("Not yet implemented");
    }

    @Test
    public void test() throws LibvirtException, InterruptedException {
        Connect conn = new Connect("qemu:///system");
        printObject(conn.getHostName());
        VirConnectDomainEventGenericCallback callBack = new VirConnectDomainEventGenericCallback() {

            @Override
            public void eventCallback(ConnectionPointer arg0, DomainPointer arg1, Pointer arg2) {
                System.out.println("haha");
            }
        };
        conn.domainEventRegisterAny(null, 0, callBack);
        Thread.sleep(50000);
    }
}