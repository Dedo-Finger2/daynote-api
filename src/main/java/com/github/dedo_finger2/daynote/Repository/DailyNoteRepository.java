package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyNoteRepository extends JpaRepository<DailyNote, Long> {
}
