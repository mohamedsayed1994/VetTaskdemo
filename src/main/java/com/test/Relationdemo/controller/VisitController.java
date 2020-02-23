package com.test.Relationdemo.controller;

import com.test.Relationdemo.entity.Visit;
import com.test.Relationdemo.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/visits")
@RestController
public class VisitController {
    private final VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<Visit> findAllVisit() {
        return visitService.findAll();
    }

    @GetMapping("{id}")
    public Visit findVisitById(@PathVariable Long id) {
        return visitService.findById(id);
    }

    @PostMapping
    public Visit addPet(@RequestBody Visit visit) {
        visitService.saveVisit(visit);
        return visit;
    }

    @PutMapping
    public Visit updatePet(@RequestBody Visit visit) {
        visitService.saveVisit(visit);
        return visit;
    }
}
