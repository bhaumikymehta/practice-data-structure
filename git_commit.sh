#!/bin/bash

# Generate a random number to append to the commit message
random_number=$((RANDOM % 1000))

# Construct the commit message
commit_message="meta medium question $random_number"

# Stage all changes
git add .

# Commit the changes with the generated commit message
git commit -m "$commit_message"

# Push the changes to the remote repository
git push