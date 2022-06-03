package com.example.mytest.controller;

import com.example.mytest.dto.NoteDto;
import com.example.mytest.dto.ResponseDto;
import com.example.mytest.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get All Notes
    @GetMapping("/notes")
    public List<NoteDto> getAllNotes() {
        return userService.findAllNote();
    }

    // Create a new Note
    @PostMapping("/notes")
    public ResponseDto<String> createNote(@Valid @RequestBody NoteDto noteDto) {
        return userService.createNote(noteDto);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public ResponseDto<NoteDto> getNoteById(@PathVariable(value = "id") Long noteId) {
        return userService.findSingleNote(noteId);
    }

    //Update a Note
    @PutMapping("/notes/{id}")
    public ResponseDto<String> updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody NoteDto noteDetails){
        return userService.updateNote(noteId, noteDetails);
    }

    //Delete Note
    @DeleteMapping("/notes/{id}")
    public ResponseDto<String> deleteNote(@PathVariable(value = "id") Long noteId) {
        return userService.delete(noteId);
    }
}
