package com.example.springassignmentlv3.controller;

import com.example.springassignmentlv3.dto.AdminRequestDto;
import com.example.springassignmentlv3.dto.SuccessMessageDto;
import com.example.springassignmentlv3.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/signup")
    public SuccessMessageDto AdminSignup(@Valid @RequestBody AdminRequestDto adminRequestDto) {
        adminService.adminSignup(adminRequestDto);
        return new SuccessMessageDto("관리자 회원가입에 성공하셨습니다!");
    }

    @PostMapping("/login")
    public SuccessMessageDto AdminLogin() {
        return null;
    }
}
