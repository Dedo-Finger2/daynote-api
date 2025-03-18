package com.github.dedo_finger2.daynote.Repository;

import com.github.dedo_finger2.daynote.Model.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DailyNoteRepositoryImpl implements DailyNoteRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Note> getNotes(Long id) {
        String sql = "select n from Note n where n.dailyNote.id = :id";

        final TypedQuery<Note> query = this.entityManager.createQuery(sql, Note.class);
        query.setParameter("id", id);

        return query.getResultList();
    }
}
