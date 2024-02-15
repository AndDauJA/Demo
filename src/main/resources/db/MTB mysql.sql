DROP TABLE IF EXISTS product_images CASCADE;
DROP TABLE IF EXISTS product_colors CASCADE;
DROP TABLE IF EXISTS product_sizes CASCADE;
DROP TABLE IF EXISTS product_genders CASCADE;
DROP TABLE IF EXISTS product_bike_frames CASCADE;
DROP TABLE IF EXISTS bike CASCADE;
DROP TABLE IF EXISTS accessory CASCADE;
DROP TABLE IF EXISTS helmet CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS bike_frame CASCADE;
DROP TABLE IF EXISTS brand CASCADE;
DROP TABLE IF EXISTS color CASCADE;
DROP TABLE IF EXISTS currency CASCADE;
DROP TABLE IF EXISTS gender CASCADE;
DROP TABLE IF EXISTS helmet_type CASCADE;
DROP TABLE IF EXISTS size CASCADE;
DROP TABLE IF EXISTS measure CASCADE;
DROP TABLE IF EXISTS vendor CASCADE;
DROP TABLE IF EXISTS type CASCADE;

CREATE TABLE vendor
(
    id          bigint PRIMARY KEY AUTO_INCREMENT,
    url         varchar(255),
    name        varchar(255),
    description text
);

CREATE TABLE measure
(
    id    bigint PRIMARY KEY AUTO_INCREMENT,
    value varchar(255)
);

CREATE TABLE size
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    value      varchar(255),
    measure_id bigint
);
ALTER TABLE size
    ADD FOREIGN KEY (measure_id) REFERENCES measure (id);

CREATE TABLE currency
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    type varchar(255)
);

CREATE TABLE color
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    code varchar(255),
    name varchar(255)
);

CREATE TABLE brand
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(255)
);

CREATE TABLE type
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    code varchar(255),
    name varchar(255)
);
ALTER TABLE type
    COMMENT = 'bike, helmet, kit, accessory';

CREATE TABLE gender
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    code varchar(255)
);

CREATE TABLE product
(
    id           bigint PRIMARY KEY AUTO_INCREMENT,
    sku          varchar(255),
    name         varchar(255),
    description  varchar(255),
    brand_id     bigint,
    vendor_id    bigint,
    type_id      bigint,
    price        decimal,
    currency_id  bigint,
    rating_value bigint,
    d_type       varchar(31) NOT NULL,
    created_at   timestamp,
    updated_at   timestamp
);
ALTER TABLE product
    ADD FOREIGN KEY (vendor_id) REFERENCES vendor (id);
ALTER TABLE product
    ADD FOREIGN KEY (type_id) REFERENCES type (id);
ALTER TABLE product
    ADD FOREIGN KEY (brand_id) REFERENCES brand (id);
ALTER TABLE product
    ADD FOREIGN KEY (currency_id) REFERENCES currency (id);

CREATE TABLE product_images
(
    id         bigint PRIMARY KEY AUTO_INCREMENT,
    product_id bigint,
    image_path varchar(255)
);
ALTER TABLE product_images
    ADD FOREIGN KEY (product_id) REFERENCES product (id);

CREATE TABLE product_colors
(
    product_id bigint,
    color_id   bigint,
    primary key (color_id, product_id),
    constraint product_colors_product_id_fkey
        foreign key (product_id) references product (id),
    constraint product_colors_color_id_fkey
        foreign key (color_id) references color (id)
);

CREATE TABLE product_sizes
(
    product_id bigint,
    size_id    bigint,
    primary key (size_id, product_id),
    constraint product_sizes_product_id_fkey
        foreign key (product_id) references product (id),
    constraint product_sizes_size_id_fkey
        foreign key (size_id) references size (id)
);

CREATE TABLE product_genders
(
    product_id bigint,
    gender_id  bigint,
    primary key (gender_id, product_id),
    constraint product_genders_product_id_fkey
        foreign key (product_id) references product (id),
    constraint product_genders_gender_id_fkey
        foreign key (gender_id) references gender (id)
);

CREATE TABLE bike_frame
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    code varchar(255),
    name varchar(255)
);
ALTER TABLE bike_frame
    COMMENT = 'full susspension, hard tale, carbon, other';

CREATE TABLE bike
(
    id       bigint PRIMARY KEY AUTO_INCREMENT,
    frame_id bigint
);
ALTER TABLE bike
    ADD FOREIGN KEY (id) REFERENCES product (id);
ALTER TABLE bike
    ADD FOREIGN KEY (frame_id) REFERENCES bike_frame (id);


CREATE TABLE accessory
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    note varchar(255)
);
ALTER TABLE accessory
    ADD FOREIGN KEY (id) REFERENCES product (id);

CREATE TABLE helmet_type
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    code varchar(255),
    name varchar(255)
);
ALTER TABLE helmet_type
    COMMENT = 'fullface, openface';

CREATE TABLE helmet
(
    id             bigint PRIMARY KEY AUTO_INCREMENT,
    helmet_type_id bigint
);
ALTER TABLE helmet
    ADD FOREIGN KEY (id) REFERENCES helmet_type (id);

create table product_bike_frames
(
    bike_frame_id  bigint not null,
    product_id     bigint not null,
    primary key (bike_frame_id, product_id),
    constraint product_bike_frames_bike_frames_id_fkey
        foreign key (bike_frame_id) references bike_frame (id),
    constraint product_bike_frames_product_id_fkey
        foreign key (product_id) references product (id)
);
