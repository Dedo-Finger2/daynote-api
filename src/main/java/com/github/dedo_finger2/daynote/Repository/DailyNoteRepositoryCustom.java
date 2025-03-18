package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.Note;

import java.util.List;

public interface DailyNoteRepositoryCustom {
    List<Note> getNotes(Long id);
}
