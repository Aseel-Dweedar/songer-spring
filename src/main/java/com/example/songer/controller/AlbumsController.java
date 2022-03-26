package com.example.songer.controller;

import com.example.songer.models.Albums;
import com.example.songer.models.Song;
import com.example.songer.services.AlbumsServices;
import com.example.songer.services.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class AlbumsController {

    private final AlbumsServices albumsServices;
    private final SongsService songsService;

    @Autowired
    public AlbumsController(AlbumsServices albumsServices, SongsService songsService) {
        this.albumsServices = albumsServices;
        this.songsService = songsService;
    }

    @GetMapping("/")
    String getAllAlbums(Model model , HttpServletRequest request) {

        HttpSession session = request.getSession();

        if (session.getAttribute("username") != null) {
            List<Albums> albums = albumsServices.getAllAlbums();
            model.addAttribute("albums", albums);
            model.addAttribute("user", true);
        }

        return "index";
    }

    @PostMapping("/album")
    RedirectView addAlbum(Albums album) {
        System.out.println("did i even reach here?");
        albumsServices.addAlbum(album);
        return new RedirectView("/");
    }

    @GetMapping("/oneAlbum")
    String getOneAlbum(@RequestParam Long id, Model model) {
        Albums album = albumsServices.findOneAlbum(id);
        model.addAttribute("album", album);
        Set<Song> songs = songsService.findSongsByAlbumId(id);
        model.addAttribute("songs", songs);
        return "oneAlbum";
    }

}
