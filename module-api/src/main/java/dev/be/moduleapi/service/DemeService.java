package dev.be.moduleapi.service;

import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class DemeService {

    @Value("${profile-name}")
    String profileName;

    private final MemberRepository memberRepository;

    public String save() {
        log.info("profileName : " + profileName);

        memberRepository.save(Member.builder()
                                    .name(Thread.currentThread().getName())
                                    .build());
        return "save";
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public String find() {
        int size = memberRepository.findAll().size();
        log.info("DB size {}" , size);
        return "find";
    }

    public String exception() {
        if (true) {
            throw new CustomException(CodeEnum.UNKNOWN_ERROR); // custom 에러로 wrapping
        }
        return "exception";
    }
}
