package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // Component Scan 범위 지정
        // 여러 개도 한번에 가능
        // Default범위는 : 현재 AutoAppConfig가 있는 패키지부터 (hello.core부터 전부)
        // 권장 : 프로젝트 최상단에 AutoAppConfig 파일을 위치시킨다. -> 스프링 부트에서도 해당 방법 제공
        basePackages = {"hello.core", "hello.core.member"},
        // Component Scan도중 제외할 것들
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class))
public class AutoAppConfig {
    // @Bean으로 등록한 애들이 없음!!


}
