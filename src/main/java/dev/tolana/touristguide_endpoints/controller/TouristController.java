package dev.tolana.touristguide_endpoints.controller;

import dev.tolana.touristguide_endpoints.model.TouristAttraction;
import dev.tolana.touristguide_endpoints.service.TouristService;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> attractions = touristService.getAll();
        return new ResponseEntity<>(attractions, HttpStatus.OK);

    }
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttraction(name);
        return new ResponseEntity<>(attraction,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addMessage(@RequestBody TouristAttraction attraction) {
        TouristAttraction returnAttraction = touristService.addAttraction(attraction);
        return new ResponseEntity<>(returnAttraction,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction returnAttraction = touristService.updateAttraction(attraction);
        if(returnAttraction != null) {
            return new ResponseEntity<>(returnAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new TouristAttraction("DID NOT UPDATE","CHECK NAME SPELLING"), HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction returnAttraction = touristService.deleteAttraction(name);
        return new ResponseEntity<>(returnAttraction,HttpStatus.OK);
    }
}
