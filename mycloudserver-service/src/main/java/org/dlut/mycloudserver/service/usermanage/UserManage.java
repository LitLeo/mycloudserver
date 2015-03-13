/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.service.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.dlut.mycloudserver.client.common.usermanage.QueryUserCondition;
import org.dlut.mycloudserver.dal.dataobject.UserDO;
import org.dlut.mycloudserver.dal.mapper.UserManageMapper;
import org.springframework.stereotype.Service;

/**
 * 类UserManageDAO.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年10月7日 下午11:43:45
 */

@Service("userManage")
public class UserManage {

    @Resource
    private UserManageMapper userManageMapper;

    public UserDO getUserByAccount(String account) {
        if (StringUtils.isBlank(account)) {
            return null;
        }

        return userManageMapper.getUserByAccount(account);
    }

    public int countQuery(QueryUserCondition queryUserCondition) {
        if (queryUserCondition == null) {
            return 0;
        }
        return userManageMapper.countQuery(queryUserCondition);
    }

    public List<UserDO> query(QueryUserCondition queryUserCondition) {
        if (queryUserCondition == null) {
            return new ArrayList<UserDO>();
        }
        return userManageMapper.query(queryUserCondition);
    }

    public boolean createUser(UserDO userDO) {
        if (userDO == null) {
            return false;
        }
        int res = userManageMapper.createUser(userDO);
        if (res == 1) {
            return true;
        }
        return false;
    }

    public boolean deleteUserByAccount(String account) {
        if (account == null) {
            return false;
        }
        return this.userManageMapper.deleteUserByAccount(account) == 1;
    }
}
