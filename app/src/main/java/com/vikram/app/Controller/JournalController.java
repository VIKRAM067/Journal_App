package com.vikram.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.app.Entity.Journal;
import com.vikram.app.Services.JournalService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalService journalService;

    @GetMapping("/all")
    public ResponseEntity<List<Journal>> getAllnotes()
    {
        return journalService.getAllnotes();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFunction(@RequestBody Journal journal)
    {
        return journalService.addFunction(journal);
        
    } 

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Journal>> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date)
    {
        return journalService.getByDate(date);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> putByTopic(@PathVariable Long id , @RequestBody Journal journal)
    {
        return journalService.putByTopic(id ,journal);
        
    }
    

    
}
