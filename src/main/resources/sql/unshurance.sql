USE `web_customer_tracker`;

DROP TABLE IF EXISTS insurance;

CREATE TABLE insurance(
  id int(11) NOT NULL AUTO_INCREMENT,
  agent varchar(45) DEFAULT NULL ,
  offices varchar(300) DEFAULT NULL ,
  location varchar(100) DEFAULT NULL ,
  created_date date NOT NULL ,
  start_date_insurance date DEFAULT NULL ,
  first_name varchar (150) NOT NULL ,
  last_name varchar (150) NOT NULL ,
  patronymic varchar (150) NOT NULL ,
  fio varchar (150) NOT NULL ,
  phone_number varchar (11) NOT NULL ,
  insurance_name varchar (100) NOT NULL ,
  model_auto varchar (100) NOT NULL ,
  kind_insurance varchar (100) DEFAULT NULL ,
  base_rate integer (10) DEFAULT NULL ,
  price integer (10) DEFAULT NULL ,
  discount integer (10) DEFAULT NULL ,
  discount_price integer (10) DEFAULT NULL ,
  delivery integer (10) DEFAULT NULL ,
  result_price integer (10) DEFAULT NULL ,
  kv integer (10) DEFAULT NULL ,
  kv_summary integer (10) DEFAULT NULL ,
  dk varchar (400) DEFAULT NULL ,
  admin_salery integer (10) DEFAULT NULL ,
  our_summary integer (10) DEFAULT NULL ,
  cashbox integer (10) DEFAULT NULL ,
  displayed integer (10) DEFAULT NULL ,
  displayed_everyone integer (10) DEFAULT NULL ,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =latin1;