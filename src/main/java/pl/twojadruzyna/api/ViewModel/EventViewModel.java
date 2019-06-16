package pl.twojadruzyna.api.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventViewModel {

    private Long id;
    @NotNull
    private TeamViewModel myTeam;
    @NotNull
    private TeamViewModel oppositeTeam;
    @NotNull
    private Integer oppositeTeamScores;
    @NotNull
    private Integer myTeamScores;
    private String refereeName;
    private String stadiumName;
    private String country;
    private String city;
    @NotNull
    private Date matchDate;
}
