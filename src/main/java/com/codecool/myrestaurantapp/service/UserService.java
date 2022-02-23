package com.codecool.myrestaurantapp.service;

import com.codecool.myrestaurantapp.model.entity.RoleEntity;
import com.codecool.myrestaurantapp.model.entity.UserEntity;
import com.codecool.myrestaurantapp.repository.RoleEntityRepository;
import com.codecool.myrestaurantapp.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;
    private final RoleEntityRepository roleEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public RoleEntity saveRole(RoleEntity role) {
        return roleEntityRepository.save(role);
    }

    public void addRoleToUser(String userName, String roleName) {
        UserEntity userEntity = userEntityRepository.findUserByName(userName);
        RoleEntity role = roleEntityRepository.findRoleByName(roleName);
        userEntity.getRoleEntities().add(role);
    }

    public UserEntity getUser(String name) {
        return userEntityRepository.findUserByName(name);
    }

    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            UserEntity userEntity = userEntityRepository.findUserByName(userName);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            userEntity.getRoleEntities().forEach(roleEntity -> authorities.add(new SimpleGrantedAuthority(roleEntity.getName())));
            log.info("Username: {}, Password: {}", userEntity.getName(), userEntity.getPassword());
            return new org.springframework.security.core.userdetails.User(userEntity.getName(), userEntity.getPassword(), authorities);
        }
        catch (UsernameNotFoundException exception) {
            System.out.println(exception.getMessage());
            return null;
        }

    }
}
