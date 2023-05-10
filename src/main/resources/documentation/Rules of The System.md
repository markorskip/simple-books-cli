# Rules of the system

1. Every piece of user data is an Event
2. An Event is immutable after creation
3. An dateEvent can only be constructed in a valid state
4. No duplicate events can exist in the entire system
5. The system state is created by adding all the events that occurred.  
6. No matter what order the events are replayed, the state of the system will be the same
7. Store absolutely nothing that can be derived




