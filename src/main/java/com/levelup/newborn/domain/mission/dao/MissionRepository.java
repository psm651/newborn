package com.levelup.newborn.domain.mission.dao;

import com.levelup.newborn.domain.mission.domain.Missions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Missions, Long> {

}
