package com.vikram.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.app.Entity.Journal;
import com.vikram.app.Services.JournalService;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalService journalService;

    @GetMapping("/all")
    public List<Journal> getAllnotes()
    {
        return journalService.getAllnotes();
    }

    
}
