-- July 2 2020
-- use covid19 (database)

CREATE TABLE IF NOT EXISTS tbluser (
	id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	name varchar(50) NOT NULL,
	username varchar(50) NOT NULL,
	password varchar(30) NOT NULL,
	access varchar(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS tblcountry (
	id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	isd varchar(10) NOT NULL,
	status boolean NOT NULL DEFAULT true,
	createdon datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	createdby varchar(50) NOT NULL DEFAULT 'Wander',
	updatedon datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updatedby varchar(50) NOT NULL DEFAULT 'Wander'
);

CREATE TABLE IF NOT EXISTS tbllocation (
	id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	pin int(6) NOT NULL,
	city varchar(50) NOT NULL,
	state varchar(50) NOT NULL,
	country varchar(50) NOT NULL,
	status boolean NOT NULL DEFAULT true,
	createdon datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	createdby varchar(50) NOT NULL DEFAULT 'Wander',
	updatedon datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updatedby varchar(50) NOT NULL DEFAULT 'Wander'
);

CREATE TABLE IF EXISTS tblcase (
	id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	contact int(11) NOT NULL,
	address varchar(500) NOT NULL,
	location varchar(50) NOT NULL,
	confirmeddate datetime NULL,
	status boolean NOT NULL DEFAULT true
	dischargedate datetime NULL
);
