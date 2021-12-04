set foreign_key_checks = 0;
-- 외래키 체크 설정 해제

-- gateway engine
# drop table if exists gateway_engine;
# create table gateway_engine
# (
#     -- 기본 정보
#     gateway_engine_id                 bigint auto_increment primary key comment '게이트웨이 엔진의 식별자',
#     gateway_engine_token              varchar(255)  not null comment '게이트웨이 엔진을 구분하기 위한 대체키',
#     gateway_engine_hostname           varchar(255)  not null comment '게이트웨이 엔진을 구분하기 위한 호스트이름',
#     gateway_engine_status             varchar(30)   not null comment '게이트웨이 엔진의 상태',
#
#     -- 전송을 위한 호스트 정보
#     gateway_engine_host_user          varchar(255)  not null comment '게이트웨이 엔진으로 전송하기 위한 호스트 ID',
#     gateway_engine_host_ip            varchar(255)  not null comment '게이트웨이 엔진으로 전송하기 위한 호스트 IP',
#     gateway_engine_host_port          int(5)        not null default 22 comment '게이트웨이 엔진으로 전송하기 위한 호스트 Port',
#     gateway_engine_host_transfer_path varchar(2048) not null comment '게이트웨이 엔진으로 전송하기 위한 호스트 Port',
#
#     -- 암호화 정보
#     gateway_engine_enable_encryption  tinyint(1)    not null default 1 comment '게이트웨이 엔진으로 전송된 파일의 암호화 여부',
#     gateway_engine_encryption_key     varchar(4096) not null comment '게이트웨어 엔진으로 전송된 파일의 암호화 키(공개키로 암호화된 비밀키)',
#
#     created_at                        datetime(6)   not null comment '게이트웨이의 엔진 정보 생성 일시',
#     updated_at                        datetime(6)   null comment '게이트웨이의 엔진 정보 수정 일시'
# ) comment '게이트웨이 엔진' charset = utf8mb4;
#
# create
#     index gateway_engine_idx01 on gateway_engine (gateway_engine_token, gateway_engine_hostname);
#
# create
#     index gateway_engine_idx02 on gateway_engine (gateway_engine_hostname);
#
# create
#     index gateway_engine_idx03 on gateway_engine (created_at);
#
# create
#     index gateway_engine_idx04 on gateway_engine (updated_at);
#
# create
#     unique index gateway_engine_unique_idx01 on gateway_engine (gateway_engine_hostname, gateway_engine_host_ip);
#
# -- sensor
# drop table if exists sensor;
# create table sensor
# (
#     -- 기본 정보
#     sensor_id                                                     bigint auto_increment primary key comment '센서의 식별자',
#     sensor_token                                                  varchar(255) not null comment '샌서를 구분하기 위한 대체키',
#     sensor_license                                                varchar(1024) comment '센서의 라이선스',
#     sensor_last_ping_start                                        datetime(6) comment '센서에 보낸 상태 요청 송신 시간',
#     sensor_last_ping_end                                          datetime(6) comment '센서에 보낸 상태 요청 송신 시간',
#     sensor_last_pong_start                                        datetime(6) comment '센서로부터 응답 메시지 수신 시간',
#     sensor_last_pong_end                                          datetime(6) comment '센서로부터 응답 메시지 수신 시간',
#     sensor_usable                                                 tinyint(1)   not null default true comment '센서의 사용 여부',
#     sensor_status                                                 varchar(255) not null comment '샌서의 상태',
#
#     -- 스캐너 정보
#     sensor_scanner_id                                             varchar(255) not null comment '센서에 탑재된 스캐너 식별자',
#     sensor_scan_page_count                                        bigint       not null default 0 comment '센서에 탑재된 스캐너가 스캔한 전체 페이지의 수',
#     sensor_scan_area_resolution                                   int(11)      not null default 200 comment '센서에 탑재된 스캐너를 이용하여 스캔할 때 사용할 해상도',
#     sensor_scan_area_contrast                                     int(11)      not null default 12 comment '센서에 탑재된 스캐너를 이용하여 스캔할 때 사용할 대비(Contrast)',
#     sensor_scan_area_height                                       int(11)      not null default 297 comment '센서에 탑재된 스캐너를 이용하여 스캔할 때 사용할 스캔 페이지 높이의 값(H)',
#     sensor_scan_area_width                                        int(11)      not null default 210 comment '센서에 탑재된 스캐너를 이용하여 스캔할 때 사용할 스캔 페이지 넓이의 값(W)',
#
#     -- 전송 정보
#     sensor_transfer_page_count                                    bigint       not null default 0 comment '센서에 탑재된 스캐너를 이용하여 스캔된 페이지가 게이트웨이엔진 서버로 전송된 수',
#     sensor_transfer_page_retry_count                              bigint       not null default 0 comment '센서에 탑재된 스캐너를 이용하여 스캔된 페이지가 게이트웨이엔진 서버가 요청하여 재전송한 수',
#
#     -- 파기 정보
#     sensor_stop_crushing_callback_time                            int(11)      not null default 3 comment '센서에 탑재된 파쇄기의 동작을 정지시킬 콜백 함수 시간을 위한 지연 시간(초/sec)',
#
#     -- 문서파기함 정보
#     sensor_destruction_document_box_total_height                  double       not null default 60.0 comment '센서에 탑재된 문서파기함의 최대 깊이 값(cm)',
#     sensor_destruction_document_box_current_height                double       not null default 0.0 comment '센서에 탑재된 문서파기함의 깊이 측정한 값(cm)',
#     sensor_destruction_document_box_current_height_check_interval int(11)      not null default 60 comment '센서에 탑재된 문서파기함의 깊이 측정을 수행하는 시간 간격(초/sec)',
#
#     -- 소프트웨어버전 정보
#     sensor_software_ui_version                                    varchar(255) not null default '1.0.0' comment '센서에 탑재된 UI 소프트웨어의 버전',
#     sensor_software_engine_version                                varchar(255) not null default '1.0.0' comment '센서에 탑재된 엔진 소프트웨어의 버전',
#
#     -- 네트워크 정보
#     sensor_network_ip                                             varchar(255) not null comment '센서의 네트워크 IP',
#     sensor_network_service_port                                   int(11)      not null default 38000 comment '센서의 엔진이 바인딩되는 네트워크 서비스 포트',
#     sensor_network_ssh_port                                       int(11)      not null default 2202 comment '센서의 SSH 프로세스가 바인되는 포트',
#     sensor_network_mac                                            varchar(255) not null comment '센서의 이더넷 주소(MAC)',
#
#     -- 게이트웨이엔진 서버
#     gateway_engine_id                                             bigint comment '게이트웨이엔진 서버(해당 게이트웨이엔진에서 ping/pong 수행)',
#
#     created_at                                                    datetime(6)  not null comment '센서의 정보 생성 일시',
#     updated_at                                                    datetime(6)  null comment '센서의 정보 수정 일시'
# ) comment '센서(개인정보 문서 파기 장치)' charset = utf8mb4;
#
# alter table sensor
#     add constraint fk_sensor_01
#         foreign key (gateway_engine_id)
#             references gateway_engine (gateway_engine_id)
#             on update cascade
#             on delete cascade;
#
# create
#     index sensor_idx01 on sensor (sensor_token);
#
# create
#     index sensor_idx02 on sensor (created_at);
#
# create
#     index sensor_idx03 on sensor (updated_at);
#
# create
#     unique index sensor_unique_idx01 on sensor (sensor_scanner_id);
#
# -- message
# drop table if exists message;
# create table message
# (
#     -- 기본 정보
#     message_id       bigint auto_increment primary key comment '메시지의 식별자',
#     message_token    varchar(255)  not null comment '메시지를 구분하기 위한 대체키',
#     message_status   varchar(255)  not null comment '메시지의 상태',
#
#     -- 송신 정보
#     message_sender   varchar(1024) not null comment '메시지 송신자',
#     message_sent_at  datetime(6)   not null comment '메시지 송신 시간',
#
#     -- 수신 정보
#     message_receiver varchar(255)  not null comment '메시지 수신자',
#     message_read_at  datetime(6) comment '메시지 수신 시간',
#
#     -- 메시지 정보
#     message_title    varchar(255)  not null comment '메시지 제목',
#     message_body     varchar(255)  not null comment '메시지 본문'
# ) comment '메시지' charset = utf8mb4;
#
# create
#     index message_idx01 on message (message_token);
#
# create
#     index message_idx02 on message (message_receiver);

