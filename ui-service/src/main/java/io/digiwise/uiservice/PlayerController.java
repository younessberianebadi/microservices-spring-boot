package io.digiwise.uiservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository repository;

    @Autowired
    private MatchRepository matchrepository;

    @RequestMapping("/")
    public String index(Model model){
        // List<Player> players = (List<Player>) repository.findAll();

        // model.addAttribute("players", players);

        return "auth";

    }

    @RequestMapping(value = "list")
    public String displayPlayers(Model model){
        model.addAttribute("players", "http://localhost:8081/players/add");
        return "listplayers";
    }

    @RequestMapping(value = "/players/add")
    public String addPlayer(Model model){
        // model.addAttribute("player", new Player());
        return "addplayer";
    }

    /* @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Player player){
        repository.save(player);
        return "redirect:/";
    } */

    @RequestMapping(value = "search")
    public String search(Model model){
        // List<Player> players = (List<Player>) repository.findAll();
        // model.addAttribute("players", players);
        return "search";
    }




}
