package com.isa.usersengine;

import com.isa.usersengine.repository.UsersRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        UsersRepository.getRepository().forEach(user -> System.out.println(user.getName()));

    }
}
