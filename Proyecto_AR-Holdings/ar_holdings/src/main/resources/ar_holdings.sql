drop database if exists ar_holdings;
drop user if exists hhrr;

create database ar_holdings;
use ar_holdings;

create user hhrr identified by 'Holding';
grant all privileges on ar_holdings to hhrr;
flush privileges;

create table Restaurantes(
id_Restaurante int auto_increment primary key,
nombre varchar (255),
ruta_imagen varchar(1024),
ubicacion varchar (1000),
telefono int,
sitio_web varchar (1000),
red_social varchar (255));

insert into Restaurantes (nombre,ruta_imagen,ubicacion,sitio_web,telefono,red_social) values
('Johnny Rockets','https://www.google.com/imgres?imgurl=https%3A%2F%2Fmedia.bizj.us%2Fview%2Fimg%2F2814931%2Fjohnny-rockets-exterior*900xx1500-844-0-0.jpg&tbnid=e-JuR9i3238XbM&vet=10CGkQMyiWAWoXChMIiMLY_vKKgAMVAAAAAB0AAAAAEAM..i&imgrefurl=https%3A%2F%2Fwww.bizjournals.com%2Flosangeles%2Fnews%2F2020%2F08%2F13%2Fowner-of-fatburger-buying-johnny-rockets-for-25.html&docid=2JgCWTJuifFgXM&w=900&h=506&q=johnny%20rockets&ved=0CGkQMyiWAWoXChMIiMLY_vKKgAMVAAAAAB0AAAAAEAM',
'<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d251532.68123408037!2d-84.33504581451413!3d9.917449394044436!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0e397c8ba420b%3A0x3f0f2db252b7c5a5!2sJohnny%20Rockets%20%E2%80%A2%20Multiplaza%20Curridabat!5e0!3m2!1ses!2scr!4v1689224741953!5m2!1ses!2scr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>',
'http://johnnyrockets.co.cr/','44043780','https://www.facebook.com/JohnnyRocketsCR/'),
('Capital Grill','https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.larepublica.net%2Fstorage%2Fimages%2F2020%2F12%2F14%2F20201214104629.capital-grill.x2.jpg&tbnid=G4q6jUro_2kVhM&vet=12ahUKEwjS5bTU9oqAAxV4hbAFHQyfAVsQMygAegUIARC4AQ..i&imgrefurl=https%3A%2F%2Fwww.larepublica.net%2Fnoticia%2Frestaurante-especializado-en-carnes-y-vinos-the-capital-grille-abrira-en-costa-rica&docid=sQ3b1cgP_She_M&w=1200&h=628&q=capital%20grille%20costa%20rica&ved=2ahUKEwjS5bTU9oqAAxV4hbAFHQyfAVsQMygAegUIARC4AQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15125156.78362792!2d-100.28144888546947!3d22.252777084898828!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fd3dbdbdccdf%3A0x8bc2a43d899d54be!2sThe%20Capital%20Grille!5e0!3m2!1ses!2scr!4v1689225353768!5m2!1ses!2scr%22',
'https://thecapitalgrille.cr/','44043843','https://www.facebook.com/thecapitalgrilleCostaRica'),
('Outback Steakhouse','https://www.google.com/imgres?imgurl=https%3A%2F%2Fcostaricainfolink.com%2Frestaurantes%2Fwp-content%2Fuploads%2F2018%2F11%2Frestaurante-outback-steakhouse-escazu-san-jose-costa-rica.jpg&tbnid=QgBPMiSMy5HjLM&vet=12ahUKEwjgiNLp94qAAxVLi7AFHY36AGgQMygGegUIARDHAQ..i&imgrefurl=https%3A%2F%2Fcostaricainfolink.com%2Frestaurantes%2Foutback-steakhouse%2F&docid=_RfnRBWMEgwc0M&w=610&h=260&q=outback%20steakhouse%20costa%20rica&ved=2ahUKEwjgiNLp94qAAxVLi7AFHY36AGgQMygGegUIARDHAQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3929.8802408321562!2d-84.1496749251646!3d9.94392127399758!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fb811137f587%3A0x843aae4d8980c088!2sOutback%20Steakhouse!5e0!3m2!1ses!2scr!4v1689225563801!5m2!1ses!2scr%22',
'https://outbackcr.com/','44043800','https://www.facebook.com/OutbackCR'),
('Olive Garden','https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn.forbescentroamerica.com%2F2019%2F11%2FOlive.jpg&tbnid=wrcP_w97V66UnM&vet=12ahUKEwi4-Yb1-YqAAxVEgIQIHZwBAsYQMygFegUIARDKAQ..i&imgrefurl=https%3A%2F%2Fforbescentroamerica.com%2F2019%2F11%2F13%2Folive-garden-abrira-tres-restaurantes-en-costa-rica-durante-2020&docid=cgJlplX5Mp5xwM&w=1280&h=720&q=olive%20garden%20costa%20rica&hl=es&ved=2ahUKEwi4-Yb1-YqAAxVEgIQIHZwBAsYQMygFegUIARDKAQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3930.002563911066!2d-84.13205692516475!3d9.933743674171716!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fd618bb35249%3A0xd74e563e816a5e2f!2sOlive%20Garden%20Escaz%C3%BA!5e0!3m2!1ses!2scr!4v1689225625937!5m2!1ses!2scr%22',
'https://olivegarden.cr/','44043809','https://www.facebook.com/profile.php?id=100064500322156');

