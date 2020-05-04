# GitHub README.md
Instruction 

EpicPlanners Application allows two different types of user to log in: administrators (`ADMIN`) and guests (`GUEST`) An administrator can log in with the of username and password, and a guest can log in using an access code which is automatically generated based on their name.

When an administrator logs in, an admin landing page with a tab bar on the left. The administrator can switch it to the About page, the Events page, the Guest page, the Invitation page, and the Runsheet page. The About page shows a copyright statement. The Events page includes a table with information about existing events, and administrators can create new events or edit an existing event on this page. The Guest page includes a table with the information about the guests, and administrators can create new guests and edit existing guests on this page. The Invitation page includes a list of existing events. Administrators can make invite guests to events and view their responses to the invitations. The Runsheet page includes a list of run sheets for events. The administrator can create new run sheets, edit existing run sheets and export the run sheet to PDF. All the pages have tab bar which can be used to switch to other pages.

When an administrator logs in, an admin landing page with a tab bar on the left. The administrator can switch it to the About page, the Invitation page, and the RSVP page. The About page shows a copyright statement. The Invitation page shows a list of events that the guest is invited to, and the list can be download. On the RSVP page, guests can response to invitations and make dietary requirements.

Current admin password and username is "admin".

Delete the Event.db to reset the database.
Line 708 in Database.java will input the first admin username and password. Change that line for different admin credentials.

## Page instruction
Admin - invited and add guests to events (A-Invitation-SelectGuest.fxml)

The "insert template" buttom adds a template into the Create new guest table.
The "Invite/add guests" button invites selected guests in the "guestlist" table and also adds/invites the guests in the "Create New guests" table.
If and guest template is left over in the "create new guest" table, that template contains errors.
Email address must include an @ symbol, phone number must only include digets and no fields must be empty.



