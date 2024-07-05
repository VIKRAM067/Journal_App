package com.vikram.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikram.app.Entity.Journal;

@Repository
public interface JournalDAO extends JpaRepository< Journal , Long > {

}
