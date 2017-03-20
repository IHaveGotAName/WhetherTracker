package com.podd.WeatherTracker.utilities;

import com.podd.WeatherTracker.dto.CityDTO;
import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.City;
import com.podd.WeatherTracker.entity.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class Transformer {
    public static UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setId(user.getId());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEmail(user.getEmail());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setRole(user.getRole());
        userDTO.setCity(user.getCity());
        return userDTO;
    }
    public static CityDTO cityToCityDTO(City city){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setCity(city.getCity());
        return cityDTO;
    }

    public static City cityDTOToCity(CityDTO cityDTO){
        City city = new City();
        city.setCity(cityDTO.getCity());
        city.setId(cityDTO.getId());
        return city;
    }

    public static User userDTOTouser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setId(userDTO.getId());
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setSecondName(userDTO.getSecondName());
        user.setRole(userDTO.getRole());
        user.setCity(userDTO.getCity());
        return user;
    }
    public static List<UserDTO> listUserToListUserDto(List<User> users) {
        List<UserDTO> userDTOs = new LinkedList<>();
        for (User user : users) {
            UserDTO userDTO = userToUserDTO(user);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }
}
