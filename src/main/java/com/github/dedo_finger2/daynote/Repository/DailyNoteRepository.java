package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyNoteRepository extends JpaRepository<DailyNote, Long> {
    Optional<DailyNote> findByTitle(LocalDate title);
}
