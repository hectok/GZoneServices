-- -----------------------------------------------------
-- Data for table producto
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('The Binding of Isaac: Rebirth', 14.99, 2014, 'SO: Windows 8 / 7 / Vista / XP Procesador: 2.4 GHz Quad Core 2.0 (or higher)\r Memoria: 8 GB de RAM\r Gráficos: Intel HD Graphics 4000 and higher, ATI Radeon HD-Series 4650 and higher, Nvidia GeForce 2xx-Series and up\r Almacenamiento: 449 MB de espacio disponible\r Tarjeta de sonido: Yes');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('BioShock Infinite', 29.99, 2013, 'OS: Windows 7 Service Pack 1 64-bit Processor: Quad Core Processor \nMemory: 4GB \nHard Disk Space: 30 GB free\nVideo Card: DirectX11 Compatible, AMD Radeon HD 6950 / NVIDIA GeForce GTX 560\n Video Card Memory: 1024 MB \nSound: DirectX Compatible');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Borderlands 2', 29.99, 2012, 'SO: Windows XP SP3 / Vista / Win 7 Procesador: Quad Core a 2.3 GHz Memoria: 2 GB de RAM Disco Duro: 20 GB de espacio libre Memoria Gráfica: 512 MB de VRAM Gráficos: nVidia GeForce GTX 560 / ATI Radeon HD 5850 Sonido: Compatible con DirectX 9.0c Otros requisitos: La instalación inicial necesita una conexión a internet para la autenticación con gzone; son necesarias algunas instalaciones de software (incluidas con el juego) como el cliente de gzone, DirectX 9, Microsoft .NET 4 Framework, Visual C++ Redistributable 2005, Visual C++ Redistributable 2008, Visual C++ Redistributable 2010 y los drivers de CPU de AMD (sólo para AMD en Windows XP)');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Don\'t Starve Together', 14.99, 2014, 'SO: Windows Vista/Windows 7/Windows 8 Procesador: 1.7+ GHz or better Memoria: 1 GB de RAM Gráficos: Radeon HD5450 or better; 256 MB or higher DirectX: Versión 9.0c Red: Conexión de banda ancha a Internet Almacenamiento: 750 MB de espacio disponible Tarjeta de sonido: 100% DirectX9.0c compatible sound card and drivers\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Resident Evil 7', 49.99,2017, 'SO: WINDOWS® 7, 8, 8.1, 10 (64-BIT Required) Procesador: Intel® Core™ i7 3770 3.4GHz or AMD equivalent or better Memoria: 8 GB de RAM Gráficos: NVIDIA® GeForce® GTX 1060 with 3GB VRAM DirectX: Versión 11 Almacenamiento: 24 GB de espacio disponible Tarjeta de sonido: DirectSound compatible (must support DirectX® 9.0c or higher) Notas adicionales: Hardware specification target 1080P/60FPS. *Internet connection required for game activation.\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Rise of the Tomb Raider™', 49.99,2016, 'SO: Windows 10 64 bit Procesador: Intel Core i7-3770K Memoria: 8 GB de RAM Gráficos: NVIDIA GTX 980Ti 2560x1440 or NVIDIA GTX 970 1920x1080 DirectX: Versión 11 Almacenamiento: 25 GB de espacio disponible\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('The evil within 2', 59.99,2017, 'SO: Windows 7/8.1/10 (64-bit versions) Procesador: Intel Core i7-4770 / AMD Ryzen 5 1600X or better Memoria: 16 GB de RAM Gráficos: NVIDIA GTX 1060 6GB / AMD RX 480 8GB or better Almacenamiento: 40 GB de espacio disponible\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Assassin\'s Creed® Origins', 59.99, 2017, 'SO: Windows 7 SP1, Windows 8.1, Windows 10 (64-bit versions only) Procesador: Intel Core i7- 3770 @ 3.5 GHz or AMD FX-8350 @ 4.0 GHz Memoria: 8 GB de RAM Gráficos: NVIDIA GeForce GTX 760 or AMD R9 280X (3GB VRAM with Shader Model 5.0 or better) Almacenamiento: 42 GB de espacio disponible Notas adicionales: Video Preset: High (1080p)\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Middle-earth™: Shadow of War™', 59.99, 2017, 'SO: Windows 10 Creators Update Procesador: AMD FX-8350, 4.0 GHz / Intel Core i7-3770, 3.4 GHz Memoria: 12 GB de RAM Gráficos: AMD RX 480, 4 GB or RX580, 4GB / NVIDIA GTX 970, 4GB or GTX1060, 6GB DirectX: Versión 11 Red: Conexión de banda ancha a Internet Almacenamiento: 70 GB de espacio disponible Notas adicionales: X64 required\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Alien : Isolation', 36.99,2014, 'SO: Windows 7 (64bit) Procesador: AMD: Phenom II X4 955 - 4 Core, 3.2 GHz or Intel: Core 2 Quad Q9650 - 4 Core, 3.0 GHz Memoria: 8 GB de RAM Gráficos: 2GB (AMD GPU: AMD Radeon R9 200 Series or Nvidia GPU: Nvidia GeForce GTX660) DirectX: Versión 11 Red: Conexión de banda ancha a Internet Almacenamiento: 35 GB de espacio disponible\n');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Dark Souls III', 59.99, 2016, 'SO: Windows 7 SP1 64bit, Windows 8.1 64bit Windows 10 64bit Procesador: Intel Core i7-3770 / AMD® FX-8350 Memoria: 8 GB de RAM Gráficos: NVIDIA® GeForce GTX 970 / ATI Radeon R9 series DirectX: Versión 11 Red: Conexión de banda ancha a Internet Almacenamiento: 25 GB de espacio disponible Tarjeta de sonido: DirectX 11 sound device Notas adicionales: Internet connection required for online play and product activation');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('The Witcher® 3: Wild Hunt', 29.99,2015, 'SO: 64-bit Windows 7, 64-bit Windows 8 (8.1) or 64-bit Windows 10 Procesador: Intel CPU Core i7 3770 3.4 GHz / AMD CPU AMD FX-8350 4 GHz Memoria: 8 GB de RAM Gráficos: Nvidia GPU GeForce GTX 770 / AMD GPU Radeon R9 290 Almacenamiento: 35 GB de espacio disponible ');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Total War: WARHAMMER II', 29.99,2017, 'SO: Windows 7 / 8 (8.1)/ 10 64Bit Procesador: Intel® Core™ i5-4570 3.20GHz Memoria: 8 GB de RAM Gráficos: NVIDIA GeForce GTX 770 4GB | AMD Radeon R9 290X 4GB @1080p Almacenamiento: 60 GB de espacio disponible ');
INSERT INTO producto (nombre, precio, anio, requisitos) VALUES ('Batman™: Arkham Knight', 19.99,2015, 'SO: Win 7 SP1, Win 8.1 (64-bit Operating System Required) Procesador: Intel Core i7-3770, 3.4 GHz | AMD FX-8350, 4.0 GHz Memoria: 8 GB de RAM Gráficos: NVIDIA GeForce GTX 760 - 3 GB Memory Recommended | AMD Radeon HD 7950 - 3 GB Memory Recommended DirectX: Versión 11 Red: Conexión de banda ancha a InternetAlmacenamiento: 55 GB de espacio disponible');
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Hollow Knight', 14.99, 2017, 'SO: Windows 7\nProcesador: Intel Core 2 Duo E5200\nMemoria: 4 GB de RAM\nGráficos: GeForce 9800GTX+ (1GB)\nDirectX: Versión 10\nAlmacenamiento: 9 GB de espacio disponible\nNotas adicionales: 1080p, 16:9 recommended', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Tom Clancy’s The Division', 49.99, 2016, 'SO: Windows® 7, Windows 8.1, Windows 10 (64-bit versions only)\nProcesador: Intel Core i5-2400 | AMD FX-6100, or better\nMemoria: 6 GB de RAM\nGráficos: NVIDIA GeForce GTX 560 with 2 GB VRAM (current equivalent NVIDIA GeForce GTX 760) | AMD Radeon HD 7770 with 2 GB VRAM, or better - See supported List*\nDirectX: Versión 11\nRed: Conexión de banda ancha a Internet', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('7 Days to die', 22.99, 2013, 'SO: WindowsXP (Service Pack 3)\nProcesador: 2.4 Ghz Dual Core CPU\nMemoria: 6 GB de RAM\nGráficos: 1 GB Dedicated Memory\nDirectX: Versión 10\nRed: Conexión de banda ancha a Internet\nAlmacenamiento: 4 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('No man\'s sky', 54.99, 2016, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Windows 7/8.1/10 (64-bit versions)\nProcesador: Intel Core i3\nMemoria: 8 GB de RAM\nGráficos: nVidia GTX 480, AMD Radeon 7870\nAlmacenamiento: 10 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Cuphead', 19.99, 2017, 'SO: Windows 7\nProcesador: Intel Core2 Duo E8400, 3.0GHz or AMD Athlon 64 X2 6000+, 3.0GHz or higher\nMemoria: 2 GB de RAM\nGráficos: Geforce 9600 GT or AMD HD 3870 512MB or higher\nDirectX: Versión 9.0\nAlmacenamiento: 20 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('South Park : The Stick of Truth', 29.99, 2014, 'SO: WindowsXP SP3, Windows Vista SP2, Windows 7 SP1, Windows 8 (both 32/64bit versions)\nProcesador: Intel Pentium Dual-Core E2180 @ 2.0 GHz or AMD Athlon64 X2 3800+ @ 2.0 GHz\nMemoria: 2 GB GB de RAM\nGráficos: nVidia GeForce 8800GT or AMD Radeon HD2600XT (512MB VRAM with Shader Model 4.0 or higher)\nDirectX: Versión 9.0c', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('ARK: Survival Evolved', 59.99, 2017, 'SO: Windows 7/8.1/10 (64-bit versions)\nProcesador: Intel Core i5-2400/AMD FX-8320 or better\nMemoria: 8 GB de RAM\nGráficos: NVIDIA GTX 670 2GB/AMD Radeon HD 7870 2GB or better\nDirectX: Versión 10\nAlmacenamiento: 60 GB de espacio disponible\nNotas adicionales: Requires broadband internet connection for multiplayer', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Portal 2', 19.99, 2011, 'SO: Windows 7 / Vista / XP\nProcesador: 3.0 GHz P4, Dual Core 2.0 (or higher) or AMD64X2 (or higher)\nMemoria: 2 GB de RAM\nGráficos: Video card must be 128 MB or more and with support for Pixel Shader 2.0b (ATI Radeon X800 or higher / NVIDIA GeForce 7600 or higher / Intel HD Graphics 2000 or higher).\nDirectX: Versión 9.0c\nAlmacenamiento: 8 GB de espacio disponible\nTarjeta de sonido: DirectX 9.0c compatible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('FINAL FANTASY XIV', 9.99, 2014, 'SO: Windows® 7 32/64 bit, Windows® 8.1 32/64 bit, Windows® 10 32/64 bit\nProcesador: Intel® Core™i5 2.4GHz or higher\nMemoria: 3 GB de RAM\nGráficos: 1280 x 720: NVIDIA® Geforce® GTX750 or higher, AMD Radeon™ R7 260X or higher\nDirectX: Versión 9.0c\nRed: Conexión de banda ancha a Internet\nAlmacenamiento: 60 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Mass effect', 9.99, 2008, 'Sistema Operativo: Microsoft Windows® XP con SP2 o Windows Vista*\nProcesador: Intel P4 a 2.4 GHz o más rápido / AMD a 2.0 GHz\nMemoria: 1 GB de RAM o más (2 GB para Vista)\nGráficos: Compatible con DirectX 9.0c, ATI X1300 XT o superior nVidia GeForce 6800 o superior\nDisco Duro: 12 GB de espacio libre ', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Fallout 4', 29.99, 2015, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Windows 7/8/10 (64-bit OS required)\nProcesador: Intel Core i5-2300 2.8 GHz/AMD Phenom II X4 945 3.0 GHz or equivalent\nMemoria: 8 GB de RAM\nGráficos: NVIDIA GTX 550 Ti 2GB/AMD Radeon HD 7870 2GB or equivalent\nAlmacenamiento: 30 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Wolfenstein II: The New Colossus', 59.99, 2017, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Win7, 8.1, or 10 (64-Bit versions)\nProcesador: AMD FX-8350/Ryzen 5 1400 or Intel Core i5-3570/i7-3770\nMemoria: 8 GB de RAM\nGráficos: Nvidia GTX 770 4GB/AMD Radeon R9 290 4GB or better\nAlmacenamiento: 55 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Tekken 7', 49.99, 2017, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Windows 7/8/10 (64-bit OS required)\nProcesador: Intel Core i3-4160 @ 3.60GHz or equivalent\nMemoria: 6 GB de RAM\nGráficos: NVIDIA GeForce GTX 660 2GB, GTX 750Ti 2GB, or equivalent\nDirectX: Versión 11\nRed: Conexión de banda ancha a Internet\nAlmacenamiento: 60 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Farming Simulator 17', 24.99, 2016, 'SO: Windows 7/8/10\nProcesador: AMD/Intel 2.0 GHz dual-core\nMemoria: 2 GB de RAM\nGráficos: 1 GB, DirectX 11, AMD Radeon HD 6770/NVIDIA GeForce GTS 450\nRed: Conexión de banda ancha a Internet\nAlmacenamiento: 6 GB de espacio disponible\nNotas adicionales: CONNEXION A INTERNET REQUERIDA PARA EL JUEGO ONLINE', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Stellaris', 39.99, 2016, 'SO: Windows 7 x86 or newer', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Life is Strange', 19.99, 2015, 'SO: Windows Vista', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('South Park : The Fractured But Whole', 59.99, 2017, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Windows 7, Windows 8.1, Windows 10 (64-bit versions only)\nProcesador: Intel Core i5 2400 / AMD FX 4320 or equivalent\nMemoria: 6 GB de RAM\nGráficos: NVIDIA GeForce GTX 560Ti / GTX 650 / GTX 750 / GTX 950 / GTX 1050 / AMD Radeon HD 7850 / R9 270 / R9 370 / RX 460\nAlmacenamiento: 20 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Left 4 dead 2', 19.99, 2009, 'SO: Windows® 7 32/64-bit / Vista 32/64 / XP\nProcesador: Pentium 4 3.0GHz\nMemoria: 2 GB de RAM\nGráficos: Video card with 128 MB, Shader model 2.0. ATI X800, NVidia 6600 or better\nDirectX: Versión 9.0c\nAlmacenamiento: 13 GB de espacio disponible\nTarjeta de sonido: DirectX 9.0c compatible sound card', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Project Cars 2', 59.99, 2017, 'SO: Windows 10 (+ specific versions of 7)\nProcesador: 3.5 GHz Intel Core i5 3450, 4.0 GHz AMD FX-8350\nMemoria: 8 GB de RAM\nGráficos: GTX680 or equivalent\nDirectX: Versión 11\nRed: Conexión de banda ancha a Internet\nAlmacenamiento: 50 GB de espacio disponible\nTarjeta de sonido: DirectX compatible sound card', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('The evil within', 9.99, 2014, 'SO: 64-bit Windows 7 SP1/Windows 8.1\nProcesador: i7 or an equivalent with four plus core processor\nMemoria: 4 GB de RAM\nGráficos: GTX 460 or equivalent 1 GB VRAM card\nDirectX: Versión 11\nAlmacenamiento: 50 GB de espacio disponible', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Sid Meier’s Civilization VI', 59.99, 2016, 'Requiere un procesador y un sistema operativo de 64 bits', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Rust', 31.99, 2018, 'Requiere un procesador y un sistema operativo de 64 bits', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('DRAGON BALL FighterZ', 59.99, 2018, 'Requiere un procesador y un sistema operativo de 64 bits\nSO: Windows 7/8/10 (64-bit OS required)\nProcesador: AMD FX-4350, 4.2 GHz / Intel Core i5-3470, 3.20 GHz\nMemoria: 4 GB de RAM\nGráficos: Radeon HD 6870, 1 GB / GeForce GTX 650 Ti, 1 GB\nDirectX: Versión 11\nRed: Conexión de banda ancha a Internet\nTarjeta de sonido: DirectX compatible soundcard or onboard chipset', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Injustice 2', 59.99, 2017, 'Requiere un procesador y un sistema operativo de 64 bits', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('Dead by daylight', 19.99, 2016, 'Requiere un procesador y un sistema operativo de 64 bits', NULL);
INSERT INTO Producto (nombre, precio, anio, requisitos, id_oferta) VALUES ('NBA 2K18', 49.99, 2017, 'SO: Windows 7x64 / Windows 8.1x64 / Windows 10x64\nProcesador: Intel® Core™ i3-530 @ 2.93 GHz / AMD Phenom™ II X4 805 @ 2.50 GHz or better\nMemoria: 4 GB de RAM\nGráficos: NVIDIA® GeForce® GT 450 1GB / ATI® Radeon™ HD 7770 1GB or better\nDirectX: Versión 11\nAlmacenamiento: 70 GB de espacio disponible\nTarjeta de sonido: DirectX 9.0x compatibl', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table NJugadores
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Un jugador');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Multijugador');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Multijugador en línea');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Multijugador local');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Pantalla dividida');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Multijugador masivo');
INSERT INTO NJugadores (id_nJugadores, njugadores) VALUES (DEFAULT, 'Cooperativo en línea');

COMMIT;


-- -----------------------------------------------------
-- Data for table Idioma
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Idioma (id_idioma, idioma) VALUES ('ES', 'Español');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('EN', 'English');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('FR', 'Frances');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('GE', 'Aleman');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('IT', 'Italiano');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('JP', 'Japones');
INSERT INTO Idioma (id_idioma, idioma) VALUES ('KR', 'Coreano');

COMMIT;

-- -----------------------------------------------------
-- Data for table Oferta
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Oferta (id_oferta, fecha_creacion, precio) VALUES (DEFAULT, '2017-02-01', 0.10);
INSERT INTO Oferta (id_oferta, fecha_creacion, precio) VALUES (DEFAULT, '2017-02-02', 0.25);
INSERT INTO Oferta (id_oferta, fecha_creacion, precio) VALUES (DEFAULT, '2017-02-03', 0.50);
INSERT INTO Oferta (id_oferta, fecha_creacion, precio) VALUES (DEFAULT, '2017-02-04', 0.75);

COMMIT;


-- -----------------------------------------------------
-- Data for table Categoria
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Categoria (id_categoria) VALUES (1);
INSERT INTO Categoria (id_categoria) VALUES (2);
INSERT INTO Categoria (id_categoria) VALUES (3);
INSERT INTO Categoria (id_categoria) VALUES (4);
INSERT INTO Categoria (id_categoria) VALUES (5);
INSERT INTO Categoria (id_categoria) VALUES (6);
INSERT INTO Categoria (id_categoria) VALUES (7);
INSERT INTO Categoria (id_categoria) VALUES (8);
INSERT INTO Categoria (id_categoria) VALUES (9);
INSERT INTO Categoria (id_categoria) VALUES (10);
INSERT INTO Categoria (id_categoria) VALUES (11);
INSERT INTO Categoria (id_categoria) VALUES (12);
INSERT INTO Categoria (id_categoria) VALUES (13);
INSERT INTO Categoria (id_categoria) VALUES (14);
INSERT INTO Categoria (id_categoria) VALUES (15);
INSERT INTO Categoria (id_categoria) VALUES (16);
INSERT INTO Categoria (id_categoria) VALUES (17);
INSERT INTO Categoria (id_categoria) VALUES (18);
INSERT INTO Categoria (id_categoria) VALUES (19);
INSERT INTO Categoria (id_categoria) VALUES (20);
INSERT INTO Categoria (id_categoria) VALUES (21);
INSERT INTO Categoria (id_categoria) VALUES (22);
INSERT INTO Categoria (id_categoria) VALUES (23);
INSERT INTO Categoria (id_categoria) VALUES (24);
INSERT INTO Categoria (id_categoria) VALUES (25);
INSERT INTO Categoria (id_categoria) VALUES (26);
INSERT INTO Categoria (id_categoria) VALUES (27);
INSERT INTO Categoria (id_categoria) VALUES (28);
INSERT INTO Categoria (id_categoria) VALUES (29);
INSERT INTO Categoria (id_categoria) VALUES (30);

COMMIT;

-- -----------------------------------------------------
-- Data for table Categoria_Idioma
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (1, 'ES', 'Accion');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (2, 'ES', 'Lucha');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (3, 'ES', 'Beat \'em up');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (4, 'ES', 'Arcade');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (5, 'ES', 'Plataformas');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (6, 'ES', 'Disparos en primera persona');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (7, 'ES', 'Disparos en tercera persona');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (8, 'ES', 'Shoot \'em up');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (9, 'ES', 'Estrategia en tiempo real');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (10, 'ES', 'Estrategia por turnos');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (11, 'ES', 'Simulacion');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (12, 'ES', 'Simulacion de vehiculos');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (13, 'ES', 'Simulacion de construccion');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (14, 'ES', 'Simulacion de vida');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (15, 'ES', 'Simulacion de combate');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (16, 'ES', 'Deporte');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (17, 'ES', 'Carreras');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (18, 'ES', 'Aventura');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (19, 'ES', 'Aventura conversacional');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (20, 'ES', 'Aventura gráfica');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (21, 'ES', 'Acción-Aventura');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (22, 'ES', 'Survival horror');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (23, 'ES', 'Sigilo');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (24, 'ES', 'Rol');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (25, 'ES', 'Sandbox');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (26, 'ES', 'Musical');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (27, 'ES', 'Puzzle');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (28, 'ES', 'Party games');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (29, 'ES', 'Educación');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (30, 'ES', 'Indie');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (1, 'EN', 'Action');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (2, 'EN', 'Fighting games');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (3, 'EN', 'Beat \'em up');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (4, 'EN', 'Arcade');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (5, 'EN', 'Platforms');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (6, 'EN', 'First person shooter');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (7, 'EN', 'Third person shooter');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (8, 'EN', 'Shoot \'em up');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (9, 'EN', 'Real-Time strategy');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (10, 'EN', 'Turn-based strategy');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (11, 'EN', 'Simulation');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (12, 'EN', 'Vehicle simulation');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (13, 'EN', 'Construcion simulation');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (14, 'EN', 'Life simulation');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (15, 'EN', 'Fight simulation');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (16, 'EN', 'Sports');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (17, 'EN', 'Racing');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (18, 'EN', 'Adventure');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (19, 'EN', 'Text adventure');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (20, 'EN', 'Graphic adventures');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (21, 'EN', 'Action-adventure');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (22, 'EN', 'Sruvival horror');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (23, 'EN', 'Stealth ');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (24, 'EN', 'Rol');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (25, 'EN', 'Sandbox');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (26, 'EN', 'Musical');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (27, 'EN', 'Puzzle');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (28, 'EN', 'Party games');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (29, 'EN', 'Education');
INSERT INTO Categoria_Idioma (id_categoria, id_idioma, categoria) VALUES (30, 'EN', 'Indie');

COMMIT;


-- -----------------------------------------------------
-- Data for table Producto_Idioma
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (1, 'ES', 'Cuando la madre de Isaac comienza a escuchar la voz de Dios exigiendo que se haga un sacrificio para demostrar su fe, Isaac escapa al sótano enfrentando manadas de enemigos desquiciados, hermanos y hermanas perdidos, sus miedos y, finalmente, a su madre.', 'The Binding of Isaac: Rebirth es un shooter RPG de acción con ​​elementos de Rogue-Like. Siguiendo a Isaac en su viaje, los jugadores encontrarán extraños tesoros que cambiarán la forma de Isaac, dándole habilidades sobrehumanas y permitiéndole luchar contra manadas de misteriosas criaturas, descubrir secretos');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (1, 'EN', 'When Isaac’s mother starts hearing the voice of God demanding a sacrifice be made to prove her faith, Isaac escapes into the basement facing droves of deranged enemies, lost brothers and sisters, his fears, and eventually his mother.', 'The Binding of Isaac: Rebirth is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (2, 'ES', 'En deuda con la gente equivocada, con su vida en juego, veterano de la caballería estadounidense y ahora contratado, Booker DeWitt tiene una sola oportunidad para limpiar su pizarra. Debe rescatar a Elizabeth, una chica misteriosa encarcelada desde la infancia y encerrada en la ciudad de Columbia, en pleno vuelo.', 'En deuda con la gente equivocada, con su vida en juego, veterano de la caballería estadounidense y ahora contratado, Booker DeWitt tiene una sola oportunidad para limpiar su pizarra. Debe rescatar a Elizabeth, una chica misteriosa encarcelada desde la infancia y encerrada en la ciudad de Columbia, en pleno vuelo. Obligados a confiar el uno en el otro, Booker y Elizabeth forman un vínculo poderoso durante su atrevida escapada. Juntos, aprenden a aprovechar un arsenal en expansión de armas y habilidades, mientras luchan en zeppelins en las nubes, a lo largo de Skylines de alta velocidad y en las calles de Columbia, todo mientras sobreviven a las amenazas de la ciudad descubriendo su oscuro secreto.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (2, 'EN', 'Indebted to the wrong people, with his life on the line, veteran of the U.S. Cavalry and now hired gun, Booker DeWitt has only one opportunity to wipe his slate clean. He must rescue Elizabeth, a mysterious girl imprisoned since childhood and locked up in the flying city of Columbia.', 'Indebted to the wrong people, with his life on the line, veteran of the U.S. Cavalry and now hired gun, Booker DeWitt has only one opportunity to wipe his slate clean. He must rescue Elizabeth, a mysterious girl imprisoned since childhood and locked up in the flying city of Columbia. Forced to trust one another, Booker and Elizabeth form a powerful bond during their daring escape. Together, they learn to harness an expanding arsenal of weapons and abilities, as they fight on zeppelins in the clouds, along high-speed Sky-Lines, and down in the streets of Columbia, all while surviving the threats of the air-city and uncovering its dark secret.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (3, 'ES', 'Una nueva era de disparos y saqueos está a punto de comenzar. Juega como uno de los cuatro nuevos buscadores de la Cámara y enfréntate a legiones de nuevas criaturas, psicópatas y al villano que las controla, Jack el Guapo. Haz nuevos amigos, equípalos con un cillón de armas y pelea a su lado en partidas cooperativas de 4 jugadores, en una implacable búsqueda de venganza y redención a través de un desconocido e impredecible planeta.', 'Una nueva era de disparos y saqueos está a punto de comenzar. Juega como uno de los cuatro nuevos buscadores de la Cámara y enfréntate a legiones de nuevas criaturas, psicópatas y al villano que las controla, Jack el Guapo.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (3, 'EN', 'A new era of shoot and loot is about to begin. Play as one of four new vault hunters facing off against a massive new world of creatures, psychos and the evil mastermind, Handsome Jack. Make new friends, arm them with a bazillion weapons and fight alongside them in 4 player co-op on a relentless quest for revenge and redemption across the undiscovered and unpredictable living planet.', 'The Ultimate Vault Hunter’s Upgrade lets you get the most out of the Borderlands 2 experience. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (4, 'ES', 'Don\'t Starve Together es la expansión multijugador independiente del juego de supervivencia en la naturaleza sin límites Don\'t Starve. Ahora incluye A New Reign: parte 1, el primer episodio de una serie de actualizaciones. Creado para multijugador, A New Reign explora el mundo de Don\'t Starve ahora que Charlie es el amo.', 'Don\'t Starve Together es la expansión multijugador independiente del juego de supervivencia sin límites Don\'t Starve. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (4, 'EN', 'Don\'t Starve Together is the standalone multiplayer expansion of the uncompromising wilderness survival game, Don\'t Starve. Now Including, A New Reign: Part 1, the first episode of a series of updates. Built for multiplayer A New Reign explores the world of Don\'t Starve now that Charlie has taken over.', 'Don\'t Starve Together is the standalone multiplayer expansion of the uncompromising survival game Don\'t Starve. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (5, 'ES', 'Resident Evil 7 biohazard es la siguiente gran entrega de la renombrada serie Resident Evil y supone un nuevo hito para la franquicia, puesto que se aprovecha de sus raíces y abre la puerta a una experiencia de miedo realmente terrorífica. Con su gran cambio a la vista en primera persona y un estilo fotorrealista gracias al nuevo motor de Capcom RE Engine, Resident Evil 7 trae un nivel sin precedentes de inmersión que logra una experiencia de terror muy cercana y personal.', 'El peligro y la soledad emanan de las decrépitas paredes de una granja abandonada en el sur de los EE. UU. «7» marca un nuevo inicio para el género del survival horror, con el cambio a la aterradora perspectiva de jugador «vista aislada». ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (5, 'EN', 'Resident Evil 7 biohazard is the next major entry in the renowned Resident Evil series and sets a new course for the franchise as it leverages its roots and opens the door to a truly terrifying horror experience. A dramatic new shift for the series to first person view in a photorealistic style powered by Capcom’s new RE Engine, Resident Evil 7 delivers an unprecedented level of immersion that brings the thrilling horror up close and personal.', 'Fear and isolation seep through the walls of an abandoned southern farmhouse. \"7\" marks a new beginning for survival horror with the “Isolated View” of the visceral new first-person perspective. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (6, 'ES', 'Rise of the Tomb Raider: Edición 20 aniversario incluye el juego de base y el pase de temporada con contenido totalmente nuevo. Explora y defiende la Mansión Croft en la nueva historia \"Blood Ties\", defiéndela contra una invasión zombi en \"Lara’s Nightmare\". Sobrevive en condiciones extremas junto a un amigo en el modo Aguante cooperativo online y atrévete con la nueva dificultad \"Superviviente extremo\". También podrás disfrutar de un atuendo y arma inspirados por Tomb Raider III, así como 5 skins clásicos de Lara. El DLC existente te retará a explorar una nueva tumba que alberga un terror antiguo en Baba Yaga: el templo de la bruja y combate hordas de depredadores infectados en El despertar de la fría oscuridad.', 'Rise of the Tomb Raider: Edición 20 aniversario incluye el juego de base y el pase de temporada con contenido totalmente nuevo. Explora y defiende la Mansión Croft en la nueva historia \"Blood Ties\", defiéndela contra una invasión zombi en \"Lara’s Nightmare\". ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (6, 'EN', 'Rise of the Tomb Raider: 20 Year Celebration includes the base game and Season Pass featuring all-new content. Explore Croft Manor in the new “Blood Ties” story, then defend it against a zombie invasion in “Lara’s Nightmare”. Survive extreme conditions with a friend in the new online Co-Op Endurance mode, and brave the new “Extreme Survivor” difficulty. Also features an outfit and weapon inspired by Tomb Raider III, and 5 classic Lara skins. Existing DLC will challenge you to explore a new tomb that houses an ancient terror in Baba Yaga: The Temple of the Witch, and combat waves of infected predators in Cold Darkness Awakened.', 'Rise of the Tomb Raider: 20 Year Celebration includes the base game and Season Pass featuring all-new content. Explore Croft Manor in the new “Blood Ties” story, then defend it against a zombie invasion in “Lara’s Nightmare”. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (7, 'ES', 'Surgido de la mente maestra de Shinji Mikami, The Evil Within 2 es la última evolución del survival horror. El detective Sebastián Castellanos lo ha perdido todo, pero podrá salvar a su hija si desciende una vez más al mundo de pesadilla de STEM. Amenazas terribles surgen de cada esquina mientras todo se retuerce y se distorsiona a su alrededor. ¿Se enfrentará a la adversidad cara a cara, con armas y trampas, o se moverá entre las sombras para sobrevivir?', 'El detective Sebastián Castellanos lo ha perdido todo, incluida su hija Lily. Para salvarla, debe descender al mundo de pesadilla de STEM. Amenazas terribles surgen de cada esquina y debe confiar en su ingenio para sobrevivir. Para redimirse, su única forma de salir es entrar. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (7, 'EN', 'From mastermind Shinji Mikami, The Evil Within 2 is the latest evolution of survival horror. Detective Sebastian Castellanos has lost it all. But when given a chance to save his daughter, he must descend once more into the nightmarish world of STEM. Horrifying threats emerge from every corner as the world twists and warps around him. Will Sebastian face adversity head on with weapons and traps, or sneak through the shadows to survive.', 'Detective Sebastian Castellanos has lost everything, including his daughter, Lily. To save her, he must descend into the nightmarish world of STEM. Horrifying threats emerge from every corner, and he must rely on his wits to survive. For his one chance at redemption, the only way out is in. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (8, 'ES', 'ASSASSIN’S CREED® ORIGINS ES UN NUEVO COMIENZO. El esplendor y el misterio del antiguo Egipto se desdibujan en una cruenta lucha por el poder. ', 'ASSASSIN’S CREED® ORIGINS ES UN NUEVO COMIENZO El esplendor y el misterio del antiguo Egipto se desdibujan en una cruenta lucha por el poder. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (8, 'EN', 'ASSASSIN’S CREED® ORIGINS IS A NEW BEGINNING. Ancient Egypt, a land of majesty and intrigue, is disappearing in a ruthless fight for power. ', 'ASSASSIN’S CREED® ORIGINS IS A NEW BEGINNING Ancient Egypt, a land of majesty and intrigue, is disappearing in a ruthless fight for power. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (9, 'ES', 'Actúa en territorio enemigo para forjar tu ejército, conquistar fortalezas y dominar Mordor desde dentro. Comprueba cómo el galardonado sistema Némesis crea historias personales únicas con cada enemigo y seguidor, y enfréntate al increíble poder del Señor Oscuro, Sauron, y sus Espectros del Anillo en esta nueva y épica historia de la Tierra Media.', 'Disfruta de un mundo abierto épico, recreado por el galardonado sistema Némesis. Forja un nuevo Anillo de Poder, conquista fortalezas en grandes batallas y domina Mordor con tu propio ejército de orcos en La Tierra Media™: Sombras de Guerra™');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (9, 'EN', 'Go behind enemy lines to forge your army, conquer Fortresses and dominate Mordor from within. Experience how the award winning Nemesis System creates unique personal stories with every enemy and follower, and confront the full power of the Dark Lord Sauron and his Ringwraiths in this epic new story of Middle-earth. ', 'Experience an epic open-world brought to life by the award-winning Nemesis System. Forge a new Ring of Power, conquer Fortresses in massive battles and dominate Mordor with your personal orc army in Middle-earth™: Shadow of War™. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (10, 'ES', 'Descubre el verdadero significado del terror en Alien: Isolation, un juego de horror y supervivencia que transcurre en un ambiente de constante tensión y peligro. Han pasado quince años desde los sucesos de Alien™. La hija de Ellen Ripley, Amanda, se ve involucrada en una desesperada batalla por sobrevivir cuando se embarca en una misión que le permitirá averiguar qué sucedió realmente a su madre.', 'Descubre el verdadero significado del terror en Alien: Isolation, un juego de horror y supervivencia que transcurre en un ambiente de constante tensión y peligro. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (10, 'EN', 'HOW WILL YOU SURVIVE?', 'Discover the true meaning of fear in Alien: Isolation, a survival horror set in an atmosphere of constant dread and mortal danger. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (11, 'ES', '¡Consigue ahora mismo el Season Pass de DARK SOULS™ III y ponte a prueba con todo el contenido disponible!', 'Dark Souls continúa redefiniendo los límites con el nuevo y ambicioso capítulo de esta serie revolucionaria, tan aclamada por la crítica. ¡Prepárate para sumergirte en la oscuridad! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (11, 'EN', 'Get the DARK SOULS™ III Season Pass now and challenge yourself with all the available content!', 'Dark Souls continues to push the boundaries with the latest, ambitious chapter in the critically-acclaimed and genre-defining series. Prepare yourself and Embrace The Darkness! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (12, 'ES', 'The Witcher: Wild Hunt es un juego de rol de mundo abierto de nueva generación con una apasionante trama, ambientado en un espectacular universo de fantasía lleno de decisiones trascendentales y consecuencias impactantes. En The Witcher encarnas a Geralt de Rivia, un cazador de monstruos profesional que tiene que encontrar a la muchacha protagonista de una profecía en un amplio mundo abierto y rebosante de ciudades comerciales, islas con piratas vikingos, peligrosos puertos de montaña y cuevas olvidadas.', 'Métete en la piel de un cazarrecompensas marginado que busca a la protagonista de una profecía en un mundo fantástico abierto, turbulento y de moralidad tibia. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (12, 'EN', 'The Witcher: Wild Hunt is a story-driven, next-generation open world role-playing game set in a visually stunning fantasy universe full of meaningful choices and impactful consequences. In The Witcher you play as the professional monster hunter, Geralt of Rivia, tasked with finding a child of prophecy in a vast open world rich with merchant cities, viking pirate islands, dangerous mountain passes, and forgotten caverns to explore.', 'The Witcher is a story-driven, next-generation open world role-playing game, set in a visually stunning fantasy universe, full of meaningful choices and impactful consequences. In The Witcher, you play as Geralt of Rivia, a monster hunter tasked with finding a child from an ancient prophecy. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (13, 'ES', 'Defiende tu mundo. Destruye el suyo.', 'La secuela del galardonado Total War™: WARHAMMER®, Total War™: WARHAMMER II presenta una asombrosa campaña de exploración, expansión y conquista a través del Nuevo Mundo. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (13, 'EN', 'DEFEND YOUR WORLD. DESTROY THEIRS.', 'Strategy gaming perfected. A breath-taking campaign of exploration, expansion and conquest across a fantasy world. Turn-based civilisation management and real-time epic strategy battles with thousands of troops and monsters at your command. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (14, 'ES', 'Batman™: Arkham Knight es la épica conclusión de la galardonada trilogía de Arkham, creada por Rocksteady Studios. El título, desarrollado en exclusiva para plataformas de nueva generación, presenta la espectacular versión del batmóvil imaginada por Rocksteady. La incorporación del legendario vehículo, unida al aclamado sistema de juego de la serie Arkham, ofrece a los jugadores una recreación definitiva del universo de Batman en la que pueden recorrer las calles y sobrevolar los tejados de la totalidad de Gotham City. En este explosivo desenlace, Batman se enfrenta a la mayor amenaza para la ciudad que ha jurado proteger, cuando el Espantapájaros reaparece para unir a todos los supervillanos de Gotham y jura destruir al murciélago de una vez para siempre.', 'Batman™: Arkham Knight es la épica conclusión de la galardonada trilogía de Arkham, creada por Rocksteady Studios. El título, desarrollado en exclusiva para plataformas de nueva generación, presenta la espectacular versión del batmóvil imaginada por Rocksteady. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (14, 'EN', 'Batman™: Arkham Knight brings the award-winning Arkham trilogy from Rocksteady Studios to its epic conclusion. Developed exclusively for New-Gen platforms, Batman: Arkham Knight introduces Rocksteady\'s uniquely designed version of the Batmobile. The highly anticipated addition of this legendary vehicle, combined with the acclaimed gameplay of the Arkham series, offers gamers the ultimate and complete Batman experience as they tear through the streets and soar across the skyline of the entirety of Gotham City. In this explosive finale, Batman faces the ultimate threat against the city that he is sworn to protect, as Scarecrow returns to unite the super criminals of Gotham and destroy the Batman forever.', 'Batman™: Arkham Knight brings the award-winning Arkham trilogy from Rocksteady Studios to its epic conclusion. Developed exclusively for New-Gen platforms, Batman: Arkham Knight introduces Rocksteady\'s uniquely designed version of the Batmobile. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (15, 'ES', 'Enfréntate a las profundidades de un reino olvidado', '¡Forja tu propio camino en Hollow Knight! Una aventura épica a través de un vasto reino de insectos y héroes que se encuentra en ruinas. Explora cavernas tortuosas, combate contra criaturas corrompidas y entabla amistad con extraños insecto');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (15, 'EN', 'Brave the Depths of a Forgotten Kingdom', 'Forge your own path in Hollow Knight! An epic action adventure through a vast ruined kingdom of insects and heroes. Explore twisting caverns, battle tainted creatures and befriend bizarre bugs, all in a classic, hand-drawn 2D style. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (16, 'ES', 'Vivimos en un mundo complejo. Un mundo que cuanto más avanza, más vulnerable se hace. Hemos creado un castillo de naipes. Solo hay que quitar uno para que el castillo entero se desmorone...', 'Durante un Viernes Negro una pandemia devastadora se extiende por la ciudad de Nueva York y, uno tras otro, los servicios básicos caen. En cuestión de días, sin comida ni agua, la ciudad entera se ve abocada al caos.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (16, 'EN', 'We live in a complex world. The more advanced it gets, the more vulnerable it becomes. We’ve created a house of cards: remove just one, and everything falls apart.', 'Black Friday – a devastating pandemic sweeps through New York City, and one by one, basic services fail. In only days, without food or water, society collapses into chaos. The Division, an autonomous unit of tactical agents, is activated.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (17, 'ES', 'Con más de 2,5 millones de copias vendidas en PC (descarga digital) 7 Days to Die ha redefinido el género de la supervivencia, con una artesanía inigualable y contenido mundial. Situado en un mundo post-apocalíptico brutalmente implacable invadido por los muertos vivientes, 7 Days to Die es un juego de mundo abierto que es una combinación única de shooter en primera persona, survival horror, tower defense y juegos de rol. Presenta el combate, la artesanía, el saqueo, la minería, la exploración y el crecimiento del carácter, de una manera que ha visto una respuesta entusiasta de los fanáticos de todo el mundo. Juega el definitivo juego de rol de sandbox de supervivencia zombie que llegó primero. ¡Navezgane te espera!', '7 Days to Die es un juego de mundo abierto que es una combinación única de shooter en primera persona, survival horror, tower defense y juegos de rol. Juega el definitivo juego de rol de sandbox de supervivencia zombie que llegó primero. ¡Navezgane te espera!');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (17, 'EN', 'With over 2.5 million copies sold on PC (digital download) 7 Days to Die has redefined the survival genre, with unrivaled crafting and world-building content. Set in a brutally unforgiving post-apocalyptic world overrun by the undead, 7 Days to Die is an open-world game that is a unique combination of first person shooter, survival horror, tower defense, and role-playing games. It presents combat, crafting, looting, mining, exploration, and character growth, in a way that has seen a rapturous response from fans worldwide. Play the definitive zombie survival sandbox RPG that came first. Navezgane awaits!', '7 Days to Die is an open-world game that is a unique combination of first person shooter, survival horror, tower defense, and role-playing games. Play the definitive zombie survival sandbox RPG that came first. Navezgane awaits! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (18, 'ES', 'Inspirado por la aventura y la imaginación que nos encanta de la ciencia ficción clásica, No Man\'s Sky te presenta una galaxia para explorar, llena de planetas únicos y formas de vida, y peligro y acción constantes.', 'No Man\'s Sky es un juego sobre exploración y supervivencia en un universo infinitamente generado por procedimientos.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (18, 'EN', 'Inspired by the adventure and imagination that we love from classic science-fiction, No Man\'s Sky presents you with a galaxy to explore, filled with unique planets and lifeforms, and constant danger and action.', 'No Man\'s Sky is a game about exploration and survival in an infinite procedurally generated universe. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (19, 'ES', 'Cuphead es un juego de acción clásico estilo \"dispara y corre\" que se centra en combates contra el jefe. Inspirado en los dibujos animados de los años 30, los aspectos visual y sonoro están diseñados con esmero empleando las mismas técnicas de la época, es decir, animación tradicional a mano, fondos de acuarela y grabaciones originales de jazz.', 'Cuphead es un juego de acción clásico estilo \"dispara y corre\" que se centra en combates contra el jefe. Inspirado en los dibujos animados de los años 30, los aspectos visual y sonoro están diseñados con esmero empleando las mismas técnicas de la época, es decir, animación tradicional ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (19, 'EN', 'Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era, i.e. traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings.', 'Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era, i.e. traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (20, 'ES', 'De entre los mortíferos campos de batalla del patio de recreo de cuarto curso, un joven héroe se alzará, destinado a ser el salvador de South Park. De los creadores de South Park, Trey Parker y Matt Stone, llega una épica aventura para llegar a ser... guay. Presentamos: South Park™: The Stick of Truth™.', ' De entre los mortíferos campos de batalla del patio de recreo de cuarto curso, un joven héroe se alzará, destinado a ser el salvador de South Park. De los creadores de South Park, Trey Parker y Matt Stone, llega una épica aventura para llegar a ser... guay. Presentamos: South Park™: The Stick of Truth™. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (20, 'EN', 'From the perilous battlefields of the fourth-grade playground, a young hero will rise, destined to be South Park’s savior. From the creators of South Park, Trey Parker and Matt Stone, comes an epic quest to become… cool. Introducing South Park™: The Stick of Truth™.', 'From the perilous battlefields of the fourth-grade playground, a young hero will rise, destined to be South Park’s savior. From the creators of South Park, Trey Parker and Matt Stone, comes an epic quest to become… cool. Introducing South Park™: The Stick of Truth™.For a thousand years, the battle has been waged. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (21, 'ES', 'Como hombre o mujer desnudo, congelado y muriendo de hambre en las costas de una isla misteriosa llamada ARK, debes cazar, recolectar, construir objetos, plantar cultivos, investigar tecnologías y construir refugios para soportar los elementos. Usa tu astucia y recursos para matar o domesticar dinosaurios y otros seres primitivos, y asóciate con otros jugadores o atácalos para sobrevivir, dominar... y escapar!', ' Juega como un hombre o una mujer desnudo, congelándote y muriéndote de hambre en una isla misteriosa. Debes cazar, cosechar, crear objetos, cultivar, y construir refugios para sobrevivir. Usa tu habilidad y astucia para matar, domesticar, criar y cabalgar dinosaurios y otras criaturas primitivas. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (21, 'EN', 'As a man or woman stranded naked, freezing and starving on the shores of a mysterious island called ARK, you must hunt, harvest resources, craft items, grow crops, research technologies, and build shelters to withstand the elements. Use your cunning and resources to kill or tame & breed the leviathan dinosaurs and other primeval creatures roaming the land, and team up with or prey on hundreds of other players to survive, dominate... and escape!', 'Stranded on the shores of a mysterious island, you must learn to survive. Use your cunning to kill or tame the primeval creatures roaming the land, and encounter other players to survive, dominate... and escape! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (22, 'ES', 'Portal 2 continúa con esa fórmula ganadora consistente en una innovadora mecánica de juego, historia y música que condujeron al Portal original a ganar más de 70 galardones y lo convirtieron en un nuevo mito de la industria.', '¡La \"Iniciativa de Prueba Perpetua\" ha sido ampliada, permitiéndote ahora diseñar puzles cooperativos para ti y tus amigos! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (22, 'EN', 'Portal 2 draws from the award-winning formula of innovative gameplay, story, and music that earned the original Portal over 70 industry accolades and created a cult following.', 'The \"Perpetual Testing Initiative\" has been expanded to allow you to design co-op puzzles for you and your friends! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (23, 'ES', 'Participe en una épica y en constante cambio FINAL FANTASY mientras se aventura y explora con amigos de todo el mundo.', 'Participe en una épica y en constante cambio FINAL FANTASY mientras se aventura y explora con amigos de todo el mundo.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (23, 'EN', 'Take part in an epic and ever-changing FINAL FANTASY as you adventure and explore with friends from around the world.', ' Take part in an epic and ever-changing FINAL FANTASY as you adventure and explore with friends from around the world. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (24, 'ES', 'En el papel del Comandante Shepard, guiarás a un pelotón de elite en una aventura llena de acción y heroísmo a través de la galaxia.', ' En el papel del Comandante Shepard, guiarás a un pelotón de elite en una aventura llena de acción y heroísmo a través de la galaxia. Descubre el peligro inminente de una antigua amenaza y lucha contra el traidor Saren y su ejército mortal para salvar la civilización. ¡El destino de todas las vidas depende de tus acciones! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (24, 'EN', 'As Commander Shepard, you lead an elite squad on a heroic, action-packed adventure throughout the galaxy. ', 'As Commander Shepard, you lead an elite squad on a heroic, action-packed adventure throughout the galaxy. Discover the imminent danger from an ancient threat and battle the traitorous Saren and his deadly army to save civilization. The fate of all life depends on your actions! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (25, 'ES', 'Bethesda Game Studios, el galardonado creador de Fallout 3 y The Elder Scrolls V: Skyrim, os da la bienvenida al mundo de Fallout 4, su juego más ambicioso hasta la fecha y la siguiente generación de mundos abiertos. Eres el único superviviente del Refugio 111 en un mundo destruido por la guerra nuclear. Cada segundo es una lucha por la supervivencia, y en tus manos estarán todas las decisiones. Solo tú puedes reconstruir el yermo y decidir su futuro. Bienvenido a casa.', ' Bethesda Game Studios, el galardonado creador de Fallout 3 y The Elder Scrolls V: Skyrim, os da la bienvenida al mundo de Fallout 4, su juego más ambicioso hasta la fecha y la siguiente generación de mundos abiertos. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (25, 'EN', 'Bethesda Game Studios, the award-winning creators of Fallout 3 and The Elder Scrolls V: Skyrim, welcome you to the world of Fallout 4 – their most ambitious game ever, and the next generation of open-world gaming.', 'Bethesda Game Studios, the award-winning creators of Fallout 3 and The Elder Scrolls V: Skyrim, welcome you to the world of Fallout 4 – their most ambitious game ever, and the next generation of open-world gaming. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (26, 'ES', 'Wolfenstein® II: The New Colossus™ es la esperadísima secuela de Wolfenstein®: The New Order™, el shooter en primera persona aclamado por la crítica y desarrollado por el galardonado estudio MachineGames. Wolfenstein® II, una emocionante aventura hecha realidad gracias al motor id Tech® 6, líder en el sector, enviará a los jugadores a unos Estados Unidos que se encuentran bajo el control nazi, en una misión para reclutar a los líderes más audaces de la resistencia que queden con vida. Combate a los nazis en lugares emblemáticos tales como la pequeña ciudad de Roswell, Nuevo México, las inundadas calles de Nueva Orleans y un Manhattan posnuclear. Equípate con un arsenal de armas brutales y desata nuevas habilidades para abrirte paso a través de legiones de avanzados soldados, cíborgs y über-soldados en este shooter en primera persona definitivo.', ' América, 1961. El asesinato del general nazi Calavera fue una victoria breve. Los nazis siguen dominando el mundo. Eres BJ Blazkowicz, alias \"Terror Billy\", miembro de la resistencia, azote del imperio nazi y última esperanza de la humanidad. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (26, 'EN', 'Wolfenstein® II: The New Colossus™ is the highly anticipated sequel to the critically acclaimed, Wolfenstein®: The New Order™ developed by the award-winning studio MachineGames. An exhilarating adventure brought to life by the industry-leading id Tech® 6, Wolfenstein® II sends players to Nazi-controlled America on a mission to recruit the boldest resistance leaders left. Fight the Nazis in iconic American locations, equip an arsenal of badass guns, and unleash new abilities to blast your way through legions of Nazi soldiers in this definitive first-person shooter.', 'America, 1961. The assassination of Nazi General Deathshead was a short-lived victory. The Nazis maintain their stranglehold on the world. You are BJ Blazkowicz, aka “Terror-Billy,” member of the Resistance, scourge of the Nazi empire, and humanity’s last hope for liberty. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (27, 'ES', 'Descubre el épico final del clan Mishima y descubre los motivos detrás de cada uno de los pasos de esta batalla interminable. TEKKEN 7, creado con Unreal Engine 4, ofrece espectaculares batallas con cinemáticas narrativas e intensos duelos para disfrutar con amigos y rivales gracias a las nuevas mecánicas de lucha.\n\nAmor, venganza, orgullo. Todo el mundo tiene un motivo para luchar. Los valores son lo que nos define y nos hace humanos, más allá de nuestras fortalezas y debilidades. No existen las motivaciones erróneas, solo el camino que decidimos escoger.\n\nExpande tu viaje de luchador comprando el pase de temporada de Tekken 7 por separado y obtén acceso a espectacular contenido adicional. ', ' Descubre el épico final de la prolongada contienda entre miembros del clan Mishima. La legendaria saga de juegos de lucha vuelve a la carga con este título creado con Unreal Engine 4 que ofrece espectaculares batallas con cinemáticas narrativas e intensos duelos para disfrutar con amigos y rivales. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (27, 'EN', 'Discover the epic conclusion of the Mishima clan and unravel the reasons behind each step of their ceaseless fight. Powered by Unreal Engine 4, TEKKEN 7 features stunning story-driven cinematic battles and intense duels that can be enjoyed with friends and rivals alike through innovative fight mechanics.\n\nLove, Revenge, Pride. Everyone has a reason to fight. Values are what define us and make us human, regardless of our strengths and weaknesses. There are no wrong motivations, just the path we choose to take.\n\nExpand your fighter\'s journey by purchasing the Tekken 7 Season Pass separately and gain access to stunning additional content ', 'Discover the epic conclusion of the long-time clan warfare between members of the Mishima family. Powered by Unreal Engine 4, the legendary fighting game franchise fights back with stunning story-driven cinematic battles and intense duels that can be enjoyed with friends and rivals. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (28, 'ES', '¡Conviértete en un granjero moderno en Farming Simulator 17! Sumérgete en un mundo abierto con una enorme cosecha de novedades: ¡nuevo escenario, vehículos, animales, cultivos y mecánicas de juego!\n\nExplora las posibilidades de tu granja en cientos de hectáreas de terreno, incluyendo el nuevo y detallado escenario norteamericano. Conduce más de 250 auténticos vehículos agrícolas y equipamiento de 75 fabricantes, incluidas marcas nuevas como Challenger, Fendt, Valtra y Massey Ferguson.\n\nCosecha todo tipo de cultivos, entre los que se incluyen girasoles y soja por primera vez. Cuida de tu ganado (vacas, ovejas, gallinas y, ahora también, cerdos), tala árboles y vende tus productos para expandir tu granja. Transporta tu mercancía con camiones y tráileres o carga y conduce trenes para llegar a tu destino.\n\nFarming Simulator 17 es rico en cuanto a actividades online: ¡juega en multijugador cooperativo de hasta 16 jugadores y descárgate mods creados por nuestra apasionada comunidad para acceder a contenidos ilimitados y que tu experiencia de Farming Simulator 17 no acabe nunca! ', ' ¡Conviértete en un granjero moderno en Farming Simulator 17! Sumérgete en un mundo abierto con una enorme cosecha de novedades: ¡nuevo escenario, vehículos, animales, cultivos y mecánicas de juego! ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (28, 'EN', 'Take on the role of a modern farmer in Farming Simulator 17! Immerse yourself in a huge open world loaded with new content: new environment, vehicles, animals, crops and gameplay mechanics!\n\nExplore farming possibilities over hundreds of acres of land, including a detailed new North American environment. Drive over 250 authentic farming vehicles and equipment from over 75 manufacturers, including new brands such as Challenger, Fendt, Valtra or Massey Ferguson.\n\nHarvest many types of crops, including for the first time sunflowers and soy beans. Take care of your livestock - cows, sheep, chickens and now pigs - take part in forestry, and sell your products to expand your farm! Transport your goods with trucks and trailers, or load and drive trains to reach your destination.\n\nFarming Simulator 17 offers rich online activities: play in co-operative multiplayer up to 16 players, and download mods created by the passionate community for unlimited content and an ever-evolving Farming Simulator 17 experience. ', 'Take on the role of a modern farmer in Farming Simulator 17! Explore farming possibilities in a new North American environment. Drive over 250 farming vehicles and equipment from over 75 manufacturers, including new brands such as Challenger, Fendt, Valtra or Massey Ferguson. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (29, 'ES', '¡Explora una vasta galaxia llena de maravillas! Paradox Development Studio, creadores de las series Crusader Kings y Europa Universalis, presenta Stellaris, una evolución del gran género de estrategia con la exploración espacial como núcleo.\n\nCon una profunda y estratégica mecánica de juego, una selección rica y muy diversa de razas alienígenas y una narración incipiente, Stellaris presenta una dinámica de juego cautivadora que recompensa la exploración interestelar mientras atraviesas, descubres, interactúas y aprendes más cosas sobre las numerosas especies que encontrarás a lo largo de tus viajes.\n\nDeja tu nombre grabado en el cosmos forjando un imperio galáctico, colonizando planetas remotos e integrando civilizaciones alienígenas. ¿Ampliarás tus fronteras utilizando la guerra como única herramienta, o recorrerás el camino de la diplomacia para lograr tus objetivos?', ' ¡Explora una vasta galaxia llena de maravillas! Paradox Development Studio, creadores de las series Crusader Kings y Europa Universalis, presenta Stellaris, una evolución del gran género de estrategia con la exploración espacial como núcleo. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (29, 'EN', 'Explore a vast galaxy full of wonder! Paradox Development Studio, makers of the Crusader Kings and Europa Universalis series presents Stellaris, an evolution of the grand strategy genre with space exploration at its core.\n\nFeaturing deep strategic gameplay, a rich and enormously diverse selection of alien races and emergent storytelling, Stellaris has engaging challenging gameplay that rewards interstellar exploration as you traverse, discover, interact and learn more about the multitude of species you will encounter during your travels.\n\nEtch your name across the cosmos by forging a galactic empire; colonizing remote planets and integrating alien civilizations. Will you expand through war alone or walk the path of diplomacy to achieve your goals?', 'Explore a vast galaxy full of wonder! Paradox Development Studio, makers of the Crusader Kings and Europa Universalis series presents Stellaris, an evolution of the grand strategy genre with space exploration at its core. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (30, 'ES', 'Life Is Strange es una aventura por episodios premiada y elogiada por la crítica que te permite retroceder en el tiempo y cambiar el pasado, el presente y el futuro.\n\nSigue la historia de Max Caulfield, una estudiante de fotografía que descubre que es capaz de retroceder en el tiempo al salvar a su mejor amiga, Chloe Price.\nJuntas comienzan a investigar la misteriosa desaparición de otra estudiante, Rachel Amber, y pronto descubren el lado más oscuro de Arcadia Bay. Max debe aprender cuanto antes que cambiar el pasado a veces puede traer consecuencias desastrosas en el futuro.', ' ¡Primer episodio gratis! Life Is Strange es una aventura por episodios premiada y elogiada por la crítica que te permite retroceder en el tiempo y cambiar el pasado, el presente y el futuro. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (30, 'EN', 'Life is Strange is an award-winning and critically acclaimed episodic adventure game that allows the player to rewind time and affect the past, present and future. \r \r Follow the story of Max Caulfield, a photography senior who discovers she can rewind time while saving her best friend Chloe Price.\r The pair soon find themselves investigating the mysterious disappearance of fellow student Rachel Amber, uncovering a dark side to life in Arcadia Bay. Meanwhile, Max must quickly learn that changing the past can sometimes lead to a devastating future.', 'Episode 1 now FREE! Life is Strange is an award-winning and critically acclaimed episodic adventure game that allows the player to rewind time and affect the past, present and future. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (31, 'ES', 'Los creadores de South Park, Trey Parker y Matt Stone, presentan South Park: the Fractured but Whole, secuela del galardonado juego de 2014 South Park: La Vara de la Verdad. Los jugadores volverán a encarnar al «chico nuevo» y participarán con los protagonistas de la serie, Stan, Kyle, Kenny y Cartman, en otra divertida y provocadora aventura rolera.\n\nEn South Park: the Fractured but Whole, los jugadores se adentrarán en el submundo criminal de South Park con el Mapache y Amigos. Este grupo de aguerridos justicieros fue fundado por Eric Cartman, cuyo alter ego, el Mapache, es mitad hombre y mitad mapache. En el papel de niño nuevo, los jugadores unirán fuerzas con Mysterion, Cobertizo y el Cometa Humano entre otros para combatir el mal mientras el Mapache trata que su equipo de superhéroes se convierta en el más querido de la historia.\n\nSouth Park™: Retaguardia en Peligro™ estará localizado completamente al castellano con las voces de los actores oficiales. ', ' Los creadores de South Park, Trey Parker y Matt Stone, presentan South Park: the Fractured but Whole, secuela del galardonado juego de 2014 South Park: La Vara de la Verdad. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (31, 'EN', 'From the creators of South Park, Trey Parker and Matt Stone, comes South Park: The Fractured But Whole, a sequel to 2014\'s award-winning South Park: The Stick of Truth. Players will once again assume the role of the New Kid and join South Park favorites Stan, Kyle, Kenny and Cartman in a new hilarious and outrageous RPG adventure.\n\nIn South Park: The Fractured But Whole, players will delve into the crime-ridden underbelly of South Park with Coon and Friends. This dedicated group of crime fighters was formed by Eric Cartman whose superhero alter-ego, The Coon, is half man, half raccoon. As the New Kid, players will join Mysterion, Toolshed, Human Kite and a host of others to battle the forces of evil while Coon strives to make his team the most beloved superheroes in history.', 'From the creators of South Park, Trey Parker and Matt Stone, comes South Park: The Fractured But Whole, a sequel to 2014\'s award-winning South Park: The Stick of Truth. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (32, 'ES', 'Ambientado en el apocalipsis zombi, Left 4 Dead 2 (L4D2) es la secuela largamente esperada del galardonado Left 4 Dead, el juego co-op número 1 de 2008.\n\nEste FPS cooperativo de acción y horror os llevará a ti y a tus amigos por las ciudades, pantanos y cementerios del Sur Profundo, desde Savannah hasta Nueva Orleans a lo largo de cinco extensas campañas.\n\nJugarás como uno de los cuatro nuevos supervivientes, armado con un enorme y devastador arsenal de armas clásicas y mejoradas. Además de las armas de fuego, tendrás la oportunidad de atacar a los infectados con diversas armas de combate cuerpo a cuerpo, desde motosierras hasta hachas, e incluso una mortífera sartén.\n\nPondrás a prueba estas armas contra tres horribles y magníficos nuevos Infectados Especiales (o jugarás como ellos en Versus). También te encontrarás con cinco nuevos infectados comunes no comunes, incluyendo a los aterradores Mudmen (hombres de barro).\n\nPara lograr llevar la jugabilidad frenética y repleta de acción de L4D a un nuevo nivel, llega el AI Director 2.0. Este Director mejorado tiene la capacidad de modificar la meteorología y las rutas a tomar, además de administrar la población enemiga, los efectos y los sonidos según tu rendimiento. L4D2 promete una experiencia única y desafiante cada vez que juegues, personalizada de acuerdo a tu estilo de juego.', ' Ambientado en el apocalipsis zombi, Left 4 Dead 2 (L4D2) es la secuela largamente esperada del galardonado Left 4 Dead, el juego co-op número 1 de 2008. Este FPS cooperativo de acción y horror os llevará a ti y a tus amigos por las ciudades, pantanos y cementerios del Sur Profundo, desde Savannah hasta Nueva Orleans a lo largo de cinco... ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (32, 'EN', 'Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead, the #1 co-op game of 2008.\nThis co-operative action horror FPS takes you and your friends through the cities, swamps and cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns.\nYou\'ll play as one of four new survivors armed with a wide and devastating array of classic and upgraded weapons. In addition to firearms, you\'ll also get a chance to take out some aggression on infected with a variety of carnage-creating melee weapons, from chainsaws to axes and even the deadly frying pan.\nYou\'ll be putting these weapons to the test against (or playing as in Versus) three horrific and formidable new Special Infected. You\'ll also encounter five new uncommon common infected, including the terrifying Mudmen.\nHelping to take L4D\'s frantic, action-packed gameplay to the next level is AI Director 2.0. This improved Director has the ability to procedurally change the weather you\'ll fight through and the pathways you\'ll take, in addition to tailoring the enemy population, effects, and sounds to match your performance. L4D2 promises a satisfying and uniquely challenging experience every time the game is played, custom-fitted to your style of play.', 'Set in the zombie apocalypse, Left 4 Dead 2 (L4D2) is the highly anticipated sequel to the award-winning Left 4 Dead, the #1 co-op game of 2008. This co-operative action horror FPS takes you and your friends through the cities, swamps and cemeteries of the Deep South, from Savannah to New Orleans across five expansive campaigns. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (33, 'ES', '• Más de 180 coches licenciados de marcas icónicas.\n• Compatibilidad total con resolución de 12K y RV.\n• Testeado y ajustado por pilotos de carreras profesionales.\n• Nuevos modos (IndyCar, Oval de carreras, Rallycross) se suman a viejos favoritos como GT3.\n• LiveTrack 3.0: superficies dinámicas y condiciones atmosféricas que afectan al rendimiento, agarre y manejo del coche en tiempo real.\n• Nuevas carreras en superficies inestables (hielo, tierra, barro).\n• Ciclo completo de 24 horas con condiciones atmosféricas en tiempo real y ambiente estacional.\n• Física de modelo de última generación.\n• Manejo con mando mejorado.\n• Potencial inmejorable para eSports. ', ' LA EXPERIENCIA DE CONDUCCIÓN DEFINITIVA Project CARS 2 ofrece el alma del automovilismo con el juego de carreras técnicamente más avanzado, realista y hermoso del mundo. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (33, 'EN', '• 180+ licensed cars from iconic manufacturers\n• Full 12K & VR Support\n• Tested and tuned by pro racing drivers\n• All-new motorsports (IndyCar, Oval Racing, Rallycross) join old favorites incl. GT3\n• LiveTrack 3.0: Dynamic surface & weather physics affect vehicle performance and handling in real-time \n• New loose surface racing (ice, dirt, mud)\n• Full 24-hour cycle featuring real-time atmospheric conditions and seasonal ambience\n• State-of-the art physics model\n• Revamped gamepad handling\n• Class-leading Esport capabilities ', 'THE ULTIMATE DRIVER JOURNEY! Project CARS 2 delivers the soul of motor racing in the world’s most beautiful, authentic, and technically-advanced racing game. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (34, 'ES', 'Creado por Shinji Mikami, responsable de la influyente serie Resident Evil, y desarrollado con el talento del equipo de Tango Gameworks, The Evil Within abraza la esencia más pura del género del survival horror. Adéntrate en una realidad perturbadora mientras intentas liberarte de retorcidas maquinaciones que solo podrían existir en los mundos más terroríficos. Enfréntate a malvadas criaturas y experimenta el auténtico terror, todo ellos amplificado por una iluminación y animación vanguardistas gracias a una versión personalizada del motor id Tech 5.\n\nHISTORIA:\n\nDurante la inspección de la escena de un terrible asesinato en masa, el inspector Sebastián Castellanos y sus colegas se encuentran con una misteriosa y poderosa fuerza. Tras presenciar la matanza de sus compañeros, Sebastián cae en una emboscada y pierde el conocimiento. Al despertar, se encuentra dentro de un mundo sobrecogedor y desquiciado en el que espantosos seres vagan entre los cadáveres.\nSebastián se embarcará en un viaje aterrador para descubrir el origen de estas fuerzas del mal y deberá enfrentarse a un terror inimaginable con un único objetivo: sobrevivir. ', ' Creado por Shinji Mikami, responsable de la influyente serie Resident Evil, y desarrollado con el talento del equipo de Tango Gameworks, The Evil Within abraza la esencia más pura del género del survival horror. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (34, 'EN', 'Developed by Shinji Mikami -- creator of the seminal Resident Evil series -- and the talented team at Tango Gameworks, The Evil Within embodies the meaning of pure survival horror. Highly-crafted environments, horrifying anxiety, and an intricate story are combined to create an immersive world that will bring you to the height of tension. With limited resources at your disposal, you’ll fight for survival and experience profound fear in this perfect blend of horror and action.\n\n\nSTORY: \n\nWhile investigating the scene of a gruesome mass murder, Detective Sebastian Castellanos and his partners encounter a mysterious and powerful force. After seeing the slaughter of fellow officers, Sebastian is ambushed and knocked unconscious. When he awakens, he finds himself in a deranged world where hideous creatures wander among the dead. \nFacing unimaginable terror, and fighting for survival, Sebastian embarks on a frightening journey to unravel what’s behind this evil force.', 'Developed by Shinji Mikami -- creator of the seminal Resident Evil series -- and the talented team at Tango Gameworks, The Evil Within embodies the meaning of pure survival horror. Highly-crafted environments, horrifying anxiety, and an intricate story are combined to create an immersive world that will bring you to the height of tension. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (35, 'ES', 'Civilization, creado originalmente por Sid Meier, el legendario diseñador de videojuegos, es un juego de estrategia por turnos en el que tu objetivo es construir un imperio que resista el paso del tiempo. Conquista el mundo entero estableciendo y liderando tu propia civilización desde la Edad de Piedra hasta la Era de la Información. Libra guerras, utiliza la diplomacia, fomenta el progreso de tu cultura y enfréntate cara a cara a los líderes más importantes de la historia para crear la civilización más grande jamás conocida.\n\nCivilization VI ofrece nuevas maneras de interactuar con tu mundo: ahora las ciudades se expanden físicamente en el mapa, la investigación activa de tecnología y cultura desbloquea nuevos potenciales y los líderes actúan en función de sus rasgos históricos mientras intentas conseguir la victoria de una de las cinco maneras posibles.', ' Juega como uno de los 20 líderes históricos, incluido Felipe II. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (35, 'EN', 'Originally created by legendary game designer Sid Meier, Civilization is a turn-based strategy game in which you attempt to build an empire to stand the test of time. Become Ruler of the World by establishing and leading a civilization from the Stone Age to the Information Age. Wage war, conduct diplomacy, advance your culture, and go head-to-head with history’s greatest leaders as you attempt to build the greatest civilization the world has ever known.\n\nCivilization VI offers new ways to engage with your world: cities now physically expand across the map, active research in technology and culture unlocks new potential, and competing leaders will pursue their own agendas based on their historical traits as you race for one of five ways to achieve victory in the game.', 'Civilization VI offers new ways to interact with your world, expand your empire across the map, advance your culture, and compete against history’s greatest leaders to build a civilization that will stand the test of time. Play as one of 20 historical leaders including Roosevelt (America) and Victoria (England). ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (36, 'ES', 'El único objetivo en Rust es sobrevivir.\n\nPara hacer esto, tendrás que superar luchas como el hambre, la sed y el frío. Hacer fuego. Construir un refugio. Mata a los animales por carne. Protégete de otros jugadores y mátalos por carne. Crea alianzas con otros jugadores y forma una ciudad.\n\nHaz lo que sea necesario para sobrevivir.', 'El único objetivo en Rust es sobrevivir. Para hacer esto, tendrás que superar luchas como el hambre, la sed y el frío. Hacer fuego. Construir un refugio. Mata a los animales por carne. Protégete de otros jugadores y mátalos por carne. Crea alianzas con otros jugadores y forma una ciudad. Haz lo que sea necesario para sobrevivir.');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (36, 'EN', 'The only aim in Rust is to survive.\n\nTo do this you will need to overcome struggles such as hunger, thirst and cold. Build a fire. Build a shelter. Kill animals for meat. Protect yourself from other players, and kill them for meat. Create alliances with other players and form a town.\n\nDo whatever it takes to survive. ', ' The only aim in Rust is to survive. To do this you will need to overcome struggles such as hunger, thirst and cold. Build a fire. Build a shelter. Kill animals for meat. Protect yourself from other players, and kill them for meat. Create alliances with other players and form a town. Do whatever it takes to survive. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (37, 'ES', 'DRAGON BALL FighterZ nace de lo que hace a DRAGON BALL tan famosa: luchas espectaculares e interminables con luchadores superpoderosos.\n\nCon Arc System Works, DRAGON BALL FighterZ maximiza los gráficos de anime de alta calidad y ofrece un juego de lucha fácil de aprender pero difícil de dominar.\n\nGráficos de anime de alta calidad\nCon el poder del motor Unreal y el talentoso equipo de Arc System Works, DRAGON BALL FighterZ es toda una hazaña visual.\n\nEn equipo/soporte 3vs3\nForma tu equipo soñado y domina rápidas combinaciones entre luchadores.\n\nEmocionante juego en línea\nPartidas igualadas, salas interactivas, locas partidas de grupos de 6 jugadores... ¡Hay para todos los gustos!\n\nModo historia exclusivo\nDescubre una aventura nunca vista con la Androide N°21, un nuevo personaje de creación supervisada por Akira Toriyama.\n\nLuchas espectaculares\n¡Experimenta combos aéreos, escenarios destructibles y escenas famosas del anime de DRAGON BALL reproducidas en una resolución de 60FPS y 1080p! ', ' DRAGON BALL FighterZ nace de lo que hace a la serie DRAGON BALL tan famosa: luchas espectaculares e interminables con luchadores superpoderosos. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (37, 'EN', 'DRAGON BALL FighterZ is born from what makes the DRAGON BALL series so loved and famous: endless spectacular fights with its all-powerful fighters.\n\nPartnering with Arc System Works, DRAGON BALL FighterZ maximizes high end Anime graphics and brings easy to learn but difficult to master fighting gameplay.\n\nHigh-end Anime Graphics\nUsing the power of the Unreal engine and the talented team at Arc System Works, DRAGON BALL FighterZ is a visual tour-de-force.\n\n3vs3 Tag/Support\nBuild your dream team and sharpen your skills to master high-speed tag combinations.\n\nThrilling Online Features\nRanked matches, interactive lobby, crazy 6-player Party Match... There is something for every taste!\n\nExclusive Story Mode\nDiscover a never-seen-before scenario featuring Android 21, a brand new character whose creation was supervised by Akira Toriyama himself.\n\nSpectacular Fights\nExperience aerial combos, destructible stages and famous scenes from the DRAGON BALL anime in 60FPS and 1080p resolution! ', 'DRAGON BALL FighterZ is born from what makes the DRAGON BALL series so loved and famous: endless spectacular fights with its all-powerful fighters. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (38, 'ES', 'Construye y mejora la versión definitiva de tus leyendas favoritas de DC en INJUSTICE 2.\n•CADA COMBATE TE DEFINE: conseguirás equipo con cada combate y podrás personalizar y subir de nivel a tus personajes favoritos.\n•UNA NUEVA AMENAZA: continuando donde lo dejó Injustice, Batman lucha contra el régimen de Superman, mientras que una nueva amenaza pondrá en riesgo la existencia de la Tierra.\n•LO MEJOR DE DC: escoge personajes del mayor elenco del Universo DC y lucha en batallas épicas y lugares simbólicos.\n•CREADO POR NETHERREALM: los desarrolladores de la aclamada saga MORTAL KOMBAT, un éxito de ventas. ', ' Construye y mejora la versión definitiva de tus leyendas favoritas de DC en INJUSTICE 2. Es tu superhéroe. Tu viaje. Tu Injustice. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (38, 'EN', 'Power up and build the ultimate version of your favourite DC legends in INJUSTICE 2. ', 'Build and power up the ultimate version of your favourite DC legends in INJUSTICE 2. This is your Legend. Your Journey. Your Injustice. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (39, 'ES', 'La muerte no es la salida.\n\nDead by Daylight es un juego de horror de multijugador (4 contra 1) en el que un jugador representa el rol del asesino despiadado y los 4 restantes juegan como supervivientes que intentan escapar de él para evitar ser capturados, torturados y asesinados.\n\nLos supervivientes juegan en tercera persona y tienen la ventaja de contar con una mejor percepción del entorno. El asesino juega en primera persona y está más enfocado en su presa.\n\nEl objetivo del superviviente en cada encuentro es escapar del área de matanza sin que lo capture el asesino, algo que suena más fácil de lo que es, especialmente con un entorno que cambia cada vez que juegas.\n\nPuedes encontrar más información en www.deadbydaylight.com\nCaracterísticas destacadas\n• Sobrevivid juntos… o no - Los supervivientes pueden colaborar o ser egoístas. Tus probabilidades de supervivencia variarán según decidas trabajar en grupo o aventurarte en solitario. ¿Lograrás ser más astuto que el asesino para escapar del área de matanza?\n\n• ¿Dónde estoy? - Cada nivel se genera aleatoriamente, así que nunca sabrás qué es lo que te espera. Con puntos de aparición al azar, nunca podrás sentirte a salvo, el entorno y sus peligros cambian cada vez que juegas.\n\n• Un festín para asesinos - Dead by Daylight hace uso de todas las características del mundo de terror. Como asesino, puedes ser cualquier cosa, desde un poderoso acuchillador a un ente paranormal aterrador. Familiarízate con las áreas de matanza y aprende a dominar los poderes únicos de cada asesino para poder cazar, capturar y sacrificar a tus víctimas.', ' Dead by Daylight es un juego de horror de multijugador (4 contra 1) en el que un jugador representa el rol del asesino despiadado y los 4 restantes juegan como supervivientes que intentan escapar de él para evitar ser capturados y asesinados. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (39, 'EN', 'Death Is Not an Escape.\n\nDead by Daylight is a multiplayer (4vs1) horror game where one player takes on the role of the savage Killer, and the other four players play as Survivors, trying to escape the Killer and avoid being caught, tortured and killed.\n\nSurvivors play in third-person and have the advantage of better situational awareness. The Killer plays in first-person and is more focused on their prey.\n\nThe Survivors\' goal in each encounter is to escape the Killing Ground without getting caught by the Killer - something that sounds easier than it is, especially when the environment changes every time you play.\n\nMore information about the game is available at http://www.deadbydaylight.com\nKey Features\n• Survive Together… Or Not - Survivors can either cooperate with the others or be selfish. Your chance of survival will vary depending on whether you work together as a team or if you go at it alone. Will you be able to outwit the Killer and escape their Killing Ground?\n\n• Where Am I? - Each level is procedurally generated, so you’ll never know what to expect. Random spawn points mean you will never feel safe as the world and its danger change every time you play.\n\n• A Feast for Killers - Dead by Daylight draws from all corners of the horror world. As a Killer you can play as anything from a powerful Slasher to terrifying paranormal entities. Familiarize yourself with your Killing Grounds and master each Killer’s unique power to be able to hunt, catch and sacrifice your victims.\n\n\n\n• Deeper and Deeper - Each Killer and Survivor has their own deep progression system and plenty of unlockables that can be customized to fit your own personal strategy. Experience, skills and understanding of the environment are key to being able to hunt or outwit the Killer.\n\n• Real People, Real Fear - The procedural levels and real human reactions to pure horror makes each game session an unexpected scenario. You will never be able to tell how it’s going to turn out. Ambience, music, and chilling environments combine into a terrifying experience. With enough time, you might even discover what’s hiding in the fog.', 'Dead by Daylight is a multiplayer (4vs1) horror game where one player takes on the role of the savage Killer, and the other four players play as Survivors, trying to escape the Killer and avoid being caught and killed. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (40, 'ES', 'DOMINA EL BARRIO\n\n    El futuro de los modos carrera en juegos de deporte está aquí, y te va a permitir jugar como tú quieras. Forja tu leyenda en partidos NBA, compite en las canchas del Parque, únete al circuito Pro-AM o explora las tiendas y calles en el nuevo entorno abierto del barrio. Nuevos sistemas de mejoras y patrocinios para Mi JUGADOR, el mayor elenco de personajes hasta la fecha, incluyendo jugadores NBA, y mucho más.\n\nCamino al 99\n\n    El metajuego que recompensa a los usuarios por mejorar la media de Mi JUGADOR, independientemente de los modos que elijan jugar. Gracias a un sistema de insignias unificado en Pro-Am, Parque y tu trayectoria NBA en Mi CARRERA, podrás combinar los atributos, animaciones e insignias para definir tu estilo de juego en la puntuación del camino al 99. \n\nCreación de jugadores mejorada\n\n    Crea el Mi JUGADOR que tú quieras, escaneando la cara con la aplicación para móvil MyNBA2K18 o de forma personalizada con las opciones que ofrece NBA 2K18. Los peinados se han actualizado con nuevas opciones, y el peso y la altura del cuerpo se han representado de forma más precisa para dar un aspecto único a Mi JUGADOR. \n\nMi EQUIPO\n\n    Colecciona cartas de jugador, con leyendas de la NBA de ayer y hoy, y utilízalas para competir en diferentes modos online y offline.\n\nSupermáximo\n\n    Crea un equipo con tope salarial y compite contra otros usuarios de nivel similar en este nuevo modo de temporada. Con un tope salarial limitado para 13 jugadores, tendrás que ser estratégico para eligiendo tu alineación en cada ronda. Los premios se otorgan según el rendimiento de cada ronda, para asegurar que cada partido cuenta.\n\nPack & Playoffs\n\n    Un nuevo modo draft que te desafía a crear el mejor equipo de 5 jugadores posible a partir de los packs que abras antes de cada ronda. Compite contra otros usuarios con equipos drafteados y avanza para conseguir cada vez mejores premios. Con Pack & Playoffs, podrás disfrutar de una nueva alineación y una nueva experiencia en cada ronda.\n\nDesafíos de calendario\n\n    Supera un calendario de 30 partidos por cada uno de los 30 equipos de la NBA. Consigue puntos de Mi EQUIPO (MTs) y premios a medida que te abras paso por 900 desafíos exclusivos basados en el calendario real de la temporada 2017-18 de la NBA\n\nUNA EXPERIENCIA DE JUEGO DE ELITE\nNuevo sistema de movimiento\n\n    El nuevo sistema de movimiento eleva el control de los jugadores a un nuevo nivel de realismo. Ahora, los dribling y el movimiento sin balón no dependen de animaciones predeterminadas. Esta revolucionaria tecnología genera dinámicamente animaciones que ofrecen la mejor experiencia de juego posible. Y tú tienes el control completo\n\nIndicador de tiro mejorado\n\n    Anota de manera más coherente gracias a un indicador de tiro mejorado, que te ofrece más información que nunca para que puedas aumentar tu precisión. ', ' El juego anual de deporte mejor valorado* de esta generación regresa con NBA 2K18, más auténtico que nunca y con múltiples mejoras en la cancha. *Según Metacritic. ');
INSERT INTO Producto_Idioma (id_producto, id_idioma, detalles_largo, detalles_corto) VALUES (40, 'EN', 'RUN THE NEIGHBORHOOD\nThe future of sports career modes has arrived, allowing you to play the game the way you like. Build your career in NBA games, hit the courts in The Playground Park, join the Pro-Am circuit, or explore the shops and venues in an all-new open neighborhood setting. Featuring new MyPLAYER upgrade and endorsement systems, our biggest cast of characters to date including NBA players, and so much more.\nThe Road to 99\nThe overarching meta-game that rewards users for improving their MyPLAYER’s overall rating, regardless of which modes they choose to play. Featuring a unified badge system across Pro-Am, Park and your NBA journey in MyCAREER, your attributes, animations and badges all combine to define your play style on your road to a 99 overall rating. \nUpdated Create A Player\nCreate the MyPLAYER you want, whether scanning your face with the MyNBA2K18 mobile app or building something custom using our preset options. Hairstyles have been updated with numerous new options to choose from, and body weight and height are more accurately represented to ensure the unique look you want for your MyPLAYER. \nMyTEAM\nCollect player cards featuring NBA legends from yesterday and today, and compete in a variety of online and offline modes. \nSuper Max\nConstruct a salary-capped team and compete against other users of similar ability in a new season mode. With a limited salary cap to distribute among 13 players, you’ll have to be strategic in selecting your lineup for each round. Prizes are awarded based on your performance each round, ensuring that every game matters.\nPack & Playoffs\nAn all-new draft mode that challenges you to build the best possible 5-man team from packs you’ll open before each round. Compete against other users’ drafted teams and advance to earn better prizes. With Pack & Playoffs, it’s a new lineup and a new experience every round. \nSchedule Challenges\nPlay through a 30 game schedule for each of the 30 NBA teams. Earn MyTEAM points and prizes as you work your way through 900 unique challenges based on the 2017-18 NBA schedule.', 'The highest rated* annual sports title returns with NBA 2K18, featuring unparalleled authenticity and improvements on the court.*According to 2008 - 2016 Metacritic. ');

COMMIT;

-- -----------------------------------------------------
-- Data for table Producto_Idioma_Disponible
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'EN');

COMMIT;

-- -----------------------------------------------------
-- Data for table Producto_Categoria
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('1', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('2', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('3', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('4', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('5', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('6', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('7', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('8', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('9', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('10', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('11', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('12', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('13', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('14', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('15', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('16', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('17', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('18', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('19', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('20', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('21', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('22', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('23', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('24', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('25', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('26', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('27', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('28', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('29', '30');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('30', '18');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('31', '24');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('32', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('33', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('34', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('35', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('36', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('37', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('38', '11');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('39', '1');
INSERT INTO producto_categoria (id_producto, id_categoria) VALUES ('40', '11');

COMMIT;

-- -----------------------------------------------------
-- Data for table Producto_NJugadores
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (1, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (2, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (3, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (4, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (5, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (6, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (7, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (8, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (9, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (10, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (11, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (12, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (13, 6);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (14, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (15, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (16, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (17, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (18, 2);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (19, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (20, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (21, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (22, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (23, 6);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (24, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (25, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (26, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (27, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (28, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (29, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (30, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (31, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (32, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (33, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (34, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (35, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (36, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (37, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (38, 3);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (39, 1);
INSERT INTO Producto_NJugadores (id_producto, id_njugador) VALUES (40, 1);

COMMIT;
 
-- -----------------------------------------------------
-- Añadidas ofertas
-- -----------------------------------------------------
UPDATE producto SET id_oferta='4' WHERE id_producto='3';
UPDATE producto SET id_oferta='2' WHERE id_producto='25';
UPDATE producto SET id_oferta='3' WHERE id_producto='2';
UPDATE producto SET id_oferta='1' WHERE id_producto='4';
UPDATE producto SET id_oferta='1' WHERE id_producto='5';
UPDATE producto SET id_oferta='2' WHERE id_producto='12';
UPDATE producto SET id_oferta='1' WHERE id_producto='19';
UPDATE producto SET id_oferta='3' WHERE id_producto='11';
UPDATE producto SET id_oferta='1' WHERE id_producto='7';
UPDATE producto SET id_oferta='1' WHERE id_producto='8';
UPDATE producto SET id_oferta='4' WHERE id_producto='9';
UPDATE producto SET id_oferta='1' WHERE id_producto='37';
UPDATE producto SET id_oferta='2' WHERE id_producto='39';
UPDATE producto SET id_oferta='1' WHERE id_producto='27';

-- -----------------------------------------------------
-- Data for table Producto_Idioma_Disponible
-- -----------------------------------------------------
START TRANSACTION;
USE gzone;
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (1, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (1, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (1, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (1, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (2, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (3, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (3, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (3, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (3, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (3, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (4, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (4, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (5, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (6, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (7, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (8, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (9, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (10, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (10, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (10, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (10, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (11, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (11, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (11, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (11, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (12, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (12, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (12, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (12, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (12, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (13, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (14, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (14, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (14, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (14, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (15, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (15, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (15, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (15, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (15, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (16, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (16, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (16, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (16, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (16, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (17, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (17, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (17, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (18, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (19, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (19, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (19, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (20, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (21, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (21, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (21, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (22, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (22, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (22, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (22, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (22, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (23, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (24, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (24, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (24, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (24, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (25, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (25, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (25, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (25, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (25, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (26, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (27, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (28, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (28, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (28, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (28, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (29, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (29, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (29, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (30, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (31, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (32, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (32, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (32, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (32, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (32, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (33, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (33, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (33, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (34, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (34, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (34, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (34, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (35, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (36, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (36, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (36, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (36, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (36, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (37, 'KR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (38, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (38, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (38, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (38, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (38, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (39, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (39, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (39, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (39, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'EN');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'ES');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'FR');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'GE');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'IT');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'JP');
INSERT INTO Producto_Idioma_Disponible (id_producto, id_idioma) VALUES (40, 'KR');

COMMIT;

