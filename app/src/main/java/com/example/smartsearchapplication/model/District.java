
package com.example.smartsearchapplication.model;

@SuppressWarnings("unused")
public class District {

    private Long id;
    private Double lat;
    private Double lng;
     private String name;

    private Long sortOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

}
