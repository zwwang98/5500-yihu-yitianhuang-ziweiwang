# CS5500-YiHu-YitianHuang-ZiweiWang

## Fitness Application
This project is about developing a fitness application to keep track of people's daily 
activities, performance ranking and receive personal recommendations from this application. 
These recommendations are based on activity patterns, and activities that people who are nearby currently do.

## Features and Functionalities
- Ranking
  - By frequency: rank activities based on overall frequency, to show clients most liked activities’ ranking
  - By calories: rank activities based on its average calories per session, to show clients most calorie-burned activities
  - By location: rank locations based on visited frequency, to show clients most visited locations
- Suggestion
  - Suggest most popular activities based on location inputs. Can, in the future, integrate with obtaining client’s real-time current location
- Recommendation
  - Suggest activities and time of each activity to complete daily calories target. Select the most popular activities in the U.S. for suggestion


## Updated Code/Test Metrics
- JUnit tests: for code quality and automate testing
- Test with Postman
- Test from the webpage (already demo)
- Test with CodeMR

## Final Product Documentation
### Where the code is
  - Client(React): https://github.com/zwwang98/5500-yihu-yitianhuang-ziweiwang/tree/main/frontend
  - Server(Spring boot): https://github.com/zwwang98/5500-yihu-yitianhuang-ziweiwang/tree/main/fitness
### Build and Deployment
  - Server
    - Build
      - Clone code to local and open the project with Intellij IDEA and Maven
      - Install all dependencies specified in `pom.xml` 
      - Update field `spring.datasource.url` in file `application.properties` in Spring boot project.  
         This project uses AWS RDS PostgreSQL database as the datasource, so the `spring.datasource.url` could be found on AWS console. 
    - Deployment
      - We chose AWS EC2 to deploy the server
      - Package the project into `.jar` file and copy it onto ec2 instance
      - Run the `.jar` file using `java -jar XXX.jar` on ec2 instance
      - Already configured AWS RDS PostgreSQL instance allowing inbound from `172.31.0.0./16`. So every time deploy the server, just do:
        - update the datasource url
        - `mvn package`
        Then the server should be available through "http://{IP}:8080/rank/activity/calories" with correctly configured security group.
  - Client
    - Build
      - Clone code to local and open the project with VS COde
      - Run `npm install` to install all dependencies
      - `npm start`
        - Runs the app in the development mode. Open http://localhost:3000 to view it in your browser.
      - `npm run build`
        - Builds the app for production to the build folder. It correctly bundles React in production mode and optimizes the build for the best performance.
    - Deployment
      - We chose to deploy React in the same instance as where the server deployment locates at
      - Copy the build output file onto ec2 instance
      - run the project using `npm start`
  - Out deployment: http://34.215.199.159:3000. Please contact us to add your IP address to the AWS EC2 instance so that you could access it.

The page will reload when you make changes.
You may also see any lint errors in the console.
- How to setup / install the product
  - Clone the repository
  - Run the code based on the instructions on "how to build the code"
- Known problems
  - Not at this stage
- Any other relevant documents
  - Not at this stage
