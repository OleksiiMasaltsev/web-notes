package ua.masaltsev.webnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.masaltsev.webnotes.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
