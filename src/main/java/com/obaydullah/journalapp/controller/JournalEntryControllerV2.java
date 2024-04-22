package com.obaydullah.journalapp.controller;


import com.obaydullah.journalapp.entity.JournalEntry;
import com.obaydullah.journalapp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
     return journalEntryService.getAllEntry();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry entry){
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return entry;
    }

    @GetMapping("/id/{id}")
    public JournalEntry getEntryById(@PathVariable ObjectId id){
        return journalEntryService.findById(id).orElse(null);
    }


    @DeleteMapping("/id/{id}")
    public boolean deleteEntryById(@PathVariable ObjectId id){
        journalEntryService.deleteById(id);

        return true;
    }


    @PutMapping("/id/{id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId id ,@RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("")?newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("")?newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
        }
        return old;
    }
}
