package com.auraai.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RecommendationService {

    /**
     * Merr rekomandime bazuar në llojin e aromës (scentType).
     * @param scentType Lloji i aromës së kërkuar nga përdoruesi.
     * @return Një listë me rekomandime për parfume.
     */
    public List<String> getRecommendations(String scentType) {
        if (scentType == null || scentType.isEmpty()) {
            return Arrays.asList("Ju lutem, specifikoni një lloj arome për të marrë rekomandime.");
        }

        // Shembull rekomandimesh bazuar në llojin e aromës (scentType)
        switch (scentType.toLowerCase()) {
            case "floral":
                return Arrays.asList("Rose Perfume", "Jasmine Delight", "Lily Essence");
            case "woody":
                return Arrays.asList("Cedarwood Classic", "Sandalwood Touch", "Oak Mystique");
            case "fruity":
                return Arrays.asList("Citrus Burst", "Tropical Passion", "Berry Bliss");
            case "fresh":
                return Arrays.asList("Ocean Breeze", "Cool Mint", "Morning Dew");
            case "spicy":
                return Arrays.asList("Cinnamon Spice", "Oriental Touch", "Cardamom Intense");
            case "sweet":
                return Arrays.asList("Vanilla Dream", "Sugar Bliss", "Honey Glow");
            default:
                return Arrays.asList("Nuk ka rekomandime për këtë kategori. Ju lutem provoni një kategori tjetër si 'floral', 'woody', 'fruity', etj.");
        }
    }
}
