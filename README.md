## How to run

- Place your SQL initialization scripts in the src/main/resources folder. You may adjust, add, or remove these scripts as needed.
- Ensure the spring.sql.init.data-locations property in application.properties points to your SQL files so Spring Boot can load them on startup.
- The H2 web console is available at /h2-console. You can configure the login and password through application.properties.


![Database Diagram](https://github.com/user-attachments/assets/c9339567-c574-421c-8d6b-dd8720bbdca1)

