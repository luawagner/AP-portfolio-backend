
package com.portfoliowagner.law.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProject {
 @NotBlank
 private String nombreP;
 @NotBlank
 private String descriptionP;
 @NotBlank
private String imgP;

    private String urlP;
    @NotBlank
    private String githubP;

    public DtoProject() {
    }
    
    
   

    public DtoProject(String nombreP, String descriptionP, String imgP, String urlP, String githubP) {
        this.nombreP = nombreP;
        this.descriptionP = descriptionP;
        this.imgP = imgP;
        this.urlP = urlP;
        this.githubP = githubP;
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
