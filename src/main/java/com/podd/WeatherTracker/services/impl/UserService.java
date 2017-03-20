package com.podd.WeatherTracker.services.impl;

import com.podd.WeatherTracker.dto.UserDTO;
import com.podd.WeatherTracker.entity.User;
import com.podd.WeatherTracker.services.api.CrudService;
import com.podd.WeatherTracker.utilities.Transformer;

import java.util.List;

import static com.podd.WeatherTracker.dao.impl.UserDAO.getUserDAO;

/**
 * Created by ivegotaname on 21.02.17.
 */
public class UserService implements CrudService<UserDTO>{

    @Override
    public UserDTO findById(int id) {
        UserDTO userDTO = Transformer.userToUserDTO(getUserDAO().findById(id));
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = Transformer.listUserToListUserDto(getUserDAO().findAll());
        return userDTOs;
    }

    @Override
    public void create(UserDTO userDTO) {
        User user = Transformer.userDTOTouser(userDTO);
        getUserDAO().create(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        getUserDAO().update(Transformer.userDTOTouser(userDTO));
    }

    @Override
    public void delete(UserDTO userDTO) {
        getUserDAO().delete(Transformer.userDTOTouser(userDTO));
    }

    public UserDTO findUserByLoginAndPassword(UserDTO userDTO){
        User user = Transformer.userDTOTouser(userDTO);
        User user1 = getUserDAO().findByLoginPassword(user.getLogin(), user.getPassword());
        userDTO = Transformer.userToUserDTO(user1);
        return userDTO;
    }
    public boolean checkLoginToEquals(String login) {
        boolean result = getUserDAO().checkLoginToEquals(login);
        return result;
    }
}