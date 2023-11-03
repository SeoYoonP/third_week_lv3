package com.example.springassignmentlv3.global.dto;

import lombok.Getter;

@Getter
public class SuccessMessageDto {
    private String message;
    public SuccessMessageDto(String message) {
        this.message = message;
    }
}