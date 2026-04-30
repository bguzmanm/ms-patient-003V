create table patient (
    id bigint auto_increment primary key,
    name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique,
    phone varchar(20) not null unique
);

create table history_patient
(
    id          bigint auto_increment primary key,
    patient_id  bigint not null,
    description text   not null,
    created_at  timestamp default CURRENT_TIMESTAMP,
    foreign key (patient_id) references patient (id) on delete no action
);

alter table history_patient
    add constraint fk_history_patient_patient_id
        foreign key (patient_id) references patient(id) on delete no action;


insert into patient (name, last_name, email, phone) values
('John', 'Doe', 'john@patient.com', '1234567890'),
('Jane', 'Smith', 'jane@patient.com', '0987654321'),
('Alice', 'Johnson', 'alice@patient.com', '5555555555'),
('Bob', 'Brown', 'bob@patient.com', '4444444444');


insert into history_patient (patient_id, description) values
(1, 'Patient has a history of hypertension.'),
(1, 'Patient is allergic to penicillin.'),
(2, 'Patient has a history of diabetes.'),
(3, 'Patient has no known medical conditions.'),
(4, 'Patient has a history of asthma.');