package com.ael.algoryqrservice.controller;

import com.ael.algoryqrservice.model.dto.QrRequest;
import com.ael.algoryqrservice.service.QrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class QrController {
    private final QrService qrService;


    @PostMapping("/create")
    public ResponseEntity<?> createQr(@RequestBody QrRequest req){
        //DTO (Data transfer object)
        qrService.createQR(req);

        return ResponseEntity.ok("Qr created");
    }
}
