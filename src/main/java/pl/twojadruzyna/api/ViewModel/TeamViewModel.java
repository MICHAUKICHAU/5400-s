package pl.twojadruzyna.api.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamViewModel {
    private Long id;
    private String name;
    private String shortName;
    private String country;
    private String city;
    private Date foundedDate;
    private Long points;
}
