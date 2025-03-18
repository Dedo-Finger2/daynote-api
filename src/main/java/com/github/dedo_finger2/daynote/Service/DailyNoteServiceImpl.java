package com.github.dedo_finger2.daynote.Service;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import com.github.dedo_finger2.daynote.Model.Note;
import com.github.dedo_finger2.daynote.Repository.DailyNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DailyNoteServiceImpl implements DailyNoteService {

    @Autowired
    private DailyNoteRepository dailyNoteRepository;

    @Override
    public List<DailyNote> getAll() {
        return List.of();
    }

    @Override
    public Optional<DailyNote> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DailyNote> getByTitle(LocalDate title) {
        return Optional.empty();
    }

    @Override
    public List<Note> getNotesById(Long id) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public DailyNote create() {
        return null;
    }
}
