package be.heh.ecproject.product.adapter.out.persistence;

import be.heh.ecproject.product.domain.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CommandPersistenceAdapter implements AllCommandUseCase{

    @Autowired
    private final CommandRepository commandRepository;

    @Override
    public Map<String, Object> getCommandDetail(int commandId) {
        List<CommandJpaEntity> commandJpaList = commandRepository.findAll();
        //mapper
        List<Command> commandList = new ArrayList<>();
        Map<String,Object> mapCommand = new HashMap<>();
        Command command;

        for (CommandJpaEntity com: commandJpaList) {
            if(com.getCommandId() == commandId) {
                command = new Command(com.getCommandId(), com.getUserId(), com.getProductId());
                commandList.add(command);
            }
        }
        //---
        mapCommand.put("COMMAND_DATA",commandJpaList);
        return mapCommand;
    }


}
