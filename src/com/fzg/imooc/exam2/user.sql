create table tb_user
(
    id int auto_increment primary key,
    username varchar(20) not null unique,
    password varchar(30)
);
drop table tb_file;
create table tb_file
(
    fid int auto_increment primary key,
    fname varchar(50) not null,
    fcontent longblob
);