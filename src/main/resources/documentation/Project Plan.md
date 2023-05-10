# Project Plan

## Final Deliverables
Website
    -Splash page
    -Tutorials - HOW TO
        -Create helper rules
        -Auto report -
        -Expense report - paidTo, category, taxCategory - all three have the same total expenses
        -Revenue report
        -Home office report
        -Create an invoice from time worked report (copy and paste into pages)
        -Project profitability report
    
Working application
-Log time, money, mileage
-Persist locally to an event_store
-Generate reports for auto, expenses, revenue, home office, profitability reports
-View logs for a date range for auto, expenses, revenue, home office, and timeworked
-Add helper rules that auto categorize


## v2
- Automatic PDF Invoice Generation
- Additional tutorials
- Bulk imports - csv and scripts
- 

## Possible features / spin offs?
- Manage Personal Expenses? Co-mingle? Seperate version?
- 

## TO DO WEBSITE
-Purchase simplebookscli.com
-Set up firebase hosting
-Set up publish script
-Create splash page: 1 - events 2. helper rules 3. run reports


## TO DO APPLICATION
- Create the reports first and work backwards to the needed events
- 
**Helper Rules**
- Create helper rule - helper rules can set the CATEGORY when it is not set automati
Helper rules do two things:
-Can SET THE CATEGORY based on transaction type, paidFrom, amount, paidTo (everything has only one category)
- Can MAP the CATEGORY to a TAX CATEGORY
- So the user only puts in the bare minimum, they get the CATEGORY and TAX_CATEGORY for free
- 

**Reports**
- Write auto report - show expenses by paidTo and category for a date range, intersect business percentage based odomoter readings and business miles, have TIP to calculate depreciation
- Write expense report - show expenses by paidTo and category for a date range
- Write revenue report - show revenue by paidFrom and category for a date range
- Write homeOffice Report - show expense by paidFrom and category, intersect business use of the home percentage, tips on depreciation
- Write profitability by project report, show revune per project, hours per project, hourlyRate

**Invoices**
-Write an automatic invoice generator, takes a date range, hourly rate, invoice #, customer info, business info

- Have screen reset between each shell command so it feels like an app
- Load a menu screen between each command
- Create helper rule event
- Create the reports first and work backwards to the needed events
- Decide event store design: DON'T store the commands, since the commands at run time create timestamps.  Rerunning the command later would create a new event. Store the actual events themselves, that are immutable.

## DONE WEBSITE

-Create hugo web site 
-Pick theme: CLI theme

## DONE APPLICATION
-Init project: Spring Boot
-Pick tech stack: Spring Shell
-Learn Spring Shell
-Create banner
-Customize prompt
-Create prototype application
-Create model
- Develop way to append to local event store
- Develop way to delete from local event store
- Decide conflict odomoter: two readings same day the app picks the higher for end of year reading and lower for start of year reading
- Decide conflicts for set properties - have the app create a sequence event when the command runs
