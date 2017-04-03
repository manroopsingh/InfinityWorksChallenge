
package com.example.singh.infinityworkschallenge.model.authorities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Authority implements Serializable{

    @SerializedName("LocalAuthorityId")
    @Expose
    private Integer localAuthorityId;
    @SerializedName("LocalAuthorityIdCode")
    @Expose
    private String localAuthorityIdCode;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FriendlyName")
    @Expose
    private String friendlyName;
    @SerializedName("Url")
    @Expose
    private String url;
    @SerializedName("SchemeUrl")
    @Expose
    private String schemeUrl;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("RegionName")
    @Expose
    private String regionName;
    @SerializedName("FileName")
    @Expose
    private String fileName;
    @SerializedName("FileNameWelsh")
    @Expose
    private String fileNameWelsh;
    @SerializedName("EstablishmentCount")
    @Expose
    private Integer establishmentCount;
    @SerializedName("CreationDate")
    @Expose
    private String creationDate;
    @SerializedName("LastPublishedDate")
    @Expose
    private String lastPublishedDate;
    @SerializedName("SchemeType")
    @Expose
    private Integer schemeType;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    public Integer getLocalAuthorityId() {
        return localAuthorityId;
    }

    public void setLocalAuthorityId(Integer localAuthorityId) {
        this.localAuthorityId = localAuthorityId;
    }

    public String getLocalAuthorityIdCode() {
        return localAuthorityIdCode;
    }

    public void setLocalAuthorityIdCode(String localAuthorityIdCode) {
        this.localAuthorityIdCode = localAuthorityIdCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSchemeUrl() {
        return schemeUrl;
    }

    public void setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameWelsh() {
        return fileNameWelsh;
    }

    public void setFileNameWelsh(String fileNameWelsh) {
        this.fileNameWelsh = fileNameWelsh;
    }

    public Integer getEstablishmentCount() {
        return establishmentCount;
    }

    public void setEstablishmentCount(Integer establishmentCount) {
        this.establishmentCount = establishmentCount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastPublishedDate() {
        return lastPublishedDate;
    }

    public void setLastPublishedDate(String lastPublishedDate) {
        this.lastPublishedDate = lastPublishedDate;
    }

    public Integer getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(Integer schemeType) {
        this.schemeType = schemeType;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
