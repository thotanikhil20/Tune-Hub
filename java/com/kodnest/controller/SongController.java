package com.kodnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.entity.Song;
import com.kodnest.service.SongService;

@Controller
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/addsongs")
    public String addSong(@ModelAttribute Song song) {
        String name = song.getName();
        boolean songExists = songService.songExists(name); 
        if (!songExists) {
            songService.saveSong(song);
        } else {
            System.out.println("Duplicate entry");
        }
        return "adminhome"; // Redirect to the desired page after adding a song
    }

    @GetMapping("/playsongs")
    public String playSongs(Model model) {
    	boolean premium= true;
    	if(premium) {
        List<Song> songs = songService.fetchAllSongs();
        model.addAttribute("songs", songs);
        return "viewsongs"; // Assuming you have a view named "viewsongs" to display the songs
    }else {
    	return "pay";
    }
}
    @GetMapping("/viewsongs")
    public String viewSongs(Model model) {
    	
    	
        List<Song> songs = songService.fetchAllSongs();
        model.addAttribute("songs", songs);
        System.out.println(songs);
        return "viewsongs"; // Assuming you have a view named "viewsongs" to display the songs
    
    	
    }
}
    
