package com.vikram.app.Entity;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // this is for getter and setter
@Entity
@Table(name= "journal")
public class Journal {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private Date date;
 private String topic;
 private String Notes;
}
