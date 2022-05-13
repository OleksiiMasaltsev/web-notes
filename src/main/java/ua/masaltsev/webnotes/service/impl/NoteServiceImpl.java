package ua.masaltsev.webnotes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.masaltsev.webnotes.dao.NoteRepository;
import ua.masaltsev.webnotes.entity.Note;
import ua.masaltsev.webnotes.service.NoteService;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Autowired
    NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> showAll() {
        return repository.findAll();
    }

    @Override
    public Note findById(Integer id) {
        Note resultNote;
        Optional<Note> optionalNote = repository.findById(id);
        if (optionalNote.isPresent()) {
            resultNote = optionalNote.get();
        } else {
            throw new RuntimeException("Note id is not found: " + id);
        }
        return resultNote;
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Note note) {
        repository.save(note);
    }
}
