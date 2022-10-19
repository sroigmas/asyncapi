package com.asyncapi.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Objects;


public class AnonymousSchema1 {
    
    private @Valid Integer id;
    
    private @Valid Integer lumens;
    
    private @Valid java.time.OffsetDateTime sentAt;
    

    

    /**
     * Id of the streetlight.
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    /**
     * Light intensity measured in lumens.
     */
    @JsonProperty("lumens")
    public Integer getLumens() {
        return lumens;
    }

    public void setLumens(Integer lumens) {
        this.lumens = lumens;
    }
    

    /**
     * Date and time when the message was sent.
     */
    @JsonProperty("sentAt")
    public java.time.OffsetDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(java.time.OffsetDateTime sentAt) {
        this.sentAt = sentAt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnonymousSchema1 anonymousSchema1 = (AnonymousSchema1) o;
        return 
            Objects.equals(this.id, anonymousSchema1.id) &&
            Objects.equals(this.lumens, anonymousSchema1.lumens) &&
            Objects.equals(this.sentAt, anonymousSchema1.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lumens, sentAt);
    }

    @Override
    public String toString() {
        return "class AnonymousSchema1 {\n" +
        
                "    id: " + toIndentedString(id) + "\n" +
                "    lumens: " + toIndentedString(lumens) + "\n" +
                "    sentAt: " + toIndentedString(sentAt) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
           return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}