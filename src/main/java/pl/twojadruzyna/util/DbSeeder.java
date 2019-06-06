package pl.twojadruzyna.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.twojadruzyna.model.Player;
import pl.twojadruzyna.model.Team;
import pl.twojadruzyna.repo.EventRepo;
import pl.twojadruzyna.repo.PlayerRepo;
import pl.twojadruzyna.repo.TeamRepo;

import java.util.Date;

@Component
@ConditionalOnProperty(name = "db.seder.active", havingValue = "true")
public class DbSeeder implements CommandLineRunner {

    private static final String INITIALIZED_DATABASE_MESSAGE = "Initialized database";
    private TeamRepo teamRepo;
    private PlayerRepo playerRepo;
    private EventRepo eventRepo;

    @Autowired
    public DbSeeder(TeamRepo teamRepo, PlayerRepo playerRepo, EventRepo eventRepo) {
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
        this.eventRepo = eventRepo;
    }


    @Override
    public void run(String... args) {
        clearDatabase();

        var player = new Player();
        player.setFirstName("Olis");
        player.setSecondName("Adebe");
        player.setAge(30);
        player.setCaptain(true);

        var team = new Team();
        team.setName("MOTOR BOGUCICE");
        team.setCity("Bogucice");
        team.setDateOfCreation(new Date());
        team.setCountry("POLSKA");
        team.setShortName("FC MOTOR");

        System.out.println(INITIALIZED_DATABASE_MESSAGE);
    }

    private void clearDatabase() {
        this.playerRepo.deleteAll();
        this.teamRepo.deleteAll();
        this.eventRepo.deleteAll();
    }
}
