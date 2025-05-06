CREATE DATABASE Kaufland
GO
USE Kaufland
GO

CREATE TABLE Kaufland_Card (
                               ID INT IDENTITY(1, 1) PRIMARY KEY,
                               code NVARCHAR(200) UNIQUE NOT NULL
);
GO

CREATE TABLE Client (
                        ID INT IDENTITY(1, 1) PRIMARY KEY,
                        card_ID INT UNIQUE,
                        first_name NVARCHAR(80) NOT NULL,
                        last_name NVARCHAR(120) NOT NULL,
                        email NVARCHAR(200) NOT NULL
);
GO

CREATE TABLE Scanner (
                         ID INT IDENTITY(1, 1) PRIMARY KEY,
                         serial_number NVARCHAR(10) UNIQUE NOT NULL
);
GO

CREATE TABLE Shopping_Session (
                                  ID INT IDENTITY(1, 1) PRIMARY KEY,
                                  card_ID INT NOT NULL,
                                  scanner_ID INT NOT NULL,
                                  shopping_start DATETIME NOT NULL,
                                  shopping_end DATETIME
);
GO

CREATE TABLE Products (
                          ID INT IDENTITY(1, 1) PRIMARY KEY,
                          product_name NVARCHAR(100) NOT NULL,
                          descr NVARCHAR(500) NOT NULL,
                          price DECIMAL(10,2) NOT NULL
);
GO

CREATE TABLE CartItems (
                           ID INT IDENTITY(1, 1) PRIMARY KEY,
                           shopping_session_ID INT NOT NULL,
                           product_ID INT NOT NULL,
                           quantity INT NOT NULL
);
GO

ALTER TABLE Client
    ADD CONSTRAINT FK_Client_KauflandCard
        FOREIGN KEY (card_ID) REFERENCES Kaufland_Card(ID);
GO

ALTER TABLE Shopping_Session
    ADD CONSTRAINT FK_Session_KauflandCard
        FOREIGN KEY (card_ID) REFERENCES Kaufland_Card(ID);
GO

ALTER TABLE Shopping_Session
    ADD CONSTRAINT FK_Session_Scanner
        FOREIGN KEY (scanner_ID) REFERENCES Scanner(ID);
GO

ALTER TABLE CartItems
    ADD CONSTRAINT FK_CartItems_Session
        FOREIGN KEY (shopping_session_ID) REFERENCES Shopping_Session(ID);
GO

ALTER TABLE CartItems
    ADD CONSTRAINT FK_CartItems_Products
        FOREIGN KEY (product_ID) REFERENCES Products(ID);
GO

INSERT INTO Kaufland_Card (code) VALUES
                                     (N'KLF-123456'),
                                     (N'KLF-654321'),
                                     (N'KLF-789123'),
                                     (N'KLF-456789'),
                                     (N'KLF-321987');
GO

INSERT INTO Client (card_ID, first_name, last_name, email) VALUES
                                                               (1, N'Anna', N'Kowalska', N'anna.kowalska@example.com'),
                                                               (2, N'Jan', N'Nowak', N'jan.nowak@example.com'),
                                                               (3, N'Magdalena', N'Zielińska', N'm.zielinska@example.com'),
                                                               (4, N'Piotr', N'Kwiatkowski', N'piotr.kwiatkowski@example.com'),
                                                               (5, N'Katarzyna', N'Wiśniewska', N'kasia.w@example.com');
GO

INSERT INTO Scanner (serial_number) VALUES
                                        (N'SCN001'),
                                        (N'SCN002'),
                                        (N'SCN003'),
                                        (N'SCN004');
GO

INSERT INTO Products (product_name, descr, price) VALUES
                                                      (N'Mleko 2%', N'Mleko krowie 2% tłuszczu, 1L', 3.49),
                                                      (N'Chleb pszenny', N'Chleb krojony 500g', 4.29),
                                                      (N'Jabłka', N'Jabłka świeże, 1kg', 5.99),
                                                      (N'Masło Extra', N'Masło 82%, 200g', 7.49),
                                                      (N'Ser żółty', N'Ser gouda w plastrach, 150g', 6.89),
                                                      (N'Woda mineralna', N'Woda niegazowana, 1.5L', 1.99),
                                                      (N'Banany', N'Banany świeże, 1kg', 4.79),
                                                      (N'Płatki kukurydziane', N'Płatki śniadaniowe, 500g', 6.29);
GO

INSERT INTO Shopping_Session (card_ID, scanner_ID, shopping_start, shopping_end) VALUES
                                                                                     (1, 1, '2025-04-30 15:00:00', '2025-04-30 15:30:00'),
                                                                                     (4, 3, '2025-04-30 11:10:00', '2025-04-30 11:45:00'),
                                                                                     (5, 4, '2025-04-30 17:20:00', '2025-04-30 17:50:00');
GO

INSERT INTO CartItems (shopping_session_ID, product_ID, quantity) VALUES
                                                                      (1, 1, 2),  -- 2x Mleko
                                                                      (1, 2, 1),  -- 1x Chleb
                                                                      (1, 3, 1),  -- 1x Jabłka
                                                                      (2, 1, 1),   -- Mleko
                                                                      (2, 4, 1),   -- Masło Extra
                                                                      (2, 5, 1),   -- Ser żółty
                                                                      (3, 6, 2),   -- Banany x2
                                                                      (3, 7, 1),   -- Płatki
                                                                      (3, 3, 3);   -- Woda x3
