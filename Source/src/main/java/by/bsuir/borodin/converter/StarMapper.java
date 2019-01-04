package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.GenreDTO;
import by.bsuir.borodin.dto.StarDTO;
import by.bsuir.borodin.entity.Genre;
import by.bsuir.borodin.entity.Star;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface StarMapper {
    @Mappings({@Mapping(target = "name", source = "entity.name")})
    StarDTO starToStarDTO(Star entity);

    @Mappings({@Mapping(target = "name", source = "dto.name")})
    Star starDTOToStar(StarDTO dto);

    List<StarDTO> listStarToListStarDTO(List<Star> list);
}
