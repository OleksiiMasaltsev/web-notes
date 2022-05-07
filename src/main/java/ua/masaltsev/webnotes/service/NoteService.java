package ua.masaltsev.webnotes.service;

import ua.masaltsev.webnotes.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> showAll();
    Optional<Note> showById(Integer id);
    void deleteById(Integer id);
    void save(Note note);
}
