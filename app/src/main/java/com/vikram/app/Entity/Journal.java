package com.vikram.app.Entity;


import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data // this is for getter and setter
@Entity
@Table(name= "journal")
public class Journal {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Temporal(TemporalType.DATE)
 private Date date;
 private String topic;
 private String Notes;

 @PrePersist
 protected void createDate()
 {
    LocalDate localdate = LocalDate.now();
    date = Date.valueOf(localdate);
 }
}
