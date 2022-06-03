package com.example.mytest.repository;

import com.example.mytest.dto.ResponseDto;
import com.example.mytest.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    ResponseDto<String> updateNote(Long noteId, Note noteDetails);
}
