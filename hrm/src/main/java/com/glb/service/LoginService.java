package com.glb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.glb.dto.Response;
import com.glb.dto.ResponseDTO;
import com.glb.entity.Staff;
import com.glb.enums.BusinessStatusEnum;
import com.glb.mapper.StaffMapper;
import com.glb.util.JWTUtil;
import com.glb.util.MD5Util;
import com.glb.vo.StaffDeptVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author : glb
 * @Date : 2023/1/30
 */

@Service
public class LoginService extends ServiceImpl<StaffMapper, Staff> {

    @Resource
    private StaffMapper staffMapper;

    public ResponseDTO login(Staff staff) {
        String password = MD5Util.MD55(staff.getPassword());
        StaffDeptVO staffDeptVO = this.staffMapper.findStaffInfo(staff.getCode(), password);
        if (staffDeptVO != null) {
            // 验证用户状态
            if (staffDeptVO.getStatus() == 1) {
                String token = JWTUtil.generateToken(staffDeptVO.getId(),password);
                return Response.success(staffDeptVO, token); // 返回员工信息和token
            }
            return Response.error(BusinessStatusEnum.STAFF_STATUS_ERROR);
        }
        return Response.error("用户名或密码错误!");
    }
}
