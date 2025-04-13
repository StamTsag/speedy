package com.speedy.services;

import com.speedy.entities.Result;
import com.speedy.repositories.ResultRepository;
import com.speedy.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public Result create(int downloadMbps, int latencyMs, String country, String server) {
        String code;

        // Avoid duplicates
        do {
            code = Utils.generateCode();
        } while (resultRepository.findByLink(code) != null);

        Result link = new Result();
        link.setLink(code);
        link.setDownloadMbps(downloadMbps);
        link.setLatency(latencyMs);
        link.setCountry(country);
        link.setServer(server);

        return resultRepository.save(link);
    }

    public Optional<Result> findByLink(String link) {
        return Optional.ofNullable(resultRepository.findByLink(link));
    }
}
