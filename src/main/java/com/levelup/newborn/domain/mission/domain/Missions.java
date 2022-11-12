package com.levelup.newborn.domain.mission.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "missions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Missions {
    @Id
    @GeneratedValue
    @Column(name = "mission_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "time_limit")
    private String timeLimit;

    @Column(name = "grade")
    private int grade;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @Builder
    public Missions(String title, String content, String author, int likeCount, String timeLimit, int grade) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.likeCount = likeCount;
        this.timeLimit = timeLimit;
        this.grade = grade;
    }
}
