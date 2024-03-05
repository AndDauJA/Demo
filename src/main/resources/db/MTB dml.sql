insert into vendor (id, url, name, description)
values (-1, 'test.vendor.demo', 'Test Vendor Demo', 'Used only for demo data');

insert into vendor (url, name, description)
values ('contextridewear.co.uk', 'Context Ridewear Ltd', null);

insert into type (code, name)
values ('BIKE', 'bike'),
       ('HELMET', 'helmet'),
       ('KIT', 'kit'),
       ('ACCESSORY', 'accessory');

insert into gender (code)
values ('MALE'),
       ('FEMALE');

insert into size (value)
values ('XXS'),
       ('XS'),
       ('S'),
       ('M'),
       ('L'),
       ('XL'),
       ('XXL');

insert into color (code, name)
values ('BLACK', 'black'),
       ('WHITE', 'white'),
       ('YELLOW', 'yellow'),
       ('RED', 'red'),
       ('PURPLE', 'purple'),
       ('PINK', 'pink'),
       ('GREEN', 'green'),
       ('GRAY', 'gray'),
       ('BLUE', 'blue');

insert into brand (name)
values ('Context ridewear');

-- Inserting data into 'measure'
INSERT INTO measure (value)
VALUES ('cm'),
       ('inches');

-- Inserting data into 'size'
INSERT INTO size (value, measure_id)
VALUES ('42', 1),
       ('10', 2);

-- Inserting data into 'currency'
INSERT INTO currency (type)
VALUES ('EUR'),
       ('USD'),
       ('GBP');

-- Inserting data into 'product'
INSERT INTO product (sku, name, description, brand_id, vendor_id, type_id, price, currency_id, rating_value, d_type,
                     created_at, updated_at)
VALUES ('SKU123', 'Road Bike', 'A high-quality road bike.', 1, -1, 1, 1000, 3, 5, 'Bike',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('SKU124', 'Mountain Bike Helmet', 'Durable helmet for mountain biking.', 1, -1, 2, 150, 3, 4, 'Helmet',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserting data into 'product_images'
INSERT INTO product_images (product_id, image_path)
VALUES (1, 'images/product1.jpg'),
       (2, 'images/product2.jpg');

-- Inserting data into 'product_colors'
INSERT INTO product_colors (product_id, color_id)
VALUES (1, 1),
       (2, 2);

-- Inserting data into 'product_sizes'
INSERT INTO product_sizes (product_id, size_id)
VALUES (1, 1),
       (2, 2);

-- Inserting data into 'product_genders'
INSERT INTO product_genders (product_id, gender_id)
VALUES (1, 1),
       (2, 2);

-- Inserting data into 'bike_frame'
INSERT INTO bike_frame (code, name)
VALUES ('carbon', 'Carbon Frame'),
       ('aluminum', 'Aluminum Frame');

-- Inserting data into 'bike'
INSERT INTO bike (id, frame_id)
VALUES (1, 1);

-- Inserting data into 'accessory'
INSERT INTO accessory (id, note)
VALUES (2, 'High durability and lightweight.');

-- Inserting data into 'helmet_type'
INSERT INTO helmet_type (code, name)
VALUES ('fullface', 'Full Face'),
       ('openface', 'Open Face');

-- Inserting data into 'helmet'
INSERT INTO helmet (id, helmet_type_id)
VALUES (2, 1);

-- Inserting data into 'product_bike_frames'
INSERT INTO product_bike_frames (bike_frame_id, product_id)
VALUES (1, 1);


