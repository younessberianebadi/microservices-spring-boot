package io.digiwise.playerservice.ressources;

import io.digiwise.playerservice.models.Player;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static io.digiwise.playerservice.models.Player.nationality.moroccan;
import static io.digiwise.playerservice.models.Player.sexe.male;
import static io.digiwise.playerservice.models.Player.category.u10;


@RestController
@RequestMapping("/players")
public class PlayersRessource {
    @RequestMapping("/{n}")
    public List<Player> /*Player*/ getPlayers(@PathVariable("n") String m){
        List<Player> list = new ArrayList<>();
        list.add(new Player(1L,"Hassan", "Amir", moroccan, LocalDate.of(2011, 2, 01), male, u10, 60, 160));
        list.add(new Player(2L,"Amr", "Sarhan", moroccan, LocalDate.of(2011, 8, 01), male, u10, 63, 170));
        return list;
        //Player player = new Player(1L,"Hassan", "Amir", moroccan, LocalDate.of(2011, 2, 01), male, u10, 60, 160);
        //return player;
    }
}
