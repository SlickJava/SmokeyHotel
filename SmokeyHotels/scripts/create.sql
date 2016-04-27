DROP TABLE IF EXISTS guest_occupancy;
DROP TABLE IF EXISTS occupancy;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room_type;
DROP TABLE IF EXISTS guest;
-- Add data showing if reservation is occupying room.

CREATE TABLE guest
(
    id      int AUTO_INCREMENT PRIMARY KEY,
    dob DATE NOT NULL,
    name    text NOT NULL,
    address text NOT NULL,
    phone text NOT NULL,
    creditCardNumber CHAR(16) NOT NULL,
    expiryDate DATE NOT NULL,
    creditCardName VARCHAR(255) NOT NULL,
    creditCardSecurity INT NOT NULL,
    guestId int NOT NULL
);


CREATE TABLE reservation
(
    id                  int AUTO_INCREMENT PRIMARY KEY,
    reservationCode    text NOT NULL,
    masterGuestId int NOT NULL,
    FOREIGN KEY (masterGuestId)  REFERENCES guest (id) ON DELETE CASCADE
);

CREATE TABLE room_type
(
    id          int AUTO_INCREMENT PRIMARY KEY,
    name        text NOT NULL,
    description text NOT NULL,
    capacity    int NOT NULL,
    price numeric NOT NULL
);

CREATE TABLE room
(
    id              int AUTO_INCREMENT PRIMARY KEY,
    number          int NOT NULL,
    vacant BOOLEAN NOT NULL,
    price NUMERIC NOT NULL,
    maxNumberOfOccupants int,
    roomTypeId    int NOT NULL,
    currentReservationId int, -- A room doesn't have to be reserved at all times
    isOccupied BOOLEAN NOT NULL,
    FOREIGN KEY (roomTypeId) REFERENCES room_type (id) ON DELETE CASCADE,
    FOREIGN KEY (currentReservationId) REFERENCES reservation (id) ON DELETE CASCADE
);


CREATE TABLE occupancy
(
    id                  int AUTO_INCREMENT PRIMARY KEY,
    roomId             int NOT NULL,
    FOREIGN KEY (roomId) REFERENCES room (id) ON DELETE CASCADE 
);


CREATE TABLE guest_occupancy
(
    id              int AUTO_INCREMENT PRIMARY KEY,
    occupancyId    int NOT NULL,
    guestId        int NOT NULL,
    reservationId  int NOT NULL,
    FOREIGN KEY (occupancyId) REFERENCES occupancy (id) ON DELETE CASCADE,
    FOREIGN KEY (guestId) REFERENCES guest (id) ON DELETE CASCADE,
    FOREIGN KEY (reservationId) REFERENCES reservation (id) ON DELETE CASCADE
);