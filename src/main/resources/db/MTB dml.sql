-- Inserting data into 'vendor'
INSERT INTO vendor (url, name, description) VALUES
                                                ('http://examplevendor.com', 'Example Vendor', 'A leading provider of quality cycling gear.'),
                                                ('http://anothervendor.com', 'Another Vendor', 'Innovative cycling accessories and apparel.');

-- Inserting data into 'measure'
INSERT INTO measure (value) VALUES
                                ('cm'),
                                ('inches');

-- Inserting data into 'size'
INSERT INTO size (value, measure_id) VALUES
                                         ('42', 1),
                                         ('10', 2);

-- Inserting data into 'currency'
INSERT INTO currency (type) VALUES
                                ('EUR'),
                                ('USD');

-- Inserting data into 'color'
INSERT INTO color (code, name) VALUES
                                   ('#000000', 'Black'),
                                   ('#FFFFFF', 'White');

-- Inserting data into 'brand'
INSERT INTO brand (name) VALUES
                             ('Nike'),
                             ('Puma');

-- Inserting data into 'type'
INSERT INTO type (code, name) VALUES
                                  ('bike', 'Bicycle'),
                                  ('helmet', 'Helmet'),
                                  ('kit', 'Cycling Kit'),
                                  ('accessory', 'Accessory');

-- Inserting data into 'gender'
INSERT INTO gender (code) VALUES
                              ('M'),
                              ('F');

-- Inserting data into 'product'
INSERT INTO product (sku, name, description, brand_id, vendor_id, type_id, price, currency_id, rating_value, d_type, created_at, updated_at) VALUES
                                                                                                                                                 ('SKU123', 'Road Bike', 'A high-quality road bike.', 1, 1, 1, 1000, 1, 5, 'bike', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                                                                                 ('SKU124', 'Mountain Bike Helmet', 'Durable helmet for mountain biking.', 2, 2, 2, 150, 2, 4, 'helmet', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserting data into 'product_images'
INSERT INTO product_images (product_id, image_path) VALUES
                                                        (1, 'images/product1.jpg'),
                                                        (2, 'images/product2.jpg');

-- Inserting data into 'product_colors'
INSERT INTO product_colors (product_id, color_id) VALUES
                                                      (1, 1),
                                                      (2, 2);

-- Inserting data into 'product_sizes'
INSERT INTO product_sizes (product_id, size_id) VALUES
                                                    (1, 1),
                                                    (2, 2);

-- Inserting data into 'product_genders'
INSERT INTO product_genders (product_id, gender_id) VALUES
                                                        (1, 1),
                                                        (2, 2);

-- Inserting data into 'bike_frame'
INSERT INTO bike_frame (code, name) VALUES
                                        ('carbon', 'Carbon Frame'),
                                        ('aluminum', 'Aluminum Frame');

-- Inserting data into 'bike'
INSERT INTO bike (id, frame_id) VALUES
    (1, 1);

-- Inserting data into 'accessory'
INSERT INTO accessory (id, note) VALUES
    (2, 'High durability and lightweight.');

-- Inserting data into 'helmet_type'
INSERT INTO helmet_type (code, name) VALUES
                                         ('fullface', 'Full Face'),
                                         ('openface', 'Open Face');

-- Inserting data into 'helmet'
INSERT INTO helmet (id, helmet_type_id) VALUES
    (2, 1);

-- Inserting data into 'product_bike_frames'
INSERT INTO product_bike_frames (bike_frame_id, product_id) VALUES
    (1, 1);


