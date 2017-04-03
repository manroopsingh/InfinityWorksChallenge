
package com.example.singh.infinityworkschallenge.model.establishments;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Establishments {

    @SerializedName("establishments")
    @Expose
    private List<Establishment> establishments = null;
    @SerializedName("meta")
    @Expose
    private Meta_ meta;
    @SerializedName("links")
    @Expose
    private List<Link_> links = null;

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

    public Meta_ getMeta() {
        return meta;
    }

    public void setMeta(Meta_ meta) {
        this.meta = meta;
    }

    public List<Link_> getLinks() {
        return links;
    }

    public void setLinks(List<Link_> links) {
        this.links = links;
    }

}
