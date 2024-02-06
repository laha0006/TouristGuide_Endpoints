package dev.tolana.touristguide_endpoints.service;

import dev.tolana.touristguide_endpoints.model.TouristAttraction;
import dev.tolana.touristguide_endpoints.repository.TouristRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAll() {
        return repository.getAll();
    }

    public TouristAttraction getAttraction(String name) {
        return repository.getAttraction(name);
    }
}
