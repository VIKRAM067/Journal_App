package com.vikram.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vikram.app.Entity.Journal;
import com.vikram.app.Repository.JournalDAO;


@Service
public class JournalService {

    @Autowired
    JournalDAO journalDAO;

    public List<Journal> getAllnotes()
    {
        return journalDAO.findAll();
    }

}
