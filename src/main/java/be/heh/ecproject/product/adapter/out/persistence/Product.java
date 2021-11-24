package be.heh.ecproject.product.adapter.out.persistence;
        import lombok.Data;
        import lombok.Getter;
        import lombok.RequiredArgsConstructor;

        import java.time.Instant;
        import java.time.LocalDate;
        import java.util.Date;
        import java.util.UUID;

@RequiredArgsConstructor
public class Product {

    @Getter
    private final Long id;
    @Getter
    private final String productName;
    @Getter
    private final int price;
    @Getter
    private final String category;
    }