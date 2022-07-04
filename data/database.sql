CREATE DATABASE crm;
USE crm;

CREATE TABLE `nguoi_dung` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ho_ten` varchar(50),
  `dia_chi` varchar(50),
  `so_dien_thoai` varchar(40),
  `email` varchar(50),
  `mat_khau` varchar(50),
  `id_phan_quyen` int,
  `token` char(10)
);

CREATE TABLE `phan_quyen` (
  `id` int PRIMARY KEY,
  `ten_phan_quyen` varchar(40)
);

CREATE TABLE `du_an` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_leader` int,
  `ten_du_an` varchar(50),
  `trang_thai` varchar(20),
  `tien_do` decimal(5,2),
  `ngay_bat_dau` date,
  `ngay_ket_thuc` date
);

CREATE TABLE `thong_tin_du_an` (
  `id_du_an` int,
  `id_nhan_vien` int,
  `cong_viec` text,
  `tien_do` decimal(5,2),
  PRIMARY KEY (`id_du_an`, `id_nhan_vien`)
);

ALTER TABLE `nguoi_dung` ADD FOREIGN KEY (`id_phan_quyen`) REFERENCES `phan_quyen` (`id`);
ALTER TABLE `du_an` ADD FOREIGN KEY (`id_leader`) REFERENCES `nguoi_dung` (`id`);
ALTER TABLE `thong_tin_du_an` ADD FOREIGN KEY (`id_du_an`) REFERENCES `du_an` (`id`);
ALTER TABLE `thong_tin_du_an` ADD FOREIGN KEY (`id_nhan_vien`) REFERENCES `nguoi_dung` (`id`);



insert into phan_quyen (id, ten_phan_quyen) values (1, "Admin");
insert into phan_quyen (id, ten_phan_quyen) values (2, "Leader");
insert into phan_quyen (id, ten_phan_quyen) values (3, "Member");

insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Dewitt Burchard', '226 Lien Circle', '360-737-4449', 'dburchard0@umn.edu', '1234', 1);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Aloise Scholard', '3401 Luster Hill', '917-835-0411', 'ascholard1@state.gov', '1234', 1);

insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Idette Brambell', '5 International Parkway', '460-467-2718', 'ibrambell0@mtv.com', '4321', 2);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Townsend Marsy', '7249 Dottie Point', '876-870-5238', 'tmarsy1@nyu.edu', '4321', 2);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Whitaker Norrie', '6330 Maywood Junction', '801-916-8145', 'wnorrie2@apple.com', '4321', 2);

insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Mariel Archanbault', '57371 Washington Pass', '321-428-7982', 'marchanbault0@shop-pro.jp', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Garrick Tewkesberry', '1024 Clarendon Street', '478-567-8648', 'gtewkesberry1@foxnews.com', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Fred McGlashan', '7147 Redwing Drive', '893-430-0788', 'fmcglashan2@ezinearticles.com', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Kiley Shead', '35688 Bartillon Street', '248-923-9082', 'kshead3@liveinternet.ru', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Delphinia Bushe', '77 Little Fleur Court', '671-375-9309', 'dbushe4@ucla.edu', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Vidovic Cosker', '5416 Main Place', '914-429-2027', 'vcosker5@fotki.com', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Kristo Brookz', '36 Northfield Road', '342-277-3558', 'kbrookz6@sakura.ne.jp', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Rochelle Simmonite', '2 Annamark Way', '319-903-6932', 'rsimmonite7@stanford.edu', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Armand Keiley', '52 Stoughton Plaza', '590-838-3958', 'akeiley8@weather.com', '1111', 3);
insert into nguoi_dung (ho_ten, dia_chi, so_dien_thoai, email, mat_khau, id_phan_quyen) values ('Manda O''Connel', '335 West Court', '913-100-8262', 'moconnel9@taobao.com', '1111', 3);

insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (3, 'Project A', 'Canelled', 20, '2022-04-29', '2022-04-18');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (4, 'Project B', 'Completed', 100, '2021-11-05', '2022-04-28');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (3, 'Project C', 'In progress', 93, '2021-08-09', '2022-05-30');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (5, 'Project D', 'In progress', 70, '2021-09-13', '2022-07-25');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (4, 'Project E', 'In progress', 42, '2022-04-09', '2021-12-03');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (3, 'Project F', 'Cancelled', 67, '2021-11-24', '2022-07-21');
insert into du_an (id_leader, ten_du_an, trang_thai, tien_do, ngay_bat_dau, ngay_ket_thuc) values (3, 'Project G', 'In progress', 34, '2021-11-17', '2021-08-05');

insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (5, 10, 'Project task description', 94);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (5, 15, 'Project task description', 19);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (6, 13, 'Project task description', 36);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (3, 10, 'Project task description', 90);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (3, 14, 'Project task description', 97);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (5, 8, 'Project task description', 45);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (2, 6, 'Project task description', 25);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (7, 15, 'Project task description', 32);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (2, 11, 'Project task description', 78);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (4, 11, 'Project task description', 59);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (2, 7, 'Project task description', 49);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (6, 9, 'Project task description', 86);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (7, 12, 'Project task description', 23);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (5, 14, 'Project task description', 82);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (7, 7, 'Project task description', 62);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (1, 14, 'Project task description', 57);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (4, 15, 'Project task description', 42);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (1, 9, 'Project task description', 67);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (7, 10, 'Project task description', 51);
insert into thong_tin_du_an (id_du_an, id_nhan_vien, cong_viec, tien_do) values (4, 10, 'Project task description', 48);