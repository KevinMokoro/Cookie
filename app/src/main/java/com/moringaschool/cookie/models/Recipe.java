
package com.moringaschool.cookie.models;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class Recipe {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("image")
    @Expose
    private String image;
//    @SerializedName("images")
//    @Expose
//    private Images images;
//    @SerializedName("source")
//    @Expose
//    private String source;
      @SerializedName("url")
      @Expose
      private String url;
//    @SerializedName("shareAs")
//    @Expose
//    private String shareAs;
//    @SerializedName("yield")
//    @Expose
//    private Double yield;
//    @SerializedName("dietLabels")
//    @Expose
//    private List<String> dietLabels = null;
//    @SerializedName("healthLabels")
//    @Expose
//    private List<String> healthLabels = null;
//    @SerializedName("cautions")
//    @Expose
//    private List<String> cautions = null;
//    @SerializedName("ingredientLines")
//    @Expose
//    private List<String> ingredientLines = null;
//    @SerializedName("ingredients")
//    @Expose
//    private List<Ingredient> ingredients = null;
//    @SerializedName("calories")
//    @Expose
//    private Double calories;
//    @SerializedName("glycemicIndex")
//    @Expose
//    private Double glycemicIndex;
//    @SerializedName("totalCO2Emissions")
//    @Expose
//    private Double totalCO2Emissions;
//    @SerializedName("co2EmissionsClass")
//    @Expose
//    private String co2EmissionsClass;
//    @SerializedName("totalWeight")
//    @Expose
//    private Double totalWeight;
//    @SerializedName("cuisineType")
//    @Expose
//    private List<String> cuisineType = null;
//    @SerializedName("mealType")
//    @Expose
//    private List<String> mealType = null;
//    @SerializedName("dishType")
//    @Expose
//    private List<String> dishType = null;
//    @SerializedName("totalNutrients")
//    @Expose
//    private TotalNutrients totalNutrients;
//    @SerializedName("totalDaily")
//    @Expose
//    private TotalDaily totalDaily;
//    @SerializedName("digest")
//    @Expose
//    private List<Digest> digest = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param image
     * @param label
//     * @param source
//     * @param calories
//     * @param totalCO2Emissions
//     * @param cuisineType
//     * @param uri
     * @param url
//     * @param totalNutrients
//     * @param dietLabels
//     * @param dishType
//     * @param yield
//     * @param totalWeight
//     * @param digest
//     * @param ingredients
//     * @param totalDaily
//     * @param ingredientLines
//     * @param glycemicIndex
//     */
    public Recipe(String uri, String label, String image, String url) {
        super();
        this.uri = uri;
        this.label = label;
        this.image = image;
        this.url = url;

    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }













}
