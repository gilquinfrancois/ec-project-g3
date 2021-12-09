package be.heh.ecproject.product.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Command
{

    @Getter
    private final int id;
    @Getter
    private final int idUser;
    @Getter
    private final int[] idProduct;

}