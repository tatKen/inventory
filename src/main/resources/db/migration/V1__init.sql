create table card (
  id bigint not null,
  created_by varchar(255) not null,
  created_datetime datetime(6) not null,
  last_modified_by varchar(255) not null,
  last_modified_datetime datetime(6) not null,
  version integer,
  card_type varchar(255),
  floor varchar(255),
  name varchar(255),
  spare_port_cnt bigint,
  status varchar(255),
  primary key (id)
) engine = InnoDB;

create table card_local_dp (
  local_dp_id bigint,
  card_id bigint not null,
  primary key (card_id)
) engine = InnoDB;

create table card_main_dp (
  main_dp_id bigint,
  card_id bigint not null,
  primary key (card_id)
) engine = InnoDB;

create table card_seq_no (next_val bigint) engine = InnoDB;

insert into
  card_seq_no
values
  (1);

create table card_splitter (
  splitter_id bigint,
  card_id bigint not null,
  primary key (card_id)
) engine = InnoDB;

create table localdp (
  id bigint not null,
  created_by varchar(255) not null,
  created_datetime datetime(6) not null,
  last_modified_by varchar(255) not null,
  last_modified_datetime datetime(6) not null,
  version integer,
  main_dp_cd varchar(255),
  exchange_cd varchar(255),
  local_dp_cd varchar(255),
  odn_from bigint,
  odn_to bigint,
  primary key (id)
) engine = InnoDB;

create table localdp_seq_no (next_val bigint) engine = InnoDB;

insert into
  localdp_seq_no
values
  (1);

create table maindp (
  id bigint not null,
  created_by varchar(255) not null,
  created_datetime datetime(6) not null,
  last_modified_by varchar(255) not null,
  last_modified_datetime datetime(6) not null,
  version integer,
  main_dp_cd varchar(255),
  exchange_cd varchar(255),
  primary key (id)
) engine = InnoDB;

create table maindp_seq_no (next_val bigint) engine = InnoDB;

insert into
  maindp_seq_no
values
  (1);

create table port (
  id bigint not null,
  created_by varchar(255) not null,
  created_datetime datetime(6) not null,
  last_modified_by varchar(255) not null,
  last_modified_datetime datetime(6) not null,
  version integer,
  name varchar(255),
  port_type varchar(255),
  project_code varchar(255),
  reserved_bwb integer not null,
  reserved_bwp integer not null,
  reserved_bws integer not null,
  reserved_bwv integer not null,
  status varchar(255),
  card_id bigint,
  primary key (id)
) engine = InnoDB;

create table port_seq_no (next_val bigint) engine = InnoDB;

insert into
  port_seq_no
values
  (1);

create table splitter (
  id bigint not null,
  created_by varchar(255) not null,
  created_datetime datetime(6) not null,
  last_modified_by varchar(255) not null,
  last_modified_datetime datetime(6) not null,
  version integer,
  bwb integer not null,
  bwp integer not null,
  bws integer not null,
  bwv integer not null,
  interface_no varchar(255),
  olt_id varchar(255),
  slot_id varchar(255),
  splitter_class varchar(255),
  primary key (id)
) engine = InnoDB;

create table splitter_seq_no (next_val bigint) engine = InnoDB;

insert into
  splitter_seq_no
values
  (1);

alter table
  card
add
  constraint UK_4t4fhlw5dppoe27of3a8lc4xj unique (name);

alter table
  card_local_dp
add
  constraint FKari2oete5l12pgbdwjynnrrbd foreign key (local_dp_id) references localdp (id);

alter table
  card_local_dp
add
  constraint FK4tbb86h9o9byfc8f3x13wapy7 foreign key (card_id) references card (id);

alter table
  card_main_dp
add
  constraint FKd5fugyf5b2s6seweuf4pyqkrp foreign key (main_dp_id) references maindp (id);

alter table
  card_main_dp
add
  constraint FK7uhkyilu10dsi177hr7ubm6qc foreign key (card_id) references card (id);

alter table
  card_splitter
add
  constraint FKkp5ohpo1honl9qanrxjscfnbr foreign key (splitter_id) references splitter (id);

alter table
  card_splitter
add
  constraint FKib6q3e6weyubjk9odp7k14gyu foreign key (card_id) references card (id);

alter table
  port
add
  constraint FKinyo6mtn9xnifdd3nrnxeee0x foreign key (card_id) references card (id);