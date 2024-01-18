INSERT INTO flight (id, airline_company_id, Origin_Country_Id, Destination_Country_Id, Departure_Time, Landing_Time, Remaining_Tickets)
VALUES
  (1,1, 1, 2, '2023-05-10 08:30:00', '2023-05-10 12:00:00', 150),
  (2,2, 2, 3, '2023-05-11 12:00:00', '2023-05-11 15:30:00', 250),
  (3,3, 3, 4, '2023-05-12 15:30:00', '2023-05-12 18:45:00', 50),
  (4,4, 4, 5, '2023-05-13 06:15:00', '2023-05-13 11:00:00', 100),
  (5,5, 5, 1, '2023-05-14 22:00:00', '2023-05-15 03:30:00', 75)
ON DUPLICATE KEY UPDATE
  airline_company_id = VALUES(airline_company_id),
  Origin_Country_Id = VALUES(Origin_Country_Id),
  Destination_Country_Id = VALUES(Destination_Country_Id),
  Departure_Time = VALUES(Departure_Time),
  Landing_Time = VALUES(Landing_Time),
  Remaining_Tickets = VALUES(Remaining_Tickets);



INSERT INTO airline_company (Id, Name, Country_Id)
VALUES
  (1, 'El Al', 1),
  (2, 'United Airlines', 2),
  (3, 'British Airways', 3),
  (4, 'Air France', 4),
  (5, 'Emirates', 5)
ON DUPLICATE KEY UPDATE
  Name = VALUES(Name),
  Country_Id = VALUES(Country_Id);