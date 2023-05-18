package com.scores365.entitys;

import java.io.Serializable;
import java.util.Date;
/* loaded from: classes2.dex */
public class VenueObj implements Serializable {
    @p9.c("GMapsPlaceID")
    public String GMapsPlaceID;
    @p9.c("Location")
    public LocationObj location;
    @p9.c("Opened")
    public Date venueBirthdate;
    @p9.c("Capacity")
    public int venueCapacity;
    @p9.c("ID")
    public int venueId;
    @p9.c("Name")
    public String venueName;
    @p9.c("Website")
    public String venueWebsite = "";
}
