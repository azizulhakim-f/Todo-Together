# Todo-Together
SOFTWARE DESIGN PATTERN PROJECT


Design Pattern:
1. Observer pattern: When an user posts something, all other users get that message instantly. This is done using observer pattern.
The database acts as the subject, and users are observer. whenever a new data is added or modified, all the observers get the update
by observing the database.

2. Decorator Pattern: Here, Both in HomePage, where all the tasks are listed, and also in grouplist page, we used decorator pattern. All 
the fragments are loaded in listview layout. and that layout is wrapped with tabview layout. so that finally we get both of it in display.

3. Simple Factory Pattern: Most of the activity contains some commmon information and methods. instead of writing them everytime manually, we added 
factory pattern. So that, all basic methods are in interfaceactivity. and all other acitivity similar to it implements this method.

4. Abstract Factory pattern: In listview of tasks, that list can contains all the tasks, or just tasks of specific user, or top rated tasks etc.
in grouplistview, things are pretty much same work while loading the fragments, just change the fragments to groups instead of tasks. This
things was done using abstract factory pattern. at first we made interface for a fragment holder that can take fragments. then created 
abstract class, one for tasks another for groups. later for each catagory of tasks or groups we implemented it the way we need. 
