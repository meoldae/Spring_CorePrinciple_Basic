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


