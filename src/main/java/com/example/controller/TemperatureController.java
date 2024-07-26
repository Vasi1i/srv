package com.example.controller;

import com.example.controller.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.regulator.Regulator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/temperature")
public class TemperatureController {

    private final Regulator regulator;

    @PostMapping("/setting")
    public ResponseEntity<CodeResponse> setTemperature(@Valid @RequestBody SettingRequest request) {
        int result = regulator.adjustTemp((byte) 0b10000010, request.getTemperature(), null, 0);
        return ResponseEntity.ok(new CodeResponse(result));
    }

    @GetMapping("/current")
    public ResponseEntity<CurrentTempResponse> getCurrentTemperature() {
        List<Float> outData = new ArrayList<>();
        regulator.adjustTemp((byte) 0b10001100, 0, outData, 0);
        return ResponseEntity.ok(new CurrentTempResponse(outData.getFirst()));
    }

    @GetMapping("/recent")
    public ResponseEntity<RecentTempsResponse> getRecentTemperatures(@Valid @ModelAttribute RecentTempsRequest recentTempsRequest) {
        List<Float> outData = new ArrayList<>();
        regulator.adjustTemp((byte) ((recentTempsRequest.getCount() << 3) | 0b10000100), 0, outData, recentTempsRequest.getOffset());
        return ResponseEntity.ok(new RecentTempsResponse(outData));
    }

    @PostMapping("/clear")
    public ResponseEntity<CodeResponse> clearTemperatures() {
        List<Float> outData = new ArrayList<>();
        int result = regulator.adjustTemp((byte) 0b10000001, 0, outData, 0);
        return ResponseEntity.ok(new CodeResponse(result));
    }
}