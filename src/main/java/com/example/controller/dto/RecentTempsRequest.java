package com.example.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@ToString
@Setter
@Getter
public class RecentTempsRequest {
    @NotNull
    @Range(min = 1, max = 15)
    private Integer count;
    @NotNull
    @Min(0)
    private Integer offset;
}
