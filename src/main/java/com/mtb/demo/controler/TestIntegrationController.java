package com.mtb.demo.controler;

import com.mtb.demo.integration.contextriderwear.dto.ContextRiderWearProductData;
import com.mtb.demo.integration.contextriderwear.service.ContextRiderWearDataStoringService;
import com.mtb.demo.integration.contextriderwear.service.ContextRiderWearService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: used only for testing purpose, will eliminated later
@RestController
@RequiredArgsConstructor
@Slf4j
@Deprecated
public class TestIntegrationController {

    private final ContextRiderWearService contextRiderWearService;
    private final ContextRiderWearDataStoringService contextRiderWearDataStoringService;

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        contextRiderWearService.getContextRiderWearClient()
                .ifPresent(client -> {
                    final List<ContextRiderWearProductData> data = client.getApi().getProducts().data();
                    data.forEach(product -> {
                        log.atInfo().log(product.toString());
                        contextRiderWearDataStoringService.saveApiToDb(product);
                    });
                });

        return ResponseEntity.ok().build();
    }
}
