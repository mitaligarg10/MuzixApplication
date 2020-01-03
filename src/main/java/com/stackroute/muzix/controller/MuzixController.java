package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Muzix;
import com.stackroute.muzix.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MuzixController {
    ResponseEntity responseEntity;
    MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) {
        try {
            muzixService.saveMuzix(muzix);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("muzix")
    public ResponseEntity<?> displayMuzix() {

        try {
            List<Muzix> listOfMuzix = muzixService.displayMuzix();
            responseEntity = new ResponseEntity<List<Muzix>>(listOfMuzix, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("muzix/{id}")
    public void removeMuzixById(@PathVariable long id) throws Exception {
        muzixService.removeMuzixById(id);
    }

    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        try {
            muzixService.UpdateMuzix(muzix);
            responseEntity = new ResponseEntity<String>("Successfully Updated", HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
