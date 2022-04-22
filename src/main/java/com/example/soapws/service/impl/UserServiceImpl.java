package com.example.soapws.service.impl;

import com.example.soapws.dto.User;
import com.example.soapws.model.Users;
import com.example.soapws.repository.UserRepository;
import com.example.soapws.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        Users users = userRepository.findById(id).orElse(null);
        return map(users);
    }

    private User map(Users source){ // we can use ModelMapper
        User destination = new User();
        destination.setId(source.getId().intValue());
        destination.setFirstname(source.getFirstname());
        destination.setLastname(source.getLastname());
        destination.setEmail(source.getEmail());
        destination.setAddress(source.getAddress());
        return destination;
    }
}
