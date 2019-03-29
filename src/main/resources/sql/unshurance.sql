USE `web_customer_tracker`;

DROP TABLE IF EXISTS insurance;

CREATE TABLE osago
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    agent varchar(45),
    offices varchar(300),
    location varchar(100),
    created_date varchar(100),
    start_date_insurance varchar(100),
    insurance_name varchar(100) NOT NULL,
    model_auto varchar(100) NOT NULL,
    kind_insurance varchar(100),
    base_rate int(10),
    price decimal(10,2),
    discount decimal(10,2),
    discount_price decimal(10,2),
    delivery int(10),
    result_price decimal(10,2),
    kv int(10),
    kv_summary int(10),
    dk varchar(400),
    admin_salery int(10),
    our_summary int(10),
    cashbox int(10),
    displayed int(10),
    displayed_everyone int(10),
    customer_id int(11),
    CONSTRAINT FK_DETAIL FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE INDEX FK_CUSTOMER_idx ON osago (customer_id);