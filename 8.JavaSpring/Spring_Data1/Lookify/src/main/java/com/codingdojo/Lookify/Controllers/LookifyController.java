package com.codingdojo.Lookify.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.Lookify.Services.LookifyService;
import com.codingdojo.Lookify.models.Song;




@Controller
public class LookifyController {
	private final LookifyService lookifyService;

public LookifyController(LookifyService lookifyService) {
		
		this.lookifyService = lookifyService;
	}


@RequestMapping("/")
public String index() {
	return "/index.jsp";
}

@RequestMapping("/dashboard")
public String dash(@ModelAttribute("songName") Song song, Model model) {
List<Song> songs=lookifyService.allSongs();
model.addAttribute("songs",songs);
return "/dashboard.jsp";
}

@RequestMapping("/new")
public String newBook(@ModelAttribute("nuevo") Song song) {
    return "/new.jsp";
}
@RequestMapping(value="/dashboard", method=RequestMethod.POST)
public String create(@Valid @ModelAttribute("songName") Song song, BindingResult result, Model model) {
   if (result.hasErrors()) {
	   List <Song> songs = lookifyService.allSongs();
		model.addAttribute("songs",songs);
        return "/new.jsp";
    } else {
       lookifyService.createSong(song);
        return "redirect:/dashboard";
    }
}

// te lleva  a la cancion individual
@RequestMapping("/songs/{id}")
public String show(@PathVariable("id") Long id,Model model) {
    Song song = lookifyService.findSong(id);
    model.addAttribute("song", song);
    return "/song.jsp";
}

//para borrar

@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
public String destroy(@PathVariable("id") Long id) {
    lookifyService.deleteSong(id);
    return "redirect:/dashboard";
}





@RequestMapping("/search/topTen")
public String topTenSong(Model model) {
	List<Song> top10Songs=lookifyService.getTopTen();
	model.addAttribute("top10", top10Songs);
	
	return "topten.jsp";
}


@PostMapping ("/search")
public String search(@ModelAttribute("songName") Song song) {
	return"redirect:/search/"+song.getName();
}

@RequestMapping("/search/{search}")
public String result(@ModelAttribute("songName") Song song,@PathVariable("search")String search, Model model) {
	List<Song> results = lookifyService.findbyArtist(search);
	model.addAttribute("search",search);
	model.addAttribute("results",results);
	return "search.jsp";
}
}
