How to run this app:

Clone the code from the repo.

Import into your IDE as an existing maven project and run as a local application.  I developed this case study on Eclipse, Intellij
might have slightly different import mechanism.

The main entry point is the OptumCcmCaseStudyApplication.

Once the app is up and running, if you just got to localhost:8080, you should see the preloaded entry into the DB on screen.

The rest endpoints and their commands are mapped in UserController.

They are:

Plain localhost:8080 a dump of all rows in the DB

localhost:8080/getAll also gives a dump of all rows in the DB

localhost:8080/getByUserId/1  Gives the row with that number.  If no such row exists, it returns a row with the name MISSING for first and last name.

localhost:8080/deleteByUserId/1 Deletes the row in question and displays the deleted row.  If no such row exists, it returns a row with the name MISSING for first and last name.

localhost:8080/getUsersByName/firstName/lastName gives all rows with that first and last name combination.  The one name pre loaded is Dennis Savard.  A blank list is returned if there are no such rows.

localhost:8080/addUserNameOnly/firstName/lastName adds a new row with just the first and last name fields set.

localhost:8080/addFullUser/firstName/middleInitial/lastName/city/state/zip/phone adds a record with all fields populated.

Several 3rd party dependencies are used and are in the pom.  A simple maven build should get them for you if you do not already have them.  I choose to start this off in spring boot.  If I did a UI, I would have used thymeleaf.  I used H2 for the DB layer.  For testing I used a combination of mockito and spock.