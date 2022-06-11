
package com.moringaschool.cookie.models;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.cookie.models.Hit;
//import com.moringaschool.cookie.models.Links;

//@Generated("jsonschema2pojo")
public class MyEdamamRecipeSearchResponse {

    @SerializedName("from")
    @Expose
    private Double from;
    @SerializedName("to")
    @Expose
    private Double to;
    @SerializedName("count")
    @Expose
    private Double count;
 //   @SerializedName("_links")
 //   @Expose
  //  private Links links;
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
     * @param to
     */
    public MyEdamamRecipeSearchResponse(Double from, Double to, Double count, List<Hit> hits) {
        super();
        this.from = from;
        this.to = to;
        this.count = count;
        this.hits = hits;
    }

    public Double getFrom() {
        return from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }

    public Double getTo() {
        return to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
