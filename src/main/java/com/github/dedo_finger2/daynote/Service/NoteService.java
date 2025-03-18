package com.github.dedo_finger2.daynote.Service;

import com.github.dedo_finger2.daynote.Model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    Note create(Long dailyNoteId, String title);
    List<Note> getAll();
    Optional<Note> getById(Long id);
    Optional<Note> updateTitleById(Long id, String title);
    Optional<Note> updateDescriptionById(Long id, String description);
    Optional<Note> updateContentById(Long id, String content);
    void deleteById(Long id);
}
