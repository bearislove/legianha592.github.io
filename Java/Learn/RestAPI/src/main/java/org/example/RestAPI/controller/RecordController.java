package org.example.RestAPI.controller;

import org.example.RestAPI.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    IWalletService walletService;

    @PostMapping("/create")
    public ResponseEntity createRecord(){

    }
}
