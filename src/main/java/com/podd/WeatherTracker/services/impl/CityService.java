package com.podd.WeatherTracker.services.impl;

import com.podd.WeatherTracker.dto.CityDTO;
import com.podd.WeatherTracker.entity.City;
import com.podd.WeatherTracker.services.api.CrudService;
import com.podd.WeatherTracker.utilities.Transformer;

import java.util.List;

import static com.podd.WeatherTracker.dao.impl.CityDAO.getCityDAO;
import static com.podd.WeatherTracker.dao.impl.UserDAO.getUserDAO;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class CityService implements CrudService<CityDTO> {
    @Override
    public CityDTO findById(int id) {
        CityDTO cityDTO = Transformer.cityToCityDTO(getCityDAO().findById(id));
        return cityDTO;
    }

    @Override
    public List<CityDTO> findAll() {
        return null;
    }

    @Override
    public void create(CityDTO cityDTO) {
        City city = Transformer.cityDTOToCity(cityDTO);
        getCityDAO().create(city);
    }

    @Override
    public void update(CityDTO cityDTO) {
        getCityDAO().update(Transformer.cityDTOToCity(cityDTO));
    }

    @Override
    public void delete(CityDTO cityDTO) {
        getCityDAO().delete(Transformer.cityDTOToCity(cityDTO));
    }
    public CityDTO findIdByCity(CityDTO cityDTO){
        City city = Transformer.cityDTOToCity(cityDTO);
        City city1 = getCityDAO().findIdByCity(city.getCity());
        cityDTO = Transformer.cityToCityDTO(city1);
        return cityDTO;
    }
}
