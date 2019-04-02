package id.eudeka.resepmami.model;

public class SampleRecipe {

    private String thumbnail;
    private String categoryName;
    private String recipeName;

    public SampleRecipe(String thumbnail, String categoryName, String recipeName) {
        this.thumbnail = thumbnail;
        this.categoryName = categoryName;
        this.recipeName = recipeName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public String toString() {
        return "SampleRecipe{" +
                "thumbnail='" + thumbnail + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", recipeName='" + recipeName + '\'' +
                '}';
    }
}
