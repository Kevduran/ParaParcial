package com.kevinduran.parcial2.services.implementatios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.SongXPlaylist;
import com.kevinduran.parcial2.repositories.SongXPlaylistRepository;
import com.kevinduran.parcial2.services.SongXPlaylistService;

@Service
public class SongXPlaylistImpl implements SongXPlaylistService{

	@Autowired
	private SongXPlaylistRepository songXPlayListRepository;

	@Override
	public List<SongXPlaylist> getAll() {
		return songXPlayListRepository.findAll();
		
	}

	@Override
	public void insertSongsIntoPlaylist(SongXPlaylist newSong) {
		songXPlayListRepository.save(newSong);
	}

	@Override
	public List<SongXPlaylist> findSongsByPlaylist(Playlist playlist) {
		List<SongXPlaylist> songs = songXPlayListRepository.findSongsByPlaylist(playlist);
		return songs;
	}

}