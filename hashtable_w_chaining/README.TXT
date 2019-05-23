------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Assignment 3 Task 2
PURPOSE OF PROJECT: To create a hash table with chaining to store people
VERSION or DATE: October 14, 2018
HOW TO START THIS PROJECT: Run the Person class. It will prompt a menu and choose from the following options to run the code.
AUTHORS: Ali Ingrey
USER INSTRUCTIONS:
To insert a person to the table, press 1. This will prompt for a name, age, and hometown.
Enter the information about the person. The age must be an integer number and the program
needs all three categories in order to store the person.

The hash table is created with a numbuckets value. This will creat the table with the integer value of that variable.
There's also a capacity variable. I currently have it as (numbuckets + 1).
When size of the table (the number of people entered)  reaches 75% of the capacity,
the table will expand to have twice as many buckets to reduce collision.

To remove a person from the list, press 2. You'll be prompted to enter a name. Enter
the name of the person you wish to delete and it will remove it from the hash table.

Pressing 3 will clear the data of all the people from the hash table and 4 will give you the size of the table.

