CREATE TABLE vendor (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  url varchar(255),
  name varchar(255),
  description text
);

CREATE TABLE measure (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  value varchar(255)
);

CREATE TABLE size (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  value varchar(255),
  measure_id bigint
);

CREATE TABLE currency (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  type varchar(255)
);

CREATE TABLE color (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  code varchar(255),
  name varchar(255)
);

CREATE TABLE brand (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  name varchar(255)
);

CREATE TABLE type (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  code varchar(255),
  name varchar(255)
);

CREATE TABLE gender (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  code varchar(255)
);

CREATE TABLE bike_frame (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  code varchar(255),
  name varchar(255)
);

CREATE TABLE helmet_type (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  code varchar(255),
  name varchar(255)
);

CREATE TABLE product (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  sku varchar(255),
  name varchar(255),
  description varchar(255),
  brand_id bigint,
  vendor_id bigint,
  type_id bigint,
  price decimal,
  currency_id bigint,
  rating_value bigint,
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE product_images (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  product_id bigint,
  image_path varchar(255)
);

CREATE TABLE product_colors (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  product_id bigint,
  color_id bigint
);

CREATE TABLE product_sizes (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  product_id bigint,
  size_id bigint
);

CREATE TABLE product_genders (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  product_id bigint,
  gender_id bigint
);

CREATE TABLE bike (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  frame_id bigint
);

CREATE TABLE accessory (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  note varchar(255)
);

CREATE TABLE helmet (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  helmet_type_id bigint
);

ALTER TABLE type COMMENT = 'bike, helmet, kit, accessory';

ALTER TABLE bike_frame COMMENT = 'full susspension, hard tale, carbon, other';

ALTER TABLE helmet_type COMMENT = 'fullface, openface';

ALTER TABLE size ADD FOREIGN KEY (measure_id) REFERENCES measure (id);

ALTER TABLE product ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);

ALTER TABLE product ADD FOREIGN KEY (type_id) REFERENCES type (id);

ALTER TABLE product ADD FOREIGN KEY (brand_id) REFERENCES brand (id);

ALTER TABLE product ADD FOREIGN KEY (currency_id) REFERENCES currency (id);

ALTER TABLE product_images ADD FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_colors ADD FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_colors ADD FOREIGN KEY (color_id) REFERENCES color (id);

ALTER TABLE product_sizes ADD FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_sizes ADD FOREIGN KEY (size_id) REFERENCES size (id);

ALTER TABLE product_genders ADD FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_genders ADD FOREIGN KEY (gender_id) REFERENCES gender (id);

ALTER TABLE bike ADD FOREIGN KEY (id) REFERENCES product (id);

ALTER TABLE bike ADD FOREIGN KEY (frame_id) REFERENCES bike_frame (id);

ALTER TABLE accessory ADD FOREIGN KEY (id) REFERENCES product (id);

ALTER TABLE helmet ADD FOREIGN KEY (id) REFERENCES product (id);

ALTER TABLE helmet ADD FOREIGN KEY (helmet_type_id) REFERENCES helmet_type (id);
