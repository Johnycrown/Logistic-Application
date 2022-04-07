package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.exceptions.DuplicateUserException;
import com.sowloo.logisticApp.data.models.Sender;
import com.sowloo.logisticApp.data.repositories.SenderRepository;
import com.sowloo.logisticApp.data.repositories.SenderRepositoryImpl;
import com.sowloo.logisticApp.dtos.requests.RegisterSenderRequest;
import com.sowloo.logisticApp.dtos.responses.RegisterSenderResponse;
import com.sowloo.logisticApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class SenderServiceImpl implements SenderService {
    private static final SenderRepository senderRepository = new SenderRepositoryImpl();

    @Override
    public RegisterSenderResponse registerSender(RegisterSenderRequest registerSenderRequest) {
        Optional<Sender> savedSenderInDb = senderRepository.findSenderByEmail(registerSenderRequest.getSenderEmail());
        if (savedSenderInDb.isPresent())
            throw new DuplicateUserException(registerSenderRequest.getSenderEmail() + "already exist");

        //convert to sender
        Sender sender = ModelMapper.map(registerSenderRequest);

        // save
        Sender savedSender = senderRepository.save(sender);
        // convert sender to dto
        // RegisterSenderResponse response = SenderModelMapper.map(savedSender);

        return ModelMapper.map(savedSender);
    }

    @Override
    public List<Sender> getSenders() {
        return senderRepository.findAll();
    }

    @Override
    public void deleteAllSenders() {
        senderRepository.deleteAll();
    }

    @Override
    public Optional<Sender> findSenderByEmail(String email) {
        return senderRepository.findSenderByEmail(email);
    }
}
