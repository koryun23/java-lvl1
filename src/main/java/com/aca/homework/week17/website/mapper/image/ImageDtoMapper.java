package com.aca.homework.week17.website.mapper.image;

import com.aca.homework.week17.website.entity.Image;
import com.aca.homework.week17.website.facade.post.dto.ImageDto;
import com.aca.homework.week17.website.mapper.Mapper;

public interface ImageDtoMapper extends Mapper<Image, ImageDto> {
    ImageDto apply(Image image);
}
