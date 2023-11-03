package com.example.springassignmentlv3.service;

import com.example.springassignmentlv3.dto.AdminRequestDto;
import com.example.springassignmentlv3.dto.LoginRequestDto;
import com.example.springassignmentlv3.entity.Admin;
import com.example.springassignmentlv3.entity.AdminRoleEnum;
import com.example.springassignmentlv3.exception.CustomException;
import com.example.springassignmentlv3.exception.ErrorCode;
import com.example.springassignmentlv3.repository.AdminRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void adminSignup(AdminRequestDto adminRequestDto) {
        String email = adminRequestDto.getEmail();
        String department = adminRequestDto.getDepartment();
        String password = passwordEncoder.encode(adminRequestDto.getPassword());
        AdminRoleEnum roleEnum = determineRoleByDepartment(department);

        /** 유효성 검사 */
        validateEmail(email);
        validateDepartment(department);

        Admin newAdmin = new Admin(email, department, password, roleEnum);
        adminRepository.save(newAdmin);
    }

    private void validateEmail(String email) {
        Optional<Admin> checkAdminEmail = adminRepository.findByEmail(email);
        if (checkAdminEmail.isPresent()) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }
    }

    public void validateDepartment(String department) {
        if (!department.equalsIgnoreCase("커리큘럼") &&
            !department.equalsIgnoreCase("개발") &&
            !department.equalsIgnoreCase("마케팅")) {
            throw new CustomException(ErrorCode.INVALID_DEPARTMENT);
        }
    }

    private AdminRoleEnum determineRoleByDepartment(String department) {
        if (department.equalsIgnoreCase("커리큘럼") ||
            department.equalsIgnoreCase("개발")) {
            return AdminRoleEnum.MANAGER;
        } else {
            return AdminRoleEnum.STAFF;
        }
    }


}
