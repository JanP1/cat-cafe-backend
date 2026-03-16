package com.catcafe.catcafe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class SupabaseStorageService implements StorageService {

    @Value("${supabase.endpoint}")
    private String endpoint;

    @Value("${supabase.bucket-name}")
    private String bucketName;

    @Override
    public String generatePublicUrl(String fileName) {
        return endpoint + "/" + bucketName + "/" + fileName;
    }
}
