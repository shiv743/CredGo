package com.example.credGo.service;

import com.example.credGo.model.Card;
import com.example.credGo.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    // Get all cards
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Get cards by category
    public List<Card> getCardsByCategory(String category) {
        return cardRepository.findByCategory(category);
    }

    // ✅ Search cards by name (used by controller)
    public List<Card> searchCardByName(String name) {
        return cardRepository.findByNameContainingIgnoreCase(name);
    }

    // Add a new card
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getFeaturedCards() {
        return cardRepository.findByFeaturedTrue();
    }

}
