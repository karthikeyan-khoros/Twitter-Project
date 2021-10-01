import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeLineViewer {

    public static void viewHomeLine(Twitter twitter)  {

        int page,count;
        Scanner scanner = new Scanner(System.in);


        System.out.print("\nEnter Page Number :");
        page = scanner.nextInt();

        System.out.print("\nEnter Tweet Count :");
        count = scanner.nextInt();


        Paging paging = new Paging(page,count);
        List<Status> statuses = new ArrayList<Status>();

        try {
            statuses  = twitter.getHomeTimeline(paging);
        }

        catch(TwitterException e)
        {
            System.out.println("^^^^^^^^^^^^^^^ Operation Failed ^^^^^^^^^^^^^^\n^");
            if(e.getErrorCode()==-1)
                System.out.println("Network Connectivity Error");
            else
                System.out.println(e.getErrorMessage());
        }

        int index=1;
        System.out.println("Showing Home timeline:");
        for (Status status : statuses) {
            System.out.println(index + ". " + status.getUser().getName() + ":" + status.getText());
            index++;
            System.out.println("*************************************************************");
        }
        System.out.println();
    }

}
