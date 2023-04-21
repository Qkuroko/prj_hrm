package com.glb.controller;

import com.glb.dto.ResponseDTO;
import com.glb.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author glb
 * @Date 2023/2/27
 * @Version 1.0
 */

@RestController
@RequestMapping("/home")
public class HomeController {

    @Resource
    private HomeService homeService;

    @GetMapping("/staff")
    public ResponseDTO getStaffData() {
        return this.homeService.getStaffData();
    }

    @GetMapping("/count")
    public ResponseDTO getCountData() {
        return this.homeService.getCountData();
    }

    @GetMapping("/city")
    public ResponseDTO getCityData() {
        return this.homeService.getCityData();
    }

    @GetMapping("/attendance")
    public ResponseDTO getAttendanceData(@RequestParam Integer id, String month) {
        return this.homeService.getAttendanceData(id, month);
    }

    @GetMapping("/department")
    public ResponseDTO getDepartmentData() {
        return this.homeService.getDepartmentData();
    }

}
