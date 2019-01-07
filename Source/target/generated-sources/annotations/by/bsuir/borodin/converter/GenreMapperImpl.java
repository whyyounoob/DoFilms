package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.GenreDTO;
import by.bsuir.borodin.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-05T16:27:20+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO genreToGenreDTO(Genre entity) {
        if ( entity == null ) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();

        genreDTO.setName( entity.getName() );

        return genreDTO;
    }

    @Override
    public Genre genreDTOToGenre(GenreDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( dto.getName() );

        return genre;
    }

    @Override
    public List<GenreDTO> listGenreToListGenreDTO(List<Genre> list) {
        if ( list == null ) {
            return null;
        }

        List<GenreDTO> list1 = new ArrayList<GenreDTO>( list.size() );
        for ( Genre genre : list ) {
            list1.add( genreToGenreDTO( genre ) );
        }

        return list1;
    }
}
