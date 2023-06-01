package com.kevinduran.parcial2.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial2.models.dtos.SongXPlaylistDto;
import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.Song;
import com.kevinduran.parcial2.models.entities.SongXPlaylist;
import com.kevinduran.parcial2.services.PlaylistService;
import com.kevinduran.parcial2.services.SongService;
import com.kevinduran.parcial2.services.SongXPlaylistService;


@RestController
@RequestMapping("/api")
public class SongXPlaylistController {

	@Autowired
	private SongXPlaylistService songXplayService;
	
	@Autowired 
	private SongService songservice;
	@Autowired 
	private PlaylistService playlistService;
	
	@GetMapping("/songsplay/{playlist}")
	public ResponseEntity<?> findallsongs(@PathVariable("playlist") UUID playlist){
		if(playlist == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró codigo de playlist");
		}{
		Playlist playlistSongs = playlistService.findByCode(playlist);
		if(playlistSongs == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningúna playlist con el identificador proporcionado");
		}else {
		List<SongXPlaylist> songs= songXplayService.findSongsByPlaylist(playlistSongs);
		return new ResponseEntity<>(
				songs, HttpStatus.OK);
		}
		}
	}
	
	@PostMapping("/newSongPlaylist")
	public ResponseEntity<?> createNewSongs(@RequestBody SongXPlaylistDto songDto){
		UUID songCode = songDto.getSongCode();
		UUID playlistCode = songDto.getPlayList();
		Date date_added = songDto.getDate_added();
		System.out.println(playlistCode);
		Song getSong = songservice.findOneById(songCode);
		Playlist getPlaylist = playlistService.findByCode(playlistCode);
		
		SongXPlaylist songplay = new SongXPlaylist(getSong, getPlaylist, date_added);
		songXplayService.insertSongsIntoPlaylist(songplay);
		return ResponseEntity.ok("Cancion registrada correctamente");
	}
}
