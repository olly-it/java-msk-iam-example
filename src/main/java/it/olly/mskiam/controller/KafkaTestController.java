package it.olly.mskiam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(path = "/kafka")
public class KafkaTestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping(path = "test")
    public ResponseEntity<String> test(@RequestParam(required = true) String msg) {
        logger.debug("kafka controller test: " + msg);
        streamBridge.send("test.q", msg);
        return ResponseEntity.ok("msg sent on test.q");
    }

}
