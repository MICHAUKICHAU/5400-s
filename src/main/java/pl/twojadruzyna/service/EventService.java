package pl.twojadruzyna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.twojadruzyna.model.Event;
import pl.twojadruzyna.repo.EventRepo;

import java.util.List;

@Service
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> getAllEvents(){
        return eventRepo.findAll();
    }
}

