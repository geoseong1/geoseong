-- New 데이터베이스 생성
create database geoseong;

-- 계정 생성
CREATE USER geoseong@localhost IDENTIFIED BY '1234';

-- 계정 권한 부여
grant all on geoseong.* to geoseong@localhost;

-- 자신의 계정에 부여된 권한 확인
show grants for geoseong@localhost;

-- grant 테이블을 reload 함으로 변경사항을 바로 적용해주는 명령어
/* 일반 계정에서는 권한을 물려받지 않는 한 동작하지 않는다. */
flush privileges;