-- department
drop table if exists department;
create table department
(
    -- 기본 정보
    department_id        bigint auto_increment primary key comment '부서의 식별자',
    department_token     varchar(255)  not null comment '부서를 구분하기 위한 대체키',
    department_name      varchar(255)  not null comment '부서의 이름',

    -- 상위 부서 정보
    department_path      varchar(2048) not null comment '부서와 상위 부서의 명칭 나열',
    department_parent_id bigint comment '부서의 상위 부서 식별자',

    -- 추가 정보
    department_order     int comment '부서 정렬',

    created_at           datetime(6)   not null comment '부서의 정보 생성 일시',
    updated_at           datetime(6)   null comment '부서의 정보 수정 일시'
) comment '부서' charset = utf8mb4;

create
    index department_idx01 on department (department_token);

create
    index department_idx02 on department (created_at);

create
    index department_idx03 on department (updated_at);

alter table department
    add constraint fk_department_01
        foreign key (department_parent_id)
            references department (department_id)
            on update cascade
            on delete cascade;

-- menu
drop table if exists menu;
create table menu
(
    -- 기본 정보
    menu_id          bigint auto_increment primary key comment '메뉴 식별자',
    menu_token       varchar(255)  not null comment '메뉴를 구분하기 위한 대체키',
    menu_name        varchar(255)  not null comment '메뉴의 이름',
    menu_description varchar(1024) comment '메뉴의 설명',
    menu_enable      boolean default true comment '메뉴 사용 여부',

    -- 상위 메뉴 정보
    menu_path        varchar(4096) not null comment '메뉴와 상위 메뉴의 명칭 나열',
    menu_parent_id   bigint comment '메뉴의 상위 부서 식별자',

    created_at       datetime(6)   not null comment '메뉴의 정보 생성 일시',
    updated_at       datetime(6)   null comment '메뉴의 정보 수정 일시'
) comment '프로그램' charset = utf8mb4;

