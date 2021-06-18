package io.digiwise.frontendservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;

@Controller
public class MainController {

    private static final String GET_ALL_PLAYERS_API = "http://localhost:8080/api/v1/joueurs";
    private static final String CREATE_PLAYER_API = "http://localhost:8080/api/v1/joueurs";
    private static final String GET_ALL_MATCHES_API = "http://localhost:8084/Match";
    private static final String CREATE_MATCH_API = "http://localhost:8084/Match";
    private static final String DELETE_PLAYER_API = "http://localhost:8080/api/v1/joueurs/{id}";
    private static final String GET_PLAYER_BY_ID_API = "http://localhost:8080/api/v1/joueurs/{id}";
    private static final String CREATE_TEST_API = "http://localhost:8099/add_test";
    private static final String GET_ALL_TESTS_API = "http://localhost:8099/tests";
    private static final String GET_TEST_BY_ID = "http://localhost:8099/tests/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/login")
    public String main() {

        return "authentification"; //view
    }


    @GetMapping("/list")
    public String mainWithParam(Model model) {


        Joueur players[] = restTemplate.getForObject(GET_ALL_PLAYERS_API, Joueur[].class);
        model.addAttribute("players", players);


        return "list"; //view
    }

    @GetMapping("/listest")
    public String testList(Model model) {


        Joueur players[] = restTemplate.getForObject(GET_ALL_PLAYERS_API, Joueur[].class);
        model.addAttribute("players", players);
        Test tests[] = restTemplate.getForObject(GET_ALL_TESTS_API, Test[].class);
        model.addAttribute("tests", tests);


        return "testlist"; //view
    }


    @GetMapping("/fixtures")
    public String getFixtures(Model model) {

        Match matches[] = restTemplate.getForObject(GET_ALL_MATCHES_API, Match[].class);
        model.addAttribute("matches", matches);

        return "matchcalendar"; //view
    }

    @GetMapping("/calendar")
    public String getCalendar() {

        return "maincallendar"; //view
    }

    @GetMapping("/educator")
    public String portalEducator() {

        return "portaledu"; //view
    }

    @GetMapping("/player")
    public String portalPlayer() {

        return "portalplayer"; //view
    }

    @GetMapping("/tutor")
    public String portalTutor() {

        return "portaltutor"; //view
    }


    @GetMapping("/search")
    public String search(Model model) {
        String name = null;
        model.addAttribute("name", name);
        // model.addAttribute("player", new Joueur());

        return "search"; //view
    }

    @PostMapping(value = "searchByName")
    public RedirectView searchByName(@ModelAttribute String name, Model model){
        Joueur player = restTemplate.getForObject(GET_ALL_PLAYERS_API + name, Joueur.class);
        model.addAttribute("player", player);
        return new RedirectView("/search");
    }

    @GetMapping(value = "/deletePlayer/{id}")
    public RedirectView deleteList(@PathVariable("id") Long playerid){
        // playerid.substring(1);
        // System.out.println(playerid);
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", playerid.toString());
        restTemplate.delete(DELETE_PLAYER_API, params);
        // restTemplate.delete(DELETE_PLAYER_API + playerid);
        return new RedirectView("/list");
    }

    @GetMapping(value = "/editPlayer/{id}")
    public String editList(@PathVariable("id") Long playerid, Model model){
        // playerid.substring(1);
        // System.out.println(playerid);
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", playerid.toString());
        // restTemplate.delete(DELETE_PLAYER_API, params);
        // restTemplate.delete(DELETE_PLAYER_API + playerid);
        model.addAttribute("cat", Joueur.categorie.values());
        model.addAttribute("sex", Joueur.sexe.values());
        model.addAttribute("nat", Joueur.nationality.values());
        model.addAttribute("pos", Joueur.position.values());
        Joueur joueur = restTemplate.getForObject(GET_PLAYER_BY_ID_API, Joueur.class, params);
        model.addAttribute("joueur", joueur);

        return "editplayer";
    }

    @GetMapping(value = "/viewPlayer/{id}")
    public String viewPlayer(@PathVariable("id") Long playerid, Model model){
        // playerid.substring(1);
        // System.out.println(playerid);
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", playerid.toString());
        // restTemplate.delete(DELETE_PLAYER_API, params);
        // restTemplate.delete(DELETE_PLAYER_API + playerid);
        model.addAttribute("cat", Joueur.categorie.values());
        model.addAttribute("sex", Joueur.sexe.values());
        model.addAttribute("nat", Joueur.nationality.values());
        model.addAttribute("pos", Joueur.position.values());
        Joueur joueur = restTemplate.getForObject(GET_PLAYER_BY_ID_API, Joueur.class, params);
        model.addAttribute("joueur", joueur);
        Test tests[] = restTemplate.getForObject(GET_ALL_TESTS_API, Test[].class);
        model.addAttribute("tests", tests);

        return "viewprofile";
    }

    @GetMapping(value = "/viewTest/{id}")
    public String viewTest(@PathVariable("id") Long testid, Model model){
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", testid.toString());
        Test test = restTemplate.getForObject( GET_TEST_BY_ID, Test.class, params);

        // Get player id to import its name from the player service
        int idPlayer = test.getId_player();
        Map < String, String > params2 = new HashMap < String, String > ();
        String idplayerS = Integer.toString(idPlayer);
        params2.put("id", idplayerS);

        // Issue the get by id request to the player service
        Joueur player = restTemplate.getForObject(GET_PLAYER_BY_ID_API, Joueur.class, params2);

        // Get the attributes
        model.addAttribute("test", test);
        model.addAttribute("player", player);

        return "bulletin";
    }

    @PostMapping(value = "/update/{id}")
    public RedirectView updatePlayer(@ModelAttribute Joueur joueur, @PathVariable("id") Long playerid){
        //System.out.println(joueur);
        // joueur.setId(0L);
        Map < String, String > params = new HashMap < String, String > ();
        params.put("id", playerid.toString());
        restTemplate.put(GET_PLAYER_BY_ID_API, joueur, params);

        // ResponseEntity<Joueur> joueur1 = restTemplate.postForEntity(CREATE_PLAYER_API, joueur, Joueur.class);
        return new RedirectView("/list");
    }


    @GetMapping("/insertmatch")
    public String insertMatch(Model model) {

        Match match = new Match();
        model.addAttribute("match", match);
        return "insertmatch"; //view
    }

    @PostMapping(value = "/saveMatch")
    public RedirectView insertMatchMethod(@ModelAttribute Match match){
        ResponseEntity<Match> matchtosend = restTemplate.postForEntity(CREATE_MATCH_API, match, Match.class);
        return new RedirectView("/fixtures");
    }

    @GetMapping("/createeducator")
    public String createEducator() {

        return "createeducator"; //view
    }

    @GetMapping("/admin")
    public String portalAdmin() {

        return "admin"; //view
    }

    @GetMapping("/createplayer")
    public String createPlayer(Model model) {
        Joueur j = new Joueur();
        model.addAttribute("joueur", j);
        return "createplayer"; //view
    }

    /*@GetMapping("/insertest")
    public String planSingleTest(Model model) {
        Test test = new Test();
        model.addAttribute("test", test);
        return "insertest"; //view
    }*/

    @PostMapping(value = "/saveTest")
    public RedirectView saveTest(@ModelAttribute Test test){
        System.out.println(test);
        test.setId(0L);
        System.out.println(test);

        ResponseEntity<Test> test1 = restTemplate.postForEntity(CREATE_TEST_API, test, Test.class);
        return new RedirectView("/listest");
    }

    @PostMapping(value = "/save")
    public RedirectView insertPlayer(@ModelAttribute Joueur joueur){
        // System.out.println(joueur);
        joueur.setId(0L);

        ResponseEntity<Joueur> joueur1 = restTemplate.postForEntity(CREATE_PLAYER_API, joueur, Joueur.class);
        return new RedirectView("/list");
    }

    @GetMapping("/gamestats")
    public String statsGames() {

        return "gamestats"; //view
    }

    @GetMapping("/absperplayer")
    public String getPlayerAbsence() {

        return "absperplayer"; //view
    }

    @GetMapping("/abspereducator")
    public String getEducatorAbsence() {

        return "abspereducator"; //view
    }

    @GetMapping("/insertest")
    public String insertTest(Model model) {

        Test test = new Test();
        model.addAttribute("test", test);
        Joueur players[] = restTemplate.getForObject(GET_ALL_PLAYERS_API, Joueur[].class);
        model.addAttribute("players", players);

        return "insertest"; //view
    }

    @GetMapping("/bulletin")
    public String bulletin() {

        return "bulletin"; //view
    }

    @GetMapping("/")
    public String welcome() {

        return "index"; //view
    }


}
