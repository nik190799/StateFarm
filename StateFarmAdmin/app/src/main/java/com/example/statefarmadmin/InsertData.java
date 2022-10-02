package com.example.statefarmadmin;

public class InsertData {

    String insuranceName;
    String description;

    String link;

    public InsertData(String insuranceName, String description, String link) {
        this.insuranceName = insuranceName;
        this.description = description;
        this.link = link;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
