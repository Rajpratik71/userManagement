## User Management

# Teaching content The content of teaching is based on software development. The main content and auxiliary tools involved are:

Web development framework: Spring + Hibernate + Mysql
Front-end development: JQuery + CSS
Source code management: Git version control
Build management: Gradle/Maven
Deployment management: Go/Jenkins

# Inspection point

Spring + hibernate configuration and environment setup
Preparation of Spring REST API
Ajax application
The concept of continuous integration
The concept of database migration

# Main verification method

Validate while learning
Blog, one blog a week
Daily code review

# Development requirements:

User management module, JQuery single page program, in the management page, you can add, delete, modify, check, batch delete, search and sort users.
In the background, it is necessary to provide REST APIs for adding, deleting and modifying users, as well as batch deletion and search functions.
Users have attributes such as name, password, email address, and age, all of which are indispensable.

# first step

Use Gradle to generate the structure of the web project
Upload the project to Github
Acceptance criteria: Submit your Github address to [Google Drive (shared with students and Team Lead)]

# second step

Configure Spring + Hibernate + Mysql
Start writing Spring REST API, first write to find all users
Acceptance criteria: When accessing the URL, all user information will be displayed on the page, without any style, just the default data format.

# Third step

Write other APIs, add, delete, modify, batch delete and search.
Acceptance criteria: It can be successfully tested with client test tools such as POSTMAN.

# fourth step

Add password encryption function, using MD5
Acceptance criteria: the password in the database is stored in cipher text.

# fifth step

Single-page program front-end implementation, a page that displays all users, users can be added, deleted, deleted in batches, searched and sorted on the page
Acceptance criteria: users can be added, deleted, modified, checked, batch deleted, searched and sorted by age through front-end interaction

# Six step

Use Go/Jenkins to create a Pipeline and build a continuous integration environment

# Everything

Role Management
A user/role has several kinds of permissions,
One kind of permission has several resources(URLs)
A user can be assigned several roles which have related permissions
