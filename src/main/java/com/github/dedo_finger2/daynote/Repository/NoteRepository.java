package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
