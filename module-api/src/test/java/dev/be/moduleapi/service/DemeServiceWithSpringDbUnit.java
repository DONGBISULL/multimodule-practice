package dev.be.moduleapi.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import dev.be.moduleapi.TestConfig;
import dev.be.modulecommon.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.transaction.Transactional;
import java.io.IOException;

//import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@Import(TestConfig.class)
@TestExecutionListeners({
        DbUnitTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class, // Bean 을 DI 받기 위해 선언해줘야 한다.
//        TransactionDbUnitTestExecutionListener.class // @DatabaseSetup 부터 @DatabaseTearDown 까지 트랜잭션이 적용된다.
        // @DatabaseTearDown 선언시 DbUnitTestExecutionListener 와 함께 사용할 수 없다.
})
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
//@DatabaseSetup(value = {"member.xml"}, type = DatabaseOperation.CLEAN_INSERT)
//@DatabaseTearDown(value = {"member.xml"}, type = DatabaseOperation.DELETE_ALL)
public class DemeServiceWithSpringDbUnit {

    @Autowired
    private DemeService demeService;

    @Autowired
    private ResourceLoader resourceLoader;
    @Test
    void createMemebr() throws IOException {
        String resourcePath = "src/test/resources/member.xml";
//        ClassLoader classLoader = getClass().getClassLoader();

        // ClassLoader를 사용하여 리소스 로드
//        java.net.URL resourceUrl = classLoader.getResource(resourcePath);
//        System.out.println("resourceUrl");
//        System.out.println(resourceUrl);
        Resource resource = resourceLoader.getResource("classpath:" + resourcePath);

        // 리소스 로드


//        // 리소스가 존재하는지 확인
        boolean exists = resource.exists();
//
        System.out.println("Resource exists: " + exists);
//        System.out.println("Resource URL: " + resource.getURL());
//        Member member = Member.builder().id(675L)
//                .name("테스트멤버111")
//                .build();
//
//        Member savedMember = demeService.createMember(member);

    }
}
