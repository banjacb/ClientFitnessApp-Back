package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.Activity;
import net.etfbl.clientfitnesapp.models.dto.AdvisorMessage;
import net.etfbl.clientfitnesapp.models.requests.ActivityRequest;
import net.etfbl.clientfitnesapp.services.AdvisorMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/advisormessages")
public class AdvisorMessageController {

    private final AdvisorMessageService advisorMessageService;

    public AdvisorMessageController(AdvisorMessageService advisorMessageService) {
        this.advisorMessageService = advisorMessageService;
    }

    @GetMapping
    public List<AdvisorMessage> findAll()
    {
        List<AdvisorMessage> advisorMessages= advisorMessageService.findAll(AdvisorMessage.class);
        return advisorMessages;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdvisorMessage insert(@RequestBody AdvisorMessage advisorMessage) throws NotFoundException {
        return advisorMessageService.insert(advisorMessage, AdvisorMessage.class);
    }
}
