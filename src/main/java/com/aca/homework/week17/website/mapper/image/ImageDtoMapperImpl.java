package com.aca.homework.week17.website.mapper.image;


import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;

public class ImageDtoMapperImpl implements ImageDtoMapper {

    @Override
    public ImageDto apply(Image value) {
        return new ImageDto(value.getBlobId());
    }
}
