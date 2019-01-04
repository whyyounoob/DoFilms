package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.GenreDTO;
import by.bsuir.borodin.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface GenreMapper {
  @Mappings({@Mapping(target = "name", source = "entity.name")})
  GenreDTO genreToGenreDTO(Genre entity);

  @Mappings({@Mapping(target = "name", source = "dto.name")})
  Genre genreDTOToGenre(GenreDTO dto);

  List<GenreDTO> listGenreToListGenreDTO(List<Genre> list);
}
