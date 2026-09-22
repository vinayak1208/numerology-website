package org.example.Numerology.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Numerology.model.NumerologyResult;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class NumerologyService {

    private final Map<String, NumerologyData> numerologyData;

    public NumerologyService(ObjectMapper objectMapper) throws IOException {

        ClassPathResource resource =
                new ClassPathResource("destiny-numbers.json");

        try (InputStream inputStream = resource.getInputStream()) {

            numerologyData = objectMapper.readValue(
                    inputStream,
                    new TypeReference<Map<String, NumerologyData>>() {
                    }
            );
        }
    }

    public NumerologyResult calculate(String name) {

        int destiny = calculateNumber(name);

        /*
         * Get the information for the calculated
         * Destiny Number from destiny-numbers.json
         */
        NumerologyData data =
                numerologyData.get(String.valueOf(destiny));

        NumerologyResult result = new NumerologyResult();

        result.setName(name);
        result.setDestinyNumber(destiny);

        if (data != null) {

            result.setRulingPlanet(
                    data.getRulingPlanet()
            );

            result.setContributingPlanets(
                    data.getContributingPlanets()
            );

            result.setDescription(
                    data.getDescription()
            );

            result.setBusinessDescription(
                    data.getBusinessDescription()
            );
        }

        return result;
    }

    private int calculateNumber(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            total += getValue(ch);
        }

        return total;
    }

    private int calculateVowels(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            if ("AEIOU".indexOf(ch) >= 0) {

                total += getValue(ch);
            }
        }

        return total;
    }

    private int calculateConsonants(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            if (Character.isLetter(ch)
                    && "AEIOU".indexOf(ch) < 0) {

                total += getValue(ch);
            }
        }

        return total;
    }

    private int getValue(char ch) {

        return switch (ch) {

            case 'A', 'I', 'J', 'Q', 'Y' -> 1;

            case 'B', 'K', 'R' -> 2;

            case 'C', 'G', 'L', 'S' -> 3;

            case 'D', 'M', 'T' -> 4;

            case 'E', 'H', 'N', 'X' -> 5;

            case 'U', 'V', 'W' -> 6;

            case 'O', 'Z' -> 7;

            case 'F', 'P' -> 8;

            default -> 0;
        };
    }

    private int reduceNumber(int number) {

        while (number > 9) {

            int sum = 0;

            while (number > 0) {

                sum += number % 10;

                number /= 10;
            }

            number = sum;
        }

        return number;
    }

    /*
     * Represents one entry from destiny-numbers.json
     */
    public static class NumerologyData {

        private String rulingPlanet;
        private String contributingPlanets;
        private String description;
        private String businessDescription;

        public String getRulingPlanet() {
            return rulingPlanet;
        }

        public void setRulingPlanet(String rulingPlanet) {
            this.rulingPlanet = rulingPlanet;
        }

        public String getContributingPlanets() {
            return contributingPlanets;
        }

        public void setContributingPlanets(String contributingPlanets) {
            this.contributingPlanets = contributingPlanets;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getBusinessDescription() {
            return businessDescription;
        }

        public void setBusinessDescription(String businessDescription) {
            this.businessDescription = businessDescription;
        }
    }
}