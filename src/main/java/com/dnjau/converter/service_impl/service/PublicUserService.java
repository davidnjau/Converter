package com.dnjau.converter.service_impl.service;

import com.dnjau.converter.model.Notification;

import java.util.concurrent.CompletableFuture;

public interface PublicUserService {

    CompletableFuture<Void> addUsers(Notification notification);
}
