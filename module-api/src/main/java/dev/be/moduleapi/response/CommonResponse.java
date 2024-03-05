package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // null 인 항목은 보여주지 않겠다
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    public CommonResponse(T info) {
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }
}
