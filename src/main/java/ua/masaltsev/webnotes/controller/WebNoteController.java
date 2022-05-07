package ua.masaltsev.webnotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebNoteController {

    @GetMapping("/notes")
    public String showNotes() {
        return "notes-list";
    }

}
