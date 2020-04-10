package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class VictimActivity extends AppCompatActivity {

    private class StoryObject{
        public int id;
        public String dialogue;
        public String option1;
        public String option2;
        public String option3;
        public int forward1;
        public int forward2;
        public int forward3;
        public int numOptions;

        public StoryObject(int id, int forward1, int forward2, int forward3, String dialogue, String option1, String option2,String option3, int numOptions){
            this.id = id;
            this.dialogue = dialogue;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.forward1 = forward1;
            this.forward2 = forward2;
            this.forward3 = forward3;
            this.numOptions = numOptions;
        }
    }

    private ArrayList<StoryObject> story = new ArrayList<StoryObject>();
    private int currentID = 1;
    private StoryObject current = new StoryObject(1,2,1,1,
            "You are John/Jane Doe. Today, you're into your office job at the Scranton " +
                    "Recreation Center development department at 9 am Monday morning. Time to start " +
                    "your day.",
            "Continue", "", "", 1);

    Button option1;
    Button option2;
    Button option3;
    TextView dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim);

        story.add(current);

        //First Decision Block
        story.add(new StoryObject(2,3,4,5,"Coworker Jared asks to use your login info to finish some work because theirs isn’t working properly.","Say no and tell him why.", "Write it on a note for them and tell them not to show anyone else.", "Type it in on his computer for him instead of telling him your login info.",3));
        story.add(new StoryObject(3,6,6,6,"You explained to Jared that you won’t give him your password because it wouldn’t keep confidential information secure by giving him access. You offer to help him fix his login and suggest he talks to the IT Department to help him.","Time for lunch", "", "",1));
        story.add(new StoryObject(4,6,6,6,"You just wanted to help him out. Unfortunately, he did exactly that and left the note sitting out on his desk when the HR Rep walked by and recognized Jared wasn’t using his login. Now you and Jared are both being internally investigated, and at risk of being fired.","Time for lunch", "", "",1));
        story.add(new StoryObject(5,6,6,6,"You had good intentions here, you tried your best. You wanted to help your coworker out while also protecting yourself, but now your boss is lecturing for messing up some numbers during the time Jared was using your login - and you’ll either get in trouble for Jared's work, or for sharing your password if you come clean.","Time for lunch", "", "",1));

        //Second Decision Block
        story.add(new StoryObject(6,7,8,9,"You leave to have lunch. You’re going to the restaurant down the street with some coworkers from other departments. You finish up what you were working on and get ready to go.","Sweet, chow time!", "Lock your computer before leaving.", "Turn off the monitor to make your computer look like it's off.",3));
        story.add(new StoryObject(7,10,2,3,"You leave your computer logged in while you leave for lunch. Jared decides to play a prank on you. He rearranges your desktop and renames your files silly things. You now have to spend precious work time changing everything back.","Back to work.", "", "",1));
        story.add(new StoryObject(8,10,2,3,"Good job, you come back and everything is just as you left it. Keep doing this to prevent losing data to playful coworkers or malicious attacks from hackers.","Back to work.", "", "",1));
        story.add(new StoryObject(9,10,2,3,"This protects you from anyone passing by, but by not locking your computer someone can mess up any of your information. If anyone happens to be watching as you turn off the monitor, they'll probably realize the computer isn't actually off or locked. Fortunately, nothing bad happened this time.","Back to work.", "", "",1));

        story.add(new StoryObject(10,11,12,13,"You get a notification that the password is about to expire for your work computer. You change it, but now what?","Write it on a Sticky note to remind yourself later.", "Write it in the notes of your locked phone.", "Memorize the new one quickly.",3));
        story.add(new StoryObject(11,14,2,3,"Now all of your coworkers know your login. Really easy for someone to login and steal your information. This is not a good way to keep your information safe.","Pack up for the day, stop at a cafe.", "option 2", "option 3",1));
        story.add(new StoryObject(12,14,2,3,"Relying on your phone to be able to login to your computer isn't the worst thing to do, but it's not the best either. If someone stole your phone or your lost it, you'd still have to reset the password just like if you'd forgotten it. This way adds a new risk of someone reading the password on your phone if you let anyone borrow it to make a call.","Pack up for the day, stop at a cafe.", "option 2", "option 3",1));
        story.add(new StoryObject(13,14,2,3,"This is the best option to keep your information safe. Memorize your passwords to prevent unwanted access from other users - if you forget the password, you can always just get it reset!","Pack up for the day, stop at a cafe.", "option 2", "option 3",1));

        story.add(new StoryObject(14,15,16,17,"You have a meeting at the local café with members from your sister company. You arrive an hour early to go over your meeting information and have some time alone to do some research.\n" +
                "You need to browse the web for information about your meeting at 2pm. How do you choose to connect?","Use a VPN.", "Directly connect to the free wifi.", "Use your phone's data plan.",3));
        story.add(new StoryObject(15,18,2,3,"Turning on a VPN secures your information from hackers and malicious attacks. Once it's on, you can safely connect to the free wifi - this is the best option.","Get Coffee", "option 2", "option 3",1));
        story.add(new StoryObject(16,18,2,3,"Anything you send over this connection is free game to whoever wants to look at it it. Do not check any personal banking or confidential information if you choose this option. This is ok for simple internet searches using a guest account, but don’t use sites that require you to enter your login data while directly connected to a public wifi connection!","Get Coffee", "option 2", "option 3",1));
        story.add(new StoryObject(17,18,2,3,"Using Data over the free wifi is better, but data being sent wirelessly between your laptop and phone can still be intercepted and information may still be compromised. Best to avoid using highly sensitive information (such as logging into a banking site) while sitting near other people who may or may not be inclined to try stealing your data!","Get Coffee", "option 2", "option 3",1));

        story.add(new StoryObject(18,19,20,21,"The barista calls your name. Get your coffee from the barista.","Woo Coffee time!", "Lock your computer, then get up and get your coffee.", "Carry your laptop with you.",3));
        story.add(new StoryObject(19,22,2,3,"Someone else spilled their coffee on your laptop. This is a big risk in a café, if you don’t have your laptop in sight line at all times. Someone can easily hop on your laptop and do whatever they wanted, steal it, or accidentally damage it in ways like this if your device is left unattended.","Have the meeting, then go home.", "option 2", "option 3",1));
        story.add(new StoryObject(20,22,2,3,"This does prevent anyone from accessing your information, but this doesn’t stop anyone from grabbing your laptop and walking away with it. Thankfully your laptop is still there, but someone stole both your pens.","Have the meeting, then go home.", "option 2", "option 3",1));
        story.add(new StoryObject(21,22,2,3,"This is the best option for keeping your belongings safe. Carry valuables in your pockets, or have a friend watch them if that option is available.","Have the meeting, then go home.", "option 2", "option 3",1));

        story.add(new StoryObject(22,23,24,25,"The meeting went smoothly and now you've gone home after work. You are planning a camping trip with your friends soon, so you need to start getting prepared for it. You eat dinner, grab a drink, and get your laptop. You go to CampingGear.com to get supplies for your camping trip. You’re all set to check out. How do you proceed?","Credit Card", "Debit Card", "Visa Gift Card",3));
        story.add(new StoryObject(23,26,2,3,"This can be a big risk. If the website is secure (https rather than http) and the vendor is reputable, it's probably fine - but security leaks happen all the time. If a hacker gets your information when you enter your credit card, they can put you into debt and steal your identity. Always make sure you're carefully checking each bank statement to detect identity theft if you use a credit card online.","Finish shopping and check your emails.", "option 2", "option 3",1));
        story.add(new StoryObject(24,26,2,3,"This is worse than a credit card. A debit card is directly linked to your bank account - contacting the bank if someone already made a purchase most likely won't allow you to get the money back. If a hacker gets this information you’re doomed. Never use a debit card for online shopping unless it's linked to an account specifically intended for that purpose (and resultantly keeps very little money in the account at any given time).","Finish shopping and check your emails.", "option 2", "option 3",1));
        story.add(new StoryObject(25,26,2,3,"Gift cards are the safest option. This is like a burner card. It is not directly linked to any of your personal banking information, and even if the card data were stolen it's not a particularly big deal.","Finish shopping and check your emails.", "option 2", "option 3",1));

        story.add(new StoryObject(26,27,28,3,"Time to check your personal emails. You need to see if there are any important emails. Better sort out your inbox.","Click on the email from a Royal Prince that wants to marry you but needs your financial help first.", "An old high school friend emails you, but the email address it came from doesn’t look like hers.", "option 3",2));
        story.add(new StoryObject(27,29,2,3,"Never click on or open emails like this. This is a scam and will cause a virus or try to steal money from you. Report this email and immediately flag it as spam.","Finish checking emails and update your phone.", "option 2", "option 3",1));
        story.add(new StoryObject(28,29,2,3,"Verify your friend’s email address through other sources before clicking on this email. If you’re unsure of the source, always cross reference before interacting with it.","Finish checking emails and update your phone.", "option 2", "option 3",1));

        story.add(new StoryObject(29,30,31,3,"You recently got a new phone and are now downloading your social media apps. How do you choose to set them up?","Use 2 step authenticators for your apps.", "Use the same password for each new page so it’s easier to remember.", "option 3",2));
        story.add(new StoryObject(30,32,2,3,"\n" +
                "This is the best way to keep from being hacked. You will be notified if someone else in a different location tries to log in. Admittedly it can be a little inconvienient at times, but the effort is definitely worth it for any app which contains data you wouldn't want everyone to have access to.","Finish", "option 2", "option 3",1));
        story.add(new StoryObject(31,32,2,3,"This is the perfect way to be hacked. Using the same password for every different app lowers the security of that password, and means if any account gets hacked, all of them are at risk!","Finish", "option 2", "option 3",1));

        story.add(new StoryObject(32,1,2,3,"Fin","Play again!", "option 2", "option 3",1));




        option1 = (Button)findViewById(R.id.opt1);
        option2 = (Button)findViewById(R.id.opt2);
        option3 = (Button)findViewById(R.id.opt3);
        dialogue = (TextView)findViewById(R.id.dialogueBox);

        updateScreen();


        option1.setOnClickListener( v->{
            currentID = current.forward1;
            updateScreen();
        });

        option2.setOnClickListener( v->{
            currentID = current.forward2;
            updateScreen();
        });

        option3.setOnClickListener( v->{
            currentID = current.forward3;
            updateScreen();
        });
    }

    private void updateScreen(){
        for(StoryObject thisObject : story){
            if(currentID == thisObject.id){
                current = thisObject;
                option1 = (Button)findViewById(R.id.opt1);
                option1.setText(thisObject.option1);
                option2.setText(thisObject.option2);
                option3.setText(thisObject.option3);
                dialogue.setText(thisObject.dialogue);
                if(thisObject.numOptions == 1){
                    option2.setVisibility(View.INVISIBLE);
                    option3.setVisibility(View.INVISIBLE);
                }else if(thisObject.numOptions == 2){
                    option2.setVisibility(View.VISIBLE);
                    option3.setVisibility(View.INVISIBLE);
                }else{
                    option2.setVisibility(View.VISIBLE);
                    option3.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}