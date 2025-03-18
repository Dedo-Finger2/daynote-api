package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.DailyNote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DailyNoteRepositoryTest {

    @Autowired
    private DailyNoteRepository dailyNoteRepository;

    @Test
    public void testSaveAndFindDailyNote() {
        DailyNote dailyNote = new DailyNote();
        dailyNote.setTitle(LocalDate.of(2025, 3, 18));

        dailyNoteRepository.save(dailyNote);

        Optional<DailyNote> foundNote  = dailyNoteRepository.findById((long) 1);

        Assertions.assertTrue(foundNote.isPresent());
    }
}
