drop schema if exists LESdbTest;
create schema LESdbTest;
use LESdbTest;

create table User(
id int NOT NULL AUTO_INCREMENT,
userName varchar(50),
password varchar(100),
role varchar(45),
primary key (id)
);

create table Semester(
id int NOT NULL AUTO_INCREMENT,
name varchar(45),
startDate varchar(45),
primary key (id)
);

create table Category(
id int NOT NULL AUTO_INCREMENT,
name varchar(45),
info varchar(200),
primary key (id)
);

create table Teacher(
id int NOT NULL AUTO_INCREMENT,
userId int,
semesterId int,
education varchar(100),
lastActive varchar(100),
currentDate varchar(100),
primary key (id),
FOREIGN KEY (userId) REFERENCES User(id),
FOREIGN KEY (semesterId) REFERENCES Semester(id)
);

create table Subject(
id int NOT NULL AUTO_INCREMENT,
categoryId int,
name varchar(45),
semestersOffered int,
primary key (id),
FOREIGN KEY (categoryId) REFERENCES Category(id)
);

create table Course(
id int NOT NULL AUTO_INCREMENT,
teacherId int,
semesterId int,
subjectId int,
primary key (id),
FOREIGN KEY (teacherId) REFERENCES Teacher(id),
FOREIGN KEY (semesterId) REFERENCES Semester(id),
FOREIGN KEY (subjectId) REFERENCES Subject(id)
);

create table Student(
id int NOT NULL AUTO_INCREMENT,
userId int,
courseId int,
age int,
hasPaid bool,
primary key (id),
FOREIGN KEY (userId) REFERENCES User(id),
FOREIGN KEY (courseID) REFERENCES Course(id)
);

create table Admin(
id int NOT NULL AUTO_INCREMENT,
userId int,
primary key (id),
FOREIGN KEY (userId) REFERENCES User(id)
);

insert into User(userName,password,role)values('Hallur','123','Student');
insert into User(userName,password,role)values('Karl','123','Student');
insert into User(userName,password,role)values('Peter','123','Student');
insert into User(userName,password,role)values('Lars','123','Student');
insert into User(userName,password,role)values('Peter','123','Student');
insert into User(userName,password,role)values('Hans','123','Student');
insert into User(userName,password,role)values('Pernille','123','Student');
insert into User(userName,password,role)values('Bo','123','Student');
insert into User(userName,password,role)values('Ulrik','123','Student');
insert into User(userName,password,role)values('Mette','123','Student');
insert into User(userName,password,role)values('Christian','123','Student');
insert into User(userName,password,role)values('Johannes','123','Student');
insert into User(userName,password,role)values('Mo','1234','Admin');
insert into User(userName,password,role)values('Kasper','123','Teacher');
insert into User(userName,password,role)values('Christian','123','Teacher');

insert into Semester(name, startDate)values('Spring Semester', '2019-01-04');
insert into Semester(name, startDate)values('Autumn Semester', '2019-08-15');

insert into Category(name, info)values('Sport', 'this category has to do with all kinds of sports such as basketball, football etc');
insert into Category(name, info)values('Programming', 'this category has to do with all kinds of coding such as Testing, Database ...');
insert into Category(name, info)values('Language', 'this category has to do with three kinds of languages: Danish, English, German');

insert into Teacher(userId,semesterId,education,lastActive,currentDate)values(14, 1, 'Computer Science degree','2019-04-04' ,'2018-11-15');
insert into Teacher(userId,semesterId,education,lastActive,currentDate)values(15, 2, 'football course','2000-01-01' ,'2019-06-15');

insert into Subject(categoryId,name,semestersOffered)values(1, 'football', 5);
insert into Subject(categoryId,name,semestersOffered)values(1, 'basketball', 7);
insert into Subject(categoryId,name,semestersOffered)values(1, 'wrestling', 3);
insert into Subject(categoryId,name,semestersOffered)values(2, 'Testing', 4);
insert into Subject(categoryId,name,semestersOffered)values(2, 'Database', 8);
insert into Subject(categoryId,name,semestersOffered)values(2, 'Algorithms', 5);
insert into Subject(categoryId,name,semestersOffered)values(3, 'Danish', 8);
insert into Subject(categoryId,name,semestersOffered)values(3, 'English', 4);
insert into Subject(categoryId,name,semestersOffered)values(3, 'German', 3);

insert into Course(teacherId,semesterId,subjectId)values(1, 1, 5);
insert into Course(teacherId,semesterId,subjectId)values(2, 2, 1);

insert into Student(userId,courseId,age,hasPaid)values(1,1, 17,true);
insert into Student(userId,courseId,age,hasPaid)values(2,1, 19,false);
insert into Student(userId,courseId,age,hasPaid)values(3,1, 32,true);
insert into Student(userId,courseId,age,hasPaid)values(4,1, 25,true);
insert into Student(userId,courseId,age,hasPaid)values(5,1, 23,false);
insert into Student(userId,courseId,age,hasPaid)values(6,1, 11,true);
insert into Student(userId,courseId,age,hasPaid)values(7,1, 40,true);
insert into Student(userId,courseId,age,hasPaid)values(8,1, 28,true);
insert into Student(userId,courseId,age,hasPaid)values(9,1, 29,false);
insert into Student(userId,courseId,age,hasPaid)values(10,2, 13,true);
insert into Student(userId,courseId,age,hasPaid)values(11,2, 32,false);
insert into Student(userId,courseId,age,hasPaid)values(12,2, 41,true);

insert into Admin(userId)values(13);
