package dev.be.moduleapi.controller;

import dev.be.moduleapi.service.DemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DemoController {

    private final DemeService demeService;

    @GetMapping("/save")
    public String save() {
        return demeService.save();
    }

    @GetMapping("/find")
    public String find() {
        return demeService.find();
    }

    @GetMapping("/exception")
    public String exception() {
        return demeService.exception();
    }
}
