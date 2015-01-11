data
====

Defines data objects, relations and data management for the turn-based strategy game. 

## Requirements

1. Oracle Java 1.7 or newer
2. Maven 3
3. A working internet connection

## Configuration

No particular configuration is necessary apart from the username/password for accessing the mysql database.
These are provided as environmental properties (dbusername and dbpassword), that are passed using the -D<property>=<value>.
For example:

mvn3 -Ddbusername=example -Ddbpassword=mypassword package

If you are unsure about the settings please contact ichatz@gmail.com

## Execution

This module is not intended to run as a stand-alone mode. It is a core module to be used for all other modules of the repository (EaW1805).

Some test cases are included to test the operation of the data managers.


## Structure

The module comprises of the following main components:

1. model - contains all the class definition for the entities of the game, and some support entities for the web site.
2. managers - all the class definitions for performing CRUD operations over a relational database based on hibernate.
3. dto - pojo objects for the data transfer of objects with the GWT client implementing the com.google.gwt.user.client.rpc.IsSerializable interface.
4. constants - various constants used throughout the game for the implementation of the existing game scenaria.
5. cache - basic interfaces for the implementation of the caching scheme at the web level (using aop).

The resources include the hibernate configuration files (xml) for the ORM.

