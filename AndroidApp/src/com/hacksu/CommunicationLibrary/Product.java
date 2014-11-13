package com.hacksu.CommunicationLibrary;

public class Product
{
    private String mDescription;
    private Float mPrice;

    public Product(String description, Float price)
    {
        mDescription = description;
        mPrice = price;
    }

    public Float getPrice()
    {
        return mPrice;
    }

    public void setPrice(Float price)
    {
        mPrice = price;
    }

    public String getDescription()
    {
        return mDescription;
    }

    public void setDescription(String description)
    {
        mDescription = description;
    }
}
