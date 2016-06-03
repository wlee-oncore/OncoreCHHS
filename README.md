http://oncorechhsjenkins.westus.cloudapp.azure.com:8080/OncoreCHHS-war/

Our team at OnCore Consulting (OnCore) felt a sense of excitement as soon as we read the details for the CHHS agile prototype. OnCore has a breadth and depth of experience in delivering systems for the public sector, and we saw this prototype as an opportunity to demonstrate our technical abilities – a core capability of OnCore Consulting.

First, we identified the team to work on the prototype, assigning a product manager, delivery manager, technical architect, front end developer, back-end developer, DevOps Engineer, usability tester and a business analyst. The team then brainstormed an initial inventory of stories and chores for the prototype. This included defining the technical and development architectures, as well as feature stories to support the prototype’s use cases. Our product manager and delivery manager then defined a plan using Pivotal Tracker. The plan showed we could deliver the prototype in three one-week iterations. With each iteration, the team would make incremental improvements to the prototype’s technical and functional features.

Next, we began the design task of our stories. We conducted working sessions with the users, interviewing them to understand the purpose of the application and their usage patterns.  We also engaged users in our whiteboard wireframe drawings, allowing them to define their interaction with the pages of the prototype by detailing the fields they wanted displayed and the actions that the user interface (UI) widgets should execute. After documenting the outcomes of the user working sessions in story specification documents, the front and back-end developers started on the build phase and quickly produced pages for users to review in the first week. While testing, the team was also able to demonstrate how the pages’ look and feel would extend to mobile, by using mobile browser emulation. Showing early results helped reinforce the importance of the design sessions to users, since they were excited to see development and changes occurring so rapidly. It also helped our team by providing us with an essential iteration in design, as well as improvements in our defect-logging and issue-tracking processes.

We achieved rapid build and prototyping through VM developer images of Ubuntu, with NetBeans IDE, and a local instance of the MySQL database installed and configured. This lightweight development environment, created early in the first iteration, allowed our developers to “hit the ground running.” The first iteration also included a technical architecture layer that separated the UI and Business tiers using local EJBs.  During iteration one, the development team built our first two feature stories and shared them with users. During iteration two, we completed feature development, incorporated user feedback, added unit and regression tests, and fixed bugs.

As the team entered iteration three, the core functionality was complete and we were adopting and building feature enhancements. We continued to solicit feature input and bugs from users as they tested through common browsers and mobile devices. The team delivered enhancements the users considered important: improving the overall user experience, making the search agency feature more flexible (TODO), and adding messaging features. We increased the UI responsiveness to ensure consistency across multiple browsers and devices. We also used NVDA to review the screens and addressed several compliance issues with the Americans with Disabilities Act (ADA). Lastly, in iteration three we evolved the technical architecture to use RESTful clients for communication to the business tier and use stereotypes to further separate the UI, business and data tiers.

From a technical standpoint, our team was excited to deliver a prototype showcasing technologies and frameworks that we felt would represent our team’s abilities. Our primary drivers were our team’s experience with the toolset and confidence in the ability to deliver within the timeframe required. Our solution for the prototype is based on all open source technologies. The technical architecture runs on Glassfish, with Java Enterprise Edition 7 using Java Server Faces (JSF 2.2), and PrimeFaces for the UI framework, based on its strong browser interoperability, mobile support and responsiveness, and ADA compliance. The back end is supported by the Java Persistence Architecture (JPA 2.1), using a MySQL database. One of the most challenging decisions our product manager made was to use a custom UI style guide instead of the Digital Services Playbook (DSP) style guide. PrimeFaces is not compatible with the DSP without customization, and this would create risk to our delivery schedule. The additional time gained by this decision enabled the team to meet the responsiveness and ADA compliance requirements with confidence.

Deployment to the Azure cloud also followed an iterative flow. The first iteration included setting up a new GitHub repository, provisioning a single Ubuntu VM, installing Jenkins, Glassfish, and MySQL, and manual builds using Ant and Jenkins. This provided the base framework to begin integration testing in a deployed environment for iteration two. The second iteration included automated builds triggered by changes in GitHub, and automated deployments to the test environment triggered by successful builds. In the third iteration, we used Jenkins to orchestrate a set of Ant tasks to build the current version of the application, passing through a gate of JUnit suites before moving on to the automated deployment to a Docker image, where a set of Selenium test cases were run for end-to-end regression.  Lastly integration to StatusCake was used for monitoring.

OnCore is grateful for the opportunity to engage our technologists on this Agile methodology prototype. We would be happy to provide the State access to our Pivotal Tracker tool, which includes documentation on each iteration, detailing the storyboards, the backlog, and the velocity in addressing the work. We have also provided How-To documentation for setting up the development and deployed environments, which can be found in the GitHub repository.

