You're in charge of implementing a new inbox view. You're given a set of data that consists of your userId, a list of users that you have communicated with and a list of messages between you and those users. From this data, we need to generate a list of conversations for your user.

You can get the raw inbox data by making an HTTP GET request to the dataset API at

https: //candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=xxx
The data set looks like this: {
    "messages": [
        {
            "content": "The quick brown fox jumps over the lazy dog",
            "fromUserId": 50210,
            "timestamp": 1529338342000,
            "toUserId": 67452
        },
        {
            "content": "Pangrams originate in the discotheque",
            "fromUserId": 67452,
            "timestamp": 1529075415000,
            "toUserId": 50210
        },
        {
            "content": "Have you planned your holidays this year yet?",
            "fromUserId": 67452,
            "timestamp": 1529542953000,
            "toUserId": 50210
        },
        {
            "content": "Strange noises have been heard on the moors",
            "fromUserId": 78596,
            "timestamp": 1533112961000,
            "toUserId": 50210
        },
        {
            "content": "You go straight ahead for two hundred yards and then take the first right turn",
            "fromUserId": 50210,
            "timestamp": 1533197225000,
            "toUserId": 78596
        },
        {
            "content": "It's a privilege and an honour to have known you",
            "fromUserId": 78596,
            "timestamp": 1533118270000,
            "toUserId": 50210
        }
    ],
    "userId": 50210,
    "users": [
        {
            "avatar": "octocat.jpg",
            "firstName": "John",
            "lastName": "Doe",
            "id": 67452
        },
        {
            "avatar": "genie.png",
            "firstName": "Michael",
            "lastName": "Crowley",
            "id": 78596
        }
    ]
}

Given this input data, we want to create a list of conversations that your user has had with other users. A conversation is defined by the other user you are sharing messages with, the total number of messages sent between the two of you and the most recent message which has been sent. We also expect the conversations to be ordered so that the conversations with the most recent messages appear first.

So given the example input data above, we would expect output which looks like: {
    "conversations": [
        {
            "avatar": "genie.png",
            "firstName": "Michael",
            "lastName": "Crowley",
            "mostRecentMessage": {
                "content": "You go straight ahead for two hundred yards and then take the first right turn",
                "timestamp": 1533197225000,
                "userId": 50210
            },
            "totalMessages": 3,
            "userId": 78596
        },
        {
            "avatar": "octocat.jpg",
            "firstName": "John",
            "lastName": "Doe",
            "mostRecentMessage": {
                "content": "Have you planned your holidays this year yet?",
                "timestamp": 1529542953000,
                "userId": 67452
            },
            "totalMessages": 3,
            "userId": 67452
        }
    ]
}

Once the input dataset has been transformed into an inbox view, you will need to send the result via an HTTP POST to

https: //candidate.hubteam.com/candidateTest/v3/problem/result?userKey=xxx
Notes
Timestamps are in milliseconds.
Messages may not be given in chronological order.
The most recent message should contain the userId of the user who the message is from.
Conversations should be in reverse chronological order based on the timestamp of the most recent message in the conversation.