package com.example.demo.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Guetter, Setter, To String(), RequiredArgsConstructor
@NoArgsConstructor //constructeur vide
@AllArgsConstructor // Constructeur plein
public class PersonDto {

	@NotEmpty() // pour les chaines de caractère
	@Size(min = 2, message = "Nom doit contenir minimum 2 caractères")
	private String firstName;
	@NotEmpty() // pour les chaines de caractère
	@Size(min = 2, message = "Prenom doit contenir minimum 2 caractères")
	private String lastName;
	@NotNull()
	@Digits(integer = 3, fraction = 0, message = "age doit contenir au maximum")
	private Integer age;


}
