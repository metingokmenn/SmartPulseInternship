package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;

public class Trade {
    private String resultCode;
    private String resultDescription;
    private Body body;

    @JsonProperty("resultCode")
    public String getResultCode() { return resultCode; }
    @JsonProperty("resultCode")
    public void setResultCode(String value) { this.resultCode = value; }

    @JsonProperty("resultDescription")
    public String getResultDescription() { return resultDescription; }
    @JsonProperty("resultDescription")
    public void setResultDescription(String value) { this.resultDescription = value; }

    @JsonProperty("body")
    public Body getBody() { return body; }
    @JsonProperty("body")
    public void setBody(Body value) { this.body = value; }


}
