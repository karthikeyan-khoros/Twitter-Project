package com.myproject;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.Scanner;

public class TweetPoster {

    public static void postTweet(Twitter twitter)  {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("\nEnter the Tweet to be Posted : ");
        String tweet = scanner.nextLine(); // Read user input

        try {
            Status status = twitter.updateStatus(tweet);
            System.out.println("Successfully updated the status ----> [" + status.getText() + "].");
        }

        catch (TwitterException e)
        {
            System.out.println("^^^^^^^^^^^^^^^ Operation Failed ^^^^^^^^^^^^^^^");
            if(e.getErrorCode()==-1)
                System.out.println("Network Connectivity Error");
            else
            System.out.println(e.getErrorMessage());
        }
    }
}
