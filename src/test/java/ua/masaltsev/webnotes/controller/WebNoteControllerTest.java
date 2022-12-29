package ua.masaltsev.webnotes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import ua.masaltsev.webnotes.entity.Note;
import ua.masaltsev.webnotes.service.NoteService;

import java.util.List;

@SpringBootTest
class WebNoteControllerTest {

    private WebNoteController webNoteController;

    @Mock
    private NoteService noteService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        webNoteController = new WebNoteController(noteService);
    }

    @Test
    void showAllNotes_returnsNoteList() {
        String viewName = webNoteController.showAllNotes(model);
        assertEquals("note-list", viewName);
    }

    @Test
    void showNoteForm() throws Exception {
        MockMvc mockMvc = standaloneSetup(webNoteController).build();
        mockMvc.perform(get("/showNoteForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("note-form"));
    }

    @Test
    void showNoteUpdate() throws Exception {

    }

    @Test
    void deleteNote() {
    }

    @Test
    void saveNote() {
    }
}