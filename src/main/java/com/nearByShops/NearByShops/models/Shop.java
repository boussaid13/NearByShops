package com.nearByShops.NearByShops.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="shops")
public class Shop {

    @Id
    private String id;
    private String picture;
    private String name;
    private String email;
    private String city;

    @GeoSpatialIndexed(type=GeoSpatialIndexType.GEO_2DSPHERE)
    private Location location;

    private Boolean isLiked;

    private Date shownAfter;


    public Shop() {
        super();
    }

    public String getId() {
        return id;
    }


    public String getPicture() {
        return picture;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getCity() {
        return city;
    }


    public Location getLocation() {
        return location;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }


    public Date getShownAfter() {
        return shownAfter;
    }

    public void setShownAfter(Date shownAfter) {
        this.shownAfter = shownAfter;
    }

}