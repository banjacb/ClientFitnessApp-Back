package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.base.CrudController;
import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.dto.Participaties;
import net.etfbl.clientfitnesapp.models.dto.Statistic;
import net.etfbl.clientfitnesapp.models.requests.CommentUserRequest;
import net.etfbl.clientfitnesapp.models.requests.ParticipatiesRequest;
import net.etfbl.clientfitnesapp.models.requests.StatisticRequest;
import net.etfbl.clientfitnesapp.services.StatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/statistics")
public class StatisticController extends CrudController<Integer, StatisticRequest, Statistic> {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        super(statisticService, Statistic.class);

        this.statisticService = statisticService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Statistic insert(@RequestBody StatisticRequest statistic) throws NotFoundException {
        return statisticService.insert(statistic, Statistic.class);
    }
}
