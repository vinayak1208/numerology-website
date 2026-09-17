package org.example.Numerology.model;

public class NumerologyResult {

    private String name;
    private int destinyNumber;
    private int soulUrgeNumber;
    private int personalityNumber;

    public NumerologyResult(String name,
                            int destinyNumber,
                            int soulUrgeNumber,
                            int personalityNumber) {
        this.name = name;
        this.destinyNumber = destinyNumber;
        this.soulUrgeNumber = soulUrgeNumber;
        this.personalityNumber = personalityNumber;
    }

    public String getName() {
        return name;
    }

    public int getDestinyNumber() {
        return destinyNumber;
    }

    public int getSoulUrgeNumber() {
        return soulUrgeNumber;
    }

    public int getPersonalityNumber() {
        return personalityNumber;
    }

}
