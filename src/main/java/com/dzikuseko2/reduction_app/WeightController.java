package com.dzikuseko2.reduction_app;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/weights")
public class WeightController {

    private final WeightRepository weightRepository;

    WeightController(final WeightRepository weightRepository) {
        this.weightRepository = weightRepository;
    }

    @GetMapping
    String showWeights(Model model){
        model.addAttribute("weight", new Weight());
        return "weights";
    }
    @PostMapping
    String addWeight(@ModelAttribute("weight") Weight current, Model model, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateWeight){
        weightRepository.save(current);
        model.addAttribute("weight", new Weight());
        model.addAttribute("message", "Dodano wpis");
        return "weights";
    }


    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Weight> addWeight(@RequestBody Weight bodyWeightToAdd) {
        Weight bodyWeightAdded = weightRepository.save(bodyWeightToAdd);

        return ResponseEntity.created(URI.create("/" + bodyWeightAdded.getId())).body(bodyWeightAdded);
        //wyświetli dodany wpis z wagą
    }
    @GetMapping("/all")
    ResponseEntity<List<Weight>>readAllWeights(Pageable page){
        return ResponseEntity.ok(weightRepository.findAll(page).getContent());
    }
    @GetMapping("/{id}")
    ResponseEntity<Weight>readWeightById(@PathVariable int id){
        return weightRepository.findAllById(id).map(weight -> ResponseEntity.ok(weight)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<?>updateWeight(@PathVariable int id, @RequestBody Weight toUpdate){
        if(!weightRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        weightRepository.findById(id).ifPresent(weight -> {weight.updatedFrom(toUpdate);
        weightRepository.save(weight);
        });
        return ResponseEntity.noContent().build();
    }
    @ModelAttribute("weights")
    List<Weight> getWeights(){
        return weightRepository.findAll();
    }
}
