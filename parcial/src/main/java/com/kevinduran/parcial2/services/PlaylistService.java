package com.kevinduran.parcial2.services;

import java.util.List;
import java.util.UUID;

import com.kevinduran.parcial2.models.entities.Playlist;

public interface PlaylistService {
	List<Playlist> findall();
	Playlist createPlaylist(Playlist playlist);
	Playlist findByCode(UUID code);
	List<Playlist> getSongsInPlaylistsByUser(UUID username);
	List<Playlist> getSongsInPlaylistsByUserandTitle(UUID username, String title);
	
}
