package com.baran.password;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Random;
public class Password_gen {

    private final Set<Character> charset;
    private final int lenght;
    public Password_gen(int lenght){
        this.lenght = lenght;
        charset = Stream.of(
                        "AZERTYUIOPQSDFGHJKLMWXCVBN".toCharArray(),
                        "azertyuiopqsdfghjklmwxcvbn".toCharArray(),
                        "0123456789".toCharArray(),
                        "!@#$%&*?_-".toCharArray()
                ).flatMapToInt(chars -> new String(chars).chars())
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

    }
    public String create() {
        Random random = new Random();
        Object[] arraycharset = charset.toArray();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < lenght; i++){
            password.append((char) arraycharset[random.nextInt(charset.size())]);
        }
        return password.toString();
    }
}

