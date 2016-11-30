package com.dudupoo.listview;

/**
 * Created by DuDuPoo on 30/11/16.
 */

public class FlowerPOJO
{
    private String title, description;
    private int imageID;

    public FlowerPOJO(String title, String description, int imageID)
    {
        this.title = title;
        this.description = description;
        this.imageID = imageID;
    }

    @Override
    public String toString()
    {
        return "FlowerPOJO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageID=" + imageID +
                '}';
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getImageID()
    {
        return imageID;
    }

    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }
}
