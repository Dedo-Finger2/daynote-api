package com.github.dedo_finger2.daynote.Service;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import com.github.dedo_finger2.daynote.Model.Note;
import com.github.dedo_finger2.daynote.Repository.DailyNoteRepository;
import com.github.dedo_finger2.daynote.Service.Exception.ResourceNotFound;
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
        return dailyNoteRepository.findAll();
    }

    @Override
    public Optional<DailyNote> getById(Long id) {
        Optional<DailyNote> dailyNote = this.dailyNoteRepository.findById(id);

        if (dailyNote.isEmpty()) throw new ResourceNotFound("daily note not found");

        return dailyNote;
    }

    @Override
    public Optional<DailyNote> getByTitle(LocalDate title) {
        Optional<DailyNote> dailyNote = this.dailyNoteRepository.findByTitle(title);

        if (dailyNote.isEmpty()) throw new ResourceNotFound("daily note not found");

        return dailyNote;
    }

    @Override
    public List<Note> getNotesById(Long id) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {
        Optional<DailyNote> dailyNote = this.dailyNoteRepository.findById(id);

        if (dailyNote.isEmpty()) throw new ResourceNotFound("daily note not found");

        this.dailyNoteRepository.deleteById(id);
    }

    @Override
    public DailyNote create() {
        return null;
    }
}
