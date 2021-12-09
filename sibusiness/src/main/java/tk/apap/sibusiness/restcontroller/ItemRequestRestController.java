package tk.apap.sibusiness.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tk.apap.sibusiness.model.CouponModel;
import tk.apap.sibusiness.model.ItemRequestModel;
import tk.apap.sibusiness.model.UserModel;
import tk.apap.sibusiness.service.CouponService;
import tk.apap.sibusiness.service.ItemRequestRestService;
import tk.apap.sibusiness.service.TypeService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util. ArrayList;
import java.util.List;
import java.time.LocalTime;

import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ItemRequestRestController {
    @Autowired
    private ItemRequestRestService itemRequestRestService;

    @PostMapping(value = "/request-item")
    private ItemRequestModel addItemRequest (@Valid @RequestBody ItemRequestModel itemRequestModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }else{
            return itemRequestRestService.addItemRequest(itemRequestModel);
            //return itemRequestModel;
        }
    }

    @GetMapping(value = "/request-item")
    private String retrieveItemRequest(){
        try{
            return "test";
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found."
            );
        }
    }
}
