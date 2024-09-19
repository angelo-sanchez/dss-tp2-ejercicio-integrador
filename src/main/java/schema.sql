create table students (
  id bigint primary key generated always as identity,
  first_name text not null,
  last_name text not null,
  age int not null,
  gender text check (gender in ('Male', 'Female', 'Other')) not null,
  document_number text unique not null,
  city_of_residence text not null,
  university_book_number text unique not null
);

create table careers (
  id bigint primary key generated always as identity,
  name text not null
);

create table student_careers (
  student_id bigint references students (id),
  career_id bigint references careers (id),
  years_enrolled int not null,
  graduated boolean not null,
  primary key (student_id, career_id)
);
