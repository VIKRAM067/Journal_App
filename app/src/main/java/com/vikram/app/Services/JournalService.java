package com.vikram.app.Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.vikram.app.Entity.Journal;
import com.vikram.app.Repository.JournalDAO;


@Service
public class JournalService {

    @Autowired
    JournalDAO journalDAO;

    public ResponseEntity<List<Journal>> getAllnotes()
    {
        try {
            return new ResponseEntity<> (journalDAO.findAll(),HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<> (new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<String> addFunction(Journal journal)
    {
        try {
            journalDAO.save(journal);
        return new ResponseEntity<>("Success",HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<> (null ,HttpStatus.BAD_REQUEST);
        

    }

    public ResponseEntity<List<Journal>> getByDate(java.util.Date utilDate) {
        // Convert java.util.Date to java.sql.Date
        try {
            Date sqlDate = new Date(utilDate.getTime());
        return new ResponseEntity<>(journalDAO.findByDate(sqlDate),HttpStatus.OK);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<> (new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }
}
