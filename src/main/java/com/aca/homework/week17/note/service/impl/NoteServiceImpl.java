package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.repository.NoteRepository;
import com.aca.homework.week17.note.service.core.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class NoteServiceImpl implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note create(NoteCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Creating and saving new note according to params - {}", params);
        Note transientNote = new Note(
                params.getUser(),
                params.getText(),
                params.getCreationDate()
        );
        LOGGER.info("Successfully created a new note - {}", transientNote);
        Note persistentNote = noteRepository.save(transientNote);
        LOGGER.info("Successfully saved the note - {}", persistentNote);
        return persistentNote;
    }
}
