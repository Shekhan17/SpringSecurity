package com.sample.security.utils.converter;

import com.sample.security.model.dto.BaseDto;
import com.sample.security.model.dto.User.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class Converter {

    private ModelMapper mapper;

    public Converter() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public <Original, Converted> Converted convert(Original entity, Class<Converted> clazz) {
        return Objects.isNull(entity) ? null
                : mapper.map(entity, clazz);
    }


}
