package com.sowloo.logisticApp.controllers;

import com.sowloo.logisticApp.data.models.Sender;
import com.sowloo.logisticApp.dtos.requests.RegisterSenderRequest;
import com.sowloo.logisticApp.dtos.responses.RegisterSenderResponse;
import com.sowloo.logisticApp.services.SenderService;
import com.sowloo.logisticApp.services.SenderServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SenderController {
    private final SenderService senderServices = new SenderServiceImpl();

    @PostMapping("/api/v1/sender")
    public RegisterSenderResponse registerSender(@RequestBody RegisterSenderRequest registerSenderRequest) {

        return senderServices.registerSender(registerSenderRequest);
    }

    @GetMapping("/api/sender/{email}")
    public Optional<Sender> findSenderByEmail(@PathVariable String email) {

        return senderServices.findSenderByEmail(email);
    }
}
