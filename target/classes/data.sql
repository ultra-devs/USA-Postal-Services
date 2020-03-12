DROP TABLE IF EXISTS  zipcodeinfo;
create table zipcodeinfo (  id INT AUTO_INCREMENT  PRIMARY KEY, accuracy varchar(255),admin_code_1 varchar(20),admin_code_2 varchar(20),admin_code_3 varchar(20),admin_name_1 varchar(100),admin_name_2 varchar(100),admin_name_3 varchar(100),country char(2),lattitude  NUMERIC(18,3),longitude  NUMERIC(18,3),place_name varchar(180),postal_code varchar(20));
-- based on currently implemented APIS required indexes
CREATE INDEX STATECODEINDX ON ZIPCODEINFO(ADMIN_CODE_1);
CREATE INDEX POSTALCODEINDX ON ZIPCODEINFO(POSTAL_CODE);

