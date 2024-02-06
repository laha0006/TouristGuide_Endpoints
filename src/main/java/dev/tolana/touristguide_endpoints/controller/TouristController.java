package dev.tolana.touristguide_endpoints.controller;

import dev.tolana.touristguide_endpoints.model.TouristAttraction;
import dev.tolana.touristguide_endpoints.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> attractions = touristService.getAll();
        return new ResponseEntity<>(attractions, HttpStatus.OK);

    }
    @GetMapping("/attractions/{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttraction(name);
        return new ResponseEntity<>(attraction,HttpStatus.OK);
    }

//    @PostMapping("/attractions/add");
//    @PostMapping("/attractions/update");
//    @GetMapping("/attractions/delete/{name}");
}
