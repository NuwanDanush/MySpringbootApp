package com.example.mytest.service;

import com.example.mytest.dto.NoteDto;
import com.example.mytest.dto.ResponseDto;
import com.example.mytest.exception.ResourceNotFoundException;
import com.example.mytest.model.Note;
import com.example.mytest.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class UserService implements NoteRepository {

    private final NoteRepository noteRepository;
    private final ResponseDto responseDto;

    protected UserService(NoteRepository noteRepository, ResponseDto responseDto) {
        this.noteRepository = noteRepository;
        this.responseDto = responseDto;
    }

    public List<NoteDto> findAllNote(){
        List<NoteDto> list1 = new ArrayList<>();
       try{
           List<Note> list2 =  noteRepository.findAll();
           for (Note note : list2){
               NoteDto noteDto = new NoteDto();
               noteDto.setId(note.getId());
               noteDto.setFirstName(note.getFirstName());
               noteDto.setLastName(note.getLastName());
               noteDto.setPhone(note.getPhone());
               list1.add(noteDto);
           }
       }catch (Exception e){
           throw new IllegalArgumentException("Error occur when FindNote!!");
       }
        return list1;
    }

    public ResponseDto<String> updateNote(Long noteId, NoteDto noteDetails){
        try{
            Optional<Note> result = noteRepository.findById(noteId);
            if(result.isPresent()){
                Note note2 = result.get();
                note2.setFirstName(noteDetails.getFirstName());
                note2.setLastName(noteDetails.getLastName());
                note2.setPhone(noteDetails.getPhone());
                Note response = noteRepository.save(note2);
                responseDto.setMessage(response.toString());
                return responseDto;
            }else {
                throw new ResourceNotFoundException("Note", "id", noteId);
            }
        }catch (Exception e){
            throw new ResourceNotFoundException("Note", "id", noteId);
        }
    }

    public ResponseDto<String> delete(Long noteId){
        try {
            Optional<Note> note1 = noteRepository.findById(noteId);
            if (note1.isPresent()){
                noteRepository.deleteById(noteId);
                responseDto.setMessage("Delete" + noteId + "success!");
                return responseDto;
            }else {
                throw new ResourceNotFoundException("Note", "id", noteId);
            }

        }catch (Exception e){
            throw new ResourceNotFoundException("Note", "id", noteId);
        }
    }

    public ResponseDto<String> createNote(NoteDto noteDto) {
       try {
           Note note = new Note();
           note.setId(noteDto.getId());
           note.setFirstName(noteDto.getFirstName());
           note.setLastName(noteDto.getLastName());
           note.setPhone(noteDto.getPhone());
           Note response = noteRepository.save(note);
           responseDto.setMessage(response.toString());
           return responseDto;

       }catch (Exception e){
           throw new IllegalArgumentException("Error occur when insert note!! ");
       }
    }

    public ResponseDto<NoteDto> findSingleNote(Long noteId) {
        try{
            Optional<Note> result = noteRepository.findById(noteId);
            if (result.isPresent()){
                Note note = result.get();
                NoteDto noteDto = new NoteDto();
                noteDto.setId(note.getId());
                noteDto.setFirstName(note.getFirstName());
                noteDto.setLastName(note.getLastName());
                noteDto.setPhone(note.getPhone());
                responseDto.setObject(noteDto);
                return responseDto;
            }
        }catch (Exception e){
            throw new IllegalArgumentException("error occur when find note using ID");
        }
        return null;
    }
}
