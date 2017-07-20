package com.dipegroup.sample.models;

import com.dipegroup.spring.es.models.objects.OriginalModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class ShopItem implements OriginalModel<Long> {

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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getKey() {
        return name;
    }

    public String getName() {
        return name;
    }
}
