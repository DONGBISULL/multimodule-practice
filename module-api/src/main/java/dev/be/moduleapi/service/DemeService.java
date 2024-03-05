package dev.be.moduleapi.service;

import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class DemeService {

    private final CommonDemoService commonDemoService;

    public String save() {
        log.info(CodeEnum.SUCCESS.getCode());
        log.info(commonDemoService.commonService());
        return "save";
    }

    public String find() {
        return "find";
    }
}
