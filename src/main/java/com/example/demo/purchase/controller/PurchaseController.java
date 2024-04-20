package com.example.demo.purchase.controller;

import com.example.demo.purchase.model.request.CreatePurchaseRequest;
import com.example.demo.purchase.model.response.CreatePurchaseResponse;
import com.example.demo.purchase.service.CreatePurchaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class PurchaseController {
    private final CreatePurchaseUseCase createPurchaseUseCase;

    @PostMapping("/purchase")
    public ResponseEntity<CreatePurchaseResponse> purchaseSticker(@RequestBody CreatePurchaseRequest request) {
        CreatePurchaseResponse response = createPurchaseUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
