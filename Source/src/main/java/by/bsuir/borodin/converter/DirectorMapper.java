package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.DirectorDTO;
import by.bsuir.borodin.entity.Director;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface DirectorMapper {
  @Mappings({@Mapping(target = "name", source = "entity.name")})
  DirectorDTO directorToDirectorDTO(Director entity);

  @Mappings({@Mapping(target = "name", source = "dto.name")})
  Director directorDTOToDirector(DirectorDTO dto);

  List<DirectorDTO> listDirectorToListDirectorDTO(List<Director> list);
}
