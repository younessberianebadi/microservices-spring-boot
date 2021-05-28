package io.digiwise.frontendservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private static final String GET_ALL_PLAYERS_API = "http://localhost:8081/players/list";

    static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String main() {

        return "authentification"; //view
    }


    @GetMapping("/list")
    public String mainWithParam(Model model) {

        /* HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_PLAYERS_API, HttpMethod.GET, entity, String.class);

        String s = result.toString();

        System.out.println(s);


        s = s.substring(s.indexOf("{"));
        s = s.substring(0, s.indexOf("}") + 1);

        System.out.println(s); */

        // final ObjectMapper objectMapper = new ObjectMapper();
        // Player langs = objectMapper.readValue(s, Player.class);

        Player player = restTemplate.getForObject(GET_ALL_PLAYERS_API, Player.class);
        model.addAttribute("player", player);


        return "list"; //view
    }

    @GetMapping("/fixtures")
    public String getFixtures() {

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
    public String search() {

        return "search"; //view
    }

    @GetMapping("/insertmatch")
    public String insertMatch() {

        return "insertmatch"; //view
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
    public String createPlayer() {

        return "createplayer"; //view
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
    public String insertTest() {

        return "insertest"; //view
    }

    @GetMapping("/bulletin")
    public String bulletin() {

        return "bulletin"; //view
    }

}
