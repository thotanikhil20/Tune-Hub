
package com.kodnest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.entity.Playlist;
import com.kodnest.entity.Song;
import com.kodnest.repository.SongRepository;
import com.kodnest.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songrepository;

	@Override
	public void saveSong(Song song) {
		songrepository.save(song);
	}

	@Override
	public boolean songExists(String name) {

		Song song = songrepository.findByName(name);

		if(song != null) {
			return true;
		}else {
			return false;
		}
	}

	public List<Song> fetchAllSongs() {
		List<Song> songs= songrepository.findAll();
		return songs;
	}

	@Override
	public boolean playlistExists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void savePlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Song song) {
		songrepository.save(song);
		
	}

	

}
