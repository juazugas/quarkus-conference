package org.acme.conference.speaker;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Speaker
 */
@Entity
public class Speaker extends PanacheEntity {

    private String uuid;

    private String nameFirst;
    private String nameLast;
    private String organization;
    private String biography;
    private String picture;
    private String twitterHandle;

    @Transient
    private Map<String, String> links = new HashMap<>();
    
    public String getUuid() {
      return uuid;
    }
    public void setUuid(String uuid) {
      this.uuid = uuid;
    }

    public String getOrganization() {
      return organization;
    }
    public void setOrganization(String organization) {
      this.organization = organization;
    }

    public String getNameFirst() {
      return nameFirst;
    }
    public void setNameFirst(String nameFirst) {
      this.nameFirst = nameFirst;
    }

    public String getNameLast() {
      return nameLast;
    }
    public void setNameLast(String nameLast) {
      this.nameLast = nameLast;
    }

    public Map<String, String> getLinks() {
      return links;
    }
    public void setLinks(Map<String, String> links) {
      this.links = links;
    }
    public String addLink(String name, String uri) {
      return this.links.put(name, uri);
    }
    public String removeLink(String name) {
      return this.links.remove(name);
    }

    public void setBiography(String biography) {
      this.biography = biography;
    }
    public String getBiography() {
      return biography;
    }

    public String getPicture() {
      return picture;
    }
    public void setPicture(String picture) {
      this.picture = picture;
    }

    public String getTwitterHandle() {
      return twitterHandle;
    }
    public void setTwitterHandle(String twitterHandle) {
      this.twitterHandle = twitterHandle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append("[");
        sb.append("<").append(id).append(">");
        sb.append(",");
        sb.append("nameFirst=").append(nameFirst);
        sb.append(",");
        sb.append("nameLast=").append(nameLast);
        sb.append("]");
        return sb.toString();
    }
}