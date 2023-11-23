package org.example.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CityWeatherDb {
    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();

    private static Long CITY_DATA_ENTITY_ID=1L;
    private static Long WEATHER_DATA_ENTITY_ID=1L;


    public CityDataEntity add(CityDataEntity entity){
        final Long newIdCityDataEntity =CITY_DATA_ENTITY_ID;
        final Long newIdWeatherDataEntity = WEATHER_DATA_ENTITY_ID;

        entity.setId(newIdCityDataEntity);
        entity.getWeatherDataEntity().setId(newIdWeatherDataEntity);

        dataBase.put(entity.getId(),entity);

        CITY_DATA_ENTITY_ID= CITY_DATA_ENTITY_ID+1;
        WEATHER_DATA_ENTITY_ID= WEATHER_DATA_ENTITY_ID+1;

        return entity;


    }

    public Optional<CityDataEntity> get(Long id){
        return Optional.ofNullable(dataBase.get(id));
    }

    //public void delete(Long id) throws NotCityFoundException {
    //    if (!dataBase.containsKey(id)) {
    //        throw new NotCityFoundException("Can't find id: " + id);
    //    }
    //    dataBase.remove(id);
    //}

    public CityDataEntity change(CityDataEntity cityDataEntity) {
        // wyszukac po id ? jak wyciągamy obiekt po kluczu?
        final CityDataEntity toChange = dataBase.get(cityDataEntity.getId());
        // zmodyfikowac jego pola (settery)
        toChange.setName(cityDataEntity.getName());
        toChange.setWeatherDataEntity(cityDataEntity.getWeatherDataEntity());
        // zapisać ponownie do mapy ? jak dodajemy po kluczu bwartość
        return dataBase.put(cityDataEntity.getId(), toChange);
    }

    public void delete(Long id){
        dataBase.remove(id);
    }
}
