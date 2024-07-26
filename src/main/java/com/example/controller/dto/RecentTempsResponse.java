package com.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class RecentTempsResponse {
    private List<Float> recentTemperatures;
}
