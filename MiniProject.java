/****************************************     
  @author    Rafi Subhan                        
  @SID       230271746
  @date      2nd December 2023
  @version   8

    Miniproject Level 8
    This is a quiz which allows multiple
    users to play, everyones scores are 
    stored seperately and displayed
    when a user gets a q right, their
    points increase, but when wrong, 
    their points return to 1

****************************************/

public class QNA {
    //instance variables hold attributes of the question
    String question;
    String answer;
}

class quiz8
{
    public static void main (String[] args) throws IOException
    {
        quizLVL8();
        return;
    } // END main


    public static void quizLVL8 () throws IOException
    {
        Scanner input = new Scanner(System.in);
        int[] userScores = new int[3]; //stores seperate user scores, 4 elements as maximum of 4 players allowed
        QNA[] customQuesAndAns = null;
        quizRules();
        boolean customSetOrNot = customOrNot();
        if(customSetOrNot == true){
            customQuesAndAns = readNewQuestionSet();
        }
        QNA[] questionsAndAnswers = quesAndAnsList(); //retrieves an array of QNA type from the quesAndAnsList method
        final int max_players = howManyPlayers(); //stores max num of players playing
        for (int j = 0; j < max_players; j++){ //loops accoridng to user input
            int totalPoints = 1; //all players start with 1 point
            for (int i = 0; i<=2; i++) //loops 3 times as 3 questions
            {
                if(customSetOrNot == true){
                System.out.println(getQuestion(customQuesAndAns[i]));
                String custom_user_answer = input.nextLine();
                boolean customCorrect = check_answer(custom_user_answer, getAnswer(customQuesAndAns[i]));
                if (customCorrect == true){
                totalPoints = totalPoints + 1; //points increase if correct
                System.out.println("You're correct!");}
                else{
                totalPoints = 1; //points decrease if answer incorrect
                System.out.println("INCORRECT! Your points will now reset to 1");}
                }
                else if(customSetOrNot == false){
                    System.out.println(getQuestion(questionsAndAnswers[i]));//.notation allows us to access different attributes of record
                    String user_answer = input.nextLine(); //allows for user answer
                    boolean correct = check_answer(user_answer, getAnswer(questionsAndAnswers[i])); //evaluates user answer against correct answer
                    if (correct == true){
                        totalPoints = totalPoints + 1; //points increase if correct
                        System.out.println("You're correct!");}
                    else{
                        totalPoints = 1; //points decrease if answer incorrect
                        System.out.println("INCORRECT! Your points will now reset to 1");}
                    }
            userScores[j] = totalPoints; //stores the total points for each user in seperate element of array to keep scores seperated
            System.out.println(userScores[j]); //score is printed       
            }
        if (j < max_players - 1) {
        nextUserMessage(max_players);} //ensures that the message is not printed unncessarily  
        }
    }
    
    // Print the rules 
    public static void quizRules ()
    {
        System.out.println("WELCOME TO THE GREAT QUIZ OF 2023!");
        System.out.println("This quiz is one which will challenge an indivudals knowledge over a broad range of topics, ultimately testing ones general knowledge.");
        System.out.println("BUT FIRST, here are some rules to keep everything regulated");
        System.out.println("1. No cheating: Participants must rely on their own knowledge and not use external resources during the quiz. ");
        System.out.println("2. Timely answers: Provide your answer within a reasonable time frame to keep the quiz moving. ");
        System.out.println("3. One answer per question: Participants can provide only one answer for each quiz question. ");
        System.out.println("4. Scoring System --> The first question is worth one point, if an answer is correct, the points for the next question increase but if you are incorrect, ");
        System.out.println("the next question goes back to being worth one point");    
        System.out.println("5. Try and get all questions correct, or score as high as you can!");
        System.out.println("6. Enjoy and have fun: Remember that quizzes are meant to be enjoyable, so have a good time! ");
        return;
        
    } // END quizRules

    public static String firstQuestion ()
    {
    
    // Asks the users name then greets them by name
    String fQuestion;
    String name;
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Before we get started, what is your name?");
    name = scanner.nextLine();
    System.out.println("Hey there " + name + " the quiz is about to start, I am going to ask a series of questions, simply just answer to the best of your ability ");
    System.out.println("lets start with a practice question, this wont be marked");
    System.out.println("QUESTION 1, What is the capital city of Australia?");
    String q1Ans = scanner.nextLine(); //allows for user input, answer is stored in string

    return q1Ans; //answer can be used in a later method
    }

