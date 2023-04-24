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
- Where the code is
  - github link: https://github.com/zwwang98/5500-yihu-yitianhuang-ziweiwang
- How to build the code
  - Backend Deployment 
    - Update field `spring.datasource.url` in file `application.properties` in Spring boot project.  
         This project uses AWS RDS PostgreSQL database as the datasource, so the `spring.datasource.url` could be found on AWS console. 
    - Already configured AWS RDS PostgreSQL instance allowing inbound from `172.31.0.0./16`. So every time deploy the server, just do:
      - update the datasource url
      - `mvn package`
      - upload `.jar` into AWS EC2 instance and run it using `java -jar XXX.jar`
      Then the server should be available through "http://{IP}:8080/rank/activity/calories"
  - Frontend Deployment
    - `npm start`
      - Runs the app in the development mode. Open http://localhost:3000 to view it in your browser.
    - `npm run build`
      - Builds the app for production to the build folder. It correctly bundles React in production mode and optimizes the build for the best performance.
- To access the webapp on cloud http://34.215.199.159:3000/recommendation, please contact us to add your IP address to the AWS EC2 instance.

The page will reload when you make changes.
You may also see any lint errors in the console.
- How to setup / install the product
  - Clone the repository
  - Run the code based on the instructions on "how to build the code"
- Known problems
  - Not at this stage
- Any other relevant documents
  - Not at this stage
