Background

The HubSpot CRM is used to store records about the people who interact with your business. These records are referred to as "contacts". A contact could be someone who filled out a form on one of our user's websites, someone one of our users had a sales meeting with, etc. The CRM also stores information about the companies that these contacts are affiliated with. Links between contacts and companies in the CRM are referred to as "associations".

For each association between a contact and a company, we record the following information:

    companyId: A unique identifier for one company
    contactId: A unique identifier for one contact
    role: The role that this contact has at the company (for example, EMPLOYEE, ADVISOR, INVESTOR, etc.)

One company can be associated with multiple contacts, and one contact can be associated with multiple companies. Additionally, a contact can have multiple roles within a single company.

The HubSpot CRM has limits in place to prevent the number of associations from growing too large. For this exercise, we have the following limits in place:

    For a given role at a company, at most five contacts can be associated.
    For a given contact at a company, associations can be made for at most two roles.

As long as those two limits are not exceeded, there is no limit to the number of contacts a single company can be associated with, and there is no limit to the number of companies that a single contact can be associated with.
The Problem

We're building a feature that will allow our users to import new associations into HubSpot. With this feature, users will upload a file containing a list of new associations they want to create. Our backend will then validate those associations, create the associations that are valid, and then return the results of the import to the user.

It's your first day at HubSpot, and you've been asked to write the code that will validate associations during imports. You're provided with an HTTP GET endpoint: https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=7d2bf9a67fc42a245aa68dc8f149

The response from that endpoint contains two arrays:

    existingAssociations: An array of all the associations that already exist in our system
    newAssociations: An array of new associations that someone is trying to import

You've been asked to validate the given newAssociations and POST the results of that validation to the following endpoint: https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=7d2bf9a67fc42a245aa68dc8f149

The POST body must be in the following format:

{
  "validAssociations": [
    {
      "companyId": 123,
      "contactId": 1,
      "role": "EMPLOYEE"
    }
  ],
  "invalidAssociations": [
    {
      "companyId": 456,
      "contactId": 1,
      "role": "INVESTOR",
      "failureReason": "WOULD_EXCEED_LIMIT"
    }
  ]
}

    validAssociations is an array containing the given newAssociations that were valid.
    invalidAssociations is an array containing the given newAssociations that were invalid, along with the reason for why each association was invalid.
    failureReason is a string explaining why the association was invalid. It has one of the following values:
        ALREADY_EXISTS
        WOULD_EXCEED_LIMIT

As mentioned above, association creation can fail for one of two reasons:

    Given association already exists
        For each entry in newAssociations that already exists in our system, we should fail that association creation with a failureReason of ALREADY_EXISTS. Because the association already exists, this new association doesn't count against any limits.
    Given association would cause a limit to be exceeded
        For any of the given newAssociations where the creation of those associations would cause us to exceed either of the previously mentioned limits, we should fail those association creations with a failureReason of WOULD_EXCEED_LIMIT.
        For a given (companyId, role) pair or (contactId, companyId) pair, if the number of existing associations is below the limit, but creating all of the given newAssociations would cause the limit to be exceeded, every new association that would contribute to that limit should be considered invalid. In these cases, even though there is capacity remaining to create a subset of the new associations that contribute to that limit, we don't know which of those new associations the user would choose to create, so we'll just fail the relevant association creates and communicate that result back to the user. This behavior is explained further in the examples below.

Example 1

Let's say that company 123 already has four EMPLOYEE associations with contacts that have the following IDs: 1, 2, 3, 4.

We receive an import that attempts to create the following new associations:

[
  {
    "companyId": 123,
    "contactId": 5,
    "role": "EMPLOYEE"
  },
  {
    "companyId": 123,
    "contactId": 6,
    "role": "EMPLOYEE"
  },
  {
    "companyId": 123,
    "contactId": 7,
    "role": "ADVISOR"
  },
  {
    "companyId": 123,
    "contactId": 8,
    "role": "ADVISOR"
  }
]

In this case, we'd expect the following validation result:

{
  "validAssociations": [
    {
      "companyId": 123,
      "contactId": 7,
      "role": "ADVISOR"
    },
    {
      "companyId": 123,
      "contactId": 8,
      "role": "ADVISOR"
    }
  ],
  "invalidAssociations": [
    {
      "companyId": 123,
      "contactId": 5,
      "role": "EMPLOYEE",
      "failureReason": "WOULD_EXCEED_LIMIT"
    },
    {
      "companyId": 123,
      "contactId": 6,
      "role": "EMPLOYEE",
      "failureReason": "WOULD_EXCEED_LIMIT"
    }
  ]
}

Associating both contacts 5 and 6 to company 123 with a role of EMPLOYEE would cause that company to exceed its limit of 5 EMPLOYEE associations, so those association creations both fail. However, company 123 currently has no ADVISOR associations, so both new ADVISOR associations are valid.
Example 2

Let's say that contact 1 is currently associated to company 123 with a role of INVESTOR.

We receive an import that attempts to create the following new associations:

[
  {
    "companyId": 123,
    "contactId": 1,
    "role": "ADVISOR"
  },
  {
    "companyId": 123,
    "contactId": 1,
    "role": "EMPLOYEE"
  },
  {
    "companyId": 456,
    "contactId": 1,
    "role": "INVESTOR"
  },
  {
    "companyId": 789,
    "contactId": 1,
    "role": "INVESTOR"
  }
]

In this case, we'd expect the following validation result:

{
  "validAssociations": [
    {
      "companyId": 456,
      "contactId": 1,
      "role": "INVESTOR"
    },
    {
      "companyId": 789,
      "contactId": 1,
      "role": "INVESTOR"
    }
  ],
  "invalidAssociations": [
    {
      "companyId": 123,
      "contactId": 1,
      "role": "ADVISOR",
      "failureReason": "WOULD_EXCEED_LIMIT"
    },
    {
      "companyId": 123,
      "contactId": 1,
      "role": "EMPLOYEE",
      "failureReason": "WOULD_EXCEED_LIMIT"
    }
  ]
}

If this import created both the ADVISOR and EMPLOYEE associations between contact 1 and company 123, in the end that contact and company would be associated with a total of three roles, which is above the limit of two roles per contact and company. So the new associations with company 123 are both invalid.