package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.models.Sender;
import com.sowloo.logisticApp.dtos.requests.RegisterSenderRequest;
import com.sowloo.logisticApp.dtos.responses.RegisterSenderResponse;

import java.util.List;
import java.util.Optional;

public interface SenderService {
    RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest);

    List<Sender> getSenders();

    void deleteAllSenders();

    Optional<Sender> findSenderByEmail(String email);
}
