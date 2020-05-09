create sequence todo_id_seq start with 1 increment by 1;

create table todos (
    id bigint DEFAULT nextval('todo_id_seq') not null,
    content varchar(1024) not null,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);
