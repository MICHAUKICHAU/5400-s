package pl.twojadruzyna.api.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.twojadruzyna.model.Team;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventViewModel {

    private Long id;
    private TeamViewModel myTeam;
    private TeamViewModel oppositeTeam;
    private Integer oppositeTeamScores;
    private Integer myTeamScores;
    private String refereeName;
    private String stadiumName;
    private String country;
    private String city;
    private Date matchDate;
}
