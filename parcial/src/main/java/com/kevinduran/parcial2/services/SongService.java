package com.kevinduran.parcial2.services;

import java.util.List;
import java.util.UUID;

import com.kevinduran.parcial2.models.entities.Song;


public interface SongService {
	
	void save(Song song) throws Exception;
	void deleteById(String id) throws Exception;
	Song findOneById(UUID id);
	List<Song> findAll();
	List<Song> findByTitle(String title);
}
