package org.example.Numerology.model;

public class NumerologyResult {

    private String name;
    private int destinyNumber;

    private String rulingPlanet;
    private String contributingPlanets;
    private String description;
    private String businessDescription;

    public NumerologyResult() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDestinyNumber() {
        return destinyNumber;
    }

    public void setDestinyNumber(int destinyNumber) {
        this.destinyNumber = destinyNumber;
    }

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