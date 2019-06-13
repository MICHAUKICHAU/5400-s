package pl.twojadruzyna.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.twojadruzyna.api.ViewModel.TeamViewModel;
import pl.twojadruzyna.service.TeamService;

import java.util.List;


@RestController
@RequestMapping("api/team")
@CrossOrigin
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamViewModel>> getTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

}
