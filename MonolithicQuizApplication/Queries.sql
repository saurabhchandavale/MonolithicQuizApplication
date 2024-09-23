use project1;
select * from demoEmployee;

create database quiz;
use quiz;

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(100),
    difficulty_level VARCHAR(50),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    question_title TEXT,
    right_answer VARCHAR(255)
);

ALTER TABLE questions
RENAME COLUMN difficulty_level TO difficultylevel;


select * from questions;


INSERT INTO questions (category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
('Java', 'Easy', 'Java SE', 'Java EE', 'Java ME', 'Java FX', 'What is the standard edition of Java?', 'Java SE'),
('Java', 'Medium', 'public', 'private', 'protected', 'static', 'Which access modifier allows access only within its own class?', 'private'),
('Java', 'Easy', 'Class', 'Object', 'Interface', 'Method', 'What is the blueprint for creating objects in Java?', 'Class'),
('Java', 'Hard', 'Compilation', 'Interpretation', 'Execution', 'Development', 'What phase converts Java source code into bytecode?', 'Compilation'),
('Java', 'Medium', 'NullPointerException', 'ArrayIndexOutOfBoundsException', 'IOException', 'ClassCastException', 'Which exception is thrown when you try to use an object reference that has the null value?', 'NullPointerException'),

('Python', 'Easy', 'print()', 'echo()', 'printf()', 'display()', 'Which function is used to output data to the console in Python?', 'print()'),
('Python', 'Medium', 'list', 'array', 'dict', 'set', 'What data type is mutable and ordered in Python?', 'list'),
('Python', 'Easy', 'for', 'while', 'do', 'each', 'Which loop is used to iterate over a sequence in Python?', 'for'),
('Python', 'Hard', 'list', 'tuple', 'set', 'dict', 'Which of these is immutable in Python?', 'tuple'),
('Python', 'Medium', 'args', 'kwargs', 'vars', 'vals', 'What keyword is used to pass a variable number of arguments to a function in Python?', 'args'),

('Java', 'Easy', 'String', 'Int', 'Boolean', 'Float', 'Which data type is used to represent text in Java?', 'String'),
('Java', 'Medium', 'constructor', 'destructor', 'method', 'function', 'What is a special method that is called when an object is instantiated?', 'constructor'),
('Java', 'Easy', 'JavaScript', 'Java', 'C#', 'Ruby', 'Which programming language is a superset of Java?', 'Java'),
('Java', 'Hard', 'JVM', 'JRE', 'JDK', 'JDB', 'Which component of Java allows the execution of Java bytecode?', 'JVM'),
('Java', 'Medium', 'implements', 'extends', 'inherits', 'includes', 'What keyword is used to implement an interface in Java?', 'implements'),

('Python', 'Easy', 'list', 'tuple', 'string', 'dict', 'What is the output of len([]) in Python?', '0'),
('Python', 'Medium', 'import', 'require', 'include', 'using', 'Which keyword is used to include modules in Python?', 'import'),
('Python', 'Easy', 'self', 'this', 'me', 'instance', 'What is the first parameter of a method in a class in Python?', 'self'),
('Python', 'Hard', '==', '!=', 'is', 'equals', 'Which operator checks for object identity in Python?', 'is'),
('Python', 'Medium', 'False', 'None', '0', 'empty', 'What is the false value in Python?', 'False');

