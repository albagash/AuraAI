package com.auraai.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    /**
     * Kthen përgjigjen e chatbot-it bazuar në mesazhin e përdoruesit.
     * @param userMessage Mesazhi i përdoruesit.
     * @return Një përgjigje nga chatbot-i.
     */
    public String getChatbotResponse(String userMessage) {
        if (userMessage == null || userMessage.isEmpty()) {
            return "Ju lutem, shkruani një mesazh për të marrë një përgjigje.";
        }

        // Logjika për përgjigje bazë.
        switch (userMessage.toLowerCase()) {
            case "hello":
                return "Përshëndetje! Si mund t'ju ndihmoj sot?";
            case "how are you?":
                return "Jam një chatbot dhe gjithmonë në dispozicion për ju!";
            case "recommend a perfume":
                return "Unë ju rekomandoj parfumin 'Chanel No. 5' për një aromë klasike dhe të sofistikuar.";
            case "what is the best perfume for men?":
                return "Për meshkuj, parfumi 'Bleu de Chanel' është një zgjedhje e shkëlqyer për freski dhe stil.";
            case "what is the best perfume for women?":
                return "Për femra, parfumi 'Dior J'adore' është një opsion elegant dhe i parezistueshëm.";
            case "suggest a perfume for summer":
                return "Për verë, provoni 'Dolce & Gabbana Light Blue' për një aromë freskuese dhe të lehtë.";
            case "suggest a perfume for winter":
                return "Për dimër, 'Tom Ford Black Orchid' është ideal për një aromë të ngrohtë dhe të thellë.";
            case "which perfume is budget-friendly?":
                return "Parfumi 'Nautica Voyage' është një zgjedhje e përballueshme dhe e këndshme.";
            case "what is the most luxurious perfume?":
                return "Parfumi 'Creed Aventus' është një nga më luksozët në treg, perfekt për raste speciale.";
            default:
                return "Më vjen keq, nuk e kam përgjigjen për këtë pyetje. Ju lutem, provoni të bëni një pyetje tjetër rreth parfumeve!";
        }
    }
}