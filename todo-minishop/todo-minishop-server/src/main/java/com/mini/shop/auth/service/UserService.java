package com.mini.shop.auth.service;

import com.mini.shop.auth.dto.UserDto;
import com.mini.shop.auth.entity.Member;
import com.mini.shop.auth.entity.Role;
import com.mini.shop.auth.repository.UserRepository;
import com.mini.shop.error.exception.DuplicatedUserException;
import com.mini.shop.error.exception.NotFoundUserException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto insertSignUp(UserDto userDto) throws DuplicatedUserException {
        if (userRepository.existsById(userDto.getId())) {
            throw new DuplicatedUserException("아이디가 이미 존재합니다.");
        }

        Role role = new Role();
        role.setRoleName("ROLE_USER");

        Member member = convertToEntity(userDto);
        member.setRoles(Collections.singleton(role));

        return userDto.convertToDto(userRepository.save(member));
    }

    public String getFindPwd(UserDto userDto) {
        Member member = userRepository.findByIdAndEmail(userDto.getId(), userDto.getEmail());
        if (member != null) {
            String newPwd = RandomStringUtils.randomAlphanumeric(10);
            member.setPassword(passwordEncoder.encode(newPwd));
            userRepository.save(member);
            return newPwd;
        }
        return null;
    }

    public UserDto getMemberInfo(String id) throws NotFoundUserException {
        Member member = userRepository.findById(id).orElseThrow(() -> new NotFoundUserException("존재하지 않는 아이디 입니다."));
        return UserDto.convertToDto(member);
    }

    public UserDto updateMemberInfo(UserDto userDto) {
        Member member = convertToEntity(userDto);
        return UserDto.convertToDto(userRepository.save(member));
    }

    private Member convertToEntity(UserDto userDto) {
        Member member = new Member();
        if (!userDto.getId().equals("")) member.setId(userDto.getId());
        if (!userDto.getPassword().equals("")) member.setPassword(passwordEncoder.encode(userDto.getPassword()));
        if (!userDto.getName().equals("")) member.setName(userDto.getName());
        if (!userDto.getEmail().equals("")) member.setEmail(userDto.getEmail());
        if (!userDto.getPhone().equals("")) member.setPhone(userDto.getPhone());
        if (!userDto.getAddress().equals("")) member.setAddress(userDto.getAddress());
        return member;
    }
}
