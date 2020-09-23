create table person (
	id integer not null
	,title varchar(50) not null
	,writer varchar(20) not null
	,content varchar(1000) not null
  ,board_date DATE DEFAULT now()
	,primary key(id)
);

create table comment(
  cno integer not null primary key, 
  bno integer not null,    
  commentContent varchar(100) not null, 
  primary key(cno),
  foreign key(bno) references person(id) on delete cascade
);
