package com.air.airtest.dto;

import lombok.Data;

/**
 * @author zhaodaodao
 * @description
 * @create 2022-06-25
 */
@Data
public class PasswordChangeDTO {
    private String oldPassword;
    private String newPassword;

    public PasswordChangeDTO() {
    }

    @Override
    public String toString() {
        return "PasswordChangeDTO{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}