create table Tiendas(
id_Tienda int auto_increment primary key,
nombre varchar (255),
ruta_imagen varchar(1024),
ubicacion varchar (1000),
telefono int,
sitio_web varchar (1000),
red_social varchar (255));

insert into Tiendas (nombre,ruta_imagen,ubicacion,sitio_web,telefono,red_social) values
('Old Navy','https://www.google.com/imgres?imgurl=https%3A%2F%2Frevistasumma.com%2Fwp-content%2Fuploads%2F2020%2F12%2Fold-navy.jpg&tbnid=QuMaGTKaTUQmJM&vet=12ahUKEwjX9uO--4qAAxXbjbAFHSEZA08QMygBegUIARDQAQ..i&imgrefurl=https%3A%2F%2Frevistasumma.com%2Fold-navy-abre-su-cuarta-tienda-en-costa-rica%2F&docid=WiGsOHlcYLvu_M&w=1835&h=1223&q=old%20navy%20costa%20rica%20tiendas&hl=es&ved=2ahUKEwjX9uO--4qAAxXbjbAFHSEZA08QMygBegUIARDQAQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d125732.58757831121!2d-84.36390170273438!3d10.005014700000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0f9958ac36029%3A0x8fb80794cce10d98!2sOld%20Navy%20City%20Mall!5e0!3m2!1ses!2scr!4v1689226612144!5m2!1ses!2scr%22',
'https://shop.lineuprewards.com/collections/old-navy?limit=50','25199275','https://www.instagram.com/lineuprewardscr/'),
('MaxMara','https://www.google.com/imgres?imgurl=https%3A%2F%2Fmapio.net%2Fimages-p%2F61150160.jpg&tbnid=kZ-9sCufdXlzyM&vet=12ahUKEwjy7YW0_IqAAxV6hLAFHX6sAd4QMygAegQIARBJ..i&imgrefurl=https%3A%2F%2Fmapio.net%2Fpic%2Fp-61150160%2F&docid=fk_vxU1Fwm4foM&w=640&h=480&q=maxmara%20costa%20rica%20tiendas&hl=es&ved=2ahUKEwjy7YW0_IqAAxV6hLAFHX6sAd4QMygAegQIARBJ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30154698.338703066!2d-118.40036610722582!3d22.69128776923323!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fd0df21daf0d%3A0x7e0530131fcc681b!2sMax%20Mara%20San%20Jose!5e0!3m2!1ses!2scr!4v1689226805037!5m2!1ses!2scr%22',
'https://world.maxmara.com/','25199053','https://www.facebook.com/maxmara'),
('Gap','https://www.google.com/imgres?imgurl=https%3A%2F%2Fadiariocr.com%2Fwp-content%2Fuploads%2F2019%2F08%2FGAP-I-e1567200793146.jpg&tbnid=_37l2uiS5PEXxM&vet=12ahUKEwi-h9aE_YqAAxWDvoQIHSl1BNsQMygBegUIARDDAQ..i&imgrefurl=https%3A%2F%2Fadiariocr.com%2Ftendencias%2Fgap-abre-en-avenida-escazu-despues-de-tres-anos-fuera-de-costa-rica%2F&docid=88TzeAdsWuFcMM&w=1290&h=888&q=gap%20costa%20rica%20tiendas&hl=es&ved=2ahUKEwi-h9aE_YqAAxWDvoQIHSl1BNsQMygBegUIARDDAQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30727284.363631725!2d-118.4473926586066!3d19.929073236371732!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fd96075d3261%3A0xee88a04f0d9d9afb!2sGap!5e0!3m2!1ses!2scr!4v1689226933451!5m2!1ses!2scr%22',
'https://shop.lineuprewards.com/collections/gap?limit=50','44043851','https://www.instagram.com/lineuprewardscr/'),
('Forever21','https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.larepublica.net%2Fstorage%2Fimages%2F2019%2F09%2F30%2F20190930081904.forever.jpg&tbnid=hKSrzhP8zx3yiM&vet=12ahUKEwiFyLSo_YqAAxV7FmIAHUCLDj4QMygCegUIARDBAQ..i&imgrefurl=https%3A%2F%2Fwww.larepublica.net%2Fnoticia%2Fforever-21-anuncia-quiebra-pero-no-cerrara-en-costa-rica&docid=sYUmFNh4aEgmoM&w=940&h=492&q=forever21%20costa%20rica%20tiendas&hl=es&ved=2ahUKEwiFyLSo_YqAAxV7FmIAHUCLDj4QMygCegUIARDBAQ',
'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d125749.51153134479!2d-84.21153780492314!3d9.961204237765989!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8fa0fb86c31606eb%3A0xa8b4f6e40fafe0d2!2sForever%2021%20%E2%80%A2%20Multiplaza%20Escaz%C3%BA!5e0!3m2!1ses!2scr!4v1689227033811!5m2!1ses!2scr%22',
'https://shop.lineuprewards.com/collections/forever-21?limit=50','42005415','https://www.facebook.com/Forever21LATAM');

