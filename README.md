# BS23-Assignment-Navid

Project Description: SpringBoot REST API for Task Management by Users with Authentication & Authorization



Steps to run :

- Download
- Open it in a preferred IDE. Intellij was used in my case.
- Run it as Spring Application.
- MySQL was used as the database for this project. (Installation of MySql is Required)
- The local port of MySql was 3306 in my case.
- In MySQL the name of my schema was 'task_management'
- Used Postman to verify the apis.

API ENDPOINTS & THEIR DESCRIPTIONS

For Authentication & Authorization - 
/auth/register 
=> The user will be asked for username, email, password, role. 
=> After successful input it will return a JSON object consisting of 
statusCode, message, id, email, password, role etc.

/auth/login
=> The user will be asked for email and password.
=> After successful input it will return a JSON object with a bearer token which will be used to do different role-based tasks later on.

/auth/refresh
=> The user will be asked for the current token.
=> After successful input it will return a new token.


/admin/tasks (To retrieve all the tasks from admin side)
=> The admin will be able to view all the tasks
/admin/tasks/{id} (Put)
=> The admin will be able to modify a task with the given id in the api
/admin/tasks/{id} (Delete)
=> The admin will be able to delete a task with the given id in the api

/user/tasks/{id}  (Put)
=> The user will be able to modify a task with the given id in the api if it matches with the request bodys task name with the user.
/user/tasks/{id}  (Delete)
=> The admin will be able to delete a task with the given id in the api if it matches with the request bodys task name with the user.

/adminuser/tasks (can be accessed by both authenticated admin/user)
=> The user will be asked to input a task with required properties along with a secret word(which will be later used 
for performing user-based update/delete)
=> After successful input it will return JSON object of the given task.
