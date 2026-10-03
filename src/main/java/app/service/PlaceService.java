package app.service;

import app.domain.Place;
import app.domain.enums.ScenaryTypeEnum;
import app.repository.PlaceRepository;

public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place create(Integer placeId, String city, String placeName, String scenaryType){
        Place place = new Place(placeId, city, placeName, ScenaryTypeEnum.valueOf(scenaryType));

        return placeRepository.create(place);
    }

    public void selectById(int id) {}

    public void update() {}
}
