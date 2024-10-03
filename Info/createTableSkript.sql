CREATE TABLE students (
    student_id SERIAL PRIMARY KEY, 
    student_name VARCHAR(100) NOT NULL, 
    course_number INT CHECK (course_number > 0)
)