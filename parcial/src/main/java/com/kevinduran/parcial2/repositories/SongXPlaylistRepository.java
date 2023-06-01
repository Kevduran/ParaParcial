package com.kevinduran.parcial2.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.SongXPlaylist;

public interface SongXPlaylistRepository extends ListCrudRepository<SongXPlaylist, UUID> {

	List<SongXPlaylist> findSongsByPlaylist(Playlist playlist);


}
