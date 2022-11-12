package com.levelup.newborn.domain.mission.controller;

import com.levelup.newborn.domain.mission.domain.Missions;
import com.levelup.newborn.domain.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    @GetMapping("{id}")
    public ResponseEntity<Missions> getMission(@PathVariable Long id) {
        Missions missions = missionService.getMission(id);
        return ResponseEntity
                .ok()
                .body(missions);
    }

    @PostMapping()
    public ResponseEntity<Missions> createMission(@RequestBody Missions data) {
        Missions missions = missionService.createMission(data);
        return ResponseEntity
                .ok()
                .body(missions);
    }
}
