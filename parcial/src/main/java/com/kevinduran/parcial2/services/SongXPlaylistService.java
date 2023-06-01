package com.kevinduran.parcial2.services;

import java.util.List;

import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.SongXPlaylist;


public interface SongXPlaylistService {
	List<SongXPlaylist> getAll();
	void insertSongsIntoPlaylist(SongXPlaylist newSong);
	  List<SongXPlaylist> findSongsByPlaylist(Playlist playlist);
}
