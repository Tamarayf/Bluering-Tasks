package com.example.task1bluering;



import com.example.task1bluering.Mapper.UsersMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MapperConfig {

    @Bean
    public UsersMapper usersMapper() {
        return Mappers.getMapper(UsersMapper.class);
    }
}
