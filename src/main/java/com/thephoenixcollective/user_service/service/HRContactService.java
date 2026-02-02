package com.thephoenixcollective.user_service.service;

import org.springframework.web.multipart.MultipartFile;

public interface HRContactService {
    void createHRContacts(MultipartFile file);
}
