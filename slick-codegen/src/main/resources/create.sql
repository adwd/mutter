SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS FOLLOW_TABLE;
DROP TABLE IF EXISTS TWEET_TABLE;
DROP TABLE IF EXISTS MEMBER_TABLE;




/* Create Tables */

CREATE TABLE FOLLOW_TABLE
(
	-- メンバーのユニークなID
	FOLLOWED_ID varchar(30) NOT NULL COMMENT 'メンバーのユニークなID',
	-- ユニークなユーザー名
	MEMBER_ID varchar(30) NOT NULL COMMENT 'ユニークなユーザー名',
	-- 作成時タイムスタンプ
	TIMESTAMP_CREATED timestamp NOT NULL COMMENT '作成時タイムスタンプ',
	-- 更新タイムスタンプ
	TIMESTAMP_UPDATED timestamp COMMENT '更新タイムスタンプ',
	PRIMARY KEY (FOLLOWED_ID),
	UNIQUE (FOLLOWED_ID),
	UNIQUE (MEMBER_ID)
);


CREATE TABLE MEMBER_TABLE
(
	-- ユニークなユーザー名
	MEMBER_ID varchar(30) NOT NULL COMMENT 'ユニークなユーザー名',
	-- ユニークでないユーザ名
	NAME varchar(30) COMMENT 'ユニークでないユーザ名',
	-- 暗号化されたパスワード
	ENCRYPTED_PASSWORD varchar(60) NOT NULL COMMENT '暗号化されたパスワード',
	-- メールアドレス
	MAIL_ADDRESS varchar(40) NOT NULL COMMENT 'メールアドレス',
	-- 作成時タイムスタンプ
	TIMESTAMP_CREATED timestamp NOT NULL COMMENT '作成時タイムスタンプ',
	-- 更新タイムスタンプ
	TIMESTAMP_UPDATED timestamp COMMENT '更新タイムスタンプ',
	PRIMARY KEY (MEMBER_ID),
	UNIQUE (MEMBER_ID)
);


CREATE TABLE TWEET_TABLE
(
	TWEET_ID bigint NOT NULL AUTO_INCREMENT,
	-- ツイート本文
	TEXT varchar(140) COMMENT 'ツイート本文',
	-- ユニークなユーザー名
	MEMBER_ID varchar(30) NOT NULL COMMENT 'ユニークなユーザー名',
	-- 作成時タイムスタンプ
	TIMESTAMP_CREATED timestamp NOT NULL COMMENT '作成時タイムスタンプ',
	-- 更新タイムスタンプ
	TIMESTAMP_UPDATED timestamp COMMENT '更新タイムスタンプ',
	PRIMARY KEY (TWEET_ID),
	UNIQUE (TWEET_ID)
);



/* Create Foreign Keys */

ALTER TABLE FOLLOW_TABLE
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER_TABLE (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TWEET_TABLE
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER_TABLE (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;