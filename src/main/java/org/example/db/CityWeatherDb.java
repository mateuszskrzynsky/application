package org.example.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CityWeatherDb {
    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();

    public void add(CityDataEntity entity){
        dataBase.put(entity.getId(), entity);
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
