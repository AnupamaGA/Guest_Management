package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GuestService {
	@Autowired
    private GuestRepo guestrepo;
	
	public List<GuestEntity> getAllProducts() {
        return guestrepo.findAll();
	}
	public Optional<GuestEntity> getProductById(int productId) {
        return guestrepo.findById(productId);
    }
	
	
	public  GuestEntity addGuest(GuestEntity guestt) {
        return guestrepo.save(guestt);
    }
	public GuestEntity updateGuestt(int guesttId, GuestEntity guestt) {
		guestt.setGuestId(guesttId);
        return guestrepo.save(guestt);
    }

    public void deleteGuestt(int guesttId) {
    	guestrepo.deleteById(guesttId);
    }

}
