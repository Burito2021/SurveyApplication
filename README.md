Business idea: app provides an easy and cheap way of saving, storing and carrrying out surveys by different businesses( cafes, pubs,shops, malls, survey centers).
According to the recent study, there is a great increase in demand in receiving feedback from customers in order to raise the quality of service provisioning.  
Technical description:
App
1. saves incoming data from User Interface(web UI or application UI on mobile, tablets, laptops, or pcs)  into DB ( CLIENT table)
- CLIENT consists of
  ID bigint(19) NOT NULL AUTO_INCREMENT,
  USERNAME varchar(50) DEFAULT NULL,
  NOTE varchar(150) DEFAULT NULL,
  EMAIL varchar(60) DEFAULT NULL,
  PHONE varchar(60) DEFAULT NULL,
  CREATE_DATE datetime DEFAULT current_timestamp(),
- If there is timeout on connection to DB, app returns timeout error
- if there is an error in process of saving, app returns SQL exception
2. displays data by the date of creation by Resultsets. If tables contains several rows by the incoming date, then all the rows that have this date should be displayed.
   e.g. CREATE_DATE LIKE '%2022-12-14%'
- If there is timeout on connection to DB, app returns timeout error
- if there is an error in process of selecting data, app returns SQL exception

3.displays data by the name of respondent by Resultsets. If tables contains several rows by the incoming name, then all the rows that have this name should be displayed.
e.g. USERNAME LIKE 'Mik%'
- If there is timeout on connection to DB, app returns timeout error
- if there is an error in process of selecting data, app returns SQL exception
