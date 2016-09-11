package questionsanswers;

import java.util.HashMap;
import java.util.Random;

public class QuestionsAnswers {
	static HashMap<String, String> questionAnswers = new HashMap<String, String>();
	
	public boolean testAnswers(String question, String answer) {
		boolean isFound = false;
		if(questionAnswers.containsKey(question))
		{
			if(questionAnswers.get(question).equals(answer))
			{
				isFound = true;
			}
		}
		return isFound;
	}
	
	public void add(String question, String answer)
	{
		questionAnswers.put(question, answer);
	}
	
	public HashMap get()
	{
		return questionAnswers;
	}
	
    /**
    * Gives out a random question from the key set. */
    	public String getRandomQuestion() {
    		Random random = new Random();
    		int questionNum = random.nextInt((questionAnswers.size()-1 - 0 + 1));		
    		Object[] values = questionAnswers.keySet().toArray();
    		Object randomValue = values[questionNum];
    		return randomValue.toString();
    	}
}
