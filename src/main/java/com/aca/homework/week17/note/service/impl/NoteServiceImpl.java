package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.repository.NoteRepository;
import com.aca.homework.week17.note.service.core.NoteService;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class NoteServiceImpl implements NoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImpl.class);
    private final NoteRepository noteRepository;
    private final UserService userService;

    public NoteServiceImpl(NoteRepository noteRepository, UserService userService) {
        Assert.notNull(noteRepository, "note repository should not be null");
        this.noteRepository = noteRepository;
        this.userService = userService;
    }

    @Override
    public Note create(NoteCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Creating and saving new note according to params - {}", params);
        Note transientNote = new Note(
                userService.getByUsername(params.getUsername()),
                params.getText(),
                params.getCreationDate()
        );
        Note persistentNote = noteRepository.save(transientNote);
        LOGGER.info("Successfully saved the note - {}", persistentNote);
        return persistentNote;
    }
}
