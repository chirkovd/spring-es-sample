package com.dipegroup.sample.models;

import com.dipegroup.spring.es.models.objects.DbModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: spring-es-sample
 * Description:
 * Date: 5/25/2017
 *
 * @author Dmitriy_Chirkov
 * @since 1.8
 */
@Document(collection = MongoShopItem.COLLECTION_NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MongoShopItem implements DbModel<Long> {

    public static final String COLLECTION_NAME = "shop-items";

    @Id
    private Long id;

    @NotNull
    @Size(min = 3)
    private String name;

    @Size(max = 300)
    private String description;

    @Size(max = 300)
    private String comment;

    @NotNull
    private String type;

    private List<String> sizes = new ArrayList<>();
    private List<String> colors = new ArrayList<>();

    private String price;
    private String discount;

    private String mainPhoto;
    private List<String> secondaryPhotos = new ArrayList<>();

    /**
     * Is set manually
     * */
    private String createdBy;

    /**
     * Is set manually
     * */
    private LocalDate created;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private LocalDate modified;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public List<String> getSecondaryPhotos() {
        return secondaryPhotos;
    }

    public void setSecondaryPhotos(List<String> secondaryPhotos) {
        this.secondaryPhotos = secondaryPhotos;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
