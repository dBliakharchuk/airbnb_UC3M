USE `airbnbdb` ;

INSERT INTO `airbnbdb`.`User`
VALUES ('mateusz@gmail.com', 'Mateusz', 'Kobierski','mateuszpass');

INSERT INTO `airbnbdb`.`User`
VALUES ('dima@gmail.com', 'Dima', 'Bliakharchuk','dimapass');

INSERT INTO `airbnbdb`.`User`
VALUES ('piotrducki@gmail.com', 'Piotr', 'Ducki','piotrduckipass');

INSERT INTO `airbnbdb`.`User`
VALUES ('piotrszylar@gmail.com', 'Piotr', 'Szylar','piotrszylarpass');

INSERT INTO `airbnbdb`.`User`
VALUES ('customer@gmail.com', 'Grzegorz', 'Brzęczyszczykiewicz','grzegorzpass');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Gran Via','34','2A','FB7A2CF0790C177106AE1B8996B7FC6416040C69236DD78A0EBD568933F43A99');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Plaza Mayor','1','34','4B88E898D23FC2657476665DDFB3A861DD055A62B1CB3AC58BCFC61CB90BC7F6');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Calle de Preciados','4','56','DE911F98C1689A36755301169BC50C0AC2DCB9417051BBA359BB1CC0FE52B00D');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Calle Central','15','5','BAE4C80EB59B205645F9E7933A54344D6658A162A284FC255BC870293C24C096');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Calle Royal','2','1','E097C1F237C5719528DA1591C64BB4197F2175E4BCC388B77699BFA6A4D86724');

INSERT INTO `airbnbdb`.`Localization`
VALUES('Spain','Madrid','Calle del Sol','2','16','BE858B0E5F319023C10AAB4228588F53C25C59A05AE02D1962008AE5967C4B17');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('mateusz@gmail.com',30.0,2,'Entire apartment','Pretty Apartment in Plaza Mayor','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',1,'4B88E898D23FC2657476665DDFB3A861DD055A62B1CB3AC58BCFC61CB90BC7F6');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('mateusz@gmail.com',50.0,1,'Entire apartment','Stunning Apartment in Sol','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',0,'DE911F98C1689A36755301169BC50C0AC2DCB9417051BBA359BB1CC0FE52B00D');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('dima@gmail.com',65.0,3,'Entire apartment','Central and quiet','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',4,'BAE4C80EB59B205645F9E7933A54344D6658A162A284FC255BC870293C24C096');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('piotrducki@gmail.com',80.0,1,'Entire loft','Flat in front of the Royal Palace','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',2,'E097C1F237C5719528DA1591C64BB4197F2175E4BCC388B77699BFA6A4D86724');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('piotrszylar@gmail.com',70.0,2,'Entire apartment','Apartment near Gran Via','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',2,'FB7A2CF0790C177106AE1B8996B7FC6416040C69236DD78A0EBD568933F43A99');

INSERT INTO `airbnbdb`.`Apartment`
VALUES('dima@gmail.com',60.0,2,'Entire apartment','Apartment in Sol','Apartment in Sol is a cozy accommodation right in the center of Madrid, where on every corner there is fun due to the innumerable bars, restaurants, shops and markets in the area.
The apartment has a kitchenette, free wifi in all areas, television, oven and microwave, washing machine, hair dryer, coffee maker and toaster. Sheets and towels are provided upon arrival.',1,'BE858B0E5F319023C10AAB4228588F53C25C59A05AE02D1962008AE5967C4B17');

INSERT INTO `airbnbdb`.`Reservation`
VALUES('E097C1F237C5719528DA1591C64BB4197F2175E4BCC388B77699BFA6A4D86724', 'dima@gmail.com', '2018-7-04');

INSERT INTO `airbnbdb`.`Message` 
VALUES('dima@gmail.com', 'customer@gmail.com','hello', '2018-10-25 11:12:32', false);

