package com.example.homeworkmodule14;

import com.example.homeworkmodule14.entity.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homeworkmodule14Application {

	public static void main(String[] args) {

		NoteService noteService = new NoteService();

		// ➕ створення нотатки
		Note note1 = new Note();
		note1.setTitle("First note");
		note1.setContent("Hello world");

		Note savedNote = noteService.add(note1);
		System.out.println("Saved: " + savedNote.getId());

		// 📄 отримати всі
		System.out.println("All notes:");
		for (Note n : noteService.listAll()) {
			System.out.println(n.getId() + " " + n.getTitle());
		}

		// 🔍 отримати по id
		Note found = noteService.getById(savedNote.getId());
		System.out.println("Found: " + found.getTitle());

		// ✏️ оновлення
		found.setTitle("Updated title");
		found.setContent("Updated content");
		noteService.update(found);

		System.out.println("After update:");
		System.out.println(noteService.getById(found.getId()).getTitle());

		// ❌ видалення
		noteService.deleteById(found.getId());
		System.out.println("Deleted note with id: " + found.getId());

		// 🔥 перевірка помилки
		try {
			noteService.getById(found.getId());
		} catch (Exception e) {
			System.out.println("Expected error: " + e.getMessage());
		}
	}
}