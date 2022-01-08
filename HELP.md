## Redis
### localhost:6379 접속
```
$ redis-cli
```
### 원격접속
```
redis-cli -h {host name} -p {port number]
```
### 정보보기
```
redis-cli info
```
### help
```
redis-cli help
```
### 모니터링
```
redis-cli monitor
```
### CRUD 명령어
#### 현재의 키값들을 확인
```
127.0.0.1:6379> keys *
(empty list or set)
```
#### key / value 형태로 저장
```
127.0.0.1:6379>set k_one v_one
OK

127.0.0.1:6379>keys *
1) "k_one"
```
#### 여러개의 key / value 형태로 저장
```
127.0.0.1:6379> mset k_two v_two k_tree v_tree
OK

127.0.0.1:6379> keys *
1) "k_tree"
2) "k_one"
3) "k_two"
```
#### 소멸시간 지정해서 저장(시간은 초단위로 입력)
```
127.0.0.1:6379> setex k_four 10 k_four
OK
```
#### key에 해당하는 value를 조회
```
127.0.0.1:6379> get k_four
(nil)
127.0.0.1:6379> get k_tree
"v_tree"
```
#### 여러개의 key를 조회
```
127.0.0.1:6379> mget k_one k_two
1) "v_one"
2) "v_two"
```
#### 해당 key와 value을 삭제
```
127.0.0.1:6379> del k_tree
(integer) 1

127.0.0.1:6379> keys *
1) "k_one"
2) "k_two"
```
#### 타임아웃까지 남은 시간을 초단위로 반환
```
127.0.0.1:6379> setex k_tree 60 v_tree
OK

127.0.0.1:6379> ttl k_tree
(integer) 54

127.0.0.1:6379> pttl k_tree
(integer) 48628

127.0.0.1:6379> ttl k_tree
(integer) -2

127.0.0.1:6379> ttl k_one
(integer) -1
```
#### *검색어*  key 검색
```
127.0.0.1:6379> keys *k*
1) "k_one"
2) "k_two"
```
#### key의 이름을 변경
```
127.0.0.1:6379> rename k_one one
OK

127.0.0.1:6379> keys *
1) "one"
2) "k_two"

127.0.0.1:6379> renamenx k_two one
(integer) 0

127.0.0.1:6379> keys *
1) "one"
2) "k_two"
```
#### 모든 데이터(key와 value)를 삭제
```
127.0.0.1:6379> flushall
OK

127.0.0.1:6379> keys *
(empty list or set)
```

---

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