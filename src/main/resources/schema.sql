create table policy (
	policy_no varchar(255) not null, 
	effective_date date,
	expiry_date date,
	policy_type varchar(255) check (policy_type in ('MOTORCOM','MOTORPER','PROPERTY')), 
	primary_insurer varchar(255),
	last_updated_time timestamp(6), 
	primary key (policy_no)
);