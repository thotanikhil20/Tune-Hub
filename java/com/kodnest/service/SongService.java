package com.kodnest.service;

import java.util.List;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean songExists(String name);

	List<Song> fetchAllSongs();

	boolean playlistExists(String name);

	void savePlaylist(Playlist playlist);

	void update(Song song);



}