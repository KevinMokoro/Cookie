
package com.moringaschool.cookie;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class MyEdamamRecipeSearchResponse {

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MyEdamamRecipeSearchResponse() {
    }

    /**
     * 
     * @param hits
     * @param count
     * @param from
     * @param links
     * @param to
     */
    public MyEdamamRecipeSearchResponse(Integer from, Integer to, Integer count, Links links, List<Hit> hits) {
        super();
        this.from = from;
        this.to = to;
        this.count = count;
        this.links = links;
        this.hits = hits;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
