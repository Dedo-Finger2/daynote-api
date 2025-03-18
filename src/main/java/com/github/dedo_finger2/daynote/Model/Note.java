package com.github.dedo_finger2.daynote.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes", uniqueConstraints = @UniqueConstraint(columnNames = {"daily_note_id", "title"}))
@Data
public class Note {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "daily_note_id", nullable = false)
    private DailyNote dailyNote;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
