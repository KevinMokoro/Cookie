
package com.moringaschool.cookie;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
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
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shareAs")
    @Expose
    private String shareAs;
    @SerializedName("yield")
    @Expose
    private Integer yield;
    @SerializedName("dietLabels")
    @Expose
    private List<String> dietLabels = null;
    @SerializedName("healthLabels")
    @Expose
    private List<String> healthLabels = null;
    @SerializedName("cautions")
    @Expose
    private List<String> cautions = null;
    @SerializedName("ingredientLines")
    @Expose
    private List<String> ingredientLines = null;
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = null;
    @SerializedName("calories")
    @Expose
    private Integer calories;
    @SerializedName("glycemicIndex")
    @Expose
    private Integer glycemicIndex;
    @SerializedName("totalCO2Emissions")
    @Expose
    private Integer totalCO2Emissions;
    @SerializedName("co2EmissionsClass")
    @Expose
    private String co2EmissionsClass;
    @SerializedName("totalWeight")
    @Expose
    private Integer totalWeight;
    @SerializedName("cuisineType")
    @Expose
    private List<String> cuisineType = null;
    @SerializedName("mealType")
    @Expose
    private List<String> mealType = null;
    @SerializedName("dishType")
    @Expose
    private List<String> dishType = null;
    @SerializedName("totalNutrients")
    @Expose
    private TotalNutrients totalNutrients;
    @SerializedName("totalDaily")
    @Expose
    private TotalDaily totalDaily;
    @SerializedName("digest")
    @Expose
    private List<Digest> digest = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipe() {
    }

    /**
     * 
     * @param image
     * @param shareAs
     * @param images
     * @param cautions
     * @param healthLabels
     * @param co2EmissionsClass
     * @param mealType
     * @param label
     * @param source
     * @param calories
     * @param totalCO2Emissions
     * @param cuisineType
     * @param uri
     * @param url
     * @param totalNutrients
     * @param dietLabels
     * @param dishType
     * @param yield
     * @param totalWeight
     * @param digest
     * @param ingredients
     * @param totalDaily
     * @param ingredientLines
     * @param glycemicIndex
     */
    public Recipe(String uri, String label, String image, Images images, String source, String url, String shareAs, Integer yield, List<String> dietLabels, List<String> healthLabels, List<String> cautions, List<String> ingredientLines, List<Ingredient> ingredients, Integer calories, Integer glycemicIndex, Integer totalCO2Emissions, String co2EmissionsClass, Integer totalWeight, List<String> cuisineType, List<String> mealType, List<String> dishType, TotalNutrients totalNutrients, TotalDaily totalDaily, List<Digest> digest) {
        super();
        this.uri = uri;
        this.label = label;
        this.image = image;
        this.images = images;
        this.source = source;
        this.url = url;
        this.shareAs = shareAs;
        this.yield = yield;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.cautions = cautions;
        this.ingredientLines = ingredientLines;
        this.ingredients = ingredients;
        this.calories = calories;
        this.glycemicIndex = glycemicIndex;
        this.totalCO2Emissions = totalCO2Emissions;
        this.co2EmissionsClass = co2EmissionsClass;
        this.totalWeight = totalWeight;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.dishType = dishType;
        this.totalNutrients = totalNutrients;
        this.totalDaily = totalDaily;
        this.digest = digest;
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

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareAs() {
        return shareAs;
    }

    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }

    public Integer getYield() {
        return yield;
    }

    public void setYield(Integer yield) {
        this.yield = yield;
    }

    public List<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public List<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public List<String> getCautions() {
        return cautions;
    }

    public void setCautions(List<String> cautions) {
        this.cautions = cautions;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(Integer glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public Integer getTotalCO2Emissions() {
        return totalCO2Emissions;
    }

    public void setTotalCO2Emissions(Integer totalCO2Emissions) {
        this.totalCO2Emissions = totalCO2Emissions;
    }

    public String getCo2EmissionsClass() {
        return co2EmissionsClass;
    }

    public void setCo2EmissionsClass(String co2EmissionsClass) {
        this.co2EmissionsClass = co2EmissionsClass;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<String> getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(List<String> cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<String> getMealType() {
        return mealType;
    }

    public void setMealType(List<String> mealType) {
        this.mealType = mealType;
    }

    public List<String> getDishType() {
        return dishType;
    }

    public void setDishType(List<String> dishType) {
        this.dishType = dishType;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public List<Digest> getDigest() {
        return digest;
    }

    public void setDigest(List<Digest> digest) {
        this.digest = digest;
    }

}
