DROP TABLE IF EXISTS product_images;
DROP TABLE IF EXISTS product_colors;
DROP TABLE IF EXISTS product_sizes;
DROP TABLE IF EXISTS product_genders;
DROP TABLE IF EXISTS bike;
DROP TABLE IF EXISTS accessory;
DROP TABLE IF EXISTS helmet;
DROP TABLE IF EXISTS product;

DROP TABLE IF EXISTS bike_frame;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS gender;
DROP TABLE IF EXISTS helmet_type;
DROP TABLE IF EXISTS size;
DROP TABLE IF EXISTS measure;
DROP TABLE IF EXISTS vendor;
DROP TABLE IF EXISTS type;

CREATE TABLE vendor (
  id serial PRIMARY KEY,
  url varchar(255),
  name varchar(255),
  description text
);

CREATE TABLE measure (
  id serial PRIMARY KEY,
  value varchar(255)
);

CREATE TABLE size (
  id serial PRIMARY KEY,
  value varchar(255),
  measure_id int
);
ALTER TABLE size ADD FOREIGN KEY (measure_id) REFERENCES measure (id);

CREATE TABLE currency (
  id serial PRIMARY KEY,
  type varchar(255)
);

CREATE TABLE color (
  id serial PRIMARY KEY,
  code varchar(255),
  name varchar(255)
);

CREATE TABLE brand (
  id serial PRIMARY KEY,
  name varchar(255)
);

CREATE TABLE type (
  id serial PRIMARY KEY,
  code varchar(255),
  name varchar(255)
);
ALTER TABLE type COMMENT = 'bike, helmet, kit, accessory';

CREATE TABLE gender (
  id serial PRIMARY KEY,
  code varchar(255)
);

CREATE TABLE bike_frame (
  id serial PRIMARY KEY,
  code varchar(255),
  name varchar(255)
);
ALTER TABLE bike_frame COMMENT = 'full susspension, hard tale, carbon, other';


CREATE TABLE helmet_type (
  id serial PRIMARY KEY,
  code varchar(255),
  name varchar(255)
);
ALTER TABLE helmet_type COMMENT = 'fullface, openface';
ALTER TABLE helmet_type ADD FOREIGN KEY (id) REFERENCES helmet (helmet_type_id);

CREATE TABLE product (
  id serial PRIMARY KEY,
  sku varchar(255),
  name varchar(255),
  description varchar(255),
  brand_id integer,
  vendor_id integer,
  type_id integer,
  price decimal,
  currency_id integer,
  rating_value integer,
  created_at timestamp,
  updated_at timestamp
);
ALTER TABLE product ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
ALTER TABLE product ADD FOREIGN KEY (type_id) REFERENCES type (id);
ALTER TABLE product ADD FOREIGN KEY (brand_id) REFERENCES brand (id);
ALTER TABLE product ADD FOREIGN KEY (currency_id) REFERENCES currency (id);

CREATE TABLE product_images (
  id serial PRIMARY KEY,
  product_id integer,
  image_path varchar(255)
);
ALTER TABLE product_images ADD FOREIGN KEY (product_id) REFERENCES product (id);

CREATE TABLE product_colors (
  id serial PRIMARY KEY,
  product_id integer,
  color_id integer
);
ALTER TABLE product_colors ADD FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE product_colors ADD FOREIGN KEY (color_id) REFERENCES color (id);

CREATE TABLE product_sizes (
  id serial PRIMARY KEY,
  product_id integer,
  size_id integer
);
ALTER TABLE product_sizes ADD FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE product_sizes ADD FOREIGN KEY (size_id) REFERENCES size (id);

CREATE TABLE product_genders (
  id serial PRIMARY KEY,
  product_id integer,
  gender_id integer
);
ALTER TABLE product_genders ADD FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE product_genders ADD FOREIGN KEY (gender_id) REFERENCES gender (id);

CREATE TABLE bike (
  id serial PRIMARY KEY,
  frame_id integer
);
ALTER TABLE bike ADD FOREIGN KEY (id) REFERENCES product (id);
ALTER TABLE bike ADD FOREIGN KEY (frame_id) REFERENCES bike_frame (id);

CREATE TABLE accessory (
  id serial PRIMARY KEY,
  note varchar(255)
);
ALTER TABLE accessory ADD FOREIGN KEY (id) REFERENCES product (id);

CREATE TABLE helmet (
  id serial PRIMARY KEY,
  helmet_type_id integer
);
ALTER TABLE helmet ADD FOREIGN KEY (id) REFERENCES product (id);
