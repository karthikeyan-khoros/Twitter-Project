package com.myproject;

import twitter4j.Twitter;
import java.util.Scanner;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

        Twitter twitter = TwitterObjectBuilder.getInstance();
        Scanner scanner = new Scanner(System.in);

        int choice;
        boolean run=true;

        System.out.println("-----------------------------------------Welcome to Tweet@Java------------------------------------------\n");

        while(run) {
            System.out.print("\n-------------------Options-------------------\n" +
                    "1. Post a Tweet\n" +
                    "2. Watch TimeLine\n" +
                    "3. Exit\n\n" +
                    "Enter your Choice : ");
            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                {
                    TweetPoster.postTweet(twitter);
                    break;
                }

                case 2:
                {
                    HomeLineViewer.viewHomeLine(twitter);
                    break;
                }

                case 3:
                {
                    run=false;
                    System.out.println(" --- THANK YOU --- ");
                    break;
                }

                default:
                {
                    System.out.println("Please Enter Proper Input !!!\n");
                }
            }
        }

    }
}