create table Contacto(
id_Contacto int auto_increment primary key,
nombre varchar (255),
apellido1 varchar (255),
apellido2 varchar (255),
telefono int,
correo varchar (255));

insert into Contacto (nombre,apellido1,apellido2,telefono,correo) values
('María','López','García','89012345','marialogar@gmail.com'),
('Pedro','Sánchez','Vargas','60123456','pedrosanc@gmail.com'),
('Laura','González','Martínez','76543210','laugmartinez@hotmail.com'),
('Carlos','Fernández','Ramírez','64321098','carlosferam@gmail.com'),
('Ana','Gutiérrez','Soto','81098765','anaguti@hotmail.com'),
('Luis','Chacón','Castro','84321098','luiscastro@gmail.com'),
('Sofía','Morales','Vargas','77654321','sofimoravargas@gmail.com');

create table Puestos(
id_Puesto int auto_increment primary key,
nombre varchar (255),
turno varchar (1),
area varchar (255),
salario double,
requicitos varchar (1000));

insert into Puestos (nombre,turno,area,salario,requicitos) values
('Analista','B','finanzas','58000','Licenciatura en Finanzas'),
('Recepcionista','A','administración','28000','Experiencia previa en atención al cliente'),
('Técnico de Soporte','A','tecnología','40000','Conocimientos en redes y sistemas operativos'),
('Ingeniero de Proyectos','B','ingeniería','75000','Experiencia en gestión de proyectos'),
('Asistente de Recursos Humanos','B','recursos humanos','32000','Conocimientos en legislación laboral'),
('Gerente de Ventas','A','ventas','90000','Experiencia en liderazgo y habilidades de negociación'),
('Desarrollador de Software','A','tecnología','60000','Conocimientos avanzados en lenguajes de programación');

create table Empleados(
id_Empleado int auto_increment primary key,
nombre varchar (255),
apellido1 varchar (255),
apellido2 varchar (255),
puesto varchar (255),
fecha_ingreso datetime,
salario double);

insert into Empleados (nombre,apellido1,apellido2,puesto,fecha_ingreso,salario) values
('Marco','Quiros','García','desarrollador','2000-07-13','5200.00'),
('Juan','González','Pérez','contabilidad','2011-10-09','3800.00'),
('Laura','Fernández','Ramírez','marketing','2009-05-12','4200.00'),
('Pedro','Sánchez','Vargas','administracion','2021-12-06','3000.00'),
('Allan','Soza','Artavia','desarrollador','2004-12-03','3000.00'),
('Ana','Martínez','Torres','ventas','2000-08-01','3500.00');
