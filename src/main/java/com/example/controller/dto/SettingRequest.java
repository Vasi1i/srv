package com.example.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@ToString
@Getter
public class SettingRequest {
    @NotNull
    @Range(min = -200, max = 1000)
    private Float temperature;
}
