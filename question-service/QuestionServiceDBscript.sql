-- 1. Create the database
CREATE DATABASE IF NOT EXISTS questionservicedb;

-- 2. Use the database
USE questionservicedb;

-- Create table for Question model
CREATE TABLE question (
    id SERIAL PRIMARY KEY,
    question_title VARCHAR(255),
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    right_answer VARCHAR(255),
    difficulty_level VARCHAR(50),
    category VARCHAR(50)
);

-- Insert sample data
INSERT INTO question  (id, question_title, option1, option2, option3, option4, right_answer, difficulty_level, category) VALUES
(1,'Which Java keyword is used to create a subclass?','class','interface','extends','implements','extends','Easy','JAVA'),
(2,'What is the output of the following Java code snippet?','4','5','6','Compile error','5','Easy','Java'),
(3,'In Java, what is the default value of an uninitialized boolean variable?','true','false','0','null','false','Easy','Java'),
(4,'Which Java keyword is used to explicitly throw an exception?','try','throw','catch','finally','throw','Easy','Java'),
(5,'What does the \"static\" keyword mean in Java?','It indicates that a variable is constant.','It indicates that a method can be accessed without creating an instance of the class.','It indicates that a class cannot be extended.','It indicates that a variable is of primitive type.','It indicates that a method can be accessed without creating an instance of the class.','Easy','Java'),
(6,'What is the correct way to declare a constant variable in Java?','constant int x = 5;','final int x = 5;','static int x = 5;','readonly int x = 5;','final int x = 5;','Easy','Java'),
(7,'Which loop in Java allows the code to be executed at least once?','for loop','while loop','do-while loop','switch loop','do-while loop','Easy','Java'),
(8,'What is the purpose of the \"break\" statement in Java?','To terminate a loop or switch statement and transfer control to the next statement.','To skip the rest of the code in a loop and move to the next iteration.','To define a label for a loop or switch statement.','To check a condition and execute a block of code repeatedly.','To terminate a loop or switch statement and transfer control to the next statement.','Easy','Java'),
(9,'Which Java operator is used to concatenate two strings?','+','-','*','/','+','Easy','Java'),
(10,'In Java, which collection class provides an implementation of a dynamic array?','HashMap','ArrayList','LinkedList','HashSet','ArrayList','Easy','Java'),
(11,'Which Python function is used to calculate the length of a list?','count()','size()','length()','len()','len()','Easy','Python'),
(12,'What is the output of the following Python code snippet?','[1, 2, 3]','[1, 2, 3, 4]','[4, 3, 2, 1]','Error','[1, 2, 3, 4]','Easy','Python'),
(13,'Which Python statement is used to exit from a loop prematurely?','break','continue','pass','return','break','Easy','Python'),
(14,'What is the purpose of the \"range()\" function in Python?','To generate a random number within a given range.','To iterate over a sequence of numbers.','To sort a list in ascending order.','To calculate the length of a string.','To iterate over a sequence of numbers.','Easy','Python'),
(15,'In Python, which data type is mutable?','int','float','str','list','list','Easy','Python'),
(16,'Which Python module is used for working with dates and times?','datetime','math','os','sys','datetime','Easy','Python'),
(17,'What is Java?','A language','An animal','A car','A city','A language','Easy','Java'),
(18,'What is Python?','A programming language','A county','A snake','A server','A programming language','Easy','Python'),
(19,'What is SpringBoot?','An application','A database','A domain name','A boot server','An application','Easy','Java'),
(20,'What is Kafka?','An api gateway','A message broker','A service','A machine','A message broker','Easy','Java'),
(21,'Which of the following is the correct syntax to declare a pointer in C++?','int ptr;','int *ptr;','ptr int;','pointer int;','int *ptr;','EASY','C++'),
(22,'Which operator is used to allocate memory dynamically in C++?','alloc','malloc','new','create','new','EASY','C++'),
(23,'Which concept allows the same function name to have different implementations in C++?','Encapsulation','Polymorphism','Inheritance','Abstraction','Polymorphism','MEDIUM','C++'),
(24,'What is the default access specifier for class members in C++?','private','public','protected','friend','private','MEDIUM','C++'),
(25,'Which feature of OOP is demonstrated when a derived class provides its own definition of a base class function?','Overloading','Overriding','Abstraction','Encapsulation','Overriding','MEDIUM','C++'),
(26,'Which of the following is not a valid type cast in C++?','static_cast','dynamic_cast','reinterpret_cast','type_cast','type_cast','HARD','C++'),
(27,'Which of the following is not a Java feature?','Object-Oriented','Portable','Use of pointers','Platform independent','Use of pointers','EASY','Java'),
(28,'Which of the following is a valid C variable name?','int','float_num','2ndValue','double','float_num','EASY','C'),
(29,'Which keyword is used to define a constant in C?','const','constant','static','#define','const','EASY','C'),
(30,'What is the size of an int data type on a 32-bit system in C?','2 bytes','4 bytes','8 bytes','Depends on the compiler','4 bytes','MEDIUM','C'),
(31,'Which of the following is the correct syntax to read a value from the user in C?','scanf(\"%d\", &num);','input(\"%d\", num);','read(\"%d\", num);','get(\"%d\", &num);','scanf(\"%d\", &num);','EASY','C'),
(32,'Which loop is guaranteed to execute at least once?','for loop','while loop','do-while loop','if loop','do-while loop','EASY','C'),
(33,'Which operator is used to access the value at the address stored in a pointer variable?','&','*','->','.','*','MEDIUM','C'),
(34,'What will be the output of the expression 5/2 in C?','2','2.5','2.0','Error','2','EASY','C'),
(35,'Which keyword is used to inherit a class in Java?','this','extends','super','implements','extends','EASY','Java');
