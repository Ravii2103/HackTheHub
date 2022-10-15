package com.hackthehub.hackthehub;

import com.hackthehub.hackthehub.model.ProsepectForm;
import com.hackthehub.hackthehub.services.ConsortiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {

    @Autowired
    private ConsortiumService consortiumService;

    public void consortiumSubscribe(ProsepectForm prospectForm) {
        final boolean sent = consortiumService.sendToAnalysis(prospectForm);
    }

}
