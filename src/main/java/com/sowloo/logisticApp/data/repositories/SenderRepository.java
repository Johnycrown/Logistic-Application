package com.sowloo.logisticApp.data.repositories;

import com.sowloo.logisticApp.data.models.Sender;

import java.util.List;
import java.util.Optional;

public interface SenderRepository {
    Sender save(Sender sender);

    Optional<Sender> findSenderByEmail(String email);

    void delete(Sender sender);

    void delete(String senderId);

    void deleteAll();

    List<Sender> findAll();
}
