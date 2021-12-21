package be.heh.ecproject.product.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Command
{

    @Getter
    private final int id;
    @Getter
    private final int idUser;
    @Getter
    private final List<Integer> idProduct;

}