package by.bsuir.borodin.converter;

import by.bsuir.borodin.dto.StarDTO;
import by.bsuir.borodin.entity.Star;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-01-05T16:27:21+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class StarMapperImpl implements StarMapper {

    @Override
    public StarDTO starToStarDTO(Star entity) {
        if ( entity == null ) {
            return null;
        }

        StarDTO starDTO = new StarDTO();

        starDTO.setName( entity.getName() );

        return starDTO;
    }

    @Override
    public Star starDTOToStar(StarDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Star star = new Star();

        star.setName( dto.getName() );

        return star;
    }

    @Override
    public List<StarDTO> listStarToListStarDTO(List<Star> list) {
        if ( list == null ) {
            return null;
        }

        List<StarDTO> list1 = new ArrayList<StarDTO>( list.size() );
        for ( Star star : list ) {
            list1.add( starToStarDTO( star ) );
        }

        return list1;
    }
}
