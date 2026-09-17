package org.example.Numerology.service;

import org.example.Numerology.model.NumerologyResult;
import org.springframework.stereotype.Service;

@Service
public class NumerologyService {

    public NumerologyResult calculate(String name) {

        int destiny = calculateNumber(name);

        int soulUrge = calculateVowels(name);

        int personality = calculateConsonants(name);

        return new NumerologyResult(
                name,
                destiny,
                soulUrge,
                personality
        );
    }

    private int calculateNumber(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            total += getValue(ch);
        }

        return reduceNumber(total);
    }

    private int calculateVowels(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            if ("AEIOU".indexOf(ch) >= 0) {

                total += getValue(ch);
            }
        }

        return reduceNumber(total);
    }

    private int calculateConsonants(String name) {

        int total = 0;

        for (char ch : name.toUpperCase().toCharArray()) {

            if (Character.isLetter(ch)
                    && "AEIOU".indexOf(ch) < 0) {

                total += getValue(ch);
            }
        }

        return reduceNumber(total);
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
}