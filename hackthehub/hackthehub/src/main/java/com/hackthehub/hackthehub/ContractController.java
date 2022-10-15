package com.hackthehub.hackthehub;

import com.hackthehub.hackthehub.model.ProspectForm;
import com.hackthehub.hackthehub.services.ConsortiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ContractController {

    @Autowired
    private ConsortiumService consortiumService;

    @PostMapping(
            value = "/hackthehub/contractIt", consumes = "application/json", produces = "application/json")
    public void consortiumSubscribe(@RequestBody ProspectForm prospectForm) {
        consortiumService.sendToAnalysis(prospectForm);
    }


    @GetMapping("/hackthehub/test")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }
}
