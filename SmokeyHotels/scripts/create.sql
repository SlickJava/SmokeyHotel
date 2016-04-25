DROP TABLE IF EXISTS guest_occupancy;
DROP TABLE IF EXISTS occupancy;
-- DROP TABLE IF EXISTS guest_reservation;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
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
    roomTypeId    int NOT NULL
    currentReservationId int,
    isOccupied BOOLEAN NOT NULL,
    FOREIGN KEY (roomTypeId) REFERENCES room_type (id),
    FOREIGN KEY (currentReservationId) REFERENCES reservation (id)
);


-- CREATE TABLE room_history
-- (
--    id              SERIAL PRIMARY KEY,
--    comments        text,
--    room_status_id  int NOT NULL REFERENCES room_status(id),
--    day_start       date NOT NULL,
--    day_end         date NOT NULL
-- );


CREATE TABLE reservation
(
    id                  int AUTO_INCREMENT PRIMARY KEY,
    reservationCode    text NOT NULL,
    masterGuestId int NOT NULL,
    FOREIGN KEY (masterGuestId)  REFERENCES guest (id)
--    day_start           date NOT NULL,
--    day_end             date NOT NULL
);

-- CREATE TABLE guest_reservation
-- (
--    id                  SERIAL PRIMARY KEY,
--    reservation_id      int NOT NULL REFERENCES reservation(id),
--    guest_id            int NOT NULL REFERENCES guest(id) 
-- );

CREATE TABLE occupancy
(
    id                  int AUTO_INCREMENT PRIMARY KEY,
    roomId             int NOT NULL
    FOREIGN KEY (roomId) REFERENCES room (id) 
);


CREATE TABLE guest_occupancy
(
    id              int AUTO_INCREMENT PRIMARY KEY,
    occupancyId    int,
    guestId        int,
    reservationId  int,
    FOREIGN KEY (occupancyId) REFERENCES occupancy (id),
    FOREIGN KEY (guestId) REFERENCES guest (id),
    FOREIGN KEY (reservationId) REFERENCES reservationId (id)
--    day_start       date NOT NULL,
--    day_end         date NOT NULL
);