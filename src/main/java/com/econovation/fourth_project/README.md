# IAM
권한 부여 및 관리 기능 구현

# 구조

IAM Policy는 AWS 리소스에 대한 권한을 정의하는 JSON 문서이다.
이 문서는(IAM Policy) Optional top-level elements와 statement 두 가지 필드로 구성된다.

## 1. Optional top-level elements
```json
{
    "Version" : "2012-10-17"
}
```

## 1.1 Version
```json
{
  "Statement": [
    {
      "Sid": "ExampleStatement1",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:ListBucket",
      "Resource": "arn:aws:s3:::example_bucket"
    },
    {
      "Sid": "ExampleStatement2",
      "Effect": "Deny",
      "Principal": "*",
      "Action": "s3:DeleteObject",
      "Resource": "s3:::example_bucket/*"
    }
  ]
}
```
- 정책 언어의 버전을 지정하는 필드
- 제한사항
  - 2012-10-17 : 현재 정책 언어 버전, 새로운 정책 작성 시 반드시 이 값을 사용해야 한다. 이 버전을 사용하지 않으면 최신 기능 이용 불가
  - 2008-10-17 : 이전 정책 언어 버전, 새로운 정책 작성이나 기존 정책 업데이트 시 사용 금지. 최신 기능이 작동하지 않는다. 

## 1.2 ID
  - 정책의 고유한 식별자이다. 자동으로 생성
  - 제한사항 : 없음

## Statement
### Statement List
  - 하나 이상의 단일 문 또는 개별 문의 배열을 포함
  - 제한 사항 : 리스트 형태로 여러 문을 포함할 수 있다.

### Sid(StatementID)
  - 정책 내 개별 문에 대한 설명 또는 고유 식별자로 사용
  - 제한 사항 : ASCII 대문자 및 숫자만 사용 가능
  - JSON 내에서 고유해야 한다. 중복 불가

### Effect(필수)
  - 명시적인 허용(Allow) 또는 거부(Deny)를 지정하는 필드
  - 제한 사항 : Allow 또는 Deny 중 하나를 선택
    - 기본적으로 모든 리소스는 거부
    - 동일한 규제에 대해 Allow, Deny 동시 존재하면 Deny가 우선 적용

## Principal
  - 보안 주체(사용자, 그룹, 역할)를 지정한다. 주로 리소스 기반 정책의 요소로 사용
  - 제한 사항 : 특정 형식의 문자열로 지정해야 한다.
    - Principal에 ECONO라고 적힌 경우 리스트로 해당하여 특정 계정의 ID의 List 형태를 받을 수 있다.

## NotPrincipal
  - 보안 주체를 제외하는 필드
  - 제한 사항 : Principal과 동일하게 특정 형식의 문자열로 지정

## Action
  - 정책에서 허용하거나 거부하는 작업(액션)을 지정한다.
  - 제한 사항 : : 문자를 seperator로 지정한다. :의 좌측은 정책을 허용, 우측은 GET,PUT,POST,DELETE 4가지만 허용

