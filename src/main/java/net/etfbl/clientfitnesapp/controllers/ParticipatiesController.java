package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.base.CrudController;
import net.etfbl.clientfitnesapp.base.CrudService;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.dto.Participaties;
import net.etfbl.clientfitnesapp.models.requests.ParticipatiesRequest;
import net.etfbl.clientfitnesapp.models.requests.ProgramRequest;
import net.etfbl.clientfitnesapp.services.ParticipatiesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/participaties")
public class ParticipatiesController  extends CrudController<Integer, ParticipatiesRequest, Participaties> {

    ParticipatiesService participatiesService;
    ParticipatiesController(ParticipatiesService participatiesService)
    {
        super(participatiesService, Participaties.class);
        this.participatiesService=participatiesService;
    }

    @PostMapping("/parForUser")
    public void participationForUser(@RequestBody ParticipatiesRequest request)  {
        participatiesService.insert(request,Participaties.class);

    }

}
