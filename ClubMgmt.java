/*

  Nick Carrozza

  Project 2

  "RDBMS for Club Management"

  Java code for user interface to interact with the database

*/

import com.sun.jdi.InvalidTypeException;
import org.postgresql.util.PSQLException;

import java.lang.reflect.Member;
import java.sql.SQLException;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Proj2Driver {

  public static void main(String[] args) throws SQLException {

    /* The following establishes a connection with the local postgres database */

    Connection myConn = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;

    try {
      //1. Establish a connection to database

      myConn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5434/cmpt220",
          "postgres", "hopefullythisworks123");

    } catch (Exception exc) {
      exc.printStackTrace();

    }

     /* Code for the user interface independent of the SQL queries:

        - Entity Supertypes:          Students,        Staff,      Meetings
        - Entity Subtype of Students: officers,        members
        - Entity Subtype of Meetings: OfficerMeetings, ClubMeetings
        - Entity Subtype of Staff:    Caterers,        Advisors


        The following code that allows the user to interact with the system and enter information regarding
        one of the strong entities */

    //create first instance of scanner object
    Scanner choosetype = new Scanner(System.in);

    //initial message to prompt the user to choose one of the strong entities to add a record to

    System.out.println("You may identify an entity to add a record to in the database: " + "\n" +

        "You may choose from one of the following: " + "\n" + "\n" +

        "New Student   (enter 'Student')" + "\n" +

        "New Event     (enter 'Event')" + "\n" +

        "New Staff     (enter 'Staff')" + "\n" +

        "New Meeting   (enter 'Meeting')"

        + "\n" + "\n" +

        "Or you may choose to record information from an existing entity: " + "\n" +

        "You may choose from one of the following: " + "\n" + "\n" +

        "Update Student Details    (enter 'Student Details')" + "\n" +

        "Update Staff Details      (enter 'Staff Details')"

      );

    boolean cantBegin = true;

      while (cantBegin) {

        cantBegin = false;

        String userInput = choosetype.nextLine();

        /* EVENT STRONG ENTITY
         -code to handle the Event strong entity
         */

        if (userInput.equals("Event") || userInput.equals("event")) {

          //create instances of Scanner necessary to allow user to provide information

          Scanner getEventDate = new Scanner(System.in);

          Scanner getEventDescr = new Scanner(System.in);

          //declare eid int variable initialized to zero temporarily
          int eid = 0;

          //declare string variable total cost initalize to ""
          int totalCost = 0;

          //declare boolean values to check if eid is correctly entered
          boolean correct_eid = false;

          boolean correct_total_cost = true;

          while (!correct_eid) {

            correct_eid = true;

            Scanner eventInfo = new Scanner(System.in);

            //prompt the user to enter a valid event ID for the event
             System.out.println("Please enter an event ID for the event: ");

          try {

            eid = eventInfo.nextInt();

          } catch (InputMismatchException e) {

            System.out.println("Invalid Event ID data type entered. Please try again. ");

            correct_eid = false;

          }

        }

        boolean correct_event_date = false;

        while (!correct_event_date) {

          correct_event_date = true;

          System.out.println("Please enter a valid date for the event. It must be in the format 'MM/DD/YYYY': ");

          String date = getEventDate.nextLine();

          //brief check to see if a / exists in the second position in the string, very unlikely user will accidentally
          //input a / in the second position and not fill out the date correctly
          if (date.indexOf("/") == 2) {

            System.out.println("Please enter a valid description for the event: ");

            String descr = getEventDescr.nextLine();

            boolean correct_event_cost = false;

            while (!correct_event_cost) {

              correct_event_cost = true;

              System.out.println("Please enter the total cost for the event: ");

              Scanner readtotalCost = new Scanner(System.in);

              try {

                totalCost = readtotalCost.nextInt();

              } catch (InputMismatchException e) {

                System.out.println("Input value for total cost incorrect. Please try again.");

                correct_event_cost = false;

              }
            }
            //after all the fields are indicated for this record, execute an "INSERT INTO"
            // SQL query using all of the user input values

            try {

              myStmt = myConn.prepareStatement

                  ("INSERT INTO events (eid, eventdate, descr, totalCost)" +
                      "VALUES (" + eid + "," + "to_date('" + date + "', 'MM/DD/YYYY')" + ",'" +
                      descr + "'," + totalCost + " );");


              myStmt.executeQuery();

            } catch (PSQLException e) {


            }

            System.out.println("Event " + eid + " has been successfully added to the database.");


          } else {

            System.out.println("Invalid date or date format entered. Please try again.");

            correct_event_date = false;

          }
        }


        /* STUDENT ENTITY SUPERTYPE
           -code to allow user to post a new student record to the database
         */

        // code to handle the student supertype with subtypes member/officer
      } else if (userInput.equals("Student") || userInput.equals("student")) {

        //declare boolean values to check if input is correct in order to proceed


        //initialize student id to 0
        int stu_id = 0;

        //initalize student status to the empty string
        String status = "";

        //create instances of scanner to allow user to enter input

        Scanner userStuFirst = new Scanner(System.in);

        Scanner userStulast = new Scanner(System.in);

        Scanner userStuStat = new Scanner(System.in);

        boolean valid_stu_id = false;

        while (!valid_stu_id) {

          valid_stu_id = true;

          System.out.println("Please enter a new student id for the student: ");

          Scanner userStudentId = new Scanner(System.in);

          try {

            stu_id = userStudentId.nextInt();

          } catch (InputMismatchException e) {

            System.out.println("Invalid Student ID data type entered. Please try again.");

            valid_stu_id = false;

          }
        }
        //proceed once valid stu id is entered

        //prompt the user to enter a first name for the student they are creating
        System.out.println("Please enter a first name for the student: ");

        String firstName = userStuFirst.nextLine();

        //prompt the user to enter a last name for the student
        System.out.println("Please enter a last name for the student: ");

        String lastName = userStulast.nextLine();

        boolean valid_type = false;

        //enter a loop to allow user to enter student type and see if it is correct
        while (!valid_type) {

          //prompt the user to enter a status for the student
          System.out.println("Please enter the status of the student (e.g. freshman, sophomore, etc.) : ");

          status = userStuStat.nextLine();

          //if statement checks to see if a valid student type is entered, must
          //be one of the options below
          if (status.equals("freshman") ||

              status.equals("Freshman") ||

              status.equals("sophomore") ||

              status.equals("junior") ||

              status.equals("Junior") ||

              status.equals("senior") ||

              status.equals("Senior")) {

            valid_type = true;


          } else {

            System.out.println("Invalid student type entered. Please try again.");
          }

        }


        //INSERT INTO query to the students table here based on what is entered

        try {

          myStmt = myConn.prepareStatement

              ("INSERT INTO students (stu_id, firstName, lastName, status)" +
                  "VALUES (" + stu_id + ",'" + firstName + "','" + lastName + "','" + status + "' );");


          myStmt.executeQuery();

        } catch (PSQLException e) {


        }

        //the following allows the user do define which type of student they are entering
        Scanner studentTypeSelect = new Scanner(System.in);

        //declare bool studentgo to determine whether or not it is necessary to enter a student subtype
        boolean studentgo = true;

        //loop to allow the user to re-enter the type if they fail to do so correctly
        while (studentgo) {

          System.out.println("Enter the type of student, member or officer");

          String userStudentType = studentTypeSelect.nextLine();

          if (userStudentType.equals("Officer") || userStudentType.equals("officer")) {

            studentgo = false;

            //insert the previously entered ID into the officers table
            //INSERT INTO query here based on what is entered

            try {

              myStmt = myConn.prepareStatement

                  ("INSERT INTO officers " +
                      "VALUES (" + stu_id + ", NOW()" + ");");


              myStmt.executeQuery();

            } catch (PSQLException e) {

            }

            System.out.println("You have successfully added officer " + stu_id + " to the database.");

            //accept either an upper or lower case spelling of member
          } else if (userStudentType.equals("Member") || userStudentType.equals("member")) {

            studentgo = false;

            //insert the previously entered ID into the members table
            //INSERT INTO query here based on what is entered

            try {
              myStmt = myConn.prepareStatement

                  ("INSERT INTO members " +
                      "VALUES (" + stu_id + ", NOW()" + ");");


              myStmt.executeQuery();

            } catch (PSQLException e) {

            }

            System.out.println("You have successfully added member " + stu_id + " to the database.");

          } else {

            System.out.println("Invalid student type. Please try again.");
          }
        }


     /* STAFF ENTITY SUPERTYPE:
      -code to handle the staff entity supertype with subtypes caterers/advisors
      */
      //allow the user to enter upper or lower case
    } else if (userInput.equals("Staff") || userInput.equals("staff")) {

      //create instances of scanner to read user input
      //prompt the user to enter a unique staff id for the staff table
      Scanner getStaffFirstName = new Scanner(System.in);

      Scanner getStaffLastName = new Scanner(System.in);


      boolean valid_staff_id = false;

      int staff_id = 0;

      while(!valid_staff_id) {

        valid_staff_id = true;

        Scanner userStaffInfo = new Scanner(System.in);

        //prompt the user to enter a valid staff id as int, try/catch will prompt them to restart otherwise
        System.out.println("Please enter a staff ID for this staff member: ");

        try {

          staff_id = userStaffInfo.nextInt();

        } catch (InputMismatchException e) {

          System.out.println("Invalid Staff ID data type entered. The record will not post to the database. Please try again.");

          valid_staff_id = false;

        }

      }
      //proceed once valid staff id entered

      System.out.println("Please enter a first name for this staff member: ");

      String staff_first_name = getStaffFirstName.nextLine();

      System.out.println("Please enter a last name for this staff member: ");

      String staff_last_name = getStaffLastName.nextLine();

      boolean valid_staff_yrs = false;

      int yrsWorking = 0;

      while(!valid_staff_yrs) {

      valid_staff_yrs = true;

      System.out.println("Please enter the number of years working for this staff member: ");

      Scanner readStaffYrs = new Scanner(System.in);

       try {

       yrsWorking = readStaffYrs.nextInt();

       } catch (InputMismatchException e) {

       System.out.println("Invalid data type for years entered. Please try again.");

       valid_staff_yrs = false;
           }
         }
        //INSERT INTO query to insert record into staff table of the database

        try {

        myStmt = myConn.prepareStatement

              ("INSERT INTO staff(staff_id, firstName, lastName, yrsWorking) " +
                  "VALUES (" + staff_id + ",'" + staff_first_name + "','" + staff_last_name +
                  "'," + yrsWorking + ");");


        myStmt.executeQuery();

        } catch (PSQLException e) {

        }



      Scanner staffTypeSelect = new Scanner(System.in);

      boolean staffgo = false;

      //loop to allow the user to re-enter the type if they fail to do so correctly, also checks to see if correct
      //id and year types are entered and displays nothing if they are incorrectly entered
      while (!staffgo) {

        staffgo = true;

        System.out.println("Enter the type of staff, advisor or caterer");

        String userStaffType = staffTypeSelect.nextLine();

        if (userStaffType.equals("Advisor") || userStaffType.equals("advisor")) {

          //the following query inserts the same staff id the user inputs into the advisors table

          try {

            myStmt = myConn.prepareStatement

                ("INSERT INTO advisors VALUES (" + staff_id + " );");

            myStmt.executeQuery();

          } catch (PSQLException e) {

          }

          System.out.println("You have successfully added advisor " + staff_id +
              " to the database.");

          //allow the user to enter upper or lower case
        } else if (userStaffType.equals("Caterer") || userStaffType.equals("caterer")) {

          //the following query inserts the same staff id the user inputs into the caterers table

          try {
            myStmt = myConn.prepareStatement

                ("INSERT INTO caterers VALUES (" + staff_id + " );");

            myStmt.executeQuery();

          } catch (PSQLException e) {

          }

          System.out.println("You have successfully added caterer " + staff_id +
              " to the database.");


        } else {

          System.out.println("Invalid staff type. Please re-enter.");

          staffgo = false;

        }

      }


        /* MEETING ENTITY SUPERTYPE
        - code for the meeting supertype with subtypes clubMeeting and officerMeeting
         */

      //code to handle the meeting entity supertype with subtypes clubMeetings and officerMeetings
    } else if (userInput.equals("Meeting") || userInput.equals("meeting")) {

      //create instances of scanner necessary to read user input

      Scanner userMeetLoc = new Scanner(System.in);

      //boolean to check if mid entered is correct
      boolean valid_meet_id = false;

      //declare mid integer initalize to zero
       int mid = 0;

      //prompt the user to enter a valid meeting id

      while(!valid_meet_id) {

        valid_meet_id = true;

        System.out.println("Please enter a valid meeting id for the meeting: ");

        Scanner userMeetID = new Scanner(System.in);

        try {

          mid = userMeetID.nextInt();

        } catch (InputMismatchException e) {

          System.out.println("Invalid meeting ID data type input. Please try again.");

          valid_meet_id = false;

        }
      }

      //proceed if correct mid entered

        boolean valid_meet_date = false;

        while(!valid_meet_date){

          valid_meet_date = true;

        System.out.println("Please enter a valid meeting date for the meeting. " +
            "It must be in the format 'MM/DD/YYYY': ");

        Scanner userMeetDate = new Scanner(System.in);

        String meetDate = userMeetDate.nextLine();

        if (meetDate.indexOf("/") == 2) {

          System.out.println("Please enter the location of the meeting: ");

          String meetLoc = userMeetLoc.nextLine();

          //execute SQL INSERT INTO query to insert the user entered meeting info to the database

          try {

            myStmt = myConn.prepareStatement

                ("INSERT INTO meetings (mid, meetdate, location)" +
                    "VALUES (" + mid + "," + "to_date('" + meetDate + "', 'MM/DD/YYYY')" + ",'" +
                    meetLoc + "' );");


            myStmt.executeQuery();

          } catch (PSQLException e) {

          }

          //create instance of scanner to allow the user to select meeting type
          Scanner meetTypeSelect = new Scanner(System.in);

          boolean meetgo = true;

          //loop to allow the user to re-enter the type if they fail to do so correctly
          while (meetgo) {

            System.out.println("Enter the type of meeting, 'Officer Meeting' or 'Club Meeting'; ");

            String userMeetType = meetTypeSelect.nextLine();

            //allow the user to input a combination of upper and lower case to allow leeway
            if (userMeetType.equals("officer meeting") || userMeetType.equals("Officer Meeting") ||
                userMeetType.equals("Officer meeting") || userMeetType.equals("officer Meeting")) {

              meetgo = false;


              //SQL query here for "INSERT INTO" on the officer meetings table of the database., as
              //well as an "INSERT INTO" the original meeting superentity with fields mid and date

              try {

                myStmt = myConn.prepareStatement

                    ("INSERT INTO officerMeetings (mid)" +
                        "VALUES (" + mid + " );");


                myStmt.executeQuery();

              } catch (PSQLException e) {

              }


              System.out.println("Officer Meeting " + mid + " was successfully added to the database.");

              //allow the user to enter a combination of inputs to allow for leeway
            } else if (userMeetType.equals("club meeting") || userMeetType.equals("Club Meeting") ||
                userMeetType.equals("Club meeting") || userMeetType.equals("club Meeting")) {

              //terminate the loop since the user entered a correct type
              meetgo = false;


              //SQL query here for "INSERT INTO" on the club meetings table of the database., as

              try {
                myStmt = myConn.prepareStatement

                    ("INSERT INTO clubMeetings (mid)" +
                        "VALUES (" + mid + " );");


                myStmt.executeQuery();


              } catch (PSQLException e) {


              }

              System.out.println("Club Meeting " + mid + " was successfully added to the database.");

            } else {

              System.out.println("Invalid meeting type entered. Please try again.");

            }

          }

        } else {

          System.out.println("Invalid date or date format entered. Please try again.");

          valid_meet_date = false;

        }

      }

        /* STUDENT DETAILS FOR ASSOCIATIVE ENTITIES HelpsOn, BoardMeetings, membMeetings, and attends */

    } else if (userInput.equals("Student Details") || userInput.equals("Student details") ||
        userInput.equals("student Details") || userInput.equals("student details")) {

      Scanner chooseStuType = new Scanner(System.in);

      boolean correct_stu_type = false;

      while(!correct_stu_type) {

        correct_stu_type = true;

        System.out.println("Please choose to update 'officer' or 'member' details: ");

        String inputStuType = chooseStuType.nextLine();

        if (inputStuType.equals("Officer") || inputStuType.equals("officer")) {

          boolean correct_off_id = false;

          int offStuId = 0;


          while (!correct_off_id) {

            correct_off_id = true;

            Scanner inputOffStuId = new Scanner(System.in);

            System.out.println("Please enter a valid student ID for the officer to provide details on: ");

            try {

              offStuId = inputOffStuId.nextInt();


            } catch (InputMismatchException e) {

              System.out.println("Invalid student ID entered for officer. Please try again.");

              correct_off_id = false;

            }

          }
          //at this point, a correct officer stu id has been entered and we can proceed

          Scanner chooseoffJoin = new Scanner(System.in);

          boolean correctoffJoin = false;

          String inputOffJoin = "";

          while (!correctoffJoin) {

            correctoffJoin = true;

            System.out.println("Did the officer attend a board meeting or help on an event? Enter 'help' or 'attend': ");

            inputOffJoin = chooseoffJoin.nextLine();

            //if the user elects to input info on officer helping on event
            if (inputOffJoin.equals("help") || inputOffJoin.equals("Help")) {

              int helponEID = 0;

              boolean correctOffEID = false;

              while (!correctOffEID) {

                correctOffEID = true;

                Scanner officerHelpOn = new Scanner(System.in);

                System.out.println("Please enter a valid event ID that the officer helped on: ");

                try {

                  helponEID = officerHelpOn.nextInt();

                } catch (InputMismatchException e) {

                  System.out.println("Invalid Event ID data type entered. Please try again.");

                  correctOffEID = false;

                }

              }
              //from here, the helpsOn associatve entity info is complete, ready to query

              try {

                myStmt = myConn.prepareStatement

                    ("INSERT INTO helpsOn (stu_id, eid)" +
                        "VALUES (" + offStuId + "," + helponEID + " );");


                myStmt.executeQuery();


              } catch (PSQLException e) {


              }


              System.out.println("You have successfully recorded officer " + offStuId + " has helped on event " + helponEID);

              //if the user elects to input info on officer attending a meeting
            } else if (inputOffJoin.equals("attend") || inputOffJoin.equals("Attend")) {

              int boardMeetMID = 0;

              boolean correctboardMID = false;

              while (!correctboardMID) {

                correctboardMID = true;

                Scanner officerBoardMID = new Scanner(System.in);

                System.out.println("Please enter a valid Meeting ID that the officer attended: ");

                try {

                  boardMeetMID = officerBoardMID.nextInt();

                } catch (InputMismatchException e) {

                  System.out.println("Invalid Meeting ID data type entered. Please try again.");

                  correctboardMID = false;

                }

              }


              //from here, the boardMeetings associatve entity info is complete, ready to query

              try {

                myStmt = myConn.prepareStatement

                    ("INSERT INTO boardMeetings (stu_id, mid)" +
                        "VALUES (" + offStuId + "," + boardMeetMID + " );");


                myStmt.executeQuery();


              } catch (PSQLException e) {


              }


              System.out.println("You have successfully recorded officer " + offStuId + " has helped on event " + boardMeetMID);

            } else {

              System.out.println("Incorrect officer action entered. Please try again.");

              correctoffJoin = false;

            }
          }


          //if the user elects to edit student type member for details
        } else if (inputStuType.equals("Member") || inputStuType.equals("member")) {

          boolean correct_memb_id = false;

          int membStuId = 0;


          while (!correct_memb_id) {

            correct_memb_id = true;

            Scanner inputMembStuId = new Scanner(System.in);

            System.out.println("Please enter a valid student ID for the member to provide details on: ");

            try {

              membStuId = inputMembStuId.nextInt();


            } catch (InputMismatchException e) {

              System.out.println("Invalid student ID entered for member. Please try again.");

              correct_memb_id = false;

            }

          }
          //at this point, a correct member stu id has been entered and we can proceed

          Scanner choosemembJoin = new Scanner(System.in);

          boolean correctmembJoin = false;

          String inputMembJoin = "";

          while (!correctmembJoin) {

            correctmembJoin = true;

            System.out.println("Did the member attend a member meeting or enjoy an event? Enter 'attend' or 'enjoy': ");

            inputMembJoin = choosemembJoin.nextLine();

            if (inputMembJoin.equals("attend") || inputMembJoin.equals("Attend")) {

              boolean correctMembMID = false;

              int readMembMID = 0;

              while (!correctMembMID) {

                correctMembMID = true;

                Scanner inputMembMID = new Scanner(System.in);

                System.out.println("Please enter a valid Meeting ID that the member attended: ");

                try {

                  readMembMID = inputMembMID.nextInt();

                } catch (InputMismatchException e) {

                  correctMembMID = false;

                  System.out.println("Invalid meeting ID data type. Please try again. ");


                }

              }
              //from here, ready for query into membMeetings

              try {

                myStmt = myConn.prepareStatement

                    ("INSERT INTO membMeetings (stu_id, mid)" +
                        "VALUES (" + membStuId + "," + readMembMID + " );");


                myStmt.executeQuery();


              } catch (PSQLException e) {


              }


              System.out.println("You have successfully recorded member " + membStuId + " has attended meeting " + readMembMID);


            } else if (inputMembJoin.equals("enjoy") || inputMembJoin.equals("Enjoy")) {

              boolean correctMembEID = false;

              int readMembEID = 0;

              while (!correctMembEID) {

                correctMembEID = true;

                Scanner inputMembEID = new Scanner(System.in);

                System.out.println("Please enter a valid Event ID that the member enjoyed themselves at: ");

                try {

                  readMembEID = inputMembEID.nextInt();

                } catch (InputMismatchException e) {

                  correctMembEID = false;

                  System.out.println("Invalid event ID data type. Please try again. ");


                }

              }
              //from here, ready for query into membMeetings

              try {

                myStmt = myConn.prepareStatement

                    ("INSERT INTO attends (stu_id, eid)" +
                        "VALUES (" + membStuId + "," + readMembEID + " );");


                myStmt.executeQuery();


              } catch (PSQLException e) {


              }

              System.out.println("You have successfully recorded member " + membStuId + " has enjoyed event " + readMembEID);


            } else {

              System.out.println("Invalid member action entered. Please try again.");

              correctmembJoin = false;

            }

          }

        } else {

          System.out.println("Invalid student type entered. Please try again.");

          correct_stu_type = false;

        }
      }

      /* STAFF DETAILS FOR ASSOCIATIVE ENTITIES catersOn and advisesOn */

    } else if (userInput.equals("Staff Details") || userInput.equals("Staff details") ||
        userInput.equals("staff Details") || userInput.equals("staff details")) {


      //ask for a valid staff id, nest in a while make a boolean
      boolean valid_staff_id = false;

      int inputStaffID = 0;

      while (!valid_staff_id) {

        valid_staff_id = true;

        Scanner readStaffID = new Scanner(System.in);

        System.out.println("Please enter a valid Staff ID to provide details on: ");

        try {

          inputStaffID = readStaffID.nextInt();

        } catch (InputMismatchException e) {

          System.out.println("Invalid Staff ID data type entered. Please try again.");

          valid_staff_id = false;

        }

      }
      //now that a valid staff_id has been entered, we are ready to proceed.

      boolean validStaffType = false;

      String staffDetailType = "";

      while (!validStaffType) {

        validStaffType = true;

        Scanner readStaffType = new Scanner(System.in);

        System.out.println("Please enter the Staff ID's role, 'Caterer' or 'Advisor': ");

        staffDetailType = readStaffType.nextLine();

        if (staffDetailType.equals("Caterer") || staffDetailType.equals("caterer")) {

          boolean correctCatersEID = false;

          int catersOnEID = 0;

          while (!correctCatersEID) {

            correctCatersEID = true;

            System.out.println("Please enter a valid Event ID that this caterer has catered for: ");

            Scanner readCaterEID = new Scanner(System.in);

            try {

              catersOnEID = readCaterEID.nextInt();


            } catch (InputMismatchException e) {

              System.out.println("Invalid Event ID data type entered. Please try again.");

              correctCatersEID = false;

            }

          }
          //after valid eid is entered, ready to query

          try {

            myStmt = myConn.prepareStatement

                ("INSERT INTO catersOn (eid, staff_id)" +
                    "VALUES (" + catersOnEID + "," + inputStaffID + " );");


            myStmt.executeQuery();


          } catch (PSQLException e) {


          }

          System.out.println("You have successfully recorded caterer " + inputStaffID + " has catered event " + catersOnEID);


        } else if (staffDetailType.equals("Advisor") || staffDetailType.equals("advisor")) {


          boolean correctAdvisorEID = false;

          int advisesOnEID = 0;

          while (!correctAdvisorEID) {

            correctAdvisorEID = true;

            System.out.println("Please enter a valid Event ID that this advisor has advised: ");

            Scanner readAdvisorEID = new Scanner(System.in);

            try {

              advisesOnEID = readAdvisorEID.nextInt();


            } catch (InputMismatchException e) {

              System.out.println("Invalid Event ID data type entered. Please try again.");

              correctAdvisorEID = false;

            }

          }
          //after valid eid is entered, ready to query

          try {

            myStmt = myConn.prepareStatement

                ("INSERT INTO advisesOn (eid, staff_id)" +
                    "VALUES (" + advisesOnEID + "," + inputStaffID + " );");


            myStmt.executeQuery();


          } catch (PSQLException e) {


          }

          System.out.println("You have successfully recorded advisor " + inputStaffID + " has advised event " + advisesOnEID);


        } else {

          System.out.println("Invalid Staff ID role entered. Please try again.");

          validStaffType = false;

        }

      }

      //if none of the correct inputs are entered from the first prompt, display invalid message and prompt to re-enter
     } else {

      System.out.println("Invalid entity or details type. Please enter either 'Student', 'Event'," +
          " 'Staff', or 'Meeting.' for an entity, or 'Student Details', 'Event Details', 'Staff Details', or 'Meeting Details' for details.");

      cantBegin = true;

       }

     }

    myConn.close();

   }

}




