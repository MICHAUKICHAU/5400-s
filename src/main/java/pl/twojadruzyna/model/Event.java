package pl.twojadruzyna.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
    @NotNull
    private Team myTeam;
    @OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
    @NotNull
    private Team oppositeTeam;
    private String refereeName;
    private String stadiumName;
    private String country;
    private String city;
    @NotNull
    private Date matchDate;
}
