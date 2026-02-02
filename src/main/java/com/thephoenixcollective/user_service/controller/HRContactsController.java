package com.thephoenixcollective.user_service.controller;

import com.thephoenixcollective.user_service.dto.HRContactsReq;
import com.thephoenixcollective.user_service.dto.HRContactsResp;
import com.thephoenixcollective.user_service.service.HRContactService;
import com.thephoenixcollective.user_service.utility.AppConstants;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class HRContactsController {

    @Autowired
    private HRContactService hrContactService;

    @PostMapping(value = AppConstants.HR_CONTACTS_SAVE_ENDPOINT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createHRContacts(@RequestPart("file") MultipartFile file) {
        log.info("event=HRContactsController.createHRContacts creating contacts where request: {}", file.getSize());
        hrContactService.createHRContacts(file);
        return ResponseEntity.ok("HR contacts uploaded successfully");

    }
}
