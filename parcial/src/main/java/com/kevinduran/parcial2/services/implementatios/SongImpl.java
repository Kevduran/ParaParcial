package com.kevinduran.parcial2.services.implementatios;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial2.models.entities.Song;
import com.kevinduran.parcial2.repositories.SongRepository;
import com.kevinduran.parcial2.services.SongService;

@Service	
public class SongImpl implements SongService {

	@Autowired
	private SongRepository songRepository;
	@Override
	public void save(Song song) {
		
		songRepository.save(song);
	}

	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Song findOneById(UUID id) {
		Song getsong = songRepository.findByCode(id);
		return getsong;
	}

	@Override
	public List<Song> findAll() {
		return songRepository.findAll();
	}

	@Override
	public List<Song> findByTitle(String title) {
		return songRepository.findByTitleContainingIgnoreCase(title);
	}


}
