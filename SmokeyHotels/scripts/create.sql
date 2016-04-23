DROP TABLE IF EXISTS guest_occupancy;
DROP TABLE IF EXISTS occupancy;
DROP TABLE IF EXISTS guest_reservation;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS room_type;
DROP TABLE IF EXISTS guest;
-- Add data finding if reservation is occupying room.

CREATE TABLE guest
(
    id      SERIAL PRIMARY KEY,
    dob DATE NOT NULL,
    name    text NOT NULL,
    address text NOT NULL,
    phone text NOT NULL,
    creditCardNumber CHAR(16) NOT NULL,
    expiryDate DATE NOT NULL,
    creditCardName VARCHAR(255) NOT NULL,
    creditCardSecurity INT NOT NULL,
    guestUniqueId int NOT NULL
);


CREATE TABLE room_type
(
    id          SERIAL PRIMARY KEY,
    code        text NOT NULL,
    description text NOT NULL,
    capacity    int NOT NULL
);

CREATE TABLE room
(
    id              SERIAL PRIMARY KEY,
    number          int NOT NULL,
    room_type_id    int NOT NULL REFERENCES room_type(id),
    room_status_id  int NOT NULL REFERENCES room_status(id),
    current_reservation_id int NOT NULL REFERENCES reservation(id),
    isOccupied BOOLEAN NOT NULL
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
    id                  SERIAL PRIMARY KEY,
    reservationCode    text NOT NULL,
    master_guest_id int NOT NULL REFERENCES guest(id)
--    day_start           date NOT NULL,
--    day_end             date NOT NULL
);

CREATE TABLE guest_reservation
(
    id                  SERIAL PRIMARY KEY,
    reservation_id      int NOT NULL REFERENCES reservation(id),
    guest_id            int NOT NULL REFERENCES guest(id) 
);

CREATE TABLE occupancy
(
    id                  SERIAL PRIMARY KEY,
    room_id             int NOT NULL REFERENCES room(id) 
);


CREATE TABLE guest_occupancy
(
    id              SERIAL PRIMARY KEY,
    occupancy_id    int NOT NULL REFERENCES occupancy(id),
    guest_id        int  NOT NULL REFERENCES guest(id),
    reservation_id  int REFERENCES reservation(id)
--    day_start       date NOT NULL,
--    day_end         date NOT NULL
);