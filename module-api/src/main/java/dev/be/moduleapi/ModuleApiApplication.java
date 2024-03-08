package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 컴포넌트 스캔
 * Parameter 0 of constructor in dev.be.moduleapi.service.DemeService required a bean of type 'dev.be.service.CommonDemoService' that could not be found.
 * <p>
 * 해결 방법 1
 * Bean scan
 * 모듈 하위의 controller , service 빈 스캔
 * => 하위에 같은 위치로 빈 스캔을 함
 * => CommonDemoService 가 있는 module-common에는 moduleapi 패스가 없음
 * => CommonDemoService 빈 스캔 이뤄지지 않음
 * => 공통 경로인 dev.be 로 Application 실행 함수를 이동
 * => 빈 스캔이 제대로 되면서 기존의 로직이 잘 실행됨
 * <p>
 * 해결 방법 2
 *
 * @SpringBootApplication scanBasePackages 옵션 사용
 * 명시적으로 컴포넌트 스캔할 영역 패키지 지정
 */
@SpringBootApplication(scanBasePackages = {
        "dev.be.moduleapi", "dev.be.modulecommon"
})
@EntityScan(basePackages = "dev.be.modulecommon.domain")
@EnableJpaRepositories(basePackages = {"dev.be.modulecommon.repository"})
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
