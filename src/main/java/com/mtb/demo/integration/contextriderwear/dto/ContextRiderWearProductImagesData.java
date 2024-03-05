package com.mtb.demo.integration.contextriderwear.dto;

import java.util.Date;

public record ContextRiderWearProductImagesData(
    long id,
    long product_id,
    boolean isThumbnail,
    int sortOrder,
    String description,
    String imageFile,
    String urlZoom,
    String urlStandard,
    String urlThumbnail,
    String urlTiny,
    Date dateModified
) {
}
