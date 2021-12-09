set foreign_key_checks = 0;

-- department
drop table if exists department;
create table department
(
    -- 기본 정보
    department_id          bigint auto_increment primary key comment '부서의 식별자',
    department_token       varchar(255)  not null comment '부서를 구분하기 위한 대체키',
    department_name        varchar(255)  not null comment '부서의 이름',
    department_description varchar(1024) comment '부서의 설명',
    department_enable      boolean default true comment '부서 사용 여부',

    -- 상위 부서 정보
    department_path        varchar(2048) not null comment '부서와 상위 부서의 명칭 나열',
    department_parent_id   bigint comment '부서의 상위 부서 식별자',

    -- 추가 정보
    department_order       int comment '부서 정렬',

    created_at             datetime(6)   not null comment '부서의 정보 생성 일시',
    updated_at             datetime(6)   null comment '부서의 정보 수정 일시'
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

    -- 화면 정보
    screen_id           bigint comment '프로그램에 속하는 화면의 식별자',

    -- API 정보
    api_id              bigint comment '프로그램에 속하는 API의 식별자',

    -- 권한 정보
    authority_id        bigint comment '프고르매이 속하는 권한의 식별자',

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

    created_at       datetime(6)  not null comment '역할의 정보 생성 일시',
    updated_at       datetime(6)  null comment '역할의 정보 수정 일시'
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

    created_at            datetime(6)  not null comment '권한의 정보 생성 일시',
    updated_at            datetime(6)  null comment '권한의 정보 수정 일시'
) comment '권한' charset = utf8mb4;

create
    index authority_idx01 on authority (authority_token);

create
    index authority_idx02 on authority (created_at);

create
    index authority_idx03 on authority (updated_at);

-- api
drop table if exists api;
create table api
(
    -- 기본 정보
    api_id          bigint auto_increment primary key comment 'API의 식별자',
    api_token       varchar(255)  not null comment 'API를 구분하기 위한 대체키',
    api_name        varchar(255)  not null comment 'API의 이름',
    api_description varchar(1024) comment 'API의 설명',
    api_method      varchar(255)  not null comment 'API 호출 방법(GET, POST, PUT, DELETE, etc)',
    api_url         varchar(4096) not null comment 'API의 URL',
    api_enable      boolean default true comment 'API의 사용 여부',

    created_at      datetime(6)   not null comment 'API의 정보 생성 일시',
    updated_at      datetime(6)   null comment 'API의 정보 수정 일시'
) comment 'API' charset = utf8mb4;

create
    index api_idx01 on api (api_token);

create
    index api_idx02 on api (created_at);

create
    index api_idx03 on api (updated_at);

-- screen
drop table if exists screen;
create table screen
(
    -- 기본 정보
    screen_id          bigint auto_increment primary key comment '화면의 식별자',
    screen_token       varchar(255) not null comment '화면을 구분하기 위한 대체키',
    screen_name        varchar(255) not null comment '화면의 이름',
    screen_description varchar(1024) comment '화면의 설명',
    screen_enable      boolean default true comment '화면의 사용 여부',

    created_at         datetime(6)  not null comment '화면의 정보 생성 일시',
    updated_at         datetime(6)  null comment '화면의 정보 수정 일시'
) comment '화면' charset = utf8mb4;

create
    index screen_idx01 on screen (screen_token);

create
    index screen_idx02 on screen (created_at);

create
    index screen_idx03 on screen (updated_at);

-- screen button
drop table if exists screen_button;
create table screen_button
(
    -- 기본 정보
    screen_button_id          bigint auto_increment primary key comment '화면버튼의 식별자',
    screen_button_token       varchar(255)  not null comment '화면버튼을 구분하기 위한 대체키',
    screen_button_name        varchar(255)  not null comment '화면버튼의 이름',
    screen_button_description varchar(1024) comment '화면버튼의 설명',
    screen_button_method      varchar(255)  not null comment '화면버튼 URL의 HTTP 메소드',
    screen_button_url         varchar(4096) not null comment '화면버튼의 URL',
    screen_button_enable      boolean default true comment '화면버튼의 사용 여부',

    -- 화면 정보
    screen_id                 bigint        not null comment '화면버튼이 속한 화면의 식별자',

    created_at                datetime(6)   not null comment '화면버튼의 정보 생성 일시',
    updated_at                datetime(6)   null comment '화면버튼의 정보 수정 일시'
) comment '화면' charset = utf8mb4;

alter table screen_button
    add constraint fk_screen_button_01
        foreign key (screen_id)
            references screen (screen_id)
            on update cascade
            on delete cascade;

create
    index screen_button_idx01 on screen_button (created_at);

create
    index screen_button_idx03 on screen_button (updated_at);

set foreign_key_checks = 1; -- 외래키 체크 설정