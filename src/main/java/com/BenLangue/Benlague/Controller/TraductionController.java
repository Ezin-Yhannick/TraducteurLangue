package com.BenLangue.Benlague.Controller;

import com.BenLangue.Benlague.DTOs.TraductionReponse;
import com.BenLangue.Benlague.DTOs.TraductionRequest;
import com.BenLangue.Benlague.Service.TraductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TraductionController {

    private final TraductionService traductionService;

    @PostMapping("/traduire")
    public TraductionReponse traduire(@RequestBody TraductionRequest traductionRequest){
        return traductionService.traductionReponse(traductionRequest);
    }
}
