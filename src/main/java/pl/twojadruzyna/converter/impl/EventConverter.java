package pl.twojadruzyna.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.twojadruzyna.api.ViewModel.EventViewModel;
import pl.twojadruzyna.api.ViewModel.TeamViewModel;
import pl.twojadruzyna.converter.IConverter;
import pl.twojadruzyna.model.Event;
import pl.twojadruzyna.model.Team;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventConverter implements IConverter<Event, EventViewModel> {

    private final TeamConverter teamConverter;

    @Autowired
    public EventConverter(TeamConverter teamConverter) {
        this.teamConverter = teamConverter;
    }

    @Override
    public EventViewModel convertToViewModel(Event entity) {
        var viewModel = new EventViewModel();
        viewModel.setId(entity.getId());
        viewModel.setMyTeam(teamConverter.convertToViewModel(entity.getMyTeam()));

        if (!entity.getTeams().isEmpty()) {
            TeamViewModel oppositeTeam = teamConverter.convertToViewModel(getOppositeTeam(entity.getTeams(), entity.getMyTeam()));
            viewModel.setOppositeTeam(oppositeTeam);
        }
        viewModel.setOppositeTeamScores(entity.getOppositeTeamScores());
        viewModel.setMyTeamScores(entity.getMyTeamScores());
        viewModel.setRefereeName(entity.getRefereeName());
        viewModel.setStadiumName(entity.getStadiumName());
        viewModel.setCountry(entity.getCountry());
        viewModel.setCity(entity.getCity());
        viewModel.setMatchDate(entity.getMatchDate());

        return viewModel;
    }

    @Override
    public Event convertToEntity(EventViewModel viewModel) {
        return null;
    }

    private Team getOppositeTeam(List<Team> teamList, Team myTeam) {
        return teamList
                .stream()
                .filter(team -> !team.equals(myTeam))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<EventViewModel> convertToEventList(List<Event> eventList){
       return eventList
               .stream()
               .map(this::convertToViewModel)
               .collect(Collectors.toList());
    }
}
