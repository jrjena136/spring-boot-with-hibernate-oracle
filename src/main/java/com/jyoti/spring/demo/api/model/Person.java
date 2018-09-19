package com.jyoti.spring.demo.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/mm/yyyy")
	private Date dob;
	
}
