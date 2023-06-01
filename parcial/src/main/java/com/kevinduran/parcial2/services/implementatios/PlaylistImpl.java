package com.kevinduran.parcial2.services.implementatios;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.User;
import com.kevinduran.parcial2.repositories.PlaylistRepository;
import com.kevinduran.parcial2.repositories.UserRepository;
import com.kevinduran.parcial2.services.PlaylistService;

@Service
public class PlaylistImpl implements PlaylistService  {
	@Autowired
	private PlaylistRepository playlistRepository;
	@Autowired
	private UserRepository userService;
	@Override
	public List<Playlist> findall() {
		return playlistRepository.findAll();
	}

	@Override
	public Playlist createPlaylist(Playlist playlist) {
		return playlistRepository.save(playlist);
	}

	@Override
	public Playlist findByCode(UUID code) {
		Playlist newPlaylist = playlistRepository.findByCode(code);
		return newPlaylist;
	}

	@Override
	public List<Playlist> getSongsInPlaylistsByUser(UUID username) {
		  User user = userService.findByCode(username);
		 
	        List<Playlist> playlists = playlistRepository.findByUserCode(username);
	       return playlists;
	}

	@Override
	public List<Playlist> getSongsInPlaylistsByUserandTitle(UUID username, String title) {
		  User user = userService.findByCode(username);
		  List<Playlist> playlist = playlistRepository.findByUserAndTitleContainingIgnoreCaseOrderByTitleAsc(user, title);
		return playlist;
	}

}
