package com.speedy.controllers;

import com.speedy.dto.ResultDTO;
import com.speedy.entities.Result;
import com.speedy.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/result/{link}")
    public ResponseEntity<HashMap<String, Integer>> getResult(@PathVariable String link) {
        return resultService.findByLink(link)
                .map(link1 -> {
                    HashMap<String, Integer> response = new HashMap<>();
                    response.put("downloadMbps", link1.getDownloadMbps());
                    response.put("latencyMs", link1.getLatencyMs());

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResultDTO createResult(@RequestParam int downloadMbps, @RequestParam int latencyMs) {
        Result link = resultService.create(downloadMbps, latencyMs);

        return new ResultDTO(link.getLink(), link.getDownloadMbps(), link.getLatencyMs());
    }
}
