package net.etfbl.clientfitnesapp.controllers;


import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.*;
import net.etfbl.clientfitnesapp.models.entities.ActivityEntity;
import net.etfbl.clientfitnesapp.models.requests.ActivityRequest;
import net.etfbl.clientfitnesapp.models.requests.BodyRequest;
import net.etfbl.clientfitnesapp.models.requests.ProgramRequest;
import net.etfbl.clientfitnesapp.services.ActivityService;
import net.etfbl.clientfitnesapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;
    private final UserService userService;


    public ActivityController(ActivityService service, UserService userService) {
        this.activityService = service;
        this.userService = userService;
    }

    @GetMapping
    public List<Activity> findAll()
    {
        List<Activity> activities= activityService.findAll(Activity.class);
        return activities;
    }

    @GetMapping("/{id}")
    public List<Activity> findById(@PathVariable Integer id) throws NotFoundException {

       List<Activity> activities = activityService.findAll(Activity.class);
       List<Activity> result= new ArrayList<>();
       for(var a: activities)
       {
           if(a.getUser_id()==id)
               result.add(a);
       }
        return result;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Activity insert(@RequestBody ActivityRequest activityRequest) throws NotFoundException {
        return activityService.insert(activityRequest, Activity.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        activityService.delete(id);
    }


    @GetMapping("/kilo/{id}")
    public BodyRequest findStatisticForClient(@PathVariable Integer id ) {

        List<Activity> result = new ArrayList<>();
        List<User> users = userService.findAll(User.class);
        List<Activity> activities = activityService.findAll(Activity.class);

        for (User user : users) {
            if (user.getId() == (id)) {
                for (Activity activity : activities) {
                    if (activity.getUser_id().equals(id)) {

                        result.add(activity);

                    }
                }
                var x = result.stream().map(Activity::getDate).toList();
                var y = result.stream().map(Activity::getKilo).toList();

                return new BodyRequest(x, y);
            }


        }
        return  null;
    }

}
