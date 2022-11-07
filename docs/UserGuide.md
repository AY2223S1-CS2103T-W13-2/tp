---
layout: page
title: User Guide
---

<p align="center">
    <img src="images/LTNS_logo.png" width="200" height="200">
</p>

Long Time No See (LTNS) is a  **comprehensive desktop app built for financial advisors to manage their clients' financial policies and events**. It is optimized for use via a **[Command Line Interface](#command-line-interface-cli) (CLI)** while still having the benefits of an intuitive and minimalistic **[Graphical User Interface](#graphic-user-interface-gui) (GUI)**. With all the essential tools packed into one app, LTNS will enable you to streamline your financial advising journey immediately!

This document is the official user guide of the Long Time No See (LTNS) app. This guide serves as an introduction to LTNS and a help menu should you have any doubts while using the app.

# Table of Contents
1. [Quickstart](#quick-start)
2. [Features](#features)<br>
   1. [Common Features](#common-features)<br>
      1. [Viewing Help](#viewing-help--help)
      2. [Clearing Entries](#clearing-all-entries--clear)
      3. [Exiting the Program](#exiting-the-program--exit)
      4. [Saving Data](#saving-the-data)
      5. [Manually Editing Data File](#editing-the-data-file)
   2. [Client Features](#client-features)<br>
      1. [Adding a Client](#adding-a-client--addclient)
      2. [Listing all Clients](#listing-all-clients--allclients)
      3. [Editing a Client](#editing-a-client--editclient)
      4. [Searching for a Client](#searching-for-clients--findclient)
      5. [Deleting a Client](#deleting-a-client--deleteclient)
      6. [Sorting all Clients](#sorting-all-clients--sort)
      7. [Pin a Client](#pin-a-client-pin)
   3. [Policy Features](#policy-features)<br>
      1. [Adding a Policy](#adding-a-policy--addpolicy)
      2. [Switching to Policy View](#switching-to-the-view-of-currently-listed-policies--policies)
      3. [Listing all Policies](#viewing-all-policies-allpolicies)
      4. [Deleting a Policy](#deleting-a-policy--deletepolicy)
      5. [Searching for a Policy](#searching-for-a-policy--findpolicy)
      6. [Assigning a Policy to a Client](#assigning-a-policy-to-a-client--assign)
      7. [Listing all Assigned Policies](#listing-out-policies-assigned-to-a-client--listassigned)
      8. [Deleting Assigned Policies from a Client](#deleting-assigned-policies-from-a-client--deleteassigned)
      9. [Tracking your Income](#tracking-your-income---viewincome)
   4. [Event Features](#event-features)
      1. [Adding an Event](#adding-an-event-addevent)
      2. [Listing all Events](#viewing-all-events--allevents)
      3. [Searching for an Event](#searching-for-an-event--findevent)
      4. [Viewing all Events in the next 7 days](#viewing-all-events-in-the-next-7-days--calendar)
3. [Frequently Asked Questions](#faq)
4. [Command Summary](#command-summary)
5. [Glossary](#glossary)





--------------------------------------------------------------------------------------------------------------------

## Quick start
1. Ensure you have Java `11` or above installed on your Computer. (Installation Guides: [Mac User](https://www.geeksforgeeks.org/how-to-install-java-on-macos/), [Windows User](https://phoenixnap.com/kb/install-java-windows))

2. Download the latest `longtimenosee.jar` from [here](https://github.com/AY2223S1-CS2103T-W13-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your Long Time No See application.

4. Double-click the file to start the app. The GUI similar to the one below should appear in a few seconds. Note how the app contains some sample data.<br>
![GUI.png](./images/GUI.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`allClients`** : Lists all clients in the LTNS.

   * **`addClient`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-301 b/2000-01-01 i/90000.0 ra/M` : Adds a client named `John Doe` to the LTNS.

   * **`deleteClient`**`3` : Deletes the 3rd client shown in the current list.

   * **`clear`** : Deletes all clients.

   * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# Features

**Long Time No See (LTNS)** allows you to track your clients, policies and events.
As such, the features available to you are split into **4** main features:
1. [Common Features](#common-features): Here you can find basic Application features
2. [Client Features](#client-features): Here you can find all features related to keeping track of all your clients 
3. [Policy Features](#policy-features): Here you can find all features related to keeping track of all your policies 
4. [Event Features](#event-features): Here you can find all features related to keeping track of all your important appointments

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the [parameters](#parameter) to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…` after them can be used multiple times.<br>
  e.g. `[t/TAG]…​` can be used as `​` (i.e. 0 times).<br>
  and e.g. `c/cov…​` can be used 1 or more times.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`. 

* Click [here](#command-format-table) for a list of all possible parameters and their constraints

</div>

## Common Features

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

Example Usage: `help`

Example Result: Help message Pop up appears

### Clearing all entries : `clear`

Clears all data from your application. 

<div markdown="span" class="alert alert-primary">:warning: **Warning:**
This action is irreversible! 
</div>


Format: `clear`

Example Usage: `clear`

Example Result: Clears all Application data.

### Exiting the program : `exit`

Exits the program.

Format: `exit`

Example Usage: `exit`

Example Result: Exits the app

### Saving the data

LTNS application data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

LTNS application data is saved as a [JSON](#json-file) file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

Below is an example of what your JSON File should look like: 
<br>
<p align="center">
<img src="./images/JsonExample.png" width="230" height="450">
</p>


<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, LTNS will discard all data and start with an empty data file at the next run.
</div>



## Client Features

### Adding a client : `addClient`

Adds a client to the LTNS.

Format: `addClient n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​ b/BIRTHDAY i/INCOME ra/RISK_APPETITE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A client can have any number of tags (including 0)
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The format for entering a birthday is "YYYY-MM-DD". The dates entered must be valid.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The `Risk Appetite` can be classified as High, Medium or Low. They are represented by characters "H", "M" and
"L" respectively. e.g: "ra/H". All other values will be ignored.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The income added is based on an individual's Yearly income.

An income added is based on the **tax income brackets** set up by [IRAS for Financial Year 2022-2023.](https://www.iras.gov.sg/taxes/individual-income-tax/basics-of-individual-income-tax/tax-residency-and-tax-rates/individual-income-tax-rates)

This information will be displayed in the app
</div>

| Income Bracket | Yearly Income range                                 |
|----------------|-----------------------------------------------------|
| First          | Less than or equal to S$30,000                      |
| Second         | More than S$30,000, less than or equal to $40,000   |
| Third          | More than S$40,000, less than or equal to $80,000   |
| Fourth         | More than S$80,000, less than or equal to $120,000  |
| Fifth          | More than S$120,000, less than or equal to $160,000 |
| Sixth          | More than S$160,000, less than or equal to $200,000 |
| Seventh        | More than S$200,000, less than or equal to $240,000 |
| Eight          | More than S$240,000, less than or equal to $280,000 |
| Ninth          | More than S$280,000, less than or equal to $320,000 |
| Tenth          | More than $320,0000                                 |

Example Usage:
* `addClient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01, b/2000-05-05 i/5000.0 ra/L` adds John Doe into the LTNS.
* `addClient n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal b/1920-05-06 i/1000000 ra/H` adds Betsy Crowe into the LTNS.


### Listing all clients : `allClients`

Shows a list of all clients in the LTNS, without any filters.

Format: `allClients`

Example Usage: `allClients`

### Editing a client : `editClient`

Edits an existing client in the LTNS.

Format: `editClient CLIENT_INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]… [b/BIRTHDAY] [i/INCOME] [ra/RISK_APPETITE] ​`

* Edits the client at the specified `CLIENT_INDEX`. The index refers to the index number shown in the displayed client list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the client will be removed i.e adding of tags is not cumulative.
* You can remove all the client’s tags by typing `t/` without
    specifying any tags after it. 

Example Usage:
*  `editClient 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st client to be `91234567` and `johndoe@example.com` respectively.
*  `editClient 2 n/Betsy Crower t/` Edits the name of the 2nd client to be `Betsy Crower` and clears all existing tags.
*  `editClient 3 b/2000-01-01` Edits the birthday of the 3rd client to be the 1st January 2000.

### Searching for Clients : `findClient`

Search for clients based on certain [metrics](#metric)

Format: `findClient [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​ [b/BIRTHDAY] [i/INCOME] [ra/RISK_APPETITE] [ti/TITLE] [cov/COVERAGE]…​ [cmp/COMPANY_CODE]`

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
At least one metric has to be specified for the command to be valid
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Title, Coverage and Company Code refer to the Assigned Policy information of the client. More details can be found in the [Policies](#policy-features) section
</div>

The following table illustrates the details of each metric and their search range:

| Metric        | Prefix | Search range                                                                                                                                                                                                                                                                                                                                              |
|---------------|--------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Name          | n/     | - The search is case-insensitive. e.g `hans` will match `Hans`<br/> - The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`<br/> - Only full words will be matched e.g. `Han` will not match `Hans`<br/> - clients matching at least one keyword will be listed. <br/> e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`       |
| Phone         | p/     | - All clients whose phone number contains the exact specified numbers will be listed                                                                                                                                                                                                                                                                      |
| Email         | e/     | - The search is case-insensitive. e.g `alice@example.com` will match `Alice@example.com` <br/> - All clients whose email matches the input will be listed                                                                                                                                                                                                 |
| Address       | a/     | - The search is case-insensitive. e.g `Bedok` will match `bedok`<br/> - All clients whose address contains the input will be listed                                                                                                                                                                                                                       |
| Tag           | t/     | - The search is case-insensitive. e.g `friends` will match `Friends`<br/> - Only full words will be matched e.g. `colleagues` will not match `colleague`<br/> - More than one tag can be specified to list all clients that have all the specified tags. <br/> e.g. `friends` and `family` will list all clients with both the `friends` and `family` tag |
| Birthday      | b/     | - Only clients whose birthday falls on the specified date will be listed                                                                                                                                                                                                                                                                                  |
| Income        | i/     | - Any valid income value can be entered and it will be matched with the corresponding income bracket<br/> - All clients whose income falls under the same income bracket as the specified income will be listed <br/> e.g `15000` will be matched with `12000`                                                                                            |
| Risk Appetite | ra/    | - All clients whose risk appetite matches the specified risk level will be listed                                                                                                                                                                                                                                                                         |
| Title         | ti/    | - The search is case insensitive. e.g `Health Plan` will match `health plan`<br/> - Clients who are covered by a policy of which title contains at least one keyword will be listed                                                                                                                                                                       |
| Coverage      | cov/   | - More than one coverage can be specified to list all clients with all of the specified coverage types. <br/> e.g. `HEALTH` and `LIFE` will list all clients with both the `HEALTH` and `LIFE` coverage type <br/> - Clients who are covered by policies which covers all the specified coverage types will be listed                                     |
| Company Code  | cmp/   | - Clients who are covered by a policy belonging to the specified company will be listed                                                                                                                                                                                                                                                                   |

Example Usage:

* `findClient n/John` returns `john` and `John Doe`
* `findClient n/alex david` returns `Alex Yeoh`, `David Li`
* `findClient p/8743` returns clients with that contain `8743` in their phone number
* `findClient t/colleagues t/friends` returns clients with both the `colleagues` and `friends` tag
* `findClient n/alex t/friends` returns clients with the name `alex` and tagged with a `friends` tag

Below is an example of what you will expect to see when you call `findClient n/alex`:
![findClientExample](./images/findClientExample.png)

### Deleting a client : `deleteClient`

Deletes the specified client from the LTNS.

Format: `deleteClient CLIENT_INDEX`

* Deletes the client at the specified `CLIENT_INDEX`.
* The index refers to the index number shown in the displayed client list.
* The index **must be a positive integer** 1, 2, 3, …​

Example Usage:
* `allClients` followed by `deleteClient 2` deletes the 2nd client in the LTNS.
* `findClient n/Betsy` followed by `deleteClient 1` deletes the 1st Client in the results of the `findClient` command.

### Sorting all Clients : `sort`

This allows you to sort your clients in the LTNS based on a specified metric.

Format: `sort KEYWORD`

* Sorts the list of clients based on specified keyword
* Keyword must be from client details


Sorting **KEYWORDS** are shown in the table below: 

| KEYWORD          | Function                                                                                                             |
|:-----------------|:---------------------------------------------------------------------------------------------------------------------|
| `default`        | Based on when a client was added, from oldest to newest                                                              |
| `name`           | By alphabetical order ie. "a" to "z"                                                                                 |
| `email`          | Clients using the same email platform are grouped together, thereafter, alphabetical order is used within each group |
| `phone`          | By numerical order of the phone number                                                                               |
| `birthday`       | From oldest to youngest                                                                                              |                                                                                             
| `income`         | From highest to lowest income                                                                                        |
| `risk appetite`  | From highest to lowest ie. "H" to "M" to "L"                                                                         |


<div markdown="span" class="alert alert-primary">:warning: **Warning:**
If your client's name contains numbers, sorting by name might behave incorrectly!
</div>

Example Usage: 
* `sort name` will display your Client list view in alphabetical order based on their name
* `sort phone` will display your Client list view in numerical order based on their phone numbers


Below is an example of what you will expect to see when you call `sort email`:

![SortEmailExample](./images/SortEmailExample.png)

### Pin a Client: `pin`
Allows pin and unpin of important clients to be viewed separately with command `viewPin`
* Format: `pin INDEX` <br>
Example Usage: 
* `pin 1` pins the first client on list

### Assigning a Client to an Event/Policy 
An existing client in your Client list can be assigned to an Event or Policy.<br>
To find out how to do so, you can refer to the [Adding an Event](#adding-an-event-addevent) guide to assign a Client to an Event or refer to the [Assigning a Policy to a Client](#assigning-a-policy-to-a-client--assign) guide to find out how you can assign a Client to a Policy.

## Policy Features
Store policies from a large assortment of companies, with different coverages and customisable yearly commissions! Assign them to a client when you secure a deal with ease.

### Adding a policy : `addPolicy`

Adds a policy to the LTNS.

Format: `addPolicy ti/TITLE cmp/COMPANY_CODE cms/Y1COMMISION% Y2COMISSION% Y3ONWARDS% cov/COVERAGE...`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A policy must have one or more coverages.
</div>  

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
These are the valid coverages and their corresponding codes.
</div>

| Coverage Code | Coverage Name        |
|---------------|----------------------|
| LIFE          | Life Insurance       |
| MOTOR         | Motor Insurance      |
| HEALTH        | Health Insurance     |
| TRAVEL        | Travel Insurance     |
| PROPERTY      | Property Insurance   |
| MOBILE        | Mobile Insurance     |
| BITE          | Bite-sized Insurance |
| INVESTMENT    | Investment based     |

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
These are the valid companies and their corresponding codes.
</div>

| Company Code | Company Name                       |
|--------------|------------------------------------|
| MNF          | Manulife Financial Private Limited |
| PRU          | Prudential Assurance Company       |
| AXA          | AXA Insurance Private Limited      |
| GEL          | Great Eastern Life                 |
| NTU          | NTUC Income Insurance              |
| ETQ          | Etiqa Insurance                    |
| TML          | Tokio Marine Life Insurance        |
| AIA          | AIA Singapore Private Limited      |
| AVI          | Aviva Limited                      |
| FWD          | FWD Singapore Private Limited      |

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Commissions must take positive percentages within 0% to 100%! (e.g. 10% 3.5% 1.0%)
</div>  

Example Usage:
* `addPolicy ti/PruShield cmp/PRU cms/10% 5% 1% cov/LIFE`
* `addPolicy ti/ManuInvest Duo cmp/MNF cms/6% 3% 1.5% cov/INVESTMENT cov/LIFE`


### Switching to the view of currently listed policies : `policies`
Switches the display to show the current list of policies.
<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you previously filtered the policy list and switched to view events/contacts/income, this command will allow you to return to the filtered list of policies. 
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you wish to view the **full** list of policies, you may do so with the command `allPolicies`. 
</div>

Format: `policies`

Example Usage: `policies`

Example Result: Shows the currently listed policies on the screen.
![Policies](./images/policies.png)



### Viewing all policies: `allPolicies`
Switches the display to show **all** the policies stored.

Format: `allPolicies` <br />
Example Usage: `allPolicies` <br />
Example Result: Shows all policies stored in the LTNS, on the screen.

### Deleting a policy : `deletePolicy`
Deletes the policy at the specified `INDEX`.
The index refers to the index number shown in the displayed list of policies.
The index **must be a positive integer** 1, 2, 3, …​

Format: `deletePolicy POLICY_INDEX`

Example Usage:
* `allPolicies` followed by `deletePolicy 2` deletes the 2nd policy in the LTNS.
* `findPolicy ti/PruShield` followed by `deletePolicy 1` deletes the 1st policy in the results of the `findPolicy` command.


### Searching for a Policy : `findPolicy`

Search for policies based on certain [metrics](#metric)

Format: `findPolicy [ti/TITLE] [cov/COVERAGE]…​ [cmp/COMPANY_CODE]`

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
At least one metric has to be specified for the command to be valid
</div>

The following table illustrates the details of each metric and their search range:

| Metric       | Prefix | Search range                                                                                                                                                                                                                                                                                |
|--------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Title        | ti/    | - The search is case insensitive. e.g `Health Plan` will match `health plan`<br/> - Policies which titles contains at least one keyword will be listed                                                                                                                                      |
| Coverage     | cov/   | - More than one coverage can be specified to list all policies with all of the specified coverage types. <br/> e.g. `HEALTH` and `LIFE` will list all policies with both the `HEALTH` and `LIFE` coverage type <br/> - Policies which cover all the specified coverage types will be listed |
| Company Code | cmp/   | - Policies which belong to the specified company will be listed                                                                                                                                                                                                                             |

Example Usage:
* `findPolicy ti/Health plan` returns policies with the title `health plan` and `life plan`
* `findPolicy cov/LIFE cov/HEALTH` returns policies that cover both `LIFE` and `HEALTH`
* `findPolicy cmp/PRU` returns policies that belong to `Prudential Assurance Company`
* `findPolicy ti/Shield cov/LIFE` returns polices with `Shield` in its title and covers the `LIFE` coverage type

### Assigning a Policy to a Client : `assign` 

If you have successfully sealed a deal with a client, you can keep track of this by assigning the policy to your client! 

If you have yet to add either your Client or Policy to the Application, you can refer to the [Adding a Client](#adding-a-client--addclient) or [Adding a Policy](#adding-a-policy--addpolicy) guides.

Format: `assign CLIENT_INDEX POLICY_INDEX pr/PREMIUM sd/STARTDATE ed/ENDDATE`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
The start and end dates should be of the format "YYYY-MM-DD", and within the years 1900 - 2100.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Premium should be any positive numeric value below `1000000000` with or without 2 decimal places.
</div>

Example Usage:

* Step 1: `findPolicy cmp/PRU` to filter the list of policies that belong to Prudential Assurance Company.
* Step 2: `findClient n/John Doe` to filter the list of clients to find 'John Doe'.
* Step 3: `assign 1 1 pr/2000 sd/2010-10-10 ed/2021-10-12` to assign the first policy in the list from Step 1, to the 
first client in the list from Step 2, with the following details:
  1. Yearly premium of $2000
  2. Start date of 10th October 2010
  3. End date of 12th October 2021

### Listing out policies assigned to a client : `listAssigned`

If you'd like to recall which policies a client has taken up this command lists out, in the command box, the policies 
that have been assigned to a specific client.

Format: `listAssigned CLIENT_INDEX`

Example Usage:

1. `findClient n/John Doe` to filter the list of clients to find `John Doe`.
2. `listAssigned 1` to list out the policies assigned to the first client in the list from Step 1.

### Deleting assigned policies from a client : `deleteAssigned`

Unfortunate, but it happens. If a client cancels their policy prematurely, reflect the deletion of their assigned policy
in the LTNS using this command.

Format: `deleteAssigned CLIENT_INDEX ASSIGNED_POLICY_INDEX`

Example Usage:
1. Similar to [listAssigned](#listing-out-policies-assigned-to-a-client--listassigned), filter the list for the desired client and find out which policies they have been assigned to.
2. `deleteAssigned 1 1` to delete the first assigned policy in the assigned policy list from Step 1, of the first client obtained from filtering the client list.

### Tracking your Income  : `viewIncome`

Of course, as a financial advisor you would want to know your income! Automatically calculate your 3 year expected income (with selected year as starting year)

Format: `viewIncome YEAR`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Year chosen must be between 1900 and 2100
</div>

Example Usage:
* `viewIncome 2000` will display the expected income for years 2000, 2001 and 2002
* `viewIncome 1899` will not be allowed since 1899 is not between 1900 and 2200

![result for 'viewIncome 2000'](images/viewIncome.png)

(Result after typing the command `viewIncome 2000`, which displays three year expected income starting from year 2000)

## Event Features

### Adding an Event: `addEvent`

An `Event` represents an appointment with an existing Client. It has the duration (represented by the start and end time) and
the date of the appointment. It also has a handy description to briefly describe the contents of the meeting.

Never miss another meeting today!

Format: `addEvent desc/EVENT_DESCRIPTION n/CLIENT_NAME date/EVENT_DATE st/START_TIME et/END_TIME`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
    START_TIME must be chronologically before END_TIME. All times are in the format: `HH:MM`.
</div>


<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
    EVENT_DATE follows a standard date format for our app (i.e: YYYY-MM-DD).
</div>


<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
    CLIENT_NAME indicates the name of a valid client within the Client List. All Events must be tagged to a single client.
</div>

If you have not added this Client to your Client list, you can refer to the [Adding a Client](#adding-a-client--addclient) guide to add your Client first.


* Example Usage: `addEvent desc/CS101 Consultation n/Ben Leong date/2023-01-01 st/12:00 et/13:00`
* Example Result: add an event with `Ben Leong` from `12:00` to `13:00` for the `1st January 2023` for a CS101 consultation.


### Deleting an Event: `deleteEvent`

Format: `deleteEvent EVENT_INDEX`

* Deletes the event at the specified `EVENT_INDEX`.
* The index refers to the index number shown in the displayed event list.
* The index **must be a positive integer** 1, 2, 3, …​
* Example Usage: `deleteEvent 2`
* Example Result: deletes the 2nd event from the list.


### Viewing all Events : `allEvents`

This allows you to view all Events that have been previously added.
* Note that events are automatically sorted in chronological order.

Format: `allEvents`
Example Usage: `allEvents`
Example Results: Lists all events added to the app, automatically sorted in chronological order.

![result for 'allEventsSample'](images/allEventsSample.png)

### Searching for an Event : `findEvent`

Search for events based on certain [metrics](#metric)

Format: `findEvent [desc/EVENT_DESCRIPTION] [n/NAME] [date/EVENT_DATE]`

<div markdown="span" class="alert alert-primary">:information_source: **Note:**
At least one metric has to be specified for the command to be valid
</div>

The following table illustrates the details of each metric and their search range:

| Metric                                                                     | Prefix | Search range                                                                                                                                                                                                                                                                                                                                                                                            |
|----------------------------------------------------------------------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Event Description                                                          | desc/  | - The search is case-insensitive. e.g `Meeting to discuss plans` will match `meeting to discuss plans`<br/> - Only full phrases will be matched e.g. `Meeting to discuss plans` will not match `Plans`<br/> - Only events for which description contains the complete specified phrase will be listed. <br/> e.g. `discuss plans` will return `Meeting to discuss plans` and `Discuss plans`            |
| Name<br/><br/> Note: Name here refers to the name of the event participant | n/     | - The search is case-insensitive. e.g `John` will match `john`<br/> - The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`<br/> - Only full words will be matched e.g. `Han` will not match `Hans`<br/> - Events with the participant name containing at least one keyword will be listed. <br/> e.g. `Hans Bo` will return events which involve `Hans Gruber` or `Bo Yang`   |
| Event Date                                                                 | date/  | - Only events which occur on the specified date will be listed                                                                                                                                                                                                                                                                                                                                          |

Example Usage:

* `findEvent desc/coffee break meeting` returns events `morning coffee break meeting` and `afternoon coffee break meeting`
* `findEvent n/Bernice` returns all events for which participant name contains `Bernice`
* `findEvent date/2022-12-30` returns all events which occurs on `30th December 2022`
* `findEvent n/Alice date/2022-11-15` returns all events for which participant name contains `Alice` and occurs on `15th November 2022`

### Viewing all Events in the next 7 days : `calendar`

This allows you to view all Events that you have in the next 7 days, allowing you to keep track of any upcoming important appointments you have scheduled. 

Format: `calendar`

## FAQ

Q: How do I transfer my data to another Computer? <br/>
A : Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous LTNS home folder.

Q: Why am I seeing `The person you specified doesn't exist` when trying to add an event?<br/>
A : When specifying the Client that you're meeting for this event, this Client must exist in your client list first.

Q: Why am I seeing `This Event overlaps with another event....` when trying to add an event? <br/>
A: When adding an event, it's date and time cannot overlap with another event! But fret not, we've listed all overlapping events for your convenience, 
so you can view other events were causing the clash :) 

Q: Why am I seeing a `Sorting metric does not exist` when trying to sort my client list? <br/>
A : You may be typing a wrong <b>keyword</b> or calling a sorting metric which is not supported. You may refer to [this list](#sorting-all-clients--sort) for a list of supported **keywords**. If you would like to suggest more sorting **keywords**, do feel free to contact us! 

Q: Why is a blank screen shown when I use the `calendar` feature? <br/>
A: You may not have added any upcoming events in the next 7 days! You may want to [Add an Event](#adding-an-event-addevent) first. Alternatively, you can choose to [view all Events](#viewing-all-events--allevents) instead.

Q: What if a company whose policy I want to add is not available in the given list of company codes? <br/>
A: Let us know which company you require at e0725346@u.nus.edu and if we get enough requests, we might add yours in the next version!

Q: What if a coverage I want to add is not available in the list of coverages? <br/>
A: Similarly, let us know which coverage you require at e0725346@u.nus.edu and if we get enough requests, we might add yours in the next version!

Q: What do I do if the user guide does not address my concern? <br/>
A: Fret not! Simply drop us an email at e0725346@u.nus.edu, and we will reply within three working days!


--------------------------------------------------------------------------------------------------------------------


## Command format table

| Parameter Name      | Prefix | Constraints                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|---------------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Name                | n/     | - Only alphanumeric characters and spaces can be specified, and it should not be blank<br/> - Only a maximum of 60 characters is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| Phone               | p/     | - Only numbers are allowed<br/>e.g `3.3` is not valid<br/> - At least 3 numbers have to be specified<br/> - Only a maximum of 25 digits is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| Email               | e/     | <!--- Emails should be of the format `local-part@domain`<br/> - The local-part should only contain alphanumeric characters and these special characters, excluding the parentheses, (+_.-)<br/> - The local-part cannot start or end with any special characters<br/> - The domain name is made up of domain labels separated by periods<br/> - The domain name must end with a domain label at least 2 characters long, have each domain label start and end with alphanumeric characters and have each domain label consist of alphanumeric characters, separated only by hyphens, if any --> - Only valid emails are allowed<br/> e.g `Alice` is not valid while `Alice@email.com` is valid |
| Address             | a/     | - Any length of textual input except for an empty space is valid                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| Tag                 | t/     | - Only single word, alphanumeric inputs are allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| Birthday            | b/     | - Only valid date inputs of the YYYY-MM-DD format are allowed. e.g `1990-12-30`<br/> - Birthdays cannot be set in the future or before the 20th century (i.e 1900)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| Income              | i/     | - Only positive decimal numbers are allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| Risk Appetite       | ra/    | - Only one of the 3 levels, {H, M, L}, is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| Title               | ti/    | - Only alphanumeric characters and spaces can be specified, and it should not be blank<br/> - Only a maximum of 40 characters is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| Coverage            | cov/   | - Only inputs of the valid coverage type options are allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| Company Code        | cmp/   | - Only one of the valid company codes is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| Commission          | cms/   | - Has to be in the format of (Y1COMMISSION)% (Y2COMMISSION)% (Y3ONWARDS)%, where the commission values in the brackets are to be replaced with decimal values between 0 and 100 inclusive                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| Premium             | pr/    | - Only positive numbers below 1000000000, with or without 2 decimal places are allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| Start date          | sd/    | - Only valid date inputs of the YYYY-MM-DD format are allowed. e.g `2020-12-30`<br/> - Only dates that fall between the 20th and 21th century are allowed (i.e between the years 1900 and 2100)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| End date            | ed/    | - Only valid date inputs of the YYYY-MM-DD format are allowed. e.g `2020-12-30`<br/> - Only dates that fall between the 20th and 21th century are allowed (i.e between the years 1900 and 2100) <br/> - Should be later than the associated start date                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| Event Description   | desc/  | - Only alphanumeric characters and spaces can be specified, and it should not be blank<br/> - Only a maximum of 175 characters is allowed                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| Event Date          | date/  | - Only valid date inputs of the YYYY-MM-DD format are allowed. e.g `2020-12-30`<br/> - Only dates that fall between the 20th and 21th century are allowed (i.e between the years 1900 and 2100)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| Start time          | st/    | - Only valid time inputs of the HH:mm format are allowed. e.g `23:59`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| End time            | et/    | - Only valid time inputs of the HH:mm format are allowed. e.g `23:59` <br/> - Should be later than the associated start time                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |


## Command summary

### General Commands

| Action                      | Format, Examples                                                                                                                                                                                              |
|-----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Clear Pre-existing Data** | `clear`                                                                                                                                                                                                       |                                                                                                                                                                                                      
| **Help**                    | `help`                                                                                                                                                                                                        |
| **Exit Application**        | `exit`                                                                                                                                                                                                        |


### Commands For Clients

| Action                    | Format, Examples                                                                                                                                                                                                          |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Find Client**           | `findClient [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]… [b/BIRTHDAY] [i/INCOME] [ra/RISK_APPETITE] [ti/TITLE] [cov/COVERAGE]…​ [cmp/COMPANY_CODE]` <br><br> e.g: `findClient n/Jim p/98765432`                      |
| **Add Client**            | `addClient n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS t/TAG…​`  <br><br> e.g: `addClient n/Clement Tan p/98765432 e/clementTan@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney b/2019-05-05 i/10000.00 ra/M` |
| **Delete Client**         | `deleteClient (INDEX of CLIENT)` <br><br> e.g: `deleteClient 3`                                                                                                                                                           |
| **Edit Client**           | `editClient (INDEX of CLIENT) [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br><br> e.g: `editClient 2 n/James Lee e/jameslee@example.com`                                                                  |
| **View All Clients**      | `allClients`                                                                                                                                                                                                              |
| **View Filtered Clients** | `clients`                                                                                                                                                                                                                 |                                                              
| **Sort Clients**          | `sort (KEYWORD)`<br> eg. `sort name`                                                                                                                                                                                         |

Note: `allClients` shows all existing clients inside LTNS, while `clients` show all clients based on filter metric placed previously.

### Commands For Policy

| Action                     | Format, Examples                                                                                                                                              |
|----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Find Policy**            | `findPolicy [ti/TITLE] [cov/COVERAGE]…​ [cmp/COMPANY_CODE]` <br/><br>  e.g: `findPolicy cov/LIFE`                                                             |        
| **Add Policy**             | `addPolicy ti/POLICY_TITLE cmp/POLICY_COMPANY cms/POLICY_COMMISSION cov/POLICY_COVERAGE...` <br><br> e.g: `addPolicy ti/Health cmp/MNF cms/4% 3% 2% cov/LIFE` |                                                                                                                         
| **Delete Policy**          | `deletePolicy (INDEX of POLICY)` <br> <br> e.g: `deletePolicy 1`                                                                                              |                                                                                                                                                                                             
| **View All Policies**      | `allPolicies`                                                                                                                                                 |
| **View Filtered Policies** | `policies`                                                                                                                                                    |
| **View Assigned Policies** | `assign (INDEX of CLIENT) (INDEX of POLICY) pr/PREMIUM_PAID sd/START_DATE ed/END_DATE` <br> <br> e.g: `assign 1 1 pr/10000 sd/2000-01-02 ed/2000-02-01`       |
| **Delete Assigned**        | `deleteAssigned (INDEX of CLIENT) (INDEX of POLICY)` <br><br> e.g: `deleteAssigned 1 1`                                                                       |                                                                                                                                                                                                               
| **List Assigned**          | `listAssigned (INDEX of CLIENT) ` <br> <br> e.g: `listAssigned 1`                                                                                             |
| **View Income**            | `viewIncome YEAR` <br><br> e.g: `viewIncome 2000`                                                                                                             |                                                                                                                                                                                                                                                                                                                                                                           

Note: `allPolicies` shows all existing policies inside LTNS, while `policies` show all policies based on filter metric placed previously.

### Commands For Events


| Action                   | Format, Examples                                                                                                                                                                       |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Find Event**           | `findEvent [desc/EVENT_DESCRIPTION] [n/NAME] [date/EVENT_DATE]` <br/><br> e.g: `findEvent date/2022-05-05`                                                                             |
| **Add Event**            | `addEvent desc/EVENT_DESCRIPTION n/NAME date/EVENT_DATE st/START_TIME et/END_TIME` <br><br>  e.g: `addEvent desc/Meet Clement at Noon n/Clement Tan date/2022-10-10 st/12:00 et/13:00` |
| **Delete Event**         | `deleteEvent (INDEX of EVENT)` <br><br>  e.g: `deleteEvent 1`                                                                                                                          |
| **View All Events**      | `allEvents`                                                                                                                                                                            |
| **View Filtered Events** | `events`                                                                                                                                                                               |
| **View Calendar**        | `calendar`                                                                                                                                                                             |                                                                                                                                                                                                     

Note: `allEvents` shows all existing events inside LTNS, while `events` show all events based on filter metric placed previously.

### Miscellaneous Commands

| Action          | Format, Examples                                    |
|-----------------|-----------------------------------------------------|
| **Sort**        | `sort [COMPARABLE_METRIC]` <br><br> e.g: `sort AGE` |
| **Pin**         | `pin (INDEX of CLIENT)` <br><br> e.g: `pin 1`       |
| **View Pinned** | `viewPin`                                           |

#### Additional Notes:
* For better clarity, `INDEX` has been placed in parentheses to denote clearly which index is being referred to (either CLIENT, POLICY or EVENT). At the same time, it is compulsory to include `INDEX`.
  <br> E.g: `(INDEX of EVENT)` refers to index from a list of events.

## Glossary 

#### Parameter
Parameters refer to the information you type into the app to be stored. For example, `n/John` where John is the parameter.

#### Policy
An insurance or investment package entailing the details of the insurance and/or investment.

#### Coverage 
Specific to an insurance policy, coverage describes the amount of risk or liability which is covered by the insurance policy.

#### Graphic User Interface (GUI)
A User Interface that allows users to interact with the application through visual components.

#### Command-Line Interface (CLI)
A Text-Based User Interface which allows you to use the application in the form of typing out "commands".

#### JSON File 
A file which is used to store data in text form. 

#### Metric 
A standard of measurement. In the case of LTNS, a metric in sorting or searching tells the application how to compare the clients.

#### Income Bracket
Various income level ranges categorised by levels. LTNS uses the Inland Revenue Authority of Singapore's (IRAS) measurement of an income bracket.


<br>    
<br>
<br>
