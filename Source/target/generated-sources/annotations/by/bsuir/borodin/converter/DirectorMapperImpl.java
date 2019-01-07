package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.DirectorDTO;
import by.bsuir.borodin.entity.Director;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-05T16:27:21+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class DirectorMapperImpl implements DirectorMapper {

    @Override
    public DirectorDTO directorToDirectorDTO(Director entity) {
        if ( entity == null ) {
            return null;
        }

        DirectorDTO directorDTO = new DirectorDTO();

        directorDTO.setName( entity.getName() );

        return directorDTO;
    }

    @Override
    public Director directorDTOToDirector(DirectorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Director director = new Director();

        director.setName( dto.getName() );

        return director;
    }

    @Override
    public List<DirectorDTO> listDirectorToListDirectorDTO(List<Director> list) {
        if ( list == null ) {
            return null;
        }

        List<DirectorDTO> list1 = new ArrayList<DirectorDTO>( list.size() );
        for ( Director director : list ) {
            list1.add( directorToDirectorDTO( director ) );
        }

        return list1;
    }
}
