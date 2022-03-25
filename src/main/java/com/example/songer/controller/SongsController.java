package com.example.songer.controller;

import com.example.songer.models.Albums;
import com.example.songer.models.Song;
import com.example.songer.services.AlbumsServices;
import com.example.songer.services.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongsController {

    private final SongsService songsService;
    private final AlbumsServices albumsServices;

    @Autowired
    public SongsController(SongsService songsService , AlbumsServices albumsServices) {
        this.songsService = songsService;
        this.albumsServices=albumsServices;
    }

    @GetMapping("/songs")
    String getAllSongs(Model model){
        List<Song> songs = songsService.getAllSongs();
        model.addAttribute("songs" , songs);
        return "allSongs";
    }

    @PostMapping("/addsong")
    RedirectView addSong(Song song , @RequestParam Long id ,Model model ) {
        Albums album = albumsServices.findOneAlbum(id);
        songsService.addSong(song,album);
        return new RedirectView("/oneAlbum?id=" + id);
    }
}
