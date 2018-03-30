package com.project.doungen.services;

import java.util.ArrayList;
import java.util.List;

import com.project.doungen.models.Char;
import com.project.doungen.repositories.CharRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CharService {
	// Member variables / service initializations go here
		private CharRepository charRepository;
	public CharService(CharRepository charRepository){
		this.charRepository = charRepository;
	}

	public void make(Char chare){
		charRepository.save(chare);
	}
	
	// Crud methods to act on services go here.
}