    public static String firstQuestionAns ()
    {
    // Asks the users age then greets them by name
    String ansToQ1;
    ansToQ1 = "The answer to Q1 IS: The capital city of Australia is Canberra.";
    System.out.println(ansToQ1); //variable is printed out

    return ansToQ1; //answer is stored, so can be used later
    } 

    public static Boolean check_answer(String userAnswer, String correctAnswer){ //parameters are used, so they can be evaluated against each 
    if (userAnswer.equals(correctAnswer)){
        return true;} //returns boolean result
    else{
        return false;}
    }
    
    public static String[] questions ()
    {
    String[] questions = new String[3]; //array has 4 elements, including 0
    questions[0] = "Which gas do plants primarily absorb from the atmosphere during photosynthesis?";
    questions[1] = "What is the largest planet in our solar system?";
    questions[2] = "What is the chemical symbol for gold?";
    //however we only use 3 of the 4 elements, one question is stored in each element
    return questions; //array is returned so that it can be cycled through in the main method  
    }
    
    public static String answers (int qNums)
    {    
    if(qNums== 0){ //if statement branch evaluates question number
        return "co2";} //results are returned in accordance to question number
    else if (qNums == 1){
        return "Jupiter";}
    else{
        return "Au";}
    }//this method is also called in the main program, and depending on the question number in the loop, a different result is printed

    
    public static int howManyPlayers ()
    {
    Scanner input = new Scanner(System.in); //the user is connected keyboard
    System.out.println("How many players will take part in the actual quiz? The maximum is 4!");
    String temp = input.nextLine(); 
    int hmp = Integer.parseInt(temp); //this converts strings to ints
    return hmp; //number is returned so that main program knows how many times to cycle outer loop
    
    }

    public static void nextUserMessage(int max_players)//will be called usi g the arguement indicating how many users there are
    {
    if(max_players > 1){ //evaluates if max players are greater than 1
        System.out.println("Next user, your turn!");}//this is done since if there is 1 player, this message shouldnt be printed
    }

    public static QNA createQnA (String question, String answer)
    {
    QNA quesAndAns = new QNA();//new record created
    quesAndAns.question = question;
    quesAndAns.answer = answer;
    //eahc attribute of record populated by subsitutable parameters
    return quesAndAns;//record and its populated attributes can be used elsewhere
    }

    public static QNA[] quesAndAnsList () 
    {
    QNA[] quesAndAnsList = new QNA[3];
    //Create question record with its attributes
    quesAndAnsList[0] = createQnA("Which gas do plants primarily absorb from the atmosphere during photosynthesis?", "co2");
	quesAndAnsList[1] = createQnA("What is the largest planet in our solar system?", "Jupiter");
	quesAndAnsList[2] = createQnA("What is the chemical symbol for gold?", "Au");
    //Add questions to the empty list created above
    return quesAndAnsList;
    }

    public static void makeQuestions() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("what is your file name?");//prompts the user for their desired file name
        String fileName = input.nextLine();
        //file name is stored, and then created, and allows user to write to it
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for(int i = 0; i < 3; i++){
            System.out.println("write the question");
            writer.println(input.nextLine());
            System.out.println("write the answer");
            writer.println(input.nextLine());
            //whole for loop allows the txt file to be created in the format question,answer,question,answer line by line
        }
        writer.close();
    }

    public static QNA[] readNewQuestionSet() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What set of questions would you like to choose? (insert file name)");
        //user able to choose what file should be read from
        String fileName = scanner.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String question;
        String answer;
        //ques and ans held in temp variables, later fed into array
        QNA [] questionSet = new QNA[3];
        for(int i = 0; i < 3; i++) {
            question = reader.readLine();
            answer = reader.readLine();
            questionSet[i] = createQnA(question, answer);
            //every loop, a question is read, then an answer is read from the textfile, which are then intialized into a record through createQNA, stored in an array of records
        }
        reader.close();
        //array of records then returned so can be looped through in main program
        return questionSet;
    }

    public static boolean customOrNot() throws IOException 
    {
        Scanner input = new Scanner(System.in);
        boolean customSet = false;
        System.out.println("Before we go ahead, would you like to create a custom set of questions and answers?");
        String yesOrNo = input.nextLine();
        if(yesOrNo.equals("yes")){
            customSet = true;
            makeQuestions();
        }
        else{
        customSet = false;
        System.out.println("Okay, we will procede with the preset quiz instead!");
        //main program will allow pre-set questions to be carried on
        }
        return customSet;
    }       

    public static String getQuestion(QNA ques)
    {
    return ques.question; //returns string
    }

    public static String getAnswer(QNA ans)
    {
    return ans.answer; //returns string
    }
    
        
}