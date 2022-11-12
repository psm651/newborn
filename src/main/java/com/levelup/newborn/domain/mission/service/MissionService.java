package com.levelup.newborn.domain.mission.service;

import com.levelup.newborn.domain.mission.dao.MissionRepository;
import com.levelup.newborn.domain.mission.domain.Missions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;

    public Missions getMission(Long id) {
        Missions missions = missionRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return missions;
    }

    public Missions createMission(Missions data) {
        Missions missions = missionRepository.save(data);
        Missions savedMissions = this.getMission(missions.getId());
        return savedMissions;
    }
}
