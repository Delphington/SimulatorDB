CREATE TABLE students (
    student_id SERIAL PRIMARY KEY, 
    student_name VARCHAR(100) NOT NULL, 
    course_number INT CHECK (course_number > 0)
)

-- Также команда(чтобы нормально id считались)
ALTER SEQUENCE students_student_id_seq RESTART WITH 101;

