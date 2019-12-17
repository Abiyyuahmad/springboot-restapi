INSERT INTO user
( `id`, `user_name`, `first_name`, `last_name`, `email_address`, `role`, `ssn`, `password`, `address`)
VALUES
( 1001, "user1", "Spring", "Boot", "something@gmail.com", "USER", "SSN01", "$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK", "Jakarta" ),
( 1002, "user2", "Spring", "Boot", "something@gmail.com", "USER", "SSN02", "$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK", "Jakarta" ),
( 1003, "user3", "Spring", "Boot", "something@gmail.com", "USER", "SSN03", "$2a$11$l5FXfI.mkrcL0au5cBNAqOqNzsxCirl7BQQALMeSSidi.j4GpP8dK", "Jakarta" );

insert into orders values( 2001, 'order11', 1001);
insert into orders values( 2002, 'order12', 1001);
insert into orders values( 2003, 'order13', 1001);
insert into orders values( 2004, 'order21', 1002);
insert into orders values( 2005, 'order22', 1002);
insert into orders values( 2006, 'order31', 1003);
