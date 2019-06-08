package pl.twojadruzyna.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String shortName;
    private String country;
    private String city;
    private Date foundedDate;
    private Long points;
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<Player> players;

}
