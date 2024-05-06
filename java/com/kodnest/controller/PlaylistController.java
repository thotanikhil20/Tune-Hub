package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;
import com.kodnest.service.PlaylistService;
import com.kodnest.service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playlistService;
	@Autowired
	SongService songservice;

	@GetMapping("/createplaylists")
	public String createplaylists(Model model) {
		List<Song> songList = songservice.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {

		String name = playlist.getName();
		boolean playlistExists = playlistService.playlistExists(name);
		if (!playlistExists) {
			playlistService.addPlaylist(playlist);
		} else {
			System.out.println("Duplicate entry");
		}
		//updating the song_playlists table
	List<Song> songs= playlist.getSongs();
	for(Song song: songs) {
		 song.getPlaylists().add(playlist);
		 songservice.update(song);
	}
		return "adminhome";
	}

	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> playlist = playlistService.fetchAllPlaylists();
		model.addAttribute("playlist", playlist);
		return "viewplaylists";

	}
}