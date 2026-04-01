package com.example.homeworkmodule14;

import com.example.homeworkmodule14.entity.Note;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();

    private long generateId() {
        return Math.abs(new Random().nextLong());
    }

    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note){
        long id = generateId();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id){
        if(!notes.containsKey(id)){
            throw new NoSuchElementException("Failed. Didn't find note on id:" + id);
        }
        notes.remove(id);
    }

    public void update(Note note){
        long id = note.getId();
        if(!notes.containsKey(id)){
            throw new NoSuchElementException("Failed, didn't find on id:" + id);
        }
        Note existing = notes.get(id);
        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
    }

    public Note getById(long id){
        Note note = notes.get(id);
        if (note == null){
            throw new NoSuchElementException("Note not found with id:" + id);
        }
        return note;
    }
}
