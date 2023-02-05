
insert into airspace.address(id, city, state, street) values (1, "Beograd", "Beograd", "Beograd");
insert into airspace.address(id, city, state, street) values (2, "Novi Sad", "Novi Sad", "Novi Sad");
insert into airspace.address(id, city, state, street) values (3, "Nis", "Nis", "Nis");

insert into airspace.location(id, x, y, address_id) values (1,1,1,1);
insert into airspace.location(id, x, y, address_id) values (2,2,2,2);
insert into airspace.location(id, x, y, address_id) values (3,3,3,3);

insert into airspace.hotel(id, description, name, rating, stars, location_id) values ('1', 'Hotel BG', 'Beograd', '1', '1', '1');
insert into airspace.hotel(id, description, name, rating, stars, location_id) values ('2', 'Hotel NS', 'Novi Sad', '1', '1', '2');
insert into airspace.hotel(id, description, name, rating, stars, location_id) values ('3', 'Hotel NIS', 'Nis', '1', '1', '3');

insert into airspace.rentacar(id, address, description, name, rating) values (1, "Kneza Milosa 4", "Ovo je prva kompanija", "BeogradRent", 100);
insert into airspace.rentacar(id, address, description, name, rating) values (2, "Modene", "Ovo je druga kompanija", "NoviSadRent", 100);
insert into airspace.rentacar(id, address, description, name, rating) values (3, "Bulevar", "Ovo je trecakompanija", "NisRent", 100);

insert into airspace.branchoffice(id, address, office_name, rentacar_id) values (1, "Kneza Milosa 4", "Beograd",1);
insert into airspace.branchoffice(id, address, office_name, rentacar_id) values (2, "Glavna" ,"Zemun", 1);
insert into airspace.branchoffice(id, address, office_name, rentacar_id) values (3, "Sava Centar", "Novi Beograd",1);


insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (4, "Modene", "Novi Sad",1);
insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (5, "Telep", "Telep",1);
insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (6, "Bele Njive", "Podbara",1);
insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (7, "Jevrejska", "Centar",1);


insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (8, "Bulevar", "Nis",  3);
insert into airspace.branchoffice(id, address, office_name, rentacar_id) values (9, "Severni bulevar", "Nis Sever", 3);
insert into airspace.branchoffice(id, address, office_name,  rentacar_id) values (10, "Juzni Bulevar", "Nis Jug",  3);
insert into airspace.branchoffice(id, address, office_name, rentacar_id) values (11, "Glavna", "Centar", 3);

insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (1, 1, 'Beograd', 'automatic', 2015,2, 'Audi A3',5, 5, 0, 1, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (2, 1, 'Beograd', 'manual', 2010, 2, 'Toyota Avensis',5, 5, 70, 1, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (3, 1, 'Zemun', 'manual', 2010, 2, 'BMW 320d',5, 5, 0, 2, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (4, 1, 'Zemun', 'automatic', 2015,2, 'Nissan Micra',5, 5, 0, 2, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (5, 1, 'Novi Beograd', 'automatic', 2011,2, 'Mercedes E220',5, 5, 0, 3, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (6, 1, 'Novi Beograd', 'manual', 2014,2, 'Opel Insignia',5, 5, 0, 3, 1);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (7, 1, 'Zemun', 'automatic', 2011,2, 'Subaru Forester',5, 5, 50, 3, 1);

insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (8, 1, 'Novi Sad', 'manual', 2014,3, 'Opel Astra',5, 5, 0, 4, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (9, 1, 'Novi Sad', 'automatic', 2015,3, 'Nissan Micra',5, 5, 0, 4, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (10, 1, 'Telep', 'manual', 2010,3, 'Toyota Rav4',5, 5, 0, 5, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (11, 1, 'Podbara', 'automatic', 2011,3, 'Subaru Forester',5, 5, 50, 6, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (12, 1, 'Podbara', 'manual', 2014, 3, 'Opel Corsa',5, 5, 0, 6, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (13, 1, 'Centar', 'automatic', 2015, 4, 'Nissan Navara',5, 5, 60, 7, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (14, 1, 'Centar', 'automatic', 2010, 4, 'Toyota Corola',5, 5, 0, 7, 2);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (15, 1, 'Centar', 'manual', 2011,  4, 'Subaru Impreza',5, 5, 0, 7 ,2);


insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (16, 1, 'Nis', 'manual', 2014, 5, 'Opel Meriva',5, 5, 30, 8, 3);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (17, 1, 'Nis', 'automatic', 2015, 5, 'Nisan Qasqai',5, 5, 0, 9, 3);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (18, 1, 'Nis', 'automatic', 2010, 5, 'Toyota Yaris',5, 5, 0, 10, 3);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (19, 1, 'Nis', 'manual', 2011, 5, 'Subaru',5, 5, 20, 11, 3);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (20, 1, 'Nis', 'automatic', 2015,  5, 'Nissan Juke',5, 5, 0, 8, 3);
insert into airspace.vehicle(id, available, city_location, gear_box, godina_proizvodnje, id_user, model, num_of_seats, price_per_day, sale, branchoffice_id, rentacar_id) values (21, 1, 'Nis', 'automatic', 2011,  5, 'Mercedes A180',5, 5, 0, 9, 3);


insert into airspace.user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values('1', 'Novi Sad', '1', 'b816623@urhen.com', 'adminRentaCar', 'adminRentaCar', '$2a$10$L.uDKvMQCUOM8SiIHDFThubzdagCsHANjdFdIRFDO7eFgiPxQQ7nS', '021', '0', '2', 'adminrentacar', '9f116192-ab5d-48cd-b4de-94683766fbfa');
insert into airspace.user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values('2', 'Novi Sad', NULL, 'a16105@urhen.com', 'korisnik', 'korisnik', '$2a$10$RjexYK2py4UrWtxxPDFdh.J9.O8fR.oAytviz9zj.ZsIivKHcj6nu', '0211111', '0', '0', 'korisnik', '0f7ff739-7012-4b8a-96c4-680a1f509061');
insert into airspace.user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values('3', 'Beograd', NULL, 'b1153692@urhen.com', 'korisnik2', 'korisnik2', '$2a$10$IasvmlRPim417STyvGm.J.lhQ/juBIeNIXcCNwwUl.Nnpj9vj.Kqq', '01111111', '0', '0', 'korisnik2', 'b93d6e6d-9014-432c-af73-497337adbb39');
insert into airspace.user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values('4', NULL, NULL, 'jijjj@urhen.com',NULL , NULL, '$10$gIXxXGumWvAY6n4pTDfS5OzLSz3jZ5HW8/3/xeuqjhAXKdB5ocfoS', NULL, '0', '1', 'system', '0984271a-4ff3-46ea-9eaa-681b085cb046');
insert into airspace.user(id, city, company_id, email, first_name, last_name, password, phone_number, user_status, user_type, username, uuid) values('5', 'Novi Sad', '1', 'hotel@gmail.com', NULL, NULL, '$10$bHPTQwZVYBIdZ9IQoHw5pOvQhmzkJJtmnE0QDyA2kKsG77eJ4Sday', NULL, '0', '3', 'hotel', '7f66693b-7a77-4288-bc0d-8cfab554753d');

insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('1', '2019-02-01 00:00:00.000000', '2019-02-07 00:00:00.000000','35', '1', '2', '1');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('2', '2019-03-01 00:00:00.000000', '2019-03-07 00:00:00.000000','35', '1', '3', '2');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('3', '2019-04-01 00:00:00.000000', '2019-04-07 00:00:00.000000','35', '1', '2', '2');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('4', '2019-07-01 00:00:00.000000', '2019-07-08 00:00:00.000000','35', '1', '2', '1');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('5', '2019-08-01 00:00:00.000000', '2019-08-08 00:00:00.000000','35', '1', '3', '6');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('6', '2019-09-01 00:00:00.000000', '2019-09-08 00:00:00.000000','35', '1', '2', '3');

insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('7', '2019-05-01 00:00:00.000000', '2019-05-07 00:00:00.000000','35', '2', '2', '8');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('8', '2019-06-01 00:00:00.000000', '2019-06-07 00:00:00.000000','35', '2', '3', '11');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('9', '2019-07-01 00:00:00.000000', '2019-07-07 00:00:00.000000','35', '2', '2', '13');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('10', '2019-08-01 00:00:00.000000', '2019-08-07 00:00:00.000000','35', '2', '2', '13');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('11', '2019-09-01 00:00:00.000000', '2019-09-07 00:00:00.000000','35', '2', '3', '14');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('12', '2019-10-01 00:00:00.000000', '2019-10-07 00:00:00.000000','35', '2', '2', '9');

insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('13', '2019-05-01 00:00:00.000000', '2019-05-07 00:00:00.000000','35', '3', '2', '16');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('14', '2019-06-01 00:00:00.000000', '2019-06-07 00:00:00.000000','35', '3', '3', '16');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('15', '2019-07-01 00:00:00.000000', '2019-07-07 00:00:00.000000','35', '3', '2', '17');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('16', '2019-08-01 00:00:00.000000', '2019-08-07 00:00:00.000000','35', '3', '2', '19');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('17', '2019-09-01 00:00:00.000000', '2019-09-07 00:00:00.000000','35', '3', '3', '20');
insert into airspace.reservationrentacar(id, date_from, date_until, total_price, rentacar_id, user_id, vehicle_id) values ('18', '2019-10-01 00:00:00.000000', '2019-10-07 00:00:00.000000','35', '3', '2', '21');


insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (1, 1, 2, 1, 1000, 0, 1, 1);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (2, 1, 4, 2, 800, 0, 0, 1);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (3, 1, 2, 3, 2000, 0, 1, 1);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (4, 1, 3, 4, 1200, 0, 2, 1);

insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (11, 1, 6, 1, 3000, 0, 1, 2);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (12, 1, 4, 2, 800, 0, 0, 2);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (13, 1, 2, 3, 2000, 0, 1, 2);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (14, 1, 2, 4, 1200, 0, 2, 2);

insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (21, 1, 5, 1, 2000, 0, 1, 3);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (22, 1, 4, 2, 800, 0, 0, 3);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (23, 1, 2, 3, 2000, 0, 1, 3);
insert into airspace.room(id, floor, num_of_beds, number, price, rating, room_type, hotel_id) values (24, 1, 3, 4, 1200, 0, 2, 3);

insert into airspace.roomreservation(id, end_date, start_date, num_of_guests, price, customer_id, room_id) values ('1', '2019-02-01 00:00:00.000000', '2019-02-07 00:00:00.000000',2,5000, '3', '2');
insert into airspace.roomreservation(id, end_date, start_date, num_of_guests, price, customer_id, room_id) values  ('2', '2019-03-01 00:00:00.000000', '2019-03-07 00:00:00.000000',2,5000, '3', '3');
insert into airspace.roomreservation(id, end_date, start_date, num_of_guests, price, customer_id, room_id) values  ('3', '2019-04-01 00:00:00.000000', '2019-04-07 00:00:00.000000',2,5000, '3', '2');
insert into airspace.roomreservation(id, end_date, start_date, num_of_guests, price, customer_id, room_id) values ('4', '2019-07-01 00:00:00.000000', '2019-07-08 00:00:00.000000',2,5000, '2', '2');
insert into airspace.roomreservation(id, end_date, start_date, num_of_guests, price, customer_id, room_id) values  ('5', '2019-08-01 00:00:00.000000', '2019-08-08 00:00:00.000000',2,5000, '2', '3');

