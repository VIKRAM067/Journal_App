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

    // The response Entity is used to return the httpsattus code 
    //so the return type should be in that ResponseEntity<> 
    // Inside <> u should put the return type of the method

    public ResponseEntity<List<Journal>> getAllnotes()
    {
        try {
            return new ResponseEntity<> (journalDAO.findAll(),HttpStatus.OK);
            // when returning Response it has 2 params(return of the method , httpstatus)
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

    public ResponseEntity<String> putByTopic(Long id, Journal journal) {
        
        try {
            Journal newJournal = journalDAO.findById(id)
                        .orElseThrow(() -> new RuntimeException("Journal not found with id: " + id));

            newJournal.setNotes(journal.getNotes());
            journalDAO.save(newJournal);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
                                
        
       
    }

    public ResponseEntity<String> deleteById(Long id) {
        try {
            journalDAO.deleteById(id);
            return new ResponseEntity<>("success",HttpStatus.OK);
        } 
        catch (Exception e) {
           e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    
}
