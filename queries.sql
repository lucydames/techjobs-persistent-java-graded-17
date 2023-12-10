-- Part 1: Test it with SQL
SELECT * FROM techjobs.job;
-- Columns and Data Types for the 'employer' table
-- name: VARCHAR (assuming it's a variable-length string)
-- location: VARCHAR (assuming it's a variable-length string)
-- (Additional columns and data types would be listed here, if any)
-- Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St. Louis City";

-- Part 3: Test it with SQL
DROP TABLE job;

-- Part 4: Test it with SQL

SELECT * FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;