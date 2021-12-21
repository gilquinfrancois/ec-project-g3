package be.heh.ecproject.product.adapter.in.web;

import be.heh.ecproject.product.adapter.out.persistence.AllCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="api", produces="application/json")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CommandController {
    private final AllCommandUseCase allCommandUseCase;

    @GetMapping("/commandDetail")
    public Map<String, Object> getCommandDetails(@RequestParam int commandId) {
        return allCommandUseCase.getCommandDetail(commandId);
    }
}
