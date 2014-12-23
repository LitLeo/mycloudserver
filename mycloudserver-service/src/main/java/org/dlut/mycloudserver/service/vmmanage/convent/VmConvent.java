/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.mycloudserver.service.vmmanage.convent;

import java.util.ArrayList;
import java.util.List;

import org.dlut.mycloudserver.client.common.storemanage.StoreFormat;
import org.dlut.mycloudserver.client.common.vmmanage.ShowTypeEnum;
import org.dlut.mycloudserver.client.common.vmmanage.VmDTO;
import org.dlut.mycloudserver.client.common.vmmanage.VmStatusEnum;
import org.dlut.mycloudserver.dal.dataobject.VmDO;
import org.mycloudserver.common.constants.StoreConstants;

/**
 * 类VmConvent.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年12月1日 下午1:14:55
 */
public class VmConvent {

    public static VmDTO conventToVmDTO(VmDO vmDO) {
        if (vmDO == null) {
            return null;
        }

        VmDTO vmDTO = new VmDTO();
        vmDTO.setDesc(vmDO.getDesc());
        vmDTO.setHostId(vmDO.getHostId());
        vmDTO.setImageUuid(vmDO.getImageUuid());
        vmDTO.setVmMemory(vmDO.getVmMemory());
        vmDTO.setVmStatus(VmStatusEnum.getVmStatusByStatus(vmDO.getVmStatus()));
        vmDTO.setVmUuid(vmDO.getVmUuid());
        vmDTO.setVmVcpu(vmDO.getVmVcpu());
        vmDTO.setUserAccount(vmDO.getUserAccount());
        vmDTO.setClassId(vmDO.getClassId());
        vmDTO.setShowType(ShowTypeEnum.getShowTypeByValue(vmDO.getShowType()));
        vmDTO.setShowPort(vmDO.getShowPort());
        vmDTO.setShowPassword(vmDO.getShowPassword());
        vmDTO.setVmName(vmDO.getVmName());
        vmDTO.setImageTotalSize(vmDO.getImageTotalSize());
        vmDTO.setImageFormat(StoreFormat.getStoreFormatByValue(vmDO.getImageFormat()));
        vmDTO.setImagePath(StoreConstants.IMAGE_POOL_PATH + vmDO.getImageUuid());
        vmDTO.setParentVmUuid(vmDO.getParentVmUuid());
        vmDTO.setIsTemplateVm(vmDO.getIsTemplateVm());
        vmDTO.setIsPublicTemplate(vmDO.getIsPublicTemplate());

        return vmDTO;
    }

    public static VmDO conventToVmDO(VmDTO vmDTO) {
        if (vmDTO == null) {
            return null;
        }

        VmDO vmDO = new VmDO();
        vmDO.setClassId(vmDTO.getClassId());
        vmDO.setDesc(vmDTO.getDesc());
        vmDO.setHostId(vmDTO.getHostId());
        vmDO.setImageUuid(vmDTO.getImageUuid());
        vmDO.setUserAccount(vmDTO.getUserAccount());
        vmDO.setVmMemory(vmDTO.getVmMemory());
        if (vmDTO.getVmStatus() != null) {
            vmDO.setVmStatus(vmDTO.getVmStatus().getStatus());
        }
        vmDO.setVmUuid(vmDTO.getVmUuid());
        vmDO.setVmVcpu(vmDTO.getVmVcpu());
        if (vmDTO.getShowType() != null) {
            vmDO.setShowType(vmDTO.getShowType().getValue());
        }
        vmDO.setShowPort(vmDTO.getShowPort());
        vmDO.setShowPassword(vmDTO.getShowPassword());
        vmDO.setVmName(vmDTO.getVmName());
        vmDO.setImageTotalSize(vmDTO.getImageTotalSize());
        if (vmDTO.getImageFormat() != null) {
            vmDO.setImageFormat(vmDTO.getImageFormat().getValue());
        }
        vmDO.setParentVmUuid(vmDTO.getParentVmUuid());
        vmDO.setIsTemplateVm(vmDTO.getIsTemplateVm());
        vmDO.setIsPublicTemplate(vmDTO.getIsPublicTemplate());

        return vmDO;
    }

    public static List<VmDTO> coventToVmDTOList(List<VmDO> vmDOList) {
        List<VmDTO> vmDTOList = new ArrayList<VmDTO>();
        if (vmDOList == null) {
            return vmDTOList;
        }

        for (VmDO vmDO : vmDOList) {
            vmDTOList.add(conventToVmDTO(vmDO));
        }

        return vmDTOList;
    }
}
