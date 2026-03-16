package com.catcafe.catcafe.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class PlaceholderStorageService implements StorageService {

    @Override
    public String generatePublicUrl(String fileName) {
        return "https://placehold.co/600x600";
    }
}
