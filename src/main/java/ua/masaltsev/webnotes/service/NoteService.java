package ua.masaltsev.webnotes.service;

import ua.masaltsev.webnotes.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> showAll();
    Note findById(Integer id);
    void deleteById(Integer id);
    void save(Note note);
}
