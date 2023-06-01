package com.kevinduran.parcial2.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevinduran.parcial2.models.dtos.PlaylistDto;
import com.kevinduran.parcial2.models.entities.Playlist;
import com.kevinduran.parcial2.models.entities.User;
import com.kevinduran.parcial2.services.PlaylistService;
import com.kevinduran.parcial2.services.SongService;
import com.kevinduran.parcial2.services.UserService;


@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SongService songService;
	
	@GetMapping(name = "/")
	public ResponseEntity<?> findAllbook(){
		List<Playlist> playlist= playlistService.findall();
		return new ResponseEntity<>(
				playlist, HttpStatus.OK);
	}
	
	
	  @PostMapping("/create")
	public ResponseEntity<?> createPlaylist(@RequestBody PlaylistDto playlist){
		String title = playlist.getTitle();
		String description = playlist.getDescription();
		String identifier = playlist.getIdentifier();
		User user = userService.getUserByUsername(identifier);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún usuario con el identificador proporcionado");
		}else {
			Playlist playlistObj = new Playlist(title, description, user);
			playlistService.createPlaylist(playlistObj);
			  return ResponseEntity.ok("Playlist creada correctamente");
		}
	
		
	}
	@PostMapping("/getPlaylists")
	 public ResponseEntity<?> getPlaylist(@RequestParam(required = true) String username, @RequestParam(required = false) String title){
		System.out.print(username);
		if(title != null) {
			User user = userService.getUserByUsername(username);
			if(user != null) {
				 List<Playlist> playlists = playlistService.getSongsInPlaylistsByUserandTitle(user.getCode(), title);
				  return new ResponseEntity<>(
							playlists, HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún usuario con el identificador proporcionado");
			}
			
			
			
		}
		else {
		User user = userService.getUserByUsername(username);
		if(user != null) {
			 List<Playlist> playlists = playlistService.getSongsInPlaylistsByUser(user.getCode());
			  return new ResponseEntity<>(
						playlists, HttpStatus.OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún usuario con el identificador proporcionado");
		}
		}
		
		
	  }
	

	  

}
