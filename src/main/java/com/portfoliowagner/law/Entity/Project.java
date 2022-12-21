
package com.portfoliowagner.law.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreP;
    @NotNull
    private String descriptionP;
    @NotNull
    private String imgP;
    private String urlP;
    @NotNull
    private String githubP;
    
    public Project(){
        
    }

    public Project(String nombreP, String descriptionP, String imgP, String urlP, String githubP) {
        this.nombreP = nombreP;
        this.descriptionP = descriptionP;
        this.imgP = imgP;
        this.urlP = urlP;
        this.githubP = githubP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getGithubP() {
        return githubP;
    }

    public void setGithubP(String githubP) {
        this.githubP = githubP;
    }
    
}
