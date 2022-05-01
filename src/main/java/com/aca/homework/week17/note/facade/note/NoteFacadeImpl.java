package com.aca.homework.week17.note.facade.note;

import com.aca.homework.week17.note.entity.Note;
import com.aca.homework.week17.note.service.core.NoteService;
import com.aca.homework.week17.note.service.core.UserService;
import com.aca.homework.week17.note.service.impl.NoteCreationParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class NoteFacadeImpl implements NoteFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteFacadeImpl.class);
    private final NoteService noteService;
    private final UserService userService;

    public NoteFacadeImpl(NoteService noteService, UserService userService) {
        Assert.notNull(noteService, "note service should not be null");
        Assert.notNull(userService, "user service should not be null");
        this.noteService = noteService;
        this.userService = userService;
    }

    @Override
    public NoteCreationResponseDto create(NoteCreationRequestDto dto) {
        Assert.notNull(dto, "note creation request dto should not be null");
        LOGGER.info("Creating a new Note for the note creation response - {}", dto);
        Note note = noteService.create(new NoteCreationParams(
                userService.getByUsername(dto.getUsername()),
                dto.getText(),
                LocalDate.now()
        ));
        LOGGER.info("Successfully added a new note - {}", note);

        NoteCreationResponseDto responseDto = new NoteCreationResponseDto(
                note.getUser().getUsername(),
                note.getText(),
                note.getCreationDate()
        );
        LOGGER.info("Successfully created a response dto - {}", responseDto);
        return responseDto;
    }
}
