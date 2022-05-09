package ua.masaltsev.webnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.masaltsev.webnotes.service.NoteService;

@Controller
public class WebNoteController {

    private final NoteService service;

    @Autowired
    WebNoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/notes")
    public String showNotes(Model model) {
        model.addAttribute("notes", service.showAll());
        return "notes-list";
    }

}
