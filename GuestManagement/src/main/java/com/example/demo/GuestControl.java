package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/guest")
public class GuestControl {
	@Autowired
    private GuestService guestService;
	 @GetMapping
	    public List<GuestEntity> getAllProducts() {
	        return guestService.getAllProducts();
	 }
	 @GetMapping("/{id}")
	    public ResponseEntity<GuestEntity> getProductById(@PathVariable int id) {
	        Optional<GuestEntity> product = guestService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }

	 
	@PostMapping
    public ResponseEntity<GuestEntity> addGuest(@RequestBody GuestEntity guestt) {
        return new ResponseEntity<>(guestService.addGuest(guestt), HttpStatus.CREATED);
    }
	@PutMapping("/{id}")
    public ResponseEntity<GuestEntity> updateGuestt(@PathVariable int id, @RequestBody GuestEntity guestt) {
        return new ResponseEntity<>(guestService.updateGuestt(id,guestt ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuestt(@PathVariable int id) {
    	guestService.deleteGuestt(id);
        return ResponseEntity.noContent().build();
    }

}
