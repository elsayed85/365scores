package com.scores365.entitys;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class ImageSources {
    @p9.c("ImageFetchURL")
    public String imageFetchUrl = "";
    @p9.c("FaceRecognitionImageFetchURL")
    public String faceRecognitionImageFetchUrl = "";
    @p9.c("EntitiesVersionedImageURL")
    public String entitiesVersionUrl = "";
    @p9.c("EntitiesVersionedRoundImageURL")
    public String entitiesVersionRoundUrl = "";
    @p9.c("EntitiesTransparentBackgroundImageURL")
    public String entitiesTransparentBackgroundImageURL = "";
    @p9.c("EntitiesVersionedFillCropImageURL")
    public String entitiesVersionedFillCropImageURL = "";
    @p9.c("EntitiesVersionedImageWithOverlayURL")
    public String entitiesVersionedImageWithOverlayURL = "";
    @p9.c("Types")
    public HashMap<String, ImageSourcesType> sourcesType = null;

    public String getEntitiesTransparentBackgroundImageURL() {
        return this.entitiesTransparentBackgroundImageURL;
    }

    public String getEntitiesVersionRoundUrl() {
        return this.entitiesVersionRoundUrl;
    }

    public String getEntitiesVersionUrl() {
        return this.entitiesVersionUrl;
    }

    public String getEntitiesVersionedFillCropImageURL() {
        return this.entitiesVersionedFillCropImageURL;
    }

    public String getEntitiesVersionedImageWithOverlayURL() {
        return this.entitiesVersionedImageWithOverlayURL;
    }

    public String getFaceRecognitionImageFetchUrl() {
        return this.faceRecognitionImageFetchUrl;
    }

    public String getImageFetchUrl() {
        return this.imageFetchUrl;
    }

    public HashMap<String, ImageSourcesType> getSourcesType() {
        return this.sourcesType;
    }
}
