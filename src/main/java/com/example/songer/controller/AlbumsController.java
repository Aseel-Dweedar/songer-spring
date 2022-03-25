package com.example.songer.controller;

import com.example.songer.models.Albums;
import com.example.songer.services.AlbumsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumsController {

    private final AlbumsServices albumsServices;

    @Autowired
    public AlbumsController(AlbumsServices albumsServices) {
        this.albumsServices = albumsServices;
    }

    @GetMapping("/")
    String getAllAlbums(Model model) {
        List<Albums> albums = albumsServices.getAllAlbums();
        model.addAttribute("albums", albums);
        return "index";
    }

    @PostMapping("/album")
    RedirectView addAlbum(Albums album) {
        try {
            System.out.println("did i even reach here?");
            Albums newAlbum = albumsServices.addAlbum(album);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new RedirectView("/");
    }

}
