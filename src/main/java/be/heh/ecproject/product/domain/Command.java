package be.heh.ecproject.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Array;

@RequiredArgsConstructor
public class Command {

    @Getter
    private final int idCommand;
    @Getter
    private final int idUser;
    @Getter
    private final Array idProduct;
}