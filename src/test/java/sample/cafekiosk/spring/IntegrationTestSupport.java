package sample.cafekiosk.spring;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import sample.cafekiosk.spring.client.mail.MailSendClient;

@ActiveProfiles("test")
@SpringBootTest
public abstract class IntegrationTestSupport {

    // 테스트 환경 통일을 위해 MockBean 을 상위 클래스로 추출
    // 2가지 방법이 있다(프로젝트 환경에 따른 선택적 사용)
    // 1. 해당 방법 처럼 상위 클래스 하나로 통일하여, 모든 테스트에 MockBean을 호출해 서버를 1번 띄우는 방법
    // 2. MockBean 호출용 상위 클래스를 별도로 만들어 2개의 환경으로 분리하여 서버를 2번 띄우는 방법
    @MockBean
    protected MailSendClient mailSendClient;

}
