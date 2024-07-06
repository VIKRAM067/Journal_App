package com.vikram.app.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikram.app.Entity.Journal;

@Repository
public interface JournalDAO extends JpaRepository< Journal , Long > {

    List<Journal> findByDate(Date date);
    

}
