package be.heh.ecproject.product.adapter.out.persistence;

import be.heh.ecproject.product.domain.Command;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@ActiveProfiles("dev")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({CommandPersistenceAdapter.class})
public class commandPersistenceApplicationTest {
    @Autowired
    private CommandRepository commandRepository;

    @ParameterizedTest
    @ValueSource(ints = 1)
    void getCommandDetail(int id) {
        CommandPersistenceAdapter commandPersistenceAdapter = new CommandPersistenceAdapter(commandRepository);
        Map<String, Object> map = new HashMap<>();
        ArrayList<Command> commands;

        map = commandPersistenceAdapter.getCommandDetail(id);
        commands = (ArrayList<Command>) map.get("COMMAND_DATA");

        System.out.println(commands.get(0).getIdProduct());

        assertEquals("{25,65,95,5}", commands.get(0).getIdProduct());
        assertEquals(1, commands.get(0).getIdUser());
    }

    @Test
    void test() {
        System.out.println("Hello");
    }
}
