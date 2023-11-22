package org.example.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityWeatherDbTest {

    private static final CityWeatherDb dataBase = new CityWeatherDb();



    @Test

    void change() {
        //given
        final CityDataEntity cityDataEntity = new CityDataEntity();
        final long id = 1L;
        final String cityName = "Warsaw";
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);

        final CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(id);
        final String newName = cityName + "AAA";
        changedCityDataEntity.setName(newName);
        //when
        dataBase.change(changedCityDataEntity);
        //then
        final CityDataEntity result = dataBase.get(id).orElseThrow();
        Assertions.assertEquals(result.getName(), newName);
    }

    @Test
    void should_get_entity_by_id() {
        //given
        final CityDataEntity cityDataEntity = new CityDataEntity();
        final long id = 1L;
        final String cityName = "Warsaw";
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);
        //when
        final  CityDataEntity result = dataBase.get(id).orElseThrow();
        //then
        Assertions.assertEquals(result.getName(), cityName);
    }

    //@Test
    //void deleteTest(){
    //given
    //    final CityDataEntity cityDataEntity = new CityDataEntity();
    //    final long id = 1L;
    //    final String cityName = "Warsaw";
    //    cityDataEntity.setId(id);
    //    cityDataEntity.setName(cityName);
    //    dataBase.add(cityDataEntity);
    //when
    //    assertEquals(cityName, cityName);

    //}
    @Test
    void addTest() {
        //given
        final CityDataEntity cityDataEntity = new CityDataEntity();
        final long id = 1L;
        final String cityName = "Warsaw";
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        //when
        dataBase.add(cityDataEntity);
        //then
        Assertions.assertEquals(cityDataEntity.getName(), cityName);
    }

    @Test
    void deleteTest() {
        //given
        final CityDataEntity cityDataEntity = new CityDataEntity();
        final long id = 1L;
        final String cityName = "Warsaw";
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);
        //when
        dataBase.delete(id);
        //then
        final var resultOpt = dataBase.get(id);
        final boolean isPresent = resultOpt.isPresent();
        Assertions.assertFalse(isPresent);
    }



}
