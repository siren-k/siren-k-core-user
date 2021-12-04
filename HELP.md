## Docker
### 버전 확인
```
$ docker-compose --version
```
### 컨테이너 생성 및 실행
```
$ docker-compose up -d
```
|     옵션      | 설명              |
|:-----------:|-----------------|
|     -d      | 백그라운드 실행        |
|  --no-deps  | 링크 서비스 실행하지 않음  |
|   --build   | 이미지 빌드          |
|     -t      | 타임아웃 지정(기본 10초) |
### 컨테이너 상태 확인
```
$ docker-compose ps
```
### 로그 출력
```
$ docker-compose logs
```
### 컨테이너 특정 명령 실행
```
$ docker-compose run
```
**# docker-compose run [서비스명] [명령]**

**$ docker-compose run redis /bin/bash**
### 컨테이너 시작/정지/일시정지/재시작
```
$ docker-compose start
$ docker-compose stop
$ docker-compose pause
$ docker-compose unpause
$ docker-compose restart
```
### 컨테이너 삭제
```
$ docker-compose rm
```
### 컨테이너 강제 정지
```
$ docker-compose kill [service] -s SIGINT
```
### 네트워크 정보, 볼륨, 컨테이너들을 일괄 정지 및 삭제
```
$ docker-compose down
$ docker-compose down -rmi all
```
### 컨테이너 구성 확인
```
$ docker-compose config
```
---