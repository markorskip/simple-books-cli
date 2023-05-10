
# Architecture

## Rules of the system

1. Every piece of user data is an Event
2. An Event is immutable after creation
3. An dateEvent can only be constructed in a valid state
4. No duplicate events can exist in the entire system
5. The system state is created by adding all the events that occurred.  
6. No matter what order the events are replayed, the state of the system will be the same
7. Store absolutely nothing that can be derived


## Design

1. The CLI is loaded. The init script runs, creating the business_name.event_store
2. The user can now execute commands.
3. There are three core patterns of commands. Append, Delete, Read
4. Append creates a new event and appends it to the event store.  When a new event is created, it is added to the in-memory event store.  If that returns true, it is append to the file event_store.
5. A DELETE removes an event from the in-memory event store.  If that returns true, it deletes from the file event store.
6. A read command only reads from the in-memory event store, which should always be in sync with the file.
7. The file event store consists of one event per line.
8. Loading the file consists of reading each line and converting into an event.
9. Powerusers may at their own risk delete events directly from the event_store of they don't want to use the delete command.




