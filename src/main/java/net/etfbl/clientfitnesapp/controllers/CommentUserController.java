package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.CommentUser;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.requests.CommentUserRequest;
import net.etfbl.clientfitnesapp.services.CommentUserService;
import net.etfbl.clientfitnesapp.services.FitnessProgramService;
import net.etfbl.clientfitnesapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/commentusers")
public class CommentUserController {

    private final CommentUserService commentUserService;
    private final FitnessProgramService fitnessProgramService;
    private final UserService userService;



    public CommentUserController(CommentUserService commentUserService, FitnessProgramService fitnessProgramService, UserService userService) {
        this.commentUserService = commentUserService;

        this.fitnessProgramService = fitnessProgramService;
        this.userService = userService;
    }
    @GetMapping
    public List<CommentUser> findAll()
    {
        List<CommentUser> commentUsers=commentUserService.findAll(CommentUser.class);
        return commentUsers;
    }

    @GetMapping("/programComment/{id}")
    public List<CommentUser> findFitnessProgram( @PathVariable  Integer id) {

        List<CommentUser> comments = commentUserService.findAll(CommentUser.class);


        List<CommentUser> programComment = new ArrayList<>();
        for (CommentUser comment : comments) {
            if (comment.getFitness_program_id().equals(id)) {

                Integer id_user=comment.getUser_id();
                Integer program_id=comment.getFitness_program_id();
                String user_name= userService.findById(id_user, User.class).getFirst_name();
                String user_lastname= userService.findById(id_user, User.class).getFirst_name();
                String program_name=fitnessProgramService.findById(program_id, FitnessProgram.class).getName();
                comment.setFirst_name(user_name);
                comment.setLast_name(user_lastname);
                comment.setProgram_name(program_name);
                programComment.add(comment);

            }
        }


        return programComment;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentUser insert(@RequestBody CommentUserRequest commentRequest) throws NotFoundException {
        return commentUserService.insert(commentRequest, CommentUser.class);
    }


}
