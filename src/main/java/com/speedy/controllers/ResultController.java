package com.speedy.controllers;

import com.speedy.dto.ResultDTO;
import com.speedy.entities.Result;
import com.speedy.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/result/{link}")
    public ResponseEntity<Map<String, Object>> getResult(@PathVariable String link) {
        return resultService.findByLink(link)
                .map(link1 -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("downloadMbps", link1.getDownloadMbps());
                    response.put("latencyMs", link1.getLatencyMs());
                    response.put("country", link1.getCountry());
                    response.put("server", link1.getServer());

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResultDTO createResult(@RequestParam int downloadMbps, @RequestParam int latencyMs, @RequestParam String country, @RequestParam String server) {
        Result link = resultService.create(downloadMbps, latencyMs, country, server);

        return new ResultDTO(link.getLink(), link.getDownloadMbps(), link.getLatencyMs(), link.getCountry(), link.getServer());
    }
}
