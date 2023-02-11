# Spring_Core_Principle Basic
Inflearn - 스프링 핵심 원리 - 기본편
---  

## 00. 프로젝트 생성
- 프로젝트 생성
- 라이브러리 확인
- 빌드

## 01. 스프링 핵심원리 이해
- 비즈니스 요구사항과 설계 (회원, 주문, 할인)
- 객체지향적으로 역할과 구현체를 나눈 예제 구현 (순수 자바)

```commit``` : [a415cf9](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/a415cf9d8337088e3bd109db51e74af5db505c7f)  

## 02. 스프링 핵심원리 이해 - 객체지향의 적용
- 다형성을 이용한 새 할인정책 적용 -> DIP, OCP 위반 문제 발견

```commit``` : [40aae15](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/40aae15522b05b329d08d8ba7025eb143739080f)
- AppConfig (설정자) 를 이용한 관심사 분리 / DIP 위반 문제 해결 

```commit``` : [6c5361e](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/6c5361e2eedb074425b2fdc4f503aaffe24d4127)


## 03. 스프링 컨테이너와 스프링 빈
- Spring 컨테이너 사용

```commit``` : [68aab8c](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/68aab8ccad5381c2edaae0a29b0515880078f66d)
- Spring Bean을 조회하는 여러 방법 (in Test)

```commit``` : [881fba6](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/881fba659debe288fb82d0cf12753e21f29f7ee2)
- AppConfiguration을 XML 파일로 하는 방법 (거의 사용하지 않으나, 사용할 수도 있음)

```commit``` : [319c854](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/319c8543f7880284548f1816bf3987e782bb47d4)
- SpringBean의 Metadata인 BeanDefinition

```commit``` : [2b333a8](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/2bee3a8192043797da7ccc08aa1d88d2575874f2)

## 04. 싱글톤 컨테이너
- 순수 자바를 통한 DI 컨테이너

```commit``` : [f1123f8](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/f1123f89853666795c849f4a8f46d352631799cf)
- Singleton 패턴 적용

```commit``` : [b301c34](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/b301c346d2868bef8183ad2255e3357879d50edd)
- 스프링 컨테이너를 통한 싱글톤

```commit``` : [152d813](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/152d813dd1ad8f12b63c1f8dc35ad57182b7e377)
- 싱글톤 사용 시 주의할 점

```commit``` : [d0b1225](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/d0b122591cc050c0c2ee5dc68b649a5acb6ebf3c)
- @Configuration을 통한 싱글톤 확인

```commit``` : [2f93559](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/2f9355958c14f333caec05b330a1af1505409bb9)

## 05. 컴포넌트 스캔
- @ComponentScan 어노테이션을 통한 자동 의존관계 주입

```commit``` : [0408250](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/0408258b037e6815c2da21bfcfab36d0f90ed232)
- @ComponentScan 의 범위와 대상 지정 

```commit``` : [f1b480b](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/f1b480beae643a99982b821e36d94b69719f29d9)
- 어노테이션을 통한 컴포넌트 스캔 필터 적용

```commit``` : [aedb1e9](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/aedb1e9c0cca97b7b9b560b00b77fbafd4510e41)

- Bean 등록 시 중복 등록 및 충돌 (자동 vs 자동, 수동 vs 자동)

## 06. 의존관계 자동 주입
- 다양한 의존관계 주입 방법 (생성자, 수정자, 필드, 일반 메서드)

```commit``` : [8e418da](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/8e418da8f49d87226adb36cdf68620736f9c35ef)
- Autowired의 세 가지 옵션 

```commit``` : [7b052e4](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/7b052e48202de6894851a8fed000371aa068a62f)
- 생성자 주입의 장점 
  - 1. 순수 자바 코드를 통한 테스트 용이
  - 2. final 키워드 적용 가능
  
- Lombok을 통한 편의성 강화 (Getter, Setter, Constructor)

```commit``` : [7fcedc9](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/7fcedc9383df73c4087f46520bcda56a7bdedc42)
- @Qualifier, @Primary 어노테이션의 사용 

```commit``` : [510dfa6](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/510dfa6016967ee6f40777b2b87b4cb241805b1c)
- 어노테이션 파라미터(문자열) 오류 확인을 줄이기 위한 사용자 정의 어노테이션

```commit``` : [f53039f](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/f53039f3ce9024d4274efd34ace04f7c1383e3ec)
- 다수의 빈을 조회해야할 때 List, Map의 활용

```commit``` : [4901993](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/4901993b50036adfbcf7d99b996d00a2bbf32478)
- 빈 등록시 수동 등록과 자동 등록의 사용 기준

```commit``` : [74718b1](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/74718b1162fcfb61221b0a87eeee623bb011d6fb)

## 07. 스프링 빈 생명주기와 콜백 메소드
- 빈 생명주기 

```commit``` : [ec7632a](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/ec7632a49269d7110d7fdfa393dc36d4b0e7663b)
- implements InitializingBean, DisposableBean

```commit``` : [66080d9](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/66080d92f778f4c195915f0ba0acfa94b00555a9)
- 인터페이스가 아닌 설정 정보를 통한 콜백 메소드 사용 

```commit``` : [7d08c11](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/7d08c1196db589d6129a8abcf7d8cfa9c674894c)
- @PostConstruct, @PreDestroy 어노테이션의 사용

```commit``` : [9744914](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/9744914e1a419b51684e9ef7cc2ac80fd586880e)


## 08. 빈 스코프
- 싱글톤 스코프와 프로토타입 스코프

```commit``` : [e189edc](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/e189edc6fae7984ccdcb424106cffae5baf1072d)
- 싱글톤 스코프 빈이 프로토타입 빈을 사용할 때

```commit``` : [ac34b05](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/ac34b0580d396fe6b62eae1d29ae2bc3cc774cac)
- 위 문제 해결을 위한 Provider (스프링 Provider && 자바 표준 Provider)

```commit``` : [cd4a104](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/cd4a1042b1793547323b0a4956bb91b61279d466)
- Web Scope 빈과 Provider를 통한 지연주입

```commit``` : [54d32da](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/54d32dac6738592fc2b508bc4b8741edfc2a5562)
- Proxy를 통해 Provider없이 지연 주입

```commit``` : [d94bdac](https://github.com/meoldae/Spring_CorePrinciple_Basic/commit/d94bdacdbe70cb680cf798ceaad30608807f0e40)
