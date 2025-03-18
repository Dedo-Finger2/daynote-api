package com.github.dedo_finger2.daynote.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "note_links", uniqueConstraints = @UniqueConstraint(columnNames = {"from_note_id", "to_note_id"}))
@Data
public class NoteLink {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_note_id", nullable = false)
    private Note fromNote;

    @ManyToOne
    @JoinColumn(name = "to_note_id", nullable = false)
    private Note toNote;
}
