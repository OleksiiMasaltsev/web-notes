package ua.masaltsev.webnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.masaltsev.webnotes.entity.Note;
import ua.masaltsev.webnotes.service.NoteService;

import java.util.Optional;

@Controller
public class WebNoteController {

    private final NoteService service;

    @Autowired
    WebNoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/showAllNotes")
    public String showAllNotes(Model model) {
        model.addAttribute("notes", service.showAll());
        return "note-list";
    }

    @GetMapping("/showNoteForm")
    public String showNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "note-form";
    }

    @GetMapping("/showNoteUpdate")
    public String showNoteUpdate(@RequestParam("noteId") int id, Model model) {
        Optional<Note> note = service.showById(id);
        model.addAttribute(note.orElse(new Note()));
        return "note-form";
    }

    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note) {
        service.save(note);
        return "redirect:/showAllNotes";
    }


}
