package pl.twojadruzyna.model.filter;

import lombok.Data;

import java.util.Date;

@Data
public class EventFilter {
    private Long teamId;
    private String stadiumName;
    private String country;
    private String city;
    private Date eventDate;

}
