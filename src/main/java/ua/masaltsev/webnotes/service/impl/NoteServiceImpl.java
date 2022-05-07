package ua.masaltsev.webnotes.service.impl;

import org.springframework.stereotype.Service;
import ua.masaltsev.webnotes.dao.NoteRepository;
import ua.masaltsev.webnotes.entity.Note;
import ua.masaltsev.webnotes.service.NoteService;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository repository;

    @Override
    public List<Note> showAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Note> showById(Integer id) {
        return repository.findById(id);
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
