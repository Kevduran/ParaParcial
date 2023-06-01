package com.kevinduran.parcial2.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial2.models.entities.Song;

public interface SongRepository extends ListCrudRepository<Song, UUID> {
	Song findByCode(UUID id);
	List<Song> findByTitleContainingIgnoreCase(String partialTitle);
	
}
