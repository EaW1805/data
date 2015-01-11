package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.UserDTO;
import com.eaw1805.data.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert User DB objects into UserDTOs.
 */
public final class UserConverter {

    /**
     * Cannot instantiate this class.
     */
    private UserConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static UserDTO convert(final User value) {
        final UserDTO empireUserDTO = new UserDTO();
        empireUserDTO.setUserId(value.getUserId());
        empireUserDTO.setUsername(value.getUsername());
        empireUserDTO.setPassword(value.getPassword());

        return empireUserDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<UserDTO> convert(final List<User> list) {
        final List<UserDTO> listDTOs = new ArrayList<UserDTO>();
        for (final User value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}