alter table menu
    add constraint fk_menu_01
        foreign key (menu_parent_id)
            references menu (menu_id)
            on update cascade
            on delete cascade;

create
    index menu_idx01 on menu (menu_token);

create
    index menu_idx02 on menu (created_at);

create
    index menu_idx03 on menu (updated_at);

-- program
drop table if exists program;
create table program
(
    -- 기본 정보
    program_id          bigint auto_increment primary key comment '프로그램의 식별자',
    program_token       varchar(255) not null comment '프로그램을 구분하기 위한 대체키',
    program_name        varchar(255) not null comment '프로그램의 이름',
    program_description varchar(1024) comment '프로그램의 설명',
    program_enable      boolean default true comment '프로그램의 사용 여부',

    created_at          datetime(6)  not null comment '프로그램의 정보 생성 일시',
    updated_at          datetime(6)  null comment '프로그램의 정보 수정 일시'
) comment '프로그램' charset = utf8mb4;

create
    index program_idx01 on program (program_token);

create
    index program_idx02 on program (created_at);

create
    index program_idx03 on program (updated_at);

-- role
drop table if exists role;
create table role
(
    -- 기본 정보
    role_id          bigint auto_increment primary key comment '역할의 식별자',
    role_token       varchar(255) not null comment '역할을 구분하기 위한 대체키',
    role_name        varchar(255) not null comment '역할의 이름',
    role_description varchar(1024) comment '역할의 설명',
    role_enable      boolean default true comment '역할의 사용 여부',

    created_at          datetime(6)  not null comment '역할의 정보 생성 일시',
    updated_at          datetime(6)  null comment '역할의 정보 수정 일시'
) comment '역할' charset = utf8mb4;

create
    index role_idx01 on role (role_token);

create
    index role_idx02 on role (created_at);

create
    index role_idx03 on role (updated_at);

-- authority
drop table if exists authority;
create table authority
(
    -- 기본 정보
    authority_id          bigint auto_increment primary key comment '권한의 식별자',
    authority_token       varchar(255) not null comment '권한을 구분하기 위한 대체키',
    authority_name        varchar(255) not null comment '권한의 이름',
    authority_description varchar(1024) comment '권한의 설명',
    authority_enable      boolean default true comment '권한의 사용 여부',

    created_at          datetime(6)  not null comment '권한의 정보 생성 일시',
    updated_at          datetime(6)  null comment '권한의 정보 수정 일시'
) comment '권한' charset = utf8mb4;

create
    index authority_idx01 on authority (authority_token);

create
    index authority_idx02 on authority (created_at);

create
    index authority_idx03 on authority (updated_at);

set foreign_key_checks = 1; -- 외래키 체크 설정