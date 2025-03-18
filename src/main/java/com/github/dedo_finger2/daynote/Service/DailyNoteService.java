package com.github.dedo_finger2.daynote.Service;


import com.github.dedo_finger2.daynote.Model.DailyNote;
import com.github.dedo_finger2.daynote.Model.Note;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyNoteService {
    List<DailyNote> getAll();

    Optional<DailyNote> getById(Long id);

    Optional<DailyNote> getByTitle(LocalDate title);

    List<Note> getNotesById(Long id);

    void deleteById(Long id);

    DailyNote create();
}
