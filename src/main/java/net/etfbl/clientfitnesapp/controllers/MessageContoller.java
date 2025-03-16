package net.etfbl.clientfitnesapp.controllers;

import net.etfbl.clientfitnesapp.exeptions.NotFoundException;
import net.etfbl.clientfitnesapp.models.dto.FitnessProgram;
import net.etfbl.clientfitnesapp.models.dto.Message;
import net.etfbl.clientfitnesapp.models.dto.User;
import net.etfbl.clientfitnesapp.models.requests.MessageRequest;
import net.etfbl.clientfitnesapp.models.requests.ProgramRequest;
import net.etfbl.clientfitnesapp.services.MessageService;
import net.etfbl.clientfitnesapp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/messages")

public class MessageContoller {

    private final MessageService messageService;
    private final UserService userService;


    public MessageContoller(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping
    public List<Message> findAll()
    {
        List<Message> messages=messageService.findAll(Message.class);
        return messages;
    }

    @GetMapping("/{id}")
    public  List<Message> findIdMessages(@PathVariable Integer id)
    {
        List<Message> all=messageService.findAll(Message.class);
        List<Message> result= new ArrayList<>();

        for(var m: all)
        {
            if(m.getSender_id()==(id) || m.getReceiver_id()==(id))
            {
                User sender= userService.findById(m.getSender_id(), User.class);
                User receiver= userService.findById(m.getReceiver_id(), User.class);
               m.setName_sender(sender.getFirst_name());
               m.setSurname_sender(sender.getLast_name());
                m.setName_receiver(receiver.getFirst_name());
                m.setSurname_receiver(receiver.getLast_name());
                result.add(m);
            }
        }
        return  result;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message insert(@RequestBody Message message) throws NotFoundException {
        return messageService.insert(message, Message.class);
    }
